package fire.petshop.dao.buyandbilling;

/**
 * 类名：OrdersDAO
 * 父类：BaseDAO
 *功能：提供对Orders表的访问方法 
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.*;

import fire.petshop.buyandbilling.model.OrdersBean;
import fire.petshop.common.util.DateUtil;

public class OrdersDAO extends BaseDAO {

	public OrdersDAO() {
		super();
	}

	/**
	 * 方法名：open 
	 *参数：无 
	 *返回值：无 
	 *功能：获得打开的Connection实例
	 */
	public void open() {
		super.open();
	}

	/**
	 * 方法名：insertOrder
	 *参数:OrdersBean，将要插入数据库的ordersBean对象
	 *返回值：boolean，提示是否执行成功
	 *功能：插入OrdersBean对象到数据库Orders表
	 */
	public int insertOrder(OrdersBean ordersBean) {

		int identity = -1;
		
		String sql = "insert into orders";
		sql += "(userId,orderDate,shipAddr1,shipAddr2,shipCity,";
		sql += "shipState,shipZip,shipCountry,billAddr1,billAddr2,billCity,";
		sql += "billState,billZip,billCountry,courier,totalPrice,billToFirstName,billToLastName,";
		sql += "shipToFirstName,shipToLastName,cardType,creditCard,exprDate,locale) values";	
		sql += "('"	+ordersBean.getUserId()+"','"
					+DateUtil.dateFormatToString(ordersBean.getOrderDate())+"','"
					+ordersBean.getShipAddr1()+"','"
					+ordersBean.getShipAddr2()+"','"
					+ordersBean.getShipCity()+"','"
					+ordersBean.getShipState()+"','"
					+ordersBean.getShipZip()+"','"
					+ordersBean.getShipCountry()+"','"
					+ordersBean.getBillAddr1()+"','"
					+ordersBean.getBillAddr2()+"','"
					+ordersBean.getBillCity()+"','"
					+ordersBean.getBillState()+"','"
					+ordersBean.getBillZip()+"','"
					+ordersBean.getBillCountry()+"','"
					+ordersBean.getCourier()+"',"
					+ordersBean.getTotalPrice()+",'"
					+ordersBean.getBillToFirstName()+"','"
					+ordersBean.getBillToLastName()+"','"
					+ordersBean.getShipToFirstName()+"','"
					+ordersBean.getShipToLastName()+"','"
					+ordersBean.getCardType()+"','"
					+ordersBean.getCreditCard()+"','"
					+DateUtil.dateFormatToString(ordersBean.getExprDate())+"','"
					+ordersBean.getLocal()+"')";
		
		String sql1 = "select @@IDENTITY";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn.setAutoCommit(false);
			
			if (conn != null && !conn.isClosed()) {
				
				stmt = conn.createStatement();
				int res = stmt.executeUpdate(sql);
				if (res > 0) {

					rs = stmt.executeQuery(sql1);
					rs.next();
					identity = rs.getInt(1);
					conn.commit();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
				identity = -1;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close();
		}
		return identity;
	}
}
