package fire.petshop.dao.favorit;

import java.sql.*;
import fire.petshop.common.base.ConnectionBase;
/**��������:BaseDao
 * ����:�������ݿ�
 * ��д��:�
 * ʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class BaseDao {	
	   private Connection connection;
	  
	   /**��������:open
	    * ����:�������ݿ�
	    * ����ֵ:void
	    * ��д��:�
	    * ʱ��:2006-11-28
	    * ����޸�ʱ��:2006-12-2
	    * */
	   public void open()
	   {
		  ConnectionBase  connectionBase=new ConnectionBase();
	      try {
			connection=connectionBase.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	   
	   }
	   /**��������:executeUpdate
	    * ����:��sql���ĸ��� ɾ�����޸�
	    * ����ֵ:boolean
	    * ����:sql--Ҫִ�е�sql���
	    * ����:i ִ��sql��������
	    * ��д��:�
	    * ʱ��:2006-11-28
	    * ����޸�ʱ��:2006-12-2
	    * */
	   public boolean executeUpdate(String sql)
	   {
		    Statement statement = null;
		    ResultSet resultSet = null;
	        boolean flag=false;
	        try {
	        	statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				int i=statement.executeUpdate(sql);
			    if(i>0)
			      flag=true;
	        } catch (SQLException e) {
	        	flag=false;
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return flag;
	   }
	   /**��������:executeQuery
	    * ����:��sql���Ĳ�ѯ
	    * ����ֵ: resultSet
	    * ����:sql--Ҫִ�е�sql���
	    * ����:i-- ִ��sql��������
	    * ��д��:�
	    * ʱ��:2006-11-28
	    * ����޸�ʱ��:2006-12-2
	    * */
	   public ResultSet executeQuery(String sql)
	   {
		    Statement statement = null;
		    ResultSet resultSet = null;
		    try {
		    	statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				resultSet=statement.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    return resultSet;
	   }
  	    /**��������:close
	    * ����:�����ݿ�Ĺر���
	    * ����ֵ: void
	    * ��д��:�
	    * ʱ��:2006-11-28
	    * ����޸�ʱ��:2006-12-2
	    * */
	   public void close()
	   {
		    try
		    {
		    	connection.close();
		    }catch(Exception e)
		    {
		    	System.out.print(e.toString());
		    }
	   }

}
