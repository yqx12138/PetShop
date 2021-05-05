package fire.petshop.buyandbilling.bll;

/**
 * ������CartBLL
 *���ܣ������ﳵ�����ҵ��
 *��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import java.math.*;

import fire.petshop.buyandbilling.form.*;
import fire.petshop.buyandbilling.model.*;
import fire.petshop.dao.buyandbilling.*;

public class CartBLL {
	
	/**
	 * ��������getCartItemFormByID
	 * ����:CartItemForm��������ID���Ե�CartItemForm����
	 * ����ֵ��CartItemForm����ѯ�õ���CartItemForm����
	 * ���ܣ�����ID��ѯCartItemForm����
	 */
	public static CartItemForm getCartItemFormByID(CartItemForm cartItemForm)
	{
		ItemBean itemBean = new ItemBean();
		itemBean.setItemId(cartItemForm.getItemId());
		
		ItemDAO itemDao = new ItemDAO();
		
		itemBean = itemDao.queryInventoryByID(itemBean);
		
		ProductBean productBean = new ProductBean();
		productBean.setProductId(itemBean.getProductId());
		
		ProductDAO productDao = new ProductDAO();
		
		productBean = productDao.queryProductByID(productBean);
		
		InventoryBean inventoryBean = new InventoryBean();
		inventoryBean.setItemId(itemBean.getItemId());
		
		InventoryDAO inventoryDao = new InventoryDAO();
		
		inventoryBean = inventoryDao.queryInventoryByID(inventoryBean);
		
		cartItemForm.setProduct(productBean.getName()+itemBean.getAttr1());
		cartItemForm.setQuantity(1);
		cartItemForm.setUnitPrice(new BigDecimal(itemBean.getListPrice(),new MathContext(2,RoundingMode.FLOOR)));
		
		if(cartItemForm.getQuantity() < inventoryBean.getQty())
		{
			cartItemForm.setInStock("�л�");
		}
		else
		{
			cartItemForm.setInStock("ȱ��");
		}
		cartItemForm.calculateSubTatal();
		
		return cartItemForm;
	}
}
