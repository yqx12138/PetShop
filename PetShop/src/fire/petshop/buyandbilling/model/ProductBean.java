package fire.petshop.buyandbilling.model;

/**
 * ������ProductBean
 * ���ܣ������Ӧ���ݿ���Product���ҵ���¼
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

public class ProductBean {
	
	private String productId;
	private String category;
	private String name;
	private String descn;
	
	public ProductBean()
	{}
	
	public ProductBean(String productId, String category, String name, String descn) {
		super();
		this.productId = productId;
		this.category = category;
		this.name = name;
		this.descn = descn;
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
