package fire.petshop.buyandbilling.form;

/**
 * 类名：OrderStatusForm
 * 功能：保存描述订单状态的必须信息
 * 编写者：张少成
 * 最后变更日期：2006-12-04
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
