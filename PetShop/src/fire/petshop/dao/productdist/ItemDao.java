/**
*����:ItemDao.java
*��Ҫ����:��ҵ����ṩҪ�õ������ݿ�����
*��д��:������
*����޸�����:2006-11-28
*/
package fire.petshop.dao.productdist;

import java.sql.*;

import fire.petshop.common.base.ConnectionBase;

public class ItemDao {

	private Connection connection;
 /**
	 *������:open
	 *�޲���
	 *����ֵ:void
	 *��������:������ṩһ�������ݿ�����ķ���
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public void open() {
		ConnectionBase connectionBase = new ConnectionBase();
		try {
			connection = connectionBase.getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        /**
	 *������:executeUpdate
	 *����:sql
	 *����ֵ:boolean
	 *��������:������ṩһ�������ݿ���²�����һ������
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public boolean executeUpdate(String sql) {
		boolean flag = false;

		Statement statement = null;
		try {
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			int i = statement.executeUpdate(sql);
			if (i > 0)
				flag = true;
		} catch (SQLException e) {
			flag = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
          /**
	 * ������:executeQuery
	 * ����:sql
	 * ����ֵ:ResultSet
	 * ��������:������ṩһ����ѯ���ݿ������һ������
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public ResultSet executeQuery(String sql) {
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = connection
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
        /**
	 *������:close
	 *�޲���
     *����ֵ:void
	 *��������:������ṩһ���ر����ݿ������һ������
	 *��д��:������
     *����޸�����:2006-11-28
     */
	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
}
