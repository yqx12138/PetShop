/**
 *����:QueryItemServlet.java
 *��Ҫ����:���û������ѯ����Ʒ��Ϣȫ����ʾ����.
 *��д��:������
 *����޸�����:2006-11-28
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
	 * ������:destory �޲��� ����ֵ:void ��������:��������servletʵ����,���������������õ�. ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * ������:doGet ����:HttpServletRequest,HttpServletResponse ����ֵvoid
	 * ��������:���û��������װ��һ��request���� ��д��:������ ����޸�����:2006-11-28
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PageUtil pg = null;

		String searchItem = request.getParameter("searchItem");
		String no = "";

		if (searchItem.equals("")) {
			no = "�������ڲ�Ѯ";
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
			search = "�Բ���û������Ҫ�����ĳ���!";
		}

		request.setAttribute("count", count);
		request.setAttribute("search", search);

		request.setAttribute("searchItem", searchItem);
		RequestDispatcher dis = request.getRequestDispatcher("searchItems.jsp");
		dis.forward(request, response);
	}

	/**
	 * ������:doPost ����:HttpServletRequest,HttpServletResponse ����ֵ:void
	 * ��������:���û�����������Ϣ��װ��һ��response���� ��д��:������ ����޸�����:2006-11-28
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * ������:init �޲��� ����ֵ:void ��������:��ʼ��servletʱ���� ��д��:������ ����޸�����:2006-11-28
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
