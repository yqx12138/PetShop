package fire.petshop.buyandbilling.servlet;

/**
 * ������RemoveItemFromCartServlet
 * ���ܣ����ݲ���indexɾ�����ﳵ��ָ���Ĺ��ﳵ��Ŀ
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.buyandbilling.cart.Cart;

public class RemoveItemFromCartServlet extends HttpServlet {

	private static final long serialVersionUID = 9064673702636333907L;

	/**
	 * Constructor of the object.
	 */
	public RemoveItemFromCartServlet() {
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
		
		String itemIndex = request.getParameter("itemIndex");
		
		int index = Integer.parseInt(itemIndex);
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		
		cart.removeItem(index);
		
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
