package fire.petshop.dao.buyandbilling;



/**
 * 类名：ItemDAO
 * 父类：BaseDAO
 *功能：提供对Item表的访问方法 
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fire.petshop.buyandbilling.model.ItemBean;

public class ItemDAO extends BaseDAO{

	public ItemDAO() {
		super();
	}

	public void open() {
		super.open();
	}
	
	
	/**
	 * 方法名：queryItemByID 
	 *参数：ItemBean
	 *返回值：ItemBean
	 *功能：通过主健获得ItemBean对象
	 */
	public ItemBean queryInventoryByID(ItemBean itemBean) {
		
		String sql = "select itemid,productid,listprice,attr1 from item where itemid='"+itemBean.getItemId()+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if(conn != null && !conn.isClosed())
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				itemBean.setProductId(rs.getString("productid"));
				itemBean.setListPrice(rs.getDouble("listprice"));
				itemBean.setAttr1(rs.getString("attr1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		
		return itemBean;
	}

}
