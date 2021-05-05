
/**
*类名:SearchItemForm.java
*主要功能:把产品的基本信息封装成一个from便于让jsp页面调用
*主要方法:getXXX()获取属性,setXXX(String XXX)填充属性  
*编写者:周艳龙
*最后修改日期:2006-11-28
*/package fire.petshop.productdist.model;

public class SearchItemModel {
	 private String productId;
     private String attr1;
     private String description;
     public SearchItemModel()
     {
    	 
     }
     public SearchItemModel(String productId,String attr1,String description)
     {
    	 this.productId=productId;
    	 this.attr1=attr1;
    	 this.description=description;
     }
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
