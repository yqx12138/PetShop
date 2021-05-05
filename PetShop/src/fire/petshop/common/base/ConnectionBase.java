package fire.petshop.common.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ������ConnectionBase ���ܣ��������ӣ�DAO���ͨ��������Connection����ʹ�����ͨ������ر����� ��д�ߣ����ٳ�
 * ��������ڣ�2006-11-28
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
	 * ��������initConn �������� ����ֵ���� ���ܣ���ʼ�������Connectionʵ��
	 */
	private void initConn() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/petshop?useUnicode=false&characterEncoding=gbk", "root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������getConnection �������� ����ֵ��java.sql.Connection ���ܣ���ô򿪵����Ӷ���
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
