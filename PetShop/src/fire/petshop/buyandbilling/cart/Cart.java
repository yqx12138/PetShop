package fire.petshop.buyandbilling.cart;

/**
 * ������Cart
 * ���ܣ������ﳵ���ҵ��
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import fire.petshop.buyandbilling.form.CartItemForm;

public class Cart {
	
	private ArrayList<CartItemForm> cartItems = new ArrayList<CartItemForm>();
	private BigDecimal totalPrice = new BigDecimal(0.0d);
	
	/**
	 * ��������addItem
	 * ����:CartItemForm����Ҫ���빺�ﳵ�б��е��е�CartItemForm����
	 * ����ֵ����
	 * ���ܣ�����CartItemForm��ӹ��ﳵ��Ŀ
	 */	
	public void addItem(CartItemForm itemForm)
	{
		cartItems.add(itemForm);
		calculateTotalPrice();
	}
	
	/**
	 * ��������removeItem
	 * ����:int����Ҫɾ���Ĺ��ﳵ��Ŀ�±�
	 * ����ֵ����
	 * ���ܣ�ɾ�����ﳵ��ָ������Ŀ
	 */
	public void removeItem(int index)
	{
		cartItems.remove(index);
		calculateTotalPrice();
	}
	
	/**
	 * ��������getCartItem
	 * ����:int����Ҫ���ҵĹ��ﳵ��Ŀ�±�
	 * ����ֵ��CartItemForm�����ҵ��Ĺ��ﳵ��Ŀ����
	 * ���ܣ������±���ҹ��ﳵ��Ŀ
	 */
	public CartItemForm getCartItem(int index)
	{
		return cartItems.get(index);
	}
	
	/**
	 * ��������getItemCount
	 * ����:��
	 * ����ֵ��int�����ﳵ�е���Ŀ��
	 * ���ܣ��鿴���ﳵ�е���Ŀ��
	 */
	public int getItemCount()
	{
		return cartItems.size();
	}
	
	/**
	 * ��������calculateTotalPrice
	 * ����:��
	 * ����ֵ����
	 * ���ܣ����㹺�ﳵ����Ʒ���ܼ۸�
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
	 * ��������getTotalPrice
	 * ����:��
	 * ����ֵ��BigDecimal����õ��ܼ۸�
	 * ���ܣ��鿴���ﳵ����Ŀ���ܼ۸�
	 */
	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}

	/**
	 * ��������getCartItems
	 * ����:��
	 * ����ֵ��ArrayList<CartItemForm>�����ﳵ�е���Ŀ�б����
	 * ���ܣ���ù��ﳵ�е���Ŀ�б���������
	 */
	public ArrayList<CartItemForm> getCartItems() {
		return cartItems;
	}
	
	/**
	 * ��������clearCart
	 * ����:��
	 * ����ֵ����
	 * ���ܣ���չ��ﳵ�е���Ŀ�б�
	 */
	public void clearCart()
	{
		cartItems.clear();
	}
}
