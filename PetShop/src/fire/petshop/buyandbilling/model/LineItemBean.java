package fire.petshop.buyandbilling.model;

/**
 * 类名：LineItemBean
 * 功能：保存对应数据库中LineItem表的业务记录
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

public class LineItemBean {
	
	private int orderId;
	private int lineNum;
	private String itemId;
	private int quantity;
	private double unitPrice;
	
	public LineItemBean()
	{}
	
	public LineItemBean(	int orderId, 
							int lineNum, 
							String itemId, 
							int quantity, 
							double unitPrice
						) 
	{
		super();
		this.orderId = orderId;
		this.lineNum = lineNum;
		this.itemId = itemId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}
