package fire.petshop.favorit.bll;
//import fire.petshop.favorit.form.ProductForm;
//import fire.petshop.favorit.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import fire.petshop.common.util.PageUtil;
import fire.petshop.dao.favorit.BaseDao;
import fire.petshop.dao.favorit.FavoritDao;
/**����:FavoriBLL
 * ����:���ⲿ�ṩһЩ��̬�ĵ��÷���
 * ������:�
 * ����ʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class FavoritBLL {
	private static FavoritDao favoritDao = new FavoritDao();
	
	/**��������:getAllFavorit
	 * ����:ͨ��������û�Id��ѯ����û�ѡ�����һ������������Ϣ
	 * ����:userId page
	 * ����ֵ:ArrayList
	 * ��д��:�
	 * ����ʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public static ArrayList getAllFavorit(String userId,PageUtil page)
	{
		
		return favoritDao.showFavorit(userId,page);
	}
	/**��������:getIntemCount
	 * ����:ͨ��������û�Id��ѯһ������������������
	 * ����:userId
	 * ����:str �û�ѡ��ĳ�������   count �����������
	 * ����ֵ:count ���������
	 * ��д��:�
	 * ����ʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
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
	
//  ��form��bean
//	private static ProductForm productFormToBean(Product product)
//	{
//		ProductForm productForm=new ProductForm();
//		productForm.setProductId(product.getProductId());
//		productForm.setName(product.getName());
//		
//		return productForm;		
//	}	
//  ��bean��form
//	private static Product beanToProductForm(ProductForm productForm)
//	{
//		Product product=new Product();
//		product.setProductId(productForm.getProductId());
//		product.setName(productForm.getName());
//		
//		return product;
//	}
}
