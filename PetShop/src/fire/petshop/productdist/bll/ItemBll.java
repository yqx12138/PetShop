/**
 *����:ItemBll.java
 *��Ҫ����:������ṩ�Բ�Ʒ���������з���
 *����:������
 *�༭����:2006-11-28  
 *����޸�ʱ��:2006-12-2 15:27:49
 */
package fire.petshop.productdist.bll;

import java.sql.*;
import java.util.ArrayList;

import fire.petshop.common.util.PageUtil;
import fire.petshop.dao.productdist.ItemDao;
import fire.petshop.productdist.form.ItemDetailForm;
import fire.petshop.productdist.form.ItemForm;
import fire.petshop.productdist.form.SearchItemForm;
import fire.petshop.productdist.model.ItemDetailModel;
import fire.petshop.productdist.model.ItemModel;
import fire.petshop.productdist.model.SearchItemModel;

public class ItemBll {

	/**
	 * ������:getItemList ����:ProductId,page ����ֵ:ArrayList
	 * ����:���ݴ���Ĳ��������ж�Ӧ����Ʒ�����,��װ��form,�ٰ�form��ӵ�������,����Լ��ϵ���ʽ���� ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public static ArrayList getItemList(String ProductId, PageUtil page) {
		ItemDao itemDao = new ItemDao();

		int pageindex = page.getPageIndex();
		int Items = page.getItemCountPerPage();
		int count = (pageindex - 1) * Items + 1;
		String sql = "select * from item where productid = '"
				+ ProductId + "'";
		ArrayList arrayList = new ArrayList();
		try {
			itemDao.open();
			ResultSet resultSet = itemDao.executeQuery(sql);
			boolean res = resultSet.absolute(count);
			if(res)
			{
				for (int i = 0; i < Items; i++) {
					
					ItemModel itemModel = new ItemModel();
					itemModel.setItemId(resultSet.getString(1));
					itemModel.setListPrice(resultSet.getString(3));
					itemModel.setAttr1(resultSet.getString(7));
					ItemForm itemForm = itModelToForm(itemModel);
					arrayList.add(itemForm);
					if (!resultSet.next())
						break;
				}
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			itemDao.close();
		}
		return arrayList;
	}

	/**
	 * ������:getSearchItemList ����:searchItem,page ����ֵ:ArrayList
	 * ����:���ݴ���Ĳ��������ж�Ӧ����Ʒ�����,��װ��form,�ٰ�form��ӵ�������,����Լ��ϵ���ʽ���� ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public static ArrayList getSearchItemList(String searchItem, PageUtil p) {
		ItemDao itemDao = new ItemDao();

		int pageIndex = p.getPageIndex();
		int pageSize = p.getItemCountPerPage();
		int current = (pageIndex - 1) * pageSize + 1;

		String sql = "select * from product where `name` like '%"
				+ searchItem + "%'";
		//System.out.print(sql);
		ArrayList arrayList = new ArrayList();
		try {
			itemDao.open();
			ResultSet resultSet = itemDao.executeQuery(sql);
			boolean res = resultSet.absolute(current);
			
			if(res)
			{
				for (int i = 0; i < pageSize; i++) {
					SearchItemModel searchItemModel = new SearchItemModel(resultSet
							.getString(1), resultSet.getString(3), resultSet
							.getString(4));
					SearchItemForm searchItemForm = searchModelToForm(searchItemModel);
					arrayList.add(searchItemForm);
					if (!resultSet.next()) {
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			itemDao.close();
		}
		return arrayList;
	}

	/**
	 * ������:getItemDetalis ����:itemId ����ֵ:ItemDetailForm
	 * ����:���ݴ���Ĳ���������Ӧ����Ʒ����ϸ��Ϣ�����,��װ��form���� ��д��:������ ����޸�����:2006-11-28
	 */
	public static ItemDetailForm getItemDetalis(String ItemId) {
		ItemDao itemDao = new ItemDao();

		String sql = "select * from item where itemId='" + ItemId
				+ "'";
		// System.out.print(sql);
		ItemDetailForm itemDetailForm = null;
		itemDao.open();
		try {
			ResultSet resultSet = itemDao.executeQuery(sql);
			if (resultSet.next()) {
				ItemDetailModel itemDetaModel = new ItemDetailModel(resultSet
						.getString(1), resultSet.getString(7), resultSet
						.getString(3));
				itemDetailForm = iDModelToForm(itemDetaModel);
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			// itemDao.close();
		}
		return itemDetailForm;
	}

	/**
	 * ������:getProductID ����:itemId ����ֵ:String ����:���ݴ���Ĳ���������Ӧ����Ʒ��ProductId����
	 * ��д��:������ ����޸�����:2006-11-28
	 */
	public static String getProductID(String itemId) {
		ItemDao itemDao = new ItemDao();

		String productID = null;
		String sql = "select productID from item where itemId='"
				+ itemId + "'";
		// System.out.print(sql);
		itemDao.open();
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				productID = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			itemDao.close();
		}
		return productID;
	}

	/**
	 * ������:getQtys ����:itemId ����ֵ:String ����:���ݴ���Ĳ���������Ӧ����Ʒ�Ŀ�淵�� ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public static String getQtys(String itemId) {
		ItemDao itemDao = new ItemDao();

		String qtys = null;
		String sql = "select qty from Inventory where itemId='"
				+ itemId + "'";
		System.out.print(sql);
		itemDao.open();
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				qtys = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			itemDao.close();
		}
		return qtys;
	}

	/**
	 * ������:getDescns ����:itemId ����ֵ:String ����:���ݴ���Ĳ���������Ӧ����Ʒ��һЩ������Ϣ���� ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public static String getDescns(String itemId) {
		ItemDao itemDao = new ItemDao();

		String descn = null;
		String sql = "select descn from product where productID='"
				+ getProductID(itemId) + "'";
		// System.out.print(sql);
		itemDao.open();
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			while (rs.next()) {
				descn = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			itemDao.close();
		}
		return descn;
	}

	/**
	 * ������:iDModelToForm ����:itemDetaliModel ����ֵ:ItemDetailForm
	 * ����:��ģ�Ͳ��е�����ת������ʾ���е�����,�Ա�jspҳ����� ��д��:������ ����޸�����:2006-11-28
	 */
	public static ItemDetailForm iDModelToForm(ItemDetailModel itemDetaliModel) {
		ItemDetailForm itemDetailForm = new ItemDetailForm();
		itemDetailForm.setItemId(itemDetaliModel.getItemId());
		itemDetailForm.setAttr1(itemDetaliModel.getAttr1());
		itemDetailForm.setListPrice(itemDetaliModel.getListPrice());
		// itemDetailForm.setQty(itemDetaliModel.getQty());
		return itemDetailForm;
	}

	/**
	 * ������:itModelToForm ����:itemModel ����ֵ:ItemForm
	 * ����:��ģ�Ͳ��е�����ת������ʾ���е�����,�Ա�jspҳ����� ��д��:������ ����޸�����:2006-11-28
	 */
	public static ItemForm itModelToForm(ItemModel itemModel) {
		ItemForm itemForm = new ItemForm();
		itemForm.setItemId(itemModel.getItemId());
		itemForm.setAttr1(itemModel.getAttr1());
		itemForm.setListPrice(itemModel.getListPrice());
		// System.out.print(itemModel.getListPrice()+"*******");
		return itemForm;
	}

	/**
	 * ������:searchModelToForm ����:searchItemModel ����ֵ:SearchItemForm
	 * ����:��ģ�Ͳ��е�����ת������ʾ���е�����,�Ա�jspҳ����� ��д��:������ ����޸�����:2006-11-28
	 */
	public static SearchItemForm searchModelToForm(
			SearchItemModel searchItemModel) {
		SearchItemForm searchItemForm = new SearchItemForm();
		searchItemForm.setProductId(searchItemModel.getProductId());
		searchItemForm.setAttr1(searchItemModel.getAttr1());
		searchItemForm.setDescription(searchItemModel.getDescription());
		// System.out.print(searchItemModel.getDescription()+" ");
		return searchItemForm;
	}

	/**
	 * ������:getCount ����:searchItem ����ֵ:int ����:��������Ĳ�����Ҫ���ҵļ�¼���������� ��д��:������
	 * ����޸�����:2006-11-28
	 */
	public static int getCount(String searchItem) {
		ItemDao itemDao = new ItemDao();

		int count = 0;
		String sql = "select count(*) from product where `name` like '%"
				+ searchItem + "%'";
		itemDao.open();
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			itemDao.close();
		}
		return count;
	}

	/**
	 * ������: ����:ProductId ����ֵ:int ����:��������Ĳ����Ѷ�Ӧ��¼���������� ��д��:������ ����޸�����:2006-11-28
	 */
	public static int getCountItemList(String ProductId) {
		ItemDao itemDao = new ItemDao();

		int count = 0;
		String sql = "select count(*) from item where ProductId='"
				+ ProductId + "'";
		itemDao.open();
		ResultSet rs = itemDao.executeQuery(sql);
		try {
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			itemDao.close();
		}
		return count;
	}
}
