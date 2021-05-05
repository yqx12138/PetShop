package fire.petshop.categorydist.bll;

	/**
	 * ����:CategoryBLL
	 * ����:��Ҫ��������dao������һ����Ҫ��ArrayList���д�CategoryModel��CategoryForm��ת��
	 * �༭��:����
	 * ʱ��:2006-12-4 18:00*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fire.petshop.categorydist.form.CategoryForm;
import fire.petshop.categorydist.model.CategoryModel;
import fire.petshop.dao.categorydist.ProductDao;
	
public class CategoryBLL {
	
	private static ProductDao dao=new ProductDao();
	private static ResultSet rs=null;
	
	/**
	*������:getCategory
	*����ֵ:ArrayList<CategoryForm>
	*����:ͨ���������ݿ���petshop.dbo.category���е�Name�ֶ�
	*�༭��:����
	*������ʱ��:2006-12-4 15:32
	*/
	public static ArrayList<CategoryForm> getCategory()
	{
		ArrayList<CategoryForm> arry=new ArrayList<CategoryForm>();
		String sql="select `Name` from category";
		dao.open();
		rs=dao.execQuery(sql);
		try {
			while(rs.next())
			{
				CategoryModel model=new CategoryModel();
				model.setName(rs.getString("name"));
				CategoryForm form=CategoryModelToForm(model);
				arry.add(form);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			dao.close();
		}
		return arry;
	}
	/**
	*������:CategoryFormModelToForm
	*����:CategoryModel���� model
	*����ֵ:CategoryForm
	*����:��CategoryModel����ת����CategoryForm����
	*�༭��:����
	*������ʱ��:2006-12-4 14:00
	*/
	public static CategoryForm CategoryModelToForm(CategoryModel model)
	{
		CategoryForm form=new CategoryForm();
		form.setCatId(model.getCatId());
		form.setName(model.getName());
		form.setDescn(model.getDescn());
		return form;
	}
}
