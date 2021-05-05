/**
*����:ItemListServlet.java
*��Ҫ����:���û����뿴����һ����Ʒ�Ĳ�����Ϣ��ʾ����.
*��д��:������
*����޸�����:2006-11-28
*/
package fire.petshop.productdist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.common.util.PageUtil;
import fire.petshop.productdist.bll.ItemBll;
import fire.petshop.productdist.form.ItemForm;
public class ItemListServlet extends HttpServlet {

	private PageUtil page=null;
	/**
	 * Constructor of the object.
	 */
	public ItemListServlet() {
		super();
	}
	/**
	 * ������:destory
	 * �޲���
	 * ����ֵ:void
	 * ��������:��������servletʵ����,���������������õ�.
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 *������:doGet
	 *����:HttpServletRequest,HttpServletResponse
	 *����ֵ:void
	 *��������:���û��������װ��һ��request����
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//            String productId=request;
            String pageIndex=request.getParameter("pagel");
            String productId=request.getParameter("productId");
            //int count=ItemBll.getCount(productId);
            //PageUtil pg=new PageUtil(1,count,2);
            if(page==null)
            {
            	int itmes=ItemBll.getCountItemList(productId);
            	page=new PageUtil(1,itmes,2);
            	if(pageIndex==null || pageIndex.length()==0)
            	{
            		page=new PageUtil(1,itmes,1);
            	}else{
            		page=new PageUtil(Integer.parseInt(pageIndex),itmes,1);
            	}
            	
            }
            else{
            	if(pageIndex==null)
            	{
            		int itmes=ItemBll.getCountItemList(productId);
            		page=new PageUtil(1,itmes,2);
            	}
            }
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
            System.out.print(productId);
            ArrayList  arrayList=ItemBll.getItemList(productId,page);
            System.out.print(arrayList.size());
            request.setAttribute("productId", productId);
            request.setAttribute("arrayList", arrayList);
            request.setAttribute("pagel", page);
            RequestDispatcher  dis= request.getRequestDispatcher("items.jsp");		
	        dis.forward(request,response );
	}
	/**
	 *������:doPost
	 *����:HttpServletRequest,HttpServletResponse
	 *����ֵ:void
	 *��������:���û�����������Ϣ��װ��һ��response����
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                 this.doGet(request, response);
			}

	/**
	 *������:init
	 *�޲���
     *����ֵ:void 
	 *��������:��ʼ��servletʱ����
	 *��д��:������
     *����޸�����:2006-11-28
     */	
	
	public void init() throws ServletException {
			}

}
