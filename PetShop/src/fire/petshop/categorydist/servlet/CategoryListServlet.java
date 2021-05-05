package fire.petshop.categorydist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fire.petshop.categorydist.form.CategoryForm;
import fire.petshop.categorydist.bll.CategoryBLL;
/**
 * 类名:CategoryListServlet
 * 功能:主要展示分类的显示和对下一条展示的传值和一些导航
 * 编辑者:王鹏
 * 时间:2006-12-4 17:46*/
public class CategoryListServlet extends HttpServlet {


	public CategoryListServlet() {
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
	 * 功能:获得产品种类得分类或得一个
	 * 编辑者:王鹏
	 * 最后更改时间:2006-12-4 13:20 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<CategoryForm> arry=CategoryBLL.getCategory();
		request.setAttribute("arry", arry);
		RequestDispatcher d=request.getRequestDispatcher("main.jsp");
		d.forward(request, response);
	}

	/**
	 * 方法名:doPost
	 * 参数名:HttpServletRequest 和 HttpServletResponse
	 * 返回值:无
	 * 功能:调用doGet方法
	 * 编辑者:王鹏
	 * 最后更改时间:2006-12-4 18:10
	 * 
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
