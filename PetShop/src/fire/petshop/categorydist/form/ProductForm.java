package fire.petshop.categorydist.form;
/**
 *����:ProductForm  ����:��jspҳ�������Ӧ��ֵ������ProductForm����,
 *	  ����д��Ҳ��ȡ��,��servlet��bll����
 *�༭��:����
 *ʱ��:2006-11-28 12:00
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
