package fire.petshop.buyandbilling.servlet;

/**
 * 类名：BuildOrderServlet
 * 功能：根据参数值创建OrdersForm对象，以名称order保存到session环境中
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.buyandbilling.cart.Cart;
import fire.petshop.buyandbilling.form.OrdersForm;
import fire.petshop.common.util.DateUtil;

public class BuildOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2839182299349213511L;

	/**
	 * Constructor of the object.
	 */
	public BuildOrderServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = (String)request.getSession().getAttribute("userId");
		
		RequestDispatcher rd = null;
		
		if(userId != null && !userId.equals(""))
		{
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			
			
			OrdersForm ordersForm = new OrdersForm();
			
			ordersForm.setUserId(userId);
			ordersForm.setTotalPrice(cart.getTotalPrice().doubleValue());
			
			String exprDate = request.getParameter("year")+"-"+request.getParameter("month")+"-01";	
			
			ordersForm.setCardType(request.getParameter("cardType"));
			ordersForm.setCreditCard(request.getParameter("creditCard"));
			try {
				ordersForm.setExprDate(DateUtil.stringFormatToDate(exprDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ordersForm.setBillToFirstName(request.getParameter("billToFirstName"));
			ordersForm.setBillToLastName(request.getParameter("billToLastName"));
			ordersForm.setBillAddr1(request.getParameter("billAddr1"));
			ordersForm.setBillAddr2(request.getParameter("billAddr2"));
			ordersForm.setBillCity(request.getParameter("billCity"));
			ordersForm.setBillState(request.getParameter("billState"));
			ordersForm.setBillZip(request.getParameter("billZip"));
			ordersForm.setBillCountry(request.getParameter("billCountry"));
			
			
			if(request.getParameter("shiptobillingaddr") != null)
			{
				ordersForm.setShipToFirstName(request.getParameter("billToFirstName"));
				ordersForm.setShipToLastName(request.getParameter("billToLastName"));
				ordersForm.setShipAddr1(request.getParameter("billAddr1"));
				ordersForm.setShipAddr2(request.getParameter("billAddr2"));
				ordersForm.setShipCity(request.getParameter("billCity"));
				ordersForm.setShipState(request.getParameter("billState"));
				ordersForm.setShipZip(request.getParameter("billZip"));
				ordersForm.setShipCountry(request.getParameter("billCountry"));
			}
			
			request.getSession().setAttribute("order", ordersForm);
			
			rd = request.getRequestDispatcher("showorderbilling.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("../loginandregist/loginandregist.jsp");
		}
		
		rd.forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
