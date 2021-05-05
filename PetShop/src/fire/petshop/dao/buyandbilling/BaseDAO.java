package fire.petshop.dao.buyandbilling;

/**
 * 类名：BaseDAO
*功能：提供可用的数据库联接对象 
*编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.Connection;
import java.sql.SQLException;
import fire.petshop.common.base.ConnectionBase;

public class BaseDAO {
	
	protected Connection conn = null;

	protected BaseDAO() {
		open();
	}

/**
	 * 方法名：open 参数：无 返回值：无 功能：获得打开的Connection实例
	 */
	protected void open() {
		ConnectionBase cb = new ConnectionBase();
		try {
			conn = cb.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

/**
	 * 方法名：close 参数：无 返回值：无 功能：关闭打开的Connection实例
	 */
	protected void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
