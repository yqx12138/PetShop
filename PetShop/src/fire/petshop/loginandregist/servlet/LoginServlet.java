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
 * 类名称:LogoutServlet
 * 功能:用户在页面登陆时调用此servlet 
 * 编写:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
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
/**方法名称:destroy
*功能:销毁servlet实例,主要由容器来决定
*参数:无
*返回值:void
*编写时间:2006-11-28
*最后修改时间:2006-12-2
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
/**方法名称:doGet
*功能:调用业务层的方法
*参数:request response
*返回值:void
*编写时间:2006-11-28
*最后修改时间:2006-12-2
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
			request.setAttribute("error", "用户名或密码错误或不存在");
			d = request.getRequestDispatcher("loginandregist.jsp");
		}
		
		d.forward(request, response);
	}
/**方法名称:goPost
*功能:调doGet方法
*参数:request response
*返回值:void
*编写时间:2006-11-28
*最后修改时间:2006-12-2
*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
