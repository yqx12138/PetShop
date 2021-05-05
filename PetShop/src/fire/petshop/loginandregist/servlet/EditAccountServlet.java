package fire.petshop.loginandregist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fire.petshop.dao.loginandregist.AccountBaseDao;
import fire.petshop.loginandregist.base.BaseDao;
import fire.petshop.loginandregist.bll.AccountBLL;
import fire.petshop.loginandregist.form.RegistForm;
import fire.petshop.loginandregist.model.AccountBean;


public class EditAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public EditAccountServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{	
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");
		System.out.println(userId);
	
		AccountBaseDao accountBaseDao = new AccountBaseDao();
		
		try
		{
			ArrayList array=AccountBLL.getRegister(userId);
			//System.out.println(array.get(1)+"+++++"+array.size());
		
			ArrayList list = accountBaseDao.selectCategory();
			
			request.setAttribute("catelist", list);
			request.setAttribute("arrayList",array);
			RequestDispatcher rd=request.getRequestDispatcher("editaccount.jsp");
			rd.forward(request,response);
		}catch(Exception ex)
		{
			request.setAttribute("error",ex);
			RequestDispatcher dis = request.getRequestDispatcher("editaccount.jsp");
			dis.forward(request,response);
		} 
	}	
//	public ArrayList selectCategory()
//	{    
//		ArrayList<AccountBean> list=new ArrayList<AccountBean>();
//		BaseDao baseDao=new BaseDao();
//		try{
//			baseDao.open();
//			 String sql="select CatId,[name] from [petshop].[dbo].[category]";
//		     System.out.println(sql);
//		     ResultSet rs=baseDao.executeQuery(sql);
//		     
//		     while(rs.next())
//		     {
//		    	 AccountBean  account=new AccountBean();
//		    	 account.setCateId(rs.getString("CatId"));
//		    	 account.setCategoryName(rs.getString("name"));
//		    	 list.add(account);
//		     }
//		}catch(Exception ex)
//		{
//			System.out.println(ex);
//		}finally
//		{
//			baseDao.close();
//		}
//		return list;
//	}
		   
		
	

}
