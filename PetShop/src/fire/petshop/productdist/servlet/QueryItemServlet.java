/**
*类名:QueryItemServlet.java
*主要功能:把用户所想看到的一个商品的信息全部显示出来.
*编写者:周艳龙
*最后修改日期:2006-11-28
*/

package fire.petshop.productdist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fire.petshop.productdist.bll.ItemBll;
import fire.petshop.productdist.form.ItemDetailForm;
public class QueryItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryItemServlet() {
		super();
	}

		/**
	 *方法名:destory
	 *无参数
     *返回值:void
	 *功能描述:用来销毁servlet实例的,它是由容器来调用的.
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
           String itemId=request.getParameter("itemId");
		   String qty=ItemBll.getQtys(itemId);
		   String descn=ItemBll.getDescns(itemId);
           ItemDetailForm itemDetailForm =ItemBll.getItemDetalis(itemId);
           itemDetailForm.setQty(qty);
           itemDetailForm.setDescn(descn);
	       request.setAttribute("itemDetailForm",itemDetailForm); 
           RequestDispatcher dis=request.getRequestDispatcher("itemdetails.jsp");
	       dis.forward(request, response);
	}

	/**
	 *方法名:doPost
	 *参数:HttpServletRequest,HttpServletResponse
	 *返回值void
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
		// Put your code here
	}

}
