package fire.petshop.favorit.form;
/**类名称:ProductForm
 * 描述:封装产品的基本信息
 * 属性:getXXX()活得属性  setXXX(String x)设置属性
 * 变量:productId 产品id  Name 名称
 * 编写者:杨凡
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class ProductForm {
	private String ProductId;
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	
}
