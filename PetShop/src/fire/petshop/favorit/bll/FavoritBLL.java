package fire.petshop.favorit.bll;
//import fire.petshop.favorit.form.ProductForm;
//import fire.petshop.favorit.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import fire.petshop.common.util.PageUtil;
import fire.petshop.dao.favorit.BaseDao;
import fire.petshop.dao.favorit.FavoritDao;
/**类名:FavoriBLL
 * 功能:向外部提供一些静态的调用方法
 * 编译者:杨凡
 * 编译时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class FavoritBLL {
	private static FavoritDao favoritDao = new FavoritDao();
	
	/**方法名称:getAllFavorit
	 * 功能:通过传入的用户Id查询这个用户选择的这一类宠物的所有信息
	 * 参数:userId page
	 * 返回值:ArrayList
	 * 编写者:杨凡
	 * 编译时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public static ArrayList getAllFavorit(String userId,PageUtil page)
	{
		
		return favoritDao.showFavorit(userId,page);
	}
	/**方法名称:getIntemCount
	 * 功能:通过传入的用户Id查询一类宠物的所有所有数量
	 * 参数:userId
	 * 变量:str 用户选择的宠物名称   count 宠物的总数量
	 * 返回值:count 宠物的数量
	 * 编写者:杨凡
	 * 编译时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public static int getIntemCount(String userId)
	{
		String str=favoritDao.selectFavorit(userId);
		
		String sql="select count(*) from Product where category='"+str+"'";
		System.out.println(sql);
		BaseDao baseDao=new BaseDao();
		baseDao.open();
		
		int count=0;
		try {
			ResultSet rs= baseDao.executeQuery(sql);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			baseDao.close();
		}
		
		return count;
	}
	
//  从form到bean
//	private static ProductForm productFormToBean(Product product)
//	{
//		ProductForm productForm=new ProductForm();
//		productForm.setProductId(product.getProductId());
//		productForm.setName(product.getName());
//		
//		return productForm;		
//	}	
//  从bean到form
//	private static Product beanToProductForm(ProductForm productForm)
//	{
//		Product product=new Product();
//		product.setProductId(productForm.getProductId());
//		product.setName(productForm.getName());
//		
//		return product;
//	}
}
