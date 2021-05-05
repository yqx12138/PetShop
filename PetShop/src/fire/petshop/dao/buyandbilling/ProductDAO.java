package fire.petshop.dao.buyandbilling;

/**
 * 类名：ProductDAO
 * 父类：BaseDAO
 *功能：提供对Product表的访问方法 
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fire.petshop.buyandbilling.model.ProductBean;

public class ProductDAO extends BaseDAO {
	
	public ProductDAO() {
		super();
	}

	/**
	 * 方法名：open 
	 *参数：无 
	 *返回值：无 
	 *功能：获得打开的Connection实例
	 */
	public void open() {
		super.open();
	}

	/**
	 * 方法名：queryProductByID
	 * 参数:ProductBean ，将要查询的ProductBean对象
	 * 返回值：ProductBean，返回查询出的ProductBean对象
	 * 功能：传入设置了productId属性的ProductBean对象，查询数据库返回对应的ProductBean对象	 
*/
	public ProductBean queryProductByID(ProductBean productBean) {
		
		String sql = "select productid,category,`name`,descn from product where productid='"+productBean.getProductId()+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if(conn != null && !conn.isClosed())
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				productBean.setName(rs.getString("name"));
				productBean.setCategory(rs.getString("category"));
				productBean.setDescn(rs.getString("descn"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		
		return productBean;
	}
}
