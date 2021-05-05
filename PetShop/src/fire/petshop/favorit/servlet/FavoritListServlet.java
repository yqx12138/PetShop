package fire.petshop.favorit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fire.petshop.common.util.PageUtil;
import fire.petshop.favorit.bll.FavoritBLL;

/**������:FavoritListServlet
 * ����:���û�ѡ��ĳ�����Ϣͨ��ҳ����ʾ����
 * ��д��:�
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class FavoritListServlet extends HttpServlet {
	
	//private PageUtil page=null;
	/**��������:destroy
	*����:Ĭ�Ϲ��캯��
	*��д��:�
	*��дʱ��:2006-11-28
	*����޸�ʱ��:2006-12-2
	*/
	public FavoritListServlet() {
		super();
	}
	/**��������:destroy
	 * ����:����Servletʵ����,����������������
	 * ����:��
	 * ����ֵ:void
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	/**����:doGet
	 * ����:���÷��� ҳ�����ת
	 * ����:request �������� response ��Ӧ����
	 * ����:userId �û�Id   pageIndex ��ǰҳ  itemCount �ܼ�¼�� 
	 * ����ֵ:void 
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageUtil page=null;
		
		//��ҳ��õ�session������û�id
		String userId=(String)request.getSession().getAttribute("userId");

		RequestDispatcher rd = null;
		
		if(userId != null && !userId.equals(""))
		{
			String pageIndex=request.getParameter("pages");
			
			//ͨ�������û�id��ֵ����ѯ
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
	/**��������:goPost
	 * ����:����doGet����
	 * ����ֵ:void
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	/**��������:init
	 * ����:��ʼ��Servlet
	 * ����:��
	 * ����ֵ:void
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public void init() throws ServletException {
	
	}

}
