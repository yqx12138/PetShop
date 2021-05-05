package fire.petshop.categorydist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.categorydist.bll.ProductBLL;
import fire.petshop.categorydist.form.ProductForm;
import fire.petshop.common.util.PageUtil;

/**
 * 类名:ProductListServlet
 * 功能:主要从index.jsp页面获取一个分类的类名,根据这个名称来查找对应的种类产品,然后传到categoryjsp页面 
 * 编辑者:王鹏
 * 最后更改时间:2006-12-4 12:30
 */
public class ProductListServlet extends HttpServlet {

	public ProductListServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * 方法名:doGet
	 * 参数:HttpServletRequest 和 HttpServletResponse
	 * 返回值:无
	 * 功能:展示产品得分类 并实现分页得部分代码 获得一个ArrayList类型 转发到页面
	 * 编辑者:王鹏
	 * 最后更改时间:2006-12-4 17:20      
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageUtil page = null;
		
		String categoryName = request.getParameter("name");
		String pageIndex = request.getParameter("pageIndex");

//		if(page == null)
//		{
			int itemCount = ProductBLL.getgetItenCount(categoryName);

			if (pageIndex == null || pageIndex.length() == 0) {
				page = new PageUtil(1, itemCount, 4);
			} else {
				page = new PageUtil(Integer.parseInt(pageIndex), itemCount, 4);
			}
//		}
//		else
//		{
//			if(pageIndex == null)
//			{
//				page.setPageIndex(1);
//			}
//		}
		
		String to = request.getParameter("to");

		if (to != null) {
			if (to.equals("next")) {
				page.next();
			} else if (to.equals("privious")) {
				page.privious();
			}
		}
		ArrayList<ProductForm> arry = ProductBLL.getProductModel(categoryName,
				page);

		request.setAttribute("pagebean", page);
		request.setAttribute("name", categoryName);
		request.setAttribute("arry", arry);
		RequestDispatcher d = request.getRequestDispatcher("category.jsp");
		d.forward(request, response);
	}

	/**
	 *方法名:doPost
	 *参数名:HttpServletRequest 和 HttpServletResponse
	 *返回值:无
	 *功能:调用doGet方法
	 *编辑者:王鹏	
   	 *最后更改时间:2006-12-4 15:54
	 **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
