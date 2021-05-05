package fire.petshop.buyandbilling.listener;

/**
 * 类名：CreateCartListener 
 * 功能：监听Session的创建，并在Session创建成功后在session环境中创建Cart对象
 * 编写者：张少成
 * 最后变更日期：2006-12-04
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
