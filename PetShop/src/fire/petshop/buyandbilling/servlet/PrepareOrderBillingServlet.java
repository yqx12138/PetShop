package fire.petshop.buyandbilling.servlet;

/**
 * 类名：PrepareOrderBillingServlet
 * 功能：从数据库读出当前用户信息填入订单表单
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.loginandregist.bll.AccountBLL;
import fire.petshop.loginandregist.model.AccountBean;

public class PrepareOrderBillingServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3714036409097320231L;

	/**
	 * Constructor of the object.
	 */
	public PrepareOrderBillingServlet() {
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
			List list = AccountBLL.getRegister(userId);
			
			if(list.size() > 0)
			{
				AccountBean accountBean = (AccountBean)list.get(0);
				
				request.setAttribute("accountBean", accountBean);
				rd = request.getRequestDispatcher("orderbilling.jsp");
			}
			else
			{
				rd = request.getRequestDispatcher("../loginandregist/loginandregist.jsp");
			}
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
