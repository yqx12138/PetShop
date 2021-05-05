package fire.petshop.favorit.model;
/**类名称:Product
 * 描述:产品的基本信息
 * 属性:getXXX()活得属性  setXXX(String x)设置属性
 * 变量:productId 产品id  category 种类 name 产品名称 
 * 编写者:杨凡
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class Product {
	
	private String productId;
	private String category;
	private String name;
	private String descn;
	
	public Product()
	{
		
	}
	/**方法名称:Product
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public Product(String productId,String category,String name,String descn)
	{
		this.productId=productId;
		this.category=category;
		this.name=name;
		this.descn=descn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	

	

}
