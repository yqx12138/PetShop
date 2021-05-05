package fire.petshop.categorydist.bll;

	/**
	 * ����:ProductBLL
	 * ����:��Ҫ��������dao������һ����Ҫ��ArrayList���д�ProductModel��ProductForm��ת�������������ѯ���ܼ�¼��
	 * �༭��:����
	 * ������ʱ��:2006-12-4 18:00*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import fire.petshop.categorydist.form.ProductForm;
import fire.petshop.categorydist.model.ProductModel;
import fire.petshop.common.util.PageUtil;
import fire.petshop.dao.categorydist.ProductDao;

public class ProductBLL {
	
	
	
	/**������:getProductModel
	 *����:String���� catid  Pageutil���� page
	 *����ֵ:ArrayList<ProductForm>
	 * ����:���Ը��ݴ�����ֵ������dao����ȡrs��ר��ArrayList<ProductForm>����
	 *�༭��:����
	 *������ʱ��:2006-12-4 13:00
	 */
	public static ArrayList<ProductForm>  getProductModel(String catid,PageUtil page)
	{
		int pageIndex=page.getPageIndex();
		int itemCountPerPage=page.getItemCountPerPage();
		int count=(pageIndex-1)*itemCountPerPage+1;
		ProductDao dao=new ProductDao();
		
		ResultSet rs=null;
		
		ArrayList<ProductForm> arry=new ArrayList<ProductForm>();
		String sql="select ProductId,`Name` from product where category='"+catid+"'";
		dao.open();
		rs=dao.execQuery(sql);
		
		try {
			System.out.println(count);
			boolean res = rs.absolute(count);
			
			if(res)
			{
				for(int i=0;i<itemCountPerPage;i++)
				{
					ProductModel model=new ProductModel();
					model.setProductId(rs.getString("ProductId"));
					//model.setCategory(rs.getString("category"));
					model.setName(rs.getString("name"));
					//model.setDescn(rs.getString("descn"));
					ProductForm form=productModelToform(model);
					arry.add(form);
					if(!rs.next()) break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			dao.close();
		}
		return arry;
	}
	/**������:productModelToform 
	 *����:ProductModel ���� productmodel
	 *����ֵ:ProductForm
	 *����:ʵ��ProductModel��ProductFrom��ת��
	 *�༭��:����
	 *������ʱ��:2006-12-4 13:30
	 **/
	public static ProductForm productModelToform(ProductModel productmodel)
	{
		ProductForm form=new ProductForm();
		form.setProductID(productmodel.getProductId());
		form.setCategory(productmodel.getCategory());
		form.setName(productmodel.getName());
		form.setDescn(productmodel.getDescn());
		return form;
	}
	/**
*������:getgetItenCount
*����:String���� catid
*����ֵ:int����(��ȡ�ܼ�¼��)
*����:���ݴ�����ַ����������ݿ��л�ȡ����Ҫ�õ��ü�¼��
*�༭��:����
*������ʱ��:2006-12-4 15:00
**/
	public static int getgetItenCount(String catid)
	{
		int itemCount=0;
		ProductDao dao=new ProductDao();
		ResultSet rs=null;
		
		dao.open();
		String sql="select count(*) from Product where category='"+catid+"'";
		rs=dao.execQuery(sql);
		try {
			rs.next();
			itemCount=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			try {
				dao.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return itemCount;
	}
}
