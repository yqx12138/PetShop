package fire.petshop.buyandbilling.bll;

/**
 * 类名：LineItemBLL
 * 功能：处理购物车中条目的相关业务
 * 编写者：张少成
 * 最后变更日期：2006-12-04
 */

import java.util.ArrayList;
import java.util.List;

import fire.petshop.buyandbilling.form.LineItemForm;
import fire.petshop.buyandbilling.model.LineItemBean;
import fire.petshop.dao.buyandbilling.LineItemDAO;

public class LineItemBLL {
	
	/**
	 * 方法名：addLineItemsBatch
	 * 参数:List<LineItemForm>，将要插入数据库中的LineItemForm对象列表
	 * 返回值：boolean，返回指示是否执行成功
	 * 功能：批量将购物车中的LineItemForm列表插入到数据库的LineItem表中
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
