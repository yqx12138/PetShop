package fire.petshop.favorit.model;
/**������:Product
 * ����:��Ʒ�Ļ�����Ϣ
 * ����:getXXX()�������  setXXX(String x)��������
 * ����:productId ��Ʒid  category ���� name ��Ʒ���� 
 * ��д��:�
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class Product {
	
	private String productId;
	private String category;
	private String name;
	private String descn;
	
	public Product()
	{
		
	}
	/**��������:Product
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
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
