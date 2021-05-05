package fire.petshop.buyandbilling.servlet;

/**
 * 类名：AddItemToCartServlet
 * 功能：根据itemId参数的值添加条目到购物车
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.buyandbilling.bll.CartBLL;
import fire.petshop.buyandbilling.cart.Cart;
import fire.petshop.buyandbilling.form.CartItemForm;

public class AddItemToCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7449542183842857296L;

	/**
	 * Constructor of the object.
	 */
	public AddItemToCartServlet() {
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
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String itemId = request.getParameter("itemId");
		
		if(itemId != null)
		{
			CartItemForm cartItemForm = new CartItemForm();
			cartItemForm.setItemId(itemId);
			
			cartItemForm = CartBLL.getCartItemFormByID(cartItemForm);
			
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			
			cart.addItem(cartItemForm);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("../favorit/FavoritListServlet");
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
