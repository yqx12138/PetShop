package fire.petshop.buyandbilling.bll;

/**
 * ������LineItemBLL
 * ���ܣ������ﳵ����Ŀ�����ҵ��
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-12-04
 */

import java.util.ArrayList;
import java.util.List;

import fire.petshop.buyandbilling.form.LineItemForm;
import fire.petshop.buyandbilling.model.LineItemBean;
import fire.petshop.dao.buyandbilling.LineItemDAO;

public class LineItemBLL {
	
	/**
	 * ��������addLineItemsBatch
	 * ����:List<LineItemForm>����Ҫ�������ݿ��е�LineItemForm�����б�
	 * ����ֵ��boolean������ָʾ�Ƿ�ִ�гɹ�
	 * ���ܣ����������ﳵ�е�LineItemForm�б���뵽���ݿ��LineItem����
	 */
	public static boolean addLineItemsBatch(List<LineItemForm> lineItemForms)
	{	
		List<LineItemBean> lineItems = new ArrayList<LineItemBean>();
		
		for(LineItemForm lineItemForm : lineItemForms)
		{
			lineItems.add(formToBean(lineItemForm));
		}
		
		LineItemDAO lineItemDAO = new LineItemDAO();
		
		return lineItemDAO.insertLineItemBatch(lineItems);
	}
	
	public static LineItemBean formToBean(LineItemForm lineItemForm)
	{
		return new LineItemBean(
				lineItemForm.getOrderId(), 
				lineItemForm.getLineNum(), 
				lineItemForm.getItemId(), 
				lineItemForm.getQuantity(), 
				lineItemForm.getUnitPrice()		
		);
	}
}
