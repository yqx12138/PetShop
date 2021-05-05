/**
 *类名:QueryItemServlet.java
 *主要功能:把用户所想查询的商品信息全部显示出来.
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

import fire.petshop.common.util.PageUtil;
import fire.petshop.productdist.bll.*;
import java.util.*;

public class SearchItemServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchItemServlet() {
		super();
	}

	/**
	 * 方法名:destory 无参数 返回值:void 功能描述:用来销毁servlet实例的,它是由容器来调用的. 编写者:周艳龙
	 * 最后修改日期:2006-11-28
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * 方法名:doGet 参数:HttpServletRequest,HttpServletResponse 返回值void
	 * 功能描述:把用户的请求封装成一个request对象 编写者:周艳龙 最后修改日期:2006-11-28
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PageUtil pg = null;

		String searchItem = request.getParameter("searchItem");
		String no = "";

		if (searchItem.equals("")) {
			no = "请输入在查旬";
		}

		request.setAttribute("no", no);
		String currentPage = request.getParameter("currentPage");

		int count = ItemBll.getCount(searchItem);

		if (currentPage == null || currentPage.length() == 0) {
			pg = new PageUtil(1, count, 3);
		} else {
			int currentPage1 = Integer.parseInt(currentPage);
			pg = new PageUtil(currentPage1, count, 3);
		}

		String next = request.getParameter("next");

		if (next != null) {
			if (next.equals("next")) {
				pg.next();
			} else if (next.equals("before")) {
				pg.privious();
			}

		}

		System.out.print(searchItem);
		ArrayList searchArray = ItemBll.getSearchItemList(searchItem, pg);
		request.setAttribute("PageU", pg);
		request.setAttribute("searchArray", searchArray);
		int y = searchArray.size();
		String search = "wo";
		if (searchArray.size() < 1) {
			search = "对不起，没有你想要搜索的宠物!";
		}

		request.setAttribute("count", count);
		request.setAttribute("search", search);

		request.setAttribute("searchItem", searchItem);
		RequestDispatcher dis = request.getRequestDispatcher("searchItems.jsp");
		dis.forward(request, response);
	}

	/**
	 * 方法名:doPost 参数:HttpServletRequest,HttpServletResponse 返回值:void
	 * 功能描述:把用户的请求处理信息封装成一个response对象 编写者:周艳龙 最后修改日期:2006-11-28
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * 方法名:init 无参数 返回值:void 方法描述:初始化servlet时调用 编写者:周艳龙 最后修改日期:2006-11-28
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
