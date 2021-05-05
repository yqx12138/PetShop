package fire.petshop.loginandregist.bll;

import java.util.ArrayList;

import fire.petshop.dao.loginandregist.AccountBaseDao;
import fire.petshop.loginandregist.form.LoginForm;
import fire.petshop.loginandregist.form.RegistForm;
import fire.petshop.loginandregist.model.AccountBean;

/**
 * 类名AccountBLL 
 * 功能:模型层和视图层数据的转化
 * 编写:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
 * 
 * */
public class AccountBLL {
private static AccountBaseDao accountBaseDao=new AccountBaseDao();
	

/**
	 * 方法名称:addUser
	 * 功能:把试图层RegistForm得到的数据向模型层进行转化
	 * 返回值:boolean
	 * 参数:registForm
	 * */
public static boolean addUser(RegistForm registForm)
	{
		AccountBean accountBean=registFormToBean(registForm);		
		return accountBaseDao.addUser(accountBean);
	}	
/**
	 * 方法名称:updateRegist
	 * 功能:把试图层RegistForm得到的数据向模型层进行转化
	 * 返回值:boolean
	 * 参数:registForm
	 * */
	public static boolean  updateRegist(RegistForm registForm) throws Exception
	{
		AccountBean accountBean=registFormToBean(registForm);
		return accountBaseDao.updateMethod(accountBean);
	}
/**
	 * 方法名称:checkUser
	 * 功能:把试图层LoginForm得到的数据向模型层进行转化
	 * 返回值:boolean
	 * 参数:registForm
	 * */
	public static boolean checkUser(LoginForm loginForm)
	{
	   AccountBean accountBean=loginFormToBean(loginForm);
		
		return accountBaseDao.checkUser(accountBean);
	}	
/**
	 * 方法名称:getRegister
	 * 功能:为了把试图层和模型层分开进行的方法调用
	 * 返回值:ArrayList
	 * 参数:userId
	 * */	
	public static ArrayList getRegister(String userId)
	{
		return accountBaseDao.selectUser(userId);
	}

	private static AccountBean loginFormToBean(LoginForm loginForm)
	{
	AccountBean accountBean=new AccountBean();
		
	    accountBean.setUserId(loginForm.getUserId());
	    accountBean.setPassword(loginForm.getPassword());
		
		return accountBean;
	}
/**
	 * 方法名称:registFormToBean
	 * 功能:把试图层的数据转化到模型层
	 * 返回值:AccountBean
	 * 参数:RegistForm
	 * */
	private static AccountBean registFormToBean(RegistForm registForm)
	{
		AccountBean accountBean=new AccountBean();
		
		accountBean.setUserId(registForm.getUserId());
		accountBean.setPassword(registForm.getPassword());
		accountBean.setEmail(registForm.getEmail());
		accountBean.setFirstName(registForm.getFirstName());
		accountBean.setLastName(registForm.getLastName());
		accountBean.setAddr1(registForm.getAddr1());
		accountBean.setAddr2(registForm.getAddr2());
		accountBean.setCity(registForm.getCity());
		accountBean.setState(registForm.getState());
		accountBean.setZip(registForm.getZip());
		accountBean.setCountry(registForm.getCountry());
		accountBean.setPhone(registForm.getPhone());
		
		accountBean.setFavCategory(registForm.getFavCategory());
		accountBean.setMyListOpt(registForm.getMyListOpt());
		accountBean.setBannerOpt(registForm.getBannerOpt());
		return accountBean;
	}
	
	
	
/**
	 * 方法名称:accountBeanToLoginForm
	 * 功能:把模型层的数据转化到视图层
	 * 返回值:loginForm
	 * 参数:accountBean
	 * */	
	
	private static LoginForm accountBeanToLoginForm(AccountBean accountBean)
	{
		LoginForm loginForm=new LoginForm();
		
		loginForm.setUserId(accountBean.getUserId());
		loginForm.setPassword(accountBean.getPassword());
		
		return loginForm;		
	}
	
	
	
	
	
	
/**
	 * 方法名称:accountBeanToLoginForm
	 * 功能:把模型层的数据转化到视图层
	 * 返回值:registForm
	 * 参数:accountBean
	 * */
	private static RegistForm accountBeanToRegistForm(AccountBean accountBean)
	{
		RegistForm registForm=new RegistForm();
		
		registForm.setUserId(accountBean.getUserId());
		registForm.setPassword(accountBean.getPassword());
		registForm.setEmail(accountBean.getEmail());
		registForm.setFirstName(accountBean.getFirstName());
		registForm.setLastName(accountBean.getLastName());
		registForm.setAddr1(accountBean.getAddr1());
		registForm.setAddr2(accountBean.getAddr2());
		registForm.setCity(accountBean.getCity());
		registForm.setState(accountBean.getState());
		registForm.setZip(accountBean.getZip());
		registForm.setCountry(accountBean.getCountry());
		registForm.setPhone(accountBean.getPassword());
		
		registForm.setFavCategory(accountBean.getFavCategory());
		registForm.setMyListOpt(accountBean.getMyListOpt());
		registForm.setBannerOpt(accountBean.getBannerOpt());
		
		
		return registForm;
	}
}
