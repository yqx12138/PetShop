package fire.petshop.buyandbilling.servlet;

/**
 * 类名：ProcessOrderServlet
 * 功能：处理订单表单，并将订单信息保存到数据库
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.buyandbilling.bll.LineItemBLL;
import fire.petshop.buyandbilling.bll.OrdersBLL;
import fire.petshop.buyandbilling.cart.Cart;
import fire.petshop.buyandbilling.form.CartItemForm;
import fire.petshop.buyandbilling.form.LineItemForm;
import fire.petshop.buyandbilling.form.OrdersForm;
import fire.petshop.common.util.DateUtil;

public class ProcessOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9047838711273598527L;

	/**
	 * Constructor of the object.
	 */
	public ProcessOrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = (String)request.getSession().getAttribute("userId");
		
		RequestDispatcher rd = null;
		
		if(userId != null && !userId.equals(""))
		{
			OrdersForm ordersForm = (OrdersForm)request.getSession().getAttribute("order");
			
			if(ordersForm != null)
			{
				//设置订单处理日期
				String orderDate = DateUtil.dateFormatToString((Calendar.getInstance()).getTime());
				
				try {
					ordersForm.setOrderDate(DateUtil.stringFormatToDate(orderDate));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				//处理订单
				int newOrderId = OrdersBLL.createOrder(ordersForm);
				
				
				
				if(newOrderId != -1)
				{
					//设置新订单ID
					ordersForm.setOrderId(newOrderId);
					
					Cart cart = (Cart)request.getSession().getAttribute("cart");
					
					List<LineItemForm> lineItemForms = new ArrayList<LineItemForm>();
					
					List<CartItemForm> cartItemForms = cart.getCartItems();
					
					int lineNum = 1;
					for(CartItemForm cartItemForm : cartItemForms)
					{
						LineItemForm lineItemForm = new LineItemForm();
						
						lineItemForm.setOrderId(newOrderId);
						lineItemForm.setLineNum(lineNum);
						lineItemForm.setItemId(cartItemForm.getItemId());
						lineItemForm.setQuantity(cartItemForm.getQuantity());
						lineItemForm.setUnitPrice(cartItemForm.getUnitPrice().doubleValue());
						
						lineItemForms.add(lineItemForm);
						lineNum++;
					}
					
					LineItemBLL.addLineItemsBatch(lineItemForms);
					
					request.setAttribute("order",ordersForm);
					request.getSession().removeAttribute("order");
					
					List<CartItemForm> cartlist = new ArrayList<CartItemForm>();
					
					List<CartItemForm> cartItems = cart.getCartItems();
					
					for(CartItemForm cartitemForm : cartItems)
					{
						CartItemForm newItemForm = new CartItemForm();
						
						newItemForm.setItemId(cartitemForm.getItemId());
						newItemForm.setUnitPrice(cartitemForm.getUnitPrice());
						newItemForm.setQuantity(cartitemForm.getQuantity());
						newItemForm.setProduct(cartitemForm.getProduct());
						newItemForm.setInStock(cartitemForm.getInStock());
						newItemForm.setSubtotal(cartitemForm.getSubtotal());
						
						cartlist.add(newItemForm);
					}
					
					request.setAttribute("cartlist", cartlist);
					
					cart.clearCart();
				}
				
				
				rd = request.getRequestDispatcher("shoppingsuccess.jsp");
			}
			else
			{
				rd = request.getRequestDispatcher("shoppingcart.jsp");
			}
		}
		
		rd.forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
