/**
*类名:SearchItemForm.java
*主要功能:把产品的基本信息封装成一个from便于让jsp页面调用
*主要方法:getXXX()获取属性,setXXX(String XXX)填充属性  
*编写者:周艳龙
*最后修改日期:2006-11-28
*/
package fire.petshop.productdist.model;
public class ItemDetailModel 
{
	private String itemId;
    private String productId;
    private String listPrice;
    private String unitCost;
    private String supplier;
    private String status;
    private String attr1;
    private String attr2;
    private String attr3;
    private String attr4;
    private String attr5;
    private String qty;
 
public ItemDetailModel()
   {
	   
   }
    public ItemDetailModel(String itemId,String attr1,String listPrice)
    {
    	  this.itemId=itemId;
          this.attr1=attr1;
          this.listPrice=listPrice;
    }
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	public String getAttr3() {
		return attr3;
	}
	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}
	public String getAttr4() {
		return attr4;
	}
	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}
	public String getAttr5() {
		return attr5;
	}
	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getListPrice() {
		return listPrice;
	}
	public void setListPrice(String listPrice) {
		this.listPrice = listPrice;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}
	  public String getQty() {
			return qty;
		}
		public void setQty(String qty) {
			this.qty = qty;
		}
}
