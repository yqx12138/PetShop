package fire.petshop.buyandbilling.bll;

/**
 * 类名：CartBLL
 *功能：处理购物车的相关业务
 *编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.math.*;

import fire.petshop.buyandbilling.form.*;
import fire.petshop.buyandbilling.model.*;
import fire.petshop.dao.buyandbilling.*;

public class CartBLL {
	
	/**
	 * 方法名：getCartItemFormByID
	 * 参数:CartItemForm，设置了ID属性的CartItemForm对象
	 * 返回值：CartItemForm，查询得到的CartItemForm对象
	 * 功能：根据ID查询CartItemForm对象
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
			cartItemForm.setInStock("有货");
		}
		else
		{
			cartItemForm.setInStock("缺货");
		}
		cartItemForm.calculateSubTatal();
		
		return cartItemForm;
	}
}
