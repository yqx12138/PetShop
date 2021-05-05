package fire.petshop.buyandbilling.form;

/**
 * 类名：CartItemForm
 * 功能：保存一个购物车条目信息
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.math.*;

public class CartItemForm {
	
	private String itemId;
	private String product;
	private String inStock;
	private BigDecimal unitPrice;
	private int quantity;
	private BigDecimal subtotal;
	
	public CartItemForm()
	{
		this.itemId = "";
		this.product = "";
		this.inStock = "缺货";
		this.unitPrice = new BigDecimal(0.0d,new MathContext(2,RoundingMode.FLOOR));
		this.quantity = 0;
		this.subtotal = new BigDecimal(0.0d,new MathContext(2,RoundingMode.FLOOR));
	}

	public CartItemForm(String itemId, String product, String inStock, BigDecimal unitPrice, int quantity, BigDecimal subtotal) {
		this.itemId = itemId;
		this.product = product;
		this.inStock = inStock;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}


	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void calculateSubTatal()
	{
		subtotal = unitPrice.multiply(new BigDecimal(quantity));
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
}
