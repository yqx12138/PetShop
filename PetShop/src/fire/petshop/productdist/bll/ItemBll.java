/**
 *类名:ItemBll.java
 *主要功能:向外界提供对产品操作的所有方法
 *编者:周艳龙
 *编辑日期:2006-11-28  
 *最后修改时间:2006-12-2 15:27:49
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
	 * 方法名:getItemList 参数:ProductId,page 返回值:ArrayList
	 * 功能:根据传入的参数把所有对应的商品查出来,封装成form,再把form添加到集合中,最后以集合的形式返回 编写者:周艳龙
	 * 最后修改日期:2006-11-28
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
	 * 方法名:getSearchItemList 参数:searchItem,page 返回值:ArrayList
	 * 功能:根据传入的参数把所有对应的商品查出来,封装成form,再把form添加到集合中,最后以集合的形式返回 编写者:周艳龙
	 * 最后修改日期:2006-11-28
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
	 * 方法名:getItemDetalis 参数:itemId 返回值:ItemDetailForm
	 * 功能:根据传入的参数把所对应的商品的详细信息查出来,封装成form返回 编写者:周艳龙 最后修改日期:2006-11-28
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
	 * 方法名:getProductID 参数:itemId 返回值:String 功能:根据传入的参数把所对应的商品的ProductId返回
	 * 编写者:周艳龙 最后修改日期:2006-11-28
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
	 * 方法名:getQtys 参数:itemId 返回值:String 功能:根据传入的参数把所对应的商品的库存返回 编写者:周艳龙
	 * 最后修改日期:2006-11-28
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
	 * 方法名:getDescns 参数:itemId 返回值:String 功能:根据传入的参数把所对应的商品的一些描述信息返回 编写者:周艳龙
	 * 最后修改日期:2006-11-28
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
	 * 方法名:iDModelToForm 参数:itemDetaliModel 返回值:ItemDetailForm
	 * 功能:把模型层中的数据转换成显示层中的数据,以便jsp页面调用 编写者:周艳龙 最后修改日期:2006-11-28
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
	 * 方法名:itModelToForm 参数:itemModel 返回值:ItemForm
	 * 功能:把模型层中的数据转换成显示层中的数据,以便jsp页面调用 编写者:周艳龙 最后修改日期:2006-11-28
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
	 * 方法名:searchModelToForm 参数:searchItemModel 返回值:SearchItemForm
	 * 功能:把模型层中的数据转换成显示层中的数据,以便jsp页面调用 编写者:周艳龙 最后修改日期:2006-11-28
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
	 * 方法名:getCount 参数:searchItem 返回值:int 功能:根据输入的参数把要查找的记录的条数返回 编写者:周艳龙
	 * 最后修改日期:2006-11-28
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
	 * 方法名: 参数:ProductId 返回值:int 功能:根据输入的参数把对应记录的条数返回 编写者:周艳龙 最后修改日期:2006-11-28
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
