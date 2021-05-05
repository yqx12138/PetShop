package fire.petshop.loginandregist.base;

import java.sql.*;
import fire.petshop.common.base.ConnectionBase;
/**类名称:BaseDao
 * 功能:连接数据库
 * 编写者:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
 * */
public class BaseDao extends ConnectionBase {

	private java.sql.Connection con = null;

	private java.sql.Statement stm = null;

	private ResultSet rs = null;

	private ConnectionBase connectionBase = new ConnectionBase();
	/**
	 * 方法名称:open
	 * 功能:打开数据库
	 * 参数:无
	 * 返回值:void
  	 * 编写时间:2006-11-28
         * 最后修改时间:2006-12-1
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
	 * 方法名称:execudeQuery
	 * 功能:查询方法
	 * 返回值:Rseult
	 * 参数:无
	 * 编写时间:2006-11-28
         * 最后修改时间:2006-12-1
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
	 * 方法名称:executeUpdate
	 * 功能:向外界提供更新数据库的方法
	 * 返回值:int 
	 * 参数:sql
	 * 编写时间:2006-11-28
         * 最后修改时间:2006-12-1
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
	 * 方法名称:executeUpdate
	 * 功能:向外界提供更新数据库的方法
	 * 返回值:void 
	 * 参数:
	 * 编写时间:2006-11-28
         * 最后修改时间:2006-12-1
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
