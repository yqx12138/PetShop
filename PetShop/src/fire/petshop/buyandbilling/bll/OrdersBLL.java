package fire.petshop.buyandbilling.bll;

/**
 * ������OrdersBLL
 * ���ܣ������������ҵ��
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import fire.petshop.buyandbilling.form.OrdersForm;
import fire.petshop.buyandbilling.model.OrdersBean;
import fire.petshop.dao.buyandbilling.OrdersDAO;

public class OrdersBLL {

	/**
	 * ��������createOrder
	 * ����:OrdersForm�����ڴ���������OrdersForm
	 * ����ֵ��int�������¶�����ID��������ʧ�ܷ���-1
	 * ���ܣ�����OrdersForm�����ݿ��Orders���д���һ��������¼
	 */
	public static int createOrder(OrdersForm ordersForm) {
		
		OrdersBean ordersBean = formToBean(ordersForm);
		
		OrdersDAO ordersDAO = new OrdersDAO();
		
		return ordersDAO.insertOrder(ordersBean);
	}
	
	/**
	 * ��������formToBean
	 * ����:OrdersForm��ת��Դ
	 * ����ֵ��OrdersBean��ת��Ŀ��
	 * ���ܣ���OrdersFormת��ΪOrdersBean
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
