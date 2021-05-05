package fire.petshop.dao.favorit;

import java.sql.ResultSet;
import java.util.ArrayList;
import fire.petshop.common.util.PageUtil;
import fire.petshop.favorit.model.Product;
/**������:FavoritDao
 * ����:�����ݵ��޸ĺͲ�ѯ����
 * ��д��:�
 * ʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class FavoritDao {	
	
private static BaseDao baseDao = new BaseDao();	

	/**��������:showFavorit
 	* ����:��ʾ������Ϣ����ҳ
 	* ����ֵ:arrayList
 	* ����:userId--�û�Id page 
 	* ����:pageIndex ��ǰҳ count �ܼ�¼��  itemCountPerPage һҳ�еļ�¼�� str ��������
 	* ��д��:�
 	* ʱ��:2006-11-28
 	* ����޸�ʱ��:2006-12-2
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
	/**��������:selectFavorit
	 * ����:��ѯ�û�ѡ��ĳ�������
	 * ����:userId
	 * ����:temp �ж��û��Ƿ�ѡ���Լ�ϲ���ĳ���(0--��ʾѡ  1--��ʾ��ѡ)
	 * ����ֵ:favCategory--�û�ѡ��ĳ�������
	 * ��д��:�
	 * ����ʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public String selectFavorit(String userId)
	{			
		try
		{
			String sql="select * from Profile where UserId='"+userId+"'";
			System.out.println(sql);
			baseDao.open();			
			System.out.println("�õ���¼��");
			ResultSet rs=baseDao.executeQuery(sql);
			
			if(rs.next())
			{
				String temp=rs.getString(3);				
				System.out.println("temp="+temp);	
				
				//�жϿͻ��Ƿ�ѡ��(��"1"��ʾѡ��)
				if(temp.equals("1"))
				{
					String sql2="select * from Profile where MyListOpt="+temp+" and UserId='"+userId+"'";
					baseDao.open();	
					System.out.println(sql2);
					ResultSet rs1=baseDao.executeQuery(sql2);
					System.out.println("3333333333");
					while(rs1.next())
					{			
						//�õ��ͻ�ѡ��ĳ�������
						String favCategory=rs1.getString(2);	
						System.out.println(favCategory);
						return favCategory;								
					}										
				}
				else
				{
					System.out.println("û��ѡ��");
				}
			}
			else
			{
				System.out.println("û�м�¼");
			}
		}catch(Exception ex)
		{
			System.out.println(ex);
		}
		return null;		
	}	
}
