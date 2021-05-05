/**
*类名:ItemListServlet.java
*主要功能:把用户所想看到的一个商品的部分信息显示出来.
*编写者:周艳龙
*最后修改日期:2006-11-28
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
	 * 方法名:destory
	 * 无参数
	 * 返回值:void
	 * 功能描述:用来销毁servlet实例的,它是由容器来调用的.
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
     */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 *方法名:doGet
	 *参数:HttpServletRequest,HttpServletResponse
	 *返回值:void
	 *功能描述:把用户的请求封装成一个request对象
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
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
	 *方法名:doPost
	 *参数:HttpServletRequest,HttpServletResponse
	 *返回值:void
	 *功能描述:把用户的请求处理信息封装成一个response对象
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
     */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                 this.doGet(request, response);
			}

	/**
	 *方法名:init
	 *无参数
     *返回值:void 
	 *方法描述:初始化servlet时调用
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
     */	
	
	public void init() throws ServletException {
			}

}
