package fire.petshop.buyandbilling.form;

/**
 * ������OrderStatusForm
 * ���ܣ�������������״̬�ı�����Ϣ
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import java.util.Date;

public class OrderStatusForm {
	
	private int orderId;
	private int lineNum;
	private Date timeStamp;
	private String status;
	
	public OrderStatusForm()
	{}
	
	public OrderStatusForm(	int orderId, 
							int lineNum, 
							Date timeStamp, 
							String status
						   ) 
	{
		super();
		this.orderId = orderId;
		this.lineNum = lineNum;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	
	public int getLineNum() {
		return lineNum;
	}
	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
