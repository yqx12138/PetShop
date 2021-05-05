package fire.petshop.dao.buyandbilling;

/**
 * 类名：LineItemDAO
 * 父类：BaseDAO
 *功能：提供对LineItem表的访问方法 
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import fire.petshop.buyandbilling.model.LineItemBean;

public class LineItemDAO extends BaseDAO {

	public LineItemDAO() {
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
	 * 方法名：insertLineItemBatch 
	 *参数:List<LineItemBean>，将要插入数据库的LineItemBean列表
	 *返回值：boolean，提示是否执行成功
	 *功能：批量插入LineItemBean对象到数据库LineItem表
	 */
	public boolean insertLineItemBatch(List<LineItemBean> lineItems)
	{
		boolean flag = false;

		String preparesql = "insert into LineItem";
		preparesql += "(orderId,lineNum,itemId,quantity,unitPrice) values";
		preparesql += "(?,?,?,?,?)";
				
		PreparedStatement pstmt = null;

		try {
			conn.setAutoCommit(false);
			
			if (conn != null && !conn.isClosed()) {
				
				pstmt = conn.prepareStatement(preparesql);
				
				for(LineItemBean lineItem : lineItems)
				{
					pstmt.setInt(1, lineItem.getOrderId());
					pstmt.setInt(2, lineItem.getLineNum());
					pstmt.setString(3, lineItem.getItemId());
					pstmt.setInt(4, lineItem.getQuantity());
					pstmt.setDouble(5, lineItem.getUnitPrice());
					
					pstmt.addBatch();
				}
				
				int[] res = pstmt.executeBatch();
				
				for(int i : res)
				{
					flag = true;
					if(i < 1)
					{
						flag = false;
						break;
					}
				}
				
				if (flag) {
					conn.commit();
				}
				else
				{
					conn.rollback();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			close();
		}
		return flag;
	}
}
