package fire.petshop.buyandbilling.model;

/**
 * 类名：ItemBean
 * 功能：保存对应数据库中Item表的业务记录
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

public class ItemBean {
	private String itemId;
	private String productId;
	private double listPrice;
	private String attr1;
	
	public ItemBean()
	{}
	
	public ItemBean(String itemId, String productId, double listPrice, String attr1) {
		super();
		this.itemId = itemId;
		this.productId = productId;
		this.listPrice = listPrice;
		this.attr1 = attr1;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getListPrice() {
		return listPrice;
	}

	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
