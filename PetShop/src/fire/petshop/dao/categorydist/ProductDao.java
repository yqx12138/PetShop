package fire.petshop.dao.categorydist;
/**
 * 类名:ProductDao
 * 功能:打开数据库,操作数据库,关闭数据库
 * 编辑者:王鹏
 * 时间:2006-12-4 17:30
 * */
import java.sql.*;

import fire.petshop.common.base.ConnectionBase;

public class ProductDao {

	private Connection con=null;
	/**
	*方法名: open
	*参数:  无
	*返回值:  无
	*功能:  从ConnectionBase中或得连接
	*编辑者:  王鹏
	*最后更改时间:2006-12-4 14:30
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
	*方法名:execQuery
	*参数:String类型 sql
	*返回值:ResultSet
	*功能:根据传入得sql语句来获得一个ResultSet
	*编辑者:王鹏
	*最后更改时间:2006-12-4 14:40
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
	*方法名: close
	*参数:  无
	*返回值:  无
	*功能:  关闭connection连接  
	*编辑者:  王鹏
	*最后更改时间:2006-12-4 14:30
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
