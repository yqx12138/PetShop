package fire.petshop.buyandbilling.model;

/**
 * 类名：InventoryBean
 * 功能：保存对应数据库中Inventory表的业务记录
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

public class InventoryBean {
	
	private String itemId;
	private int qty;
	
	public InventoryBean()
	{}
	
	public InventoryBean(String itemId, int qty) {
		super();
		this.itemId = itemId;
		this.qty = qty;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
