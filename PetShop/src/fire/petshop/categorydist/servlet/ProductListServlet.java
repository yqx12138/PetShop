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
 * ����:ProductListServlet
 * ����:��Ҫ��index.jspҳ���ȡһ�����������,����������������Ҷ�Ӧ�������Ʒ,Ȼ�󴫵�categoryjspҳ�� 
 * �༭��:����
 * ������ʱ��:2006-12-4 12:30
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
	 * ������:doGet
	 * ����:HttpServletRequest �� HttpServletResponse
	 * ����ֵ:��
	 * ����:չʾ��Ʒ�÷��� ��ʵ�ַ�ҳ�ò��ִ��� ���һ��ArrayList���� ת����ҳ��
	 * �༭��:����
	 * ������ʱ��:2006-12-4 17:20      
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
	 *������:doPost
	 *������:HttpServletRequest �� HttpServletResponse
	 *����ֵ:��
	 *����:����doGet����
	 *�༭��:����	
   	 *������ʱ��:2006-12-4 15:54
	 **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
