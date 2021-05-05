package fire.petshop.dao.favorit;

import java.sql.*;
import fire.petshop.common.base.ConnectionBase;
/**方法名称:BaseDao
 * 功能:连接数据库
 * 编写者:杨凡
 * 时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class BaseDao {	
	   private Connection connection;
	  
	   /**方法名称:open
	    * 功能:连接数据库
	    * 返回值:void
	    * 编写者:杨凡
	    * 时间:2006-11-28
	    * 最后修改时间:2006-12-2
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
	   /**方法名称:executeUpdate
	    * 功能:对sql语句的更新 删除和修改
	    * 返回值:boolean
	    * 参数:sql--要执行的sql语句
	    * 变量:i 执行sql语句的数量
	    * 编写者:杨凡
	    * 时间:2006-11-28
	    * 最后修改时间:2006-12-2
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
	   /**方法名称:executeQuery
	    * 功能:对sql语句的查询
	    * 返回值: resultSet
	    * 参数:sql--要执行的sql语句
	    * 变量:i-- 执行sql语句的数量
	    * 编写者:杨凡
	    * 时间:2006-11-28
	    * 最后修改时间:2006-12-2
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
  	    /**方法名称:close
	    * 功能:对数据库的关闭流
	    * 返回值: void
	    * 编写者:杨凡
	    * 时间:2006-11-28
	    * 最后修改时间:2006-12-2
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
