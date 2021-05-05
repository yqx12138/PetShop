package fire.petshop.dao.favorit;

import java.sql.ResultSet;
import java.util.ArrayList;
import fire.petshop.common.util.PageUtil;
import fire.petshop.favorit.model.Product;
/**类名称:FavoritDao
 * 功能:对数据的修改和查询方法
 * 编写者:杨凡
 * 时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class FavoritDao {	
	
private static BaseDao baseDao = new BaseDao();	

	/**方法名称:showFavorit
 	* 功能:显示宠物信息并分页
 	* 返回值:arrayList
 	* 参数:userId--用户Id page 
 	* 变量:pageIndex 当前页 count 总记录数  itemCountPerPage 一页中的记录数 str 宠物名称
 	* 编写者:杨凡
 	* 时间:2006-11-28
 	* 最后修改时间:2006-12-2
 	* */
	public ArrayList showFavorit(String userId,PageUtil page)
	{
		int pageIndex=page.getPageIndex();
		int itemCountPerPage=page.getItemCountPerPage();
		int count=(pageIndex-1)*itemCountPerPage+1;
		ArrayList arrayList=new ArrayList();
		FavoritDao favoritDao=new FavoritDao();
		
		String str=favoritDao.selectFavorit(userId);
		
		System.out.println(str);
		if(str==null)
		{
			return arrayList;
		}			
		String sql="select * from Product where Category='"+str+"'";
		baseDao.open();	
		System.out.println(sql);
		try {			
			ResultSet rs=baseDao.executeQuery(sql);	
			boolean res = rs.absolute(count);
			
			if(res)
			{
				for(int i=0;i<itemCountPerPage;i++)
				{
					Product product=new Product();
					product.setProductId(rs.getString(1));
					product.setCategory(rs.getString(2));
					product.setName(rs.getString(3));
					product.setDescn(rs.getString(4));
					
					arrayList.add(product);
					if(!rs.next())
						break;
				}			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return arrayList;
		
	}	
	/**方法名称:selectFavorit
	 * 功能:查询用户选择的宠物名称
	 * 参数:userId
	 * 变量:temp 判断用户是否选择自己喜欢的宠物(0--表示选  1--表示不选)
	 * 返回值:favCategory--用户选择的宠物名称
	 * 编写者:杨凡
	 * 编译时间:2006-11-28
	 * 最后修改时间:2006-12-2
	 * */
	public String selectFavorit(String userId)
	{			
		try
		{
			String sql="select * from Profile where UserId='"+userId+"'";
			System.out.println(sql);
			baseDao.open();			
			System.out.println("得到记录集");
			ResultSet rs=baseDao.executeQuery(sql);
			
			if(rs.next())
			{
				String temp=rs.getString(3);				
				System.out.println("temp="+temp);	
				
				//判断客户是否选择(是"1"表示选择)
				if(temp.equals("1"))
				{
					String sql2="select * from Profile where MyListOpt="+temp+" and UserId='"+userId+"'";
					baseDao.open();	
					System.out.println(sql2);
					ResultSet rs1=baseDao.executeQuery(sql2);
					System.out.println("3333333333");
					while(rs1.next())
					{			
						//得到客户选择的宠物名称
						String favCategory=rs1.getString(2);	
						System.out.println(favCategory);
						return favCategory;								
					}										
				}
				else
				{
					System.out.println("没有选择");
				}
			}
			else
			{
				System.out.println("没有记录");
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return null;		
	}	
}
