package fire.petshop.common.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 类名：ConnectionBase 功能：管理连接，DAO层可通过此类获得Connection对象，使用完毕通过此类关闭连接 编写者：张少成
 * 最后变更日期：2006-11-28
 */

public class ConnectionBase {

	private Connection conn = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法名：initConn 参数：无 返回值：无 功能：初始化此类的Connection实例
	 */
	private void initConn() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/petshop?useUnicode=false&characterEncoding=gbk", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法名：getConnection 参数：无 返回值：java.sql.Connection 功能：获得打开的连接对象
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			initConn();
		} else {
			if (conn.isClosed()) {
				initConn();
			}
		}

		return conn;
	}
}
