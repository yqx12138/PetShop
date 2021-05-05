package fire.petshop.loginandregist.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fire.petshop.loginandregist.bll.AccountBLL;
import fire.petshop.loginandregist.form.RegistForm;

public class UpdateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

/**方法名称:initForm
*功能:把从页面得到的值封装在一个Form里,方便后面的调用
*参数:request response
*返回值:registForm
*不编写时间:2006-11-28
*最后修改时间:2006-12-02 
*/
	public RegistForm initForm(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		System.out.println(userId);
		
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
		if(userId!=null)
		{
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
			registForm.setFavCategory(favCategory);
			
			
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
				
		}

		return registForm;
		
	}
	
	public UpdateAccountServlet() {
		super();
	}
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
/**方法名称:doGet
*功能:调用业务层的方法
*参数:request response
*返回值:void
*编写时间:2006-11-28
*最后修改时间:2006-12-2
*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("进入updateServlet语句");
		RegistForm registForm=this.initForm(request, response);

		System.out.println("调用updateRegist方法");
		try {
			if(AccountBLL.updateRegist(registForm))
			{
				System.out.println("调转登陆页面");
				request.setAttribute("flag", "updateregist");
				RequestDispatcher rd=request.getRequestDispatcher("myaccount.jsp");
				rd.forward(request,response);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
