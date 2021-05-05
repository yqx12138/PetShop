package fire.petshop.dao.loginandregist;

import java.sql.ResultSet;
import java.util.ArrayList;

import fire.petshop.loginandregist.model.AccountBean;
import fire.petshop.loginandregist.base.*;
import fire.petshop.loginandregist.form.RegistForm;
/**
 * 类名称:AccountBaseDao
 * 功能:对数据进行增,删,改,查的方法
 * 编写:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
 * 
 * */ 
public class AccountBaseDao {
	
	/**
	 * 方法名称:addUser
	 * 功能:向数据库增加用户
	 * 返回值:boolean
	 * 参数:accountBean
	 * */	
	public boolean addUser(AccountBean accountBean) {
		boolean flag = false;
		BaseDao baseDao = new BaseDao();
		String sql = "insert into account(UserId,Password,Email,FirstName,LastName,Addr1,Addr2,City,State,Zip,Country,Phone) values ('"
				+ accountBean.getUserId()
				+ "','"
				+ accountBean.getPassword()
				+ "','"
				+ accountBean.getEmail()
				+ "','"
				+ accountBean.getFirstName()
				+ "','"
				+ accountBean.getLastName()
				+ "','"
				+ accountBean.getAddr1()
				+ "','"
				+ accountBean.getAddr2()
				+ "','"
				+ accountBean.getCity()
				+ "','"
				+ accountBean.getState()
				+ "','"
				+ accountBean.getZip()
				+ "','"
				+ accountBean.getCountry()
				+ "','"
				+ accountBean.getPhone()
				+ "')";
		String sql1 = "insert into profile(UserId,FavCategory,MyListOpt) values('"
				+ accountBean.getUserId()
				+ "','"
				+ accountBean.getFavCategory()
				+ "','"
				+ accountBean.getMyListOpt() + "')";
		try {
			baseDao.open();
			int i = baseDao.executeUpdate(sql);
			int j = baseDao.executeUpdate(sql1);
			if (i > 0 && j > 0)
				flag = true;
		} catch (Exception e) {
			flag = false;
			System.out.print(e);
		} finally {
			baseDao.close();
		}
		return flag;
	}
	/**
	 * 方法名称:updateMethod
	 * 功能:更新数据库中的拥护信息
	 * 返回值:boolean
	 * 参数:accountBean
	 * */
	public boolean updateMethod(AccountBean accountBean) throws Exception {
	
		BaseDao baseDao = new BaseDao();
		String sql = "update account set email='" + accountBean.getEmail()
				+ "',firstName='"+accountBean.getFirstName()+"',lastName='"+accountBean.getLastName()+"',addr1='" + accountBean.getAddr1() + "',addr2='"
				+ accountBean.getAddr2() + "',city='" + accountBean.getCity()
				+ "',state='" + accountBean.getState() + "',zip='"
				+ accountBean.getZip() + "',country='" + accountBean.getCountry()
				+ "',phone='" + accountBean.getPhone() + "' where userId='"
				+ accountBean.getUserId()+"'";
		String sql1 = "update profile set userId='"
				+ accountBean.getUserId() + "',favCategory='" + accountBean.getFavCategory()
				+ "',myListOpt='" + accountBean.getMyListOpt() + "' where userId='"
				+ accountBean.getUserId()+"' ";
		// sql=tools.getChn(sql);
		System.out.println(sql);
		System.out.println(sql1);
		baseDao.open();
		try {

			int i=baseDao.executeUpdate(sql);
			int j=baseDao.executeUpdate(sql1);
			if(i>0&j>0)
			{
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new Exception(e);
		} finally {
			baseDao.close();
		}
		return false;
	}
	/**
	 * 方法名称:checkUser
	 * 功能:验证用户登陆
	 * 返回值:boolean
	 * 参数:accountBean
	 * */
	public boolean checkUser(AccountBean accountBean) {
		
		BaseDao baseDao = new BaseDao();
		boolean flag = false;
		try {
			baseDao.open();
			String sql = "select count(*) from account where UserId='"
					+ accountBean.getUserId()
					+ "' and Password='"
					+ accountBean.getPassword() + "'";
			ResultSet rs = baseDao.executeQuery(sql);
			System.out.print(sql);
			rs.next();
			if (rs.getInt(1) > 0) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			baseDao.close();
		}
		return flag;
	}
	
	/**
	 * 方法名称:selectUser
	 * 功能:通过UserId查询用户信息
	 * 返回值:ArrayList
	 * 参数:id
	 * */
	public ArrayList selectUser(String id) {
		
		System.out.println("进入查询selectUser");
		ArrayList array=new ArrayList();
		
		BaseDao baseDao = new BaseDao();
		try {
			baseDao.open();
			String sql = "select * from account where UserId='"+id+"'";
			System.out.println(sql);
			
			String sql1 = "select * from profile where UserId='"+id+"'";
			System.out.println(sql1);
			ResultSet rs = baseDao.executeQuery(sql);
			
			if(rs.next())
			{
				AccountBean  account=new AccountBean();
				account.setUserId(rs.getString("UserId"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("Email"));
				account.setFirstName(rs.getString("FirstName"));
				account.setLastName(rs.getString("LastName"));
				account.setAddr1(rs.getString("Addr1"));
				account.setAddr2(rs.getString("Addr2"));
				account.setCity(rs.getString("City"));
				account.setState(rs.getString("State"));
				account.setZip(rs.getString("Zip"));
			
				account.setCountry(rs.getString("Country"));
				account.setPhone(rs.getString("Phone"));
				
				
				ResultSet rs2=baseDao.executeQuery(sql1);
				System.out.println("77777777777");
					if(rs2.next())
					{
						System.out.println("888888888");
						account.setUserId(rs2.getString(1));
						account.setFavCategory(rs2.getString(2));
						account.setMyListOpt(rs2.getInt(3));
//					if(rs2.getString(3).equals("0"))
//					{
//						account.setMyListOpt(null);
//					}
//					account.setMyListOpt(Integer.parseInt(rs.getString(3)));
					System.out.println(account.getPassword());
					array.add(account);

				}
			}		
		} catch (Exception e) {
			System.out.print(e);
		} finally {
			baseDao.close();
		}
		return array;
	}
	/**
	 * 方法名称:selectCategory
	 * 功能:查询category表中的动物种类信息
	 * 返回值:ArrayList
	 * 参数:
	 * */
	public ArrayList selectCategory()
	{    
		ArrayList<AccountBean> list=new ArrayList<AccountBean>();
		BaseDao baseDao=new BaseDao();
		try{
			baseDao.open();
			 String sql="select CatId,`name` from category";
		     System.out.println(sql);
		     ResultSet rs=baseDao.executeQuery(sql);
		     
		     while(rs.next())
		     {
		    	 AccountBean  account=new AccountBean();
		    	 account.setCateId(rs.getString("CatId"));
		    	 account.setCategoryName(rs.getString("name"));
		    	 list.add(account);
		     }
		}catch(Exception ex)
		{
			System.out.println(ex);
		}finally
		{
			baseDao.close();
		}
		return list;
	}
	
}
