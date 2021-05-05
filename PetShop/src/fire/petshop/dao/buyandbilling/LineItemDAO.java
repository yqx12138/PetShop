package fire.petshop.dao.buyandbilling;

/**
 * ������LineItemDAO
 * ���ࣺBaseDAO
 *���ܣ��ṩ��LineItem��ķ��ʷ��� 
 *��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
	 * ��������open 
	 *�������� 
	 *����ֵ���� 
	 *���ܣ���ô򿪵�Connectionʵ��
	 */
	public void open() {
		super.open();
	}
	

	/**
	 * ��������insertLineItemBatch 
	 *����:List<LineItemBean>����Ҫ�������ݿ��LineItemBean�б�
	 *����ֵ��boolean����ʾ�Ƿ�ִ�гɹ�
	 *���ܣ���������LineItemBean�������ݿ�LineItem��
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
