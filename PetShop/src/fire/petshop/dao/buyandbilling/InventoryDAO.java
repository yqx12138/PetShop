package fire.petshop.dao.buyandbilling;

/**
 * ������InventoryDAO
 * ���ࣺBaseDAO
 *���ܣ��ṩ��inventory��ķ��ʷ��� 
 *��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
	 * ��������open �������� ����ֵ���� ���ܣ���ô򿪵�Connectionʵ��
	 */
	public void open() {
		super.open();
	}

	/**
	 * ��������queryInventoryByID 
	 *������InventoryBean
	 *����ֵ��InventoryBean
	 *���ܣ�ͨ���������InventoryBean����
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
