package fire.petshop.buyandbilling.cart;

/**
 * 类名：Cart
 * 功能：处理购物车相关业务
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import fire.petshop.buyandbilling.form.CartItemForm;

public class Cart {
	
	private ArrayList<CartItemForm> cartItems = new ArrayList<CartItemForm>();
	private BigDecimal totalPrice = new BigDecimal(0.0d);
	
	/**
	 * 方法名：addItem
	 * 参数:CartItemForm，将要插入购物车列表中的中的CartItemForm对象
	 * 返回值：无
	 * 功能：根据CartItemForm添加购物车条目
	 */	
	public void addItem(CartItemForm itemForm)
	{
		cartItems.add(itemForm);
		calculateTotalPrice();
	}
	
	/**
	 * 方法名：removeItem
	 * 参数:int，将要删除的购物车条目下标
	 * 返回值：无
	 * 功能：删除购物车中指定的条目
	 */
	public void removeItem(int index)
	{
		cartItems.remove(index);
		calculateTotalPrice();
	}
	
	/**
	 * 方法名：getCartItem
	 * 参数:int，将要查找的购物车条目下标
	 * 返回值：CartItemForm，查找到的购物车条目对象
	 * 功能：根据下表查找购物车条目
	 */
	public CartItemForm getCartItem(int index)
	{
		return cartItems.get(index);
	}
	
	/**
	 * 方法名：getItemCount
	 * 参数:无
	 * 返回值：int，购物车中的条目数
	 * 功能：查看购物车中的条目数
	 */
	public int getItemCount()
	{
		return cartItems.size();
	}
	
	/**
	 * 方法名：calculateTotalPrice
	 * 参数:无
	 * 返回值：无
	 * 功能：计算购物车中物品的总价格
	 */
	public void calculateTotalPrice()
	{
		BigDecimal sum = new BigDecimal(0.0d);
		
		for(CartItemForm item : cartItems)
		{
			sum = sum.add(item.getSubtotal());
		}
		
		totalPrice = sum;
	}
	
	/**
	 * 方法名：getTotalPrice
	 * 参数:无
	 * 返回值：BigDecimal，或得的总价格
	 * 功能：查看购物车中条目的总价格
	 */
	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}

	/**
	 * 方法名：getCartItems
	 * 参数:无
	 * 返回值：ArrayList<CartItemForm>，购物车中的条目列表对象
	 * 功能：获得购物车中的条目列表对象的引用
	 */
	public ArrayList<CartItemForm> getCartItems() {
		return cartItems;
	}
	
	/**
	 * 方法名：clearCart
	 * 参数:无
	 * 返回值：无
	 * 功能：清空购物车中的条目列表
	 */
	public void clearCart()
	{
		cartItems.clear();
	}
}
