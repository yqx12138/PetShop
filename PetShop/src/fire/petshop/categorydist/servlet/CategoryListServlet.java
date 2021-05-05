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
 * ����:CategoryListServlet
 * ����:��Ҫչʾ�������ʾ�Ͷ���һ��չʾ�Ĵ�ֵ��һЩ����
 * �༭��:����
 * ʱ��:2006-12-4 17:46*/
public class CategoryListServlet extends HttpServlet {


	public CategoryListServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * ������:doGet
	 * ����:HttpServletRequest �� HttpServletResponse
	 * ����ֵ:��
	 * ����:��ò�Ʒ����÷�����һ��
	 * �༭��:����
	 * ������ʱ��:2006-12-4 13:20 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<CategoryForm> arry=CategoryBLL.getCategory();
		request.setAttribute("arry", arry);
		RequestDispatcher d=request.getRequestDispatcher("main.jsp");
		d.forward(request, response);
	}

	/**
	 * ������:doPost
	 * ������:HttpServletRequest �� HttpServletResponse
	 * ����ֵ:��
	 * ����:����doGet����
	 * �༭��:����
	 * ������ʱ��:2006-12-4 18:10
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
