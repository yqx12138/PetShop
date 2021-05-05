package fire.petshop.loginandregist.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.loginandregist.bll.AccountBLL;
import fire.petshop.loginandregist.form.LoginForm;
/**
 * ������:LogoutServlet
 * ����:�û���ҳ���½ʱ���ô�servlet 
 * ��д:����
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-1
 * 
 * */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
/**��������:destroy
*����:����servletʵ��,��Ҫ������������
*����:��
*����ֵ:void
*��дʱ��:2006-11-28
*����޸�ʱ��:2006-12-2
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
/**��������:doGet
*����:����ҵ���ķ���
*����:request response
*����ֵ:void
*��дʱ��:2006-11-28
*����޸�ʱ��:2006-12-2
*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		LoginForm login = new LoginForm();

		login.setUserId(userId);
		login.setPassword(password);
		
		RequestDispatcher d = null;
		
		if (AccountBLL.checkUser(login)) {
			request.getSession().setAttribute("userId", login.getUserId());
			request.setAttribute("flag", "login");
			d = request.getRequestDispatcher("myaccount.jsp");
		} else {
			request.setAttribute("error", "�û������������򲻴���");
			d = request.getRequestDispatcher("loginandregist.jsp");
		}
		
		d.forward(request, response);
	}
/**��������:goPost
*����:��doGet����
*����:request response
*����ֵ:void
*��дʱ��:2006-11-28
*����޸�ʱ��:2006-12-2
*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
