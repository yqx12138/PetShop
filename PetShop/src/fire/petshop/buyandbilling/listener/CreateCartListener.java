package fire.petshop.buyandbilling.listener;

/**
 * ������CreateCartListener 
 * ���ܣ�����Session�Ĵ���������Session�����ɹ�����session�����д���Cart����
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import fire.petshop.buyandbilling.cart.Cart;

public class CreateCartListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		
		Cart cart = new Cart();

		arg0.getSession().setAttribute("cart", cart);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {

	}

}
