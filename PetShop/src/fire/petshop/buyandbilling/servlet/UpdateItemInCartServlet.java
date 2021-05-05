package fire.petshop.buyandbilling.servlet;

/**
 * 类名：UpateItemInCartServlet
 * 功能：根据传入的quantity参数，更新购物车中的数量和价格信息
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fire.petshop.buyandbilling.cart.Cart;

public class UpdateItemInCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2124573576633979451L;

	/**
	 * Constructor of the object.
	 */
	public UpdateItemInCartServlet() {
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

		String[] quantities = request.getParameterValues("quantity");

		Cart cart = (Cart) request.getSession().getAttribute("cart");


		for (int index=0; index < cart.getItemCount(); index++) {
			if (Integer.parseInt(quantities[index]) == 0) {
				cart.removeItem(index);
			} else {
				cart.getCartItem(index).setQuantity(Integer.parseInt(quantities[index]));
				cart.getCartItem(index).calculateSubTatal();
			}
		}

		cart.calculateTotalPrice();

		RequestDispatcher rd = request
				.getRequestDispatcher("../favorit/FavoritListServlet");
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
