package fire.petshop.favorit.model;
/**������:Profile
 * ����:
 * ����:getXXX()�������  setXXX(String x)��������
 * ����:userId �û�Id  favCateGory ��������  myListOpt �Ƿ�ѡ�����
 * ��д��:�
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class Profile {
	private String userId;
	private String favCategory;
	private String myListOpt;
	private String bannerOpt;
	
	public Profile()
	{
		
	}
	/**��������:Profile
	 * ��д��:�
	 * ��дʱ��:2006-11-28
	 * ����޸�ʱ��:2006-12-2
	 * */
	public Profile(String userId,String favCategory,String myListOpt,String bannerOpt)
	{
		this.userId=userId;
		this.favCategory=favCategory;
		this.myListOpt=myListOpt;
		this.bannerOpt=bannerOpt;
	}
	public String getBannerOpt() {
		return bannerOpt;
	}
	public void setBannerOpt(String bannerOpt) {
		this.bannerOpt = bannerOpt;
	}
	public String getFavCategory() {
		return favCategory;
	}
	public void setFavCategory(String favCategory) {
		this.favCategory = favCategory;
	}
	public String getMyListOpt() {
		return myListOpt;
	}
	public void setMyListOpt(String myListOpt) {
		this.myListOpt = myListOpt;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
