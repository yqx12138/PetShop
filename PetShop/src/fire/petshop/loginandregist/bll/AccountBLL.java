package fire.petshop.loginandregist.bll;

import java.util.ArrayList;

import fire.petshop.dao.loginandregist.AccountBaseDao;
import fire.petshop.loginandregist.form.LoginForm;
import fire.petshop.loginandregist.form.RegistForm;
import fire.petshop.loginandregist.model.AccountBean;

/**
 * ����AccountBLL 
 * ����:ģ�Ͳ����ͼ�����ݵ�ת��
 * ��д:����
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-1
 * 
 * */
public class AccountBLL {
private static AccountBaseDao accountBaseDao=new AccountBaseDao();
	

/**
	 * ��������:addUser
	 * ����:����ͼ��RegistForm�õ���������ģ�Ͳ����ת��
	 * ����ֵ:boolean
	 * ����:registForm
	 * */
public static boolean addUser(RegistForm registForm)
	{
		AccountBean accountBean=registFormToBean(registForm);		
		return accountBaseDao.addUser(accountBean);
	}	
/**
	 * ��������:updateRegist
	 * ����:����ͼ��RegistForm�õ���������ģ�Ͳ����ת��
	 * ����ֵ:boolean
	 * ����:registForm
	 * */
	public static boolean  updateRegist(RegistForm registForm) throws Exception
	{
		AccountBean accountBean=registFormToBean(registForm);
		return accountBaseDao.updateMethod(accountBean);
	}
/**
	 * ��������:checkUser
	 * ����:����ͼ��LoginForm�õ���������ģ�Ͳ����ת��
	 * ����ֵ:boolean
	 * ����:registForm
	 * */
	public static boolean checkUser(LoginForm loginForm)
	{
	   AccountBean accountBean=loginFormToBean(loginForm);
		
		return accountBaseDao.checkUser(accountBean);
	}	
/**
	 * ��������:getRegister
	 * ����:Ϊ�˰���ͼ���ģ�Ͳ�ֿ����еķ�������
	 * ����ֵ:ArrayList
	 * ����:userId
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
	 * ��������:registFormToBean
	 * ����:����ͼ�������ת����ģ�Ͳ�
	 * ����ֵ:AccountBean
	 * ����:RegistForm
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
	 * ��������:accountBeanToLoginForm
	 * ����:��ģ�Ͳ������ת������ͼ��
	 * ����ֵ:loginForm
	 * ����:accountBean
	 * */	
	
	private static LoginForm accountBeanToLoginForm(AccountBean accountBean)
	{
		LoginForm loginForm=new LoginForm();
		
		loginForm.setUserId(accountBean.getUserId());
		loginForm.setPassword(accountBean.getPassword());
		
		return loginForm;		
	}
	
	
	
	
	
	
/**
	 * ��������:accountBeanToLoginForm
	 * ����:��ģ�Ͳ������ת������ͼ��
	 * ����ֵ:registForm
	 * ����:accountBean
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
