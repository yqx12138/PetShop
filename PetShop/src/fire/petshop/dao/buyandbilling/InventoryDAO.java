package fire.petshop.dao.buyandbilling;

/**
 * 类名：InventoryDAO
 * 父类：BaseDAO
 *功能：提供对inventory表的访问方法 
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fire.petshop.buyandbilling.model.InventoryBean;

public class InventoryDAO extends BaseDAO {

	public InventoryDAO() {
		super();
	}

/**
	 * 方法名：open 参数：无 返回值：无 功能：获得打开的Connection实例
	 */
	public void open() {
		super.open();
	}

	/**
	 * 方法名：queryInventoryByID 
	 *参数：InventoryBean
	 *返回值：InventoryBean
	 *功能：通过主健获得InventoryBean对象
	 */
	public InventoryBean queryInventoryByID(InventoryBean inventoryBean) {
		
		String sql = "select itemid , qty from inventory where itemid='"+inventoryBean.getItemId()+"'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if(conn != null && !conn.isClosed())
			{
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				rs.next();
				inventoryBean.setQty(rs.getInt("qty"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		
		return inventoryBean;
	}
}
