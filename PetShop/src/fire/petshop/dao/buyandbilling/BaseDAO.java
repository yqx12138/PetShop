package fire.petshop.dao.buyandbilling;

/**
 * ������BaseDAO
*���ܣ��ṩ���õ����ݿ����Ӷ��� 
*��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
	 * ��������open �������� ����ֵ���� ���ܣ���ô򿪵�Connectionʵ��
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
	 * ��������close �������� ����ֵ���� ���ܣ��رմ򿪵�Connectionʵ��
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
