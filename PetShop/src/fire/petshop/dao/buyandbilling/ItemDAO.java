package fire.petshop.dao.buyandbilling;



/**
 * ������ItemDAO
 * ���ࣺBaseDAO
 *���ܣ��ṩ��Item��ķ��ʷ��� 
 *��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
	 * ��������queryItemByID 
	 *������ItemBean
	 *����ֵ��ItemBean
	 *���ܣ�ͨ���������ItemBean����
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
