package fire.petshop.categorydist.form;
/**
 *类名:ProductForm  功能:从jsp页面获得相对应的值保存在ProductForm里面,
 *	  可以写进也可取出,在servlet和bll调用
 *编辑者:王鹏
 *时间:2006-11-28 12:00
 **/
public class ProductForm {
	private String productId;
	private String category;
	private String name;
	private String descn;
	public void setProductID(String productId)
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
