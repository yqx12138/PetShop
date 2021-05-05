package fire.petshop.buyandbilling.bll;

/**
 * 类名：OrdersBLL
 * 功能：处理订单的相关业务
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import fire.petshop.buyandbilling.form.OrdersForm;
import fire.petshop.buyandbilling.model.OrdersBean;
import fire.petshop.dao.buyandbilling.OrdersDAO;

public class OrdersBLL {

	/**
	 * 方法名：createOrder
	 * 参数:OrdersForm，用于创建订单的OrdersForm
	 * 返回值：int，返回新订单的ID，若创建失败返回-1
	 * 功能：根据OrdersForm在数据库的Orders表中创建一条订单记录
	 */
	public static int createOrder(OrdersForm ordersForm) {
		
		OrdersBean ordersBean = formToBean(ordersForm);
		
		OrdersDAO ordersDAO = new OrdersDAO();
		
		return ordersDAO.insertOrder(ordersBean);
	}
	
	/**
	 * 方法名：formToBean
	 * 参数:OrdersForm，转换源
	 * 返回值：OrdersBean，转换目标
	 * 功能：将OrdersForm转换为OrdersBean
	 */
	private static OrdersBean formToBean(OrdersForm ordersForm) {
		return new OrdersBean(ordersForm.getOrderId(), ordersForm.getUserId(),
				ordersForm.getOrderDate(), ordersForm.getShipAddr1(),
				ordersForm.getShipAddr2(), ordersForm.getShipCity(), ordersForm
						.getShipState(), ordersForm.getShipZip(), ordersForm
						.getShipCountry(), ordersForm.getBillAddr1(),
				ordersForm.getBillAddr2(), ordersForm.getBillCity(), ordersForm
						.getBillState(), ordersForm.getBillZip(), ordersForm
						.getBillCountry(), ordersForm.getCourier(), ordersForm
						.getTotalPrice(), ordersForm.getBillToFirstName(),
				ordersForm.getBillToLastName(),
				ordersForm.getShipToFirstName(),
				ordersForm.getShipToLastName(), ordersForm.getCardType(),
				ordersForm.getCreditCard(), ordersForm.getExprDate(),
				ordersForm.getLocal());
	}
}
