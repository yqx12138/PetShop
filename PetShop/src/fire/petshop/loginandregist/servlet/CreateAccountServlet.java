package fire.petshop.loginandregist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.loginandregist.bll.AccountBLL;
import fire.petshop.loginandregist.form.RegistForm;


/**
 * 类名称:CreateAccountServlet 
 * 功能:用户在页面修改自己的用户信息时调用此servlet 
 * 编写:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
 * 
 * */

public class CreateAccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CreateAccountServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
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
		String email = request.getParameter("email");
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String addr1=request.getParameter("addr1");
		String addr2=request.getParameter("addr2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zip=request.getParameter("zip");
		String country=request.getParameter("country");
		String phone = request.getParameter("phone");
		 
		String favCategory=request.getParameter("favCategory");
		String myListOpt=request.getParameter("myListOpt");
		//String bannerOpt=request.getParameter("bannerOpt");
		
	    RegistForm registForm=new RegistForm(); 
		
		registForm.setUserId(userId);
		registForm.setPassword(password);
		registForm.setFirstName(firstName);
		registForm.setLastName(lastName);
		registForm.setEmail(email);
		registForm.setAddr1(addr1);
		registForm.setAddr2(addr2);
		registForm.setCity(city);
		registForm.setState(state);
		registForm.setZip(zip);
		registForm.setCountry(country);
		registForm.setPhone(phone);
		
		
		System.out.println(registForm.getMyListOpt());
		System.out.println("33333333333");
		if( myListOpt == null)
		{
			registForm.setMyListOpt(0);
		}
		else
		{
			registForm.setMyListOpt(1);
		}
		System.out.println("------------------------------");
		System.out.println(registForm.getMyListOpt());
		
		
		registForm.setFavCategory(favCategory);
		
		
		RequestDispatcher rd1=null;

		if(AccountBLL.addUser(registForm))
		{
			request.setAttribute("flag", "regist");
			request.getSession().setAttribute("userId", userId);
			rd1 = request.getRequestDispatcher("../loginandregist/myaccount.jsp");
		}
		else
		{
			request.setAttribute("error", "注册失败！");
			rd1 = request.getRequestDispatcher("../loginandregist/createaccount.jsp");
		}
		
		rd1.forward(request, response);
			
		
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
/**方法名称:goPost
*功能:调doGet方法
*参数:request response
*返回值:void
*编写时间:2006-11-28
*最后修改时间:2006-12-2
*/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
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
