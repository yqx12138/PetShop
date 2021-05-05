/**
*����:QueryItemServlet.java
*��Ҫ����:���û����뿴����һ����Ʒ����Ϣȫ����ʾ����.
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
	 *������:destory
	 *�޲���
     *����ֵ:void
	 *��������:��������servletʵ����,���������������õ�.
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
	 *������:doPost
	 *����:HttpServletRequest,HttpServletResponse
	 *����ֵvoid
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
		// Put your code here
	}

}
