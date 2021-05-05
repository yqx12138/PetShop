package fire.petshop.buyandbilling.model;

/**
 * ������InventoryBean
 * ���ܣ������Ӧ���ݿ���Inventory���ҵ���¼
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
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
