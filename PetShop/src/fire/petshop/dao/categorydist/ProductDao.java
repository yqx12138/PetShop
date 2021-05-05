package fire.petshop.dao.categorydist;
/**
 * ����:ProductDao
 * ����:�����ݿ�,�������ݿ�,�ر����ݿ�
 * �༭��:����
 * ʱ��:2006-12-4 17:30
 * */
import java.sql.*;

import fire.petshop.common.base.ConnectionBase;

public class ProductDao {

	private Connection con=null;
	/**
	*������: open
	*����:  ��
	*����ֵ:  ��
	*����:  ��ConnectionBase�л������
	*�༭��:  ����
	*������ʱ��:2006-12-4 14:30
	*/
	
	public void open()
	{
		ConnectionBase connbase=new ConnectionBase();
		try {
			con=connbase.getConnection();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	*������:execQuery
	*����:String���� sql
	*����ֵ:ResultSet
	*����:���ݴ����sql��������һ��ResultSet
	*�༭��:����
	*������ʱ��:2006-12-4 14:40
	*/
	public ResultSet execQuery(String sql)
	{
		Statement st=null;
		ResultSet rs=null;
		
		try {
			st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=st.executeQuery(sql);
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return rs;
	}

	/**
	*������: close
	*����:  ��
	*����ֵ:  ��
	*����:  �ر�connection����  
	*�༭��:  ����
	*������ʱ��:2006-12-4 14:30
	*/

	public void close()
	{
		try {
			if(con!=null)
			{
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
