package fire.petshop.categorydist.model;
/**
 * 类名:ProductModel 
 * 功能:对应数据库表的字段,可以取出和写入 bll和dao可调用
 * 编辑者:王鹏
 * 时间:2006-11-28 12:00
 */
public class ProductModel {
	private String productId;
	private String category;
	private String name;
	private String descn;
	public void setProductId(String productId)
	{
		this.productId=productId;
	}
	public void setCategory(String category)
	{
		this.category=category;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setDescn(String descn)
	{
		this.descn=descn;
	}
	public String getProductId()
	{
		return productId;
	}
	public String getCategory()
	{
		return category;
	}
	public String getName()
	{
		return name;
	}
	public String getDescn()
	{
		return descn;
	}
}
