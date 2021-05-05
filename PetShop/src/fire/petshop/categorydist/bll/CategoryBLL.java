package fire.petshop.categorydist.bll;

	/**
	 * 类名:CategoryBLL
	 * 功能:主要用来调用dao来返回一个需要的ArrayList还有从CategoryModel到CategoryForm的转换
	 * 编辑者:王鹏
	 * 时间:2006-12-4 18:00*/

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
	*方法名:getCategory
	*返回值:ArrayList<CategoryForm>
	*功能:通过访问数据库获得petshop.dbo.category表中得Name字段
	*编辑者:王鹏
	*最后更改时间:2006-12-4 15:32
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
	*方法名:CategoryFormModelToForm
	*参数:CategoryModel类型 model
	*返回值:CategoryForm
	*功能:把CategoryModel类型转换成CategoryForm类型
	*编辑者:王鹏
	*最后更改时间:2006-12-4 14:00
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
