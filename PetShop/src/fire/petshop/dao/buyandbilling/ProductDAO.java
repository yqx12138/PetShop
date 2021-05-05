package fire.petshop.dao.buyandbilling;

/**
 * ������ProductDAO
 * ���ࣺBaseDAO
 *���ܣ��ṩ��Product��ķ��ʷ��� 
 *��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
	 * ��������open 
	 *�������� 
	 *����ֵ���� 
	 *���ܣ���ô򿪵�Connectionʵ��
	 */
	public void open() {
		super.open();
	}

	/**
	 * ��������queryProductByID
	 * ����:ProductBean ����Ҫ��ѯ��ProductBean����
	 * ����ֵ��ProductBean�����ز�ѯ����ProductBean����
	 * ���ܣ�����������productId���Ե�ProductBean���󣬲�ѯ���ݿⷵ�ض�Ӧ��ProductBean����	 
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
