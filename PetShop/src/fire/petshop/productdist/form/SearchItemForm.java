/**
*����:SearchItemForm.java
*��Ҫ����:�Ѳ�Ʒ�Ļ�����Ϣ��װ��һ��from������jspҳ�����
*��Ҫ����:getXXX()��ȡ����,setXXX(String XXX)�������  
*��д��:������
*����޸�����:2006-11-28
*/
package fire.petshop.productdist.form;

public class SearchItemForm {
       private String productId;
       private String attr1;
       private String description;
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
