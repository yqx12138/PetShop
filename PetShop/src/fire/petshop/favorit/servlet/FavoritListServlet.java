package fire.petshop.favorit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fire.petshop.common.util.PageUtil;
import fire.petshop.favorit.bll.FavoritBLL;

/**类名称:FavoritListServlet
 * 功能:把用户选择的宠物信息通过页面显示出来
 * 编写者:杨凡
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class FavoritListServlet extends HttpServlet {
	
	//private PageUtil page=null;
	/**方法名称:destroy
	*描述:默认构造函数
	*编写者:杨凡
	*编写时间:2006-11-28
	*最后修改时间:2006-12-2
	*/
	public FavoritListServlet() {
		super();
	}
	/**方法名称:destroy
	 * 功能:销毁Servlet实例的,它是由容器决定的
	 * 参数:无
	 * 返回值:void
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	/**方法:doGet
	 * 描述:调用方法 页面的跳转
	 * 参数:request 接收请求 response 响应请求
	 * 变量:userId 用户Id   pageIndex 当前页  itemCount 总记录数 
	 * 返回值:void 
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageUtil page=null;
		
		//从页面得到session保存的用户id
		String userId=(String)request.getSession().getAttribute("userId");

		RequestDispatcher rd = null;
		
		if(userId != null && !userId.equals(""))
		{
			String pageIndex=request.getParameter("pages");
			
			//通过传进用户id的值来查询
//			if(page==null)
//			{
				int itemCount=FavoritBLL.getIntemCount(userId);
				page=new PageUtil(1,itemCount,2);
				if(pageIndex==null||pageIndex.length()==0)
				{
					page=new PageUtil(1,itemCount,2);
				}
				else
				{
					page=new PageUtil(Integer.parseInt(pageIndex),itemCount,2);
				}
//			}else
//			{
//				int itemCount=FavoritBLL.getIntemCount(userId);
//				if(pageIndex==null)
//				{
//					page=new PageUtil(1,itemCount,2);
//				}
//			}
			String to=request.getParameter("to");
			if(to!=null)
			{
				if(to.equals("next"))
				{
					page.next();
					
				}else if(to.equals("before"))
				{
					page.privious();
				}
			}
			
			ArrayList array = FavoritBLL.getAllFavorit(userId,page);
			
			request.setAttribute("pages",page);
			if(array.size() > 0)
			{
				request.setAttribute("ifDisplay", "yes");
			}
			//request.setAttribute("userId",userId);
			request.setAttribute("arrayList", array);
			
			rd = request.getRequestDispatcher("../buyandbilling/shoppingcart.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("../buyandbilling/shoppingcart.jsp");
		}
		
		rd.forward(request,response);
	}
	/**方法名称:goPost
	 * 描述:调用doGet方法
	 * 返回值:void
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**方法名称:init
	 * 功能:初始化Servlet
	 * 参数:无
	 * 返回值:void
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public void init() throws ServletException {
	
	}

}
