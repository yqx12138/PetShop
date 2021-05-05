package fire.petshop.loginandregist.base;

import java.sql.*;
import fire.petshop.common.base.ConnectionBase;
/**������:BaseDao
 * ����:�������ݿ�
 * ��д��:����
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-1
 * */
public class BaseDao extends ConnectionBase {

	private java.sql.Connection con = null;

	private java.sql.Statement stm = null;

	private ResultSet rs = null;

	private ConnectionBase connectionBase = new ConnectionBase();
	/**
	 * ��������:open
	 * ����:�����ݿ�
	 * ����:��
	 * ����ֵ:void
  	 * ��дʱ��:2006-11-28
         * ����޸�ʱ��:2006-12-1
	 * */
	public void open() throws SQLException {
		con = connectionBase.getConnection();
		try {
			stm = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * ��������:execudeQuery
	 * ����:��ѯ����
	 * ����ֵ:Rseult
	 * ����:��
	 * ��дʱ��:2006-11-28
         * ����޸�ʱ��:2006-12-1
	 * 
	 * */
	public ResultSet executeQuery(String sql) {
		try {
			rs = stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * ��������:executeUpdate
	 * ����:������ṩ�������ݿ�ķ���
	 * ����ֵ:int 
	 * ����:sql
	 * ��дʱ��:2006-11-28
         * ����޸�ʱ��:2006-12-1
	 * 
	 * */
	public int executeUpdate(String sql) {
		int i = 0;
		try {
			i = stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * ��������:executeUpdate
	 * ����:������ṩ�������ݿ�ķ���
	 * ����ֵ:void 
	 * ����:
	 * ��дʱ��:2006-11-28
         * ����޸�ʱ��:2006-12-1
	 * 
	 * */
	public void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (Exception ex) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
			}
		}
	}
}
