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

/**��������:initForm
*����:�Ѵ�ҳ��õ���ֵ��װ��һ��Form��,�������ĵ���
*����:request response
*����ֵ:registForm
*����дʱ��:2006-11-28
*����޸�ʱ��:2006-12-02 
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
/**��������:doGet
*����:����ҵ���ķ���
*����:request response
*����ֵ:void
*��дʱ��:2006-11-28
*����޸�ʱ��:2006-12-2
*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("����updateServlet���");
		RegistForm registForm=this.initForm(request, response);

		System.out.println("����updateRegist����");
		try {
			if(AccountBLL.updateRegist(registForm))
			{
				System.out.println("��ת��½ҳ��");
				request.setAttribute("flag", "updateregist");
				RequestDispatcher rd=request.getRequestDispatcher("myaccount.jsp");
				rd.forward(request,response);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
}
