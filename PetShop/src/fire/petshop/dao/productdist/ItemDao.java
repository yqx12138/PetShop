/**
*类名:ItemDao.java
*主要功能:向业务层提供要用到的数据库连接
*编写者:周艳龙
*最后修改日期:2006-11-28
*/
package fire.petshop.dao.productdist;

import java.sql.*;

import fire.petshop.common.base.ConnectionBase;

public class ItemDao {

	private Connection connection;
 /**
	 *方法名:open
	 *无参数
	 *返回值:void
	 *功能描述:想外界提供一个打开数据库操作的方法
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
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
	 *方法名:executeUpdate
	 *参数:sql
	 *返回值:boolean
	 *功能描述:向外界提供一个根数据库更新操作的一个方法
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
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
	 * 方法名:executeQuery
	 * 参数:sql
	 * 返回值:ResultSet
	 * 功能描述:向外界提供一个查询数据库操作的一个方法
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
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
	 *方法名:close
	 *无参数
     *返回值:void
	 *功能描述:向外界提供一个关闭数据库操作的一个方法
	 *编写者:周艳龙
     *最后修改日期:2006-11-28
     */
	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
}
