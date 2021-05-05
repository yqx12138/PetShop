package fire.petshop.categorydist.bll;

	/**
	 * 类名:ProductBLL
	 * 功能:主要用来调用dao来返回一个需要的ArrayList还有从ProductModel到ProductForm的转换并获得您所查询的总记录数
	 * 编辑者:王鹏
	 * 最后更改时间:2006-12-4 18:00*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import fire.petshop.categorydist.form.ProductForm;
import fire.petshop.categorydist.model.ProductModel;
import fire.petshop.common.util.PageUtil;
import fire.petshop.dao.categorydist.ProductDao;

public class ProductBLL {
	
	
	
	/**方法名:getProductModel
	 *参数:String类型 catid  Pageutil类型 page
	 *返回值:ArrayList<ProductForm>
	 * 功能:可以根据传进的值来调用dao来或取rs并专成ArrayList<ProductForm>返回
	 *编辑者:王鹏
	 *最后更改时间:2006-12-4 13:00
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
	/**方法名:productModelToform 
	 *参数:ProductModel 类型 productmodel
	 *返回值:ProductForm
	 *功能:实现ProductModel到ProductFrom的转变
	 *编辑者:王鹏
	 *最后更改时间:2006-12-4 13:30
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
*方法名:getgetItenCount
*参数:String类型 catid
*返回值:int类型(获取总记录数)
*功能:根据传入的字符串来从数据库中获取您所要得到得记录数
*编辑者:王鹏
*最后更改时间:2006-12-4 15:00
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
