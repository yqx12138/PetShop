package fire.petshop.favorit.form;
/**������:ProfileForm
 * ����:��װ�����ߵĻ�����Ϣ
 * ����:getXXX()�������  setXXX(String x)��������
 * ����:userId �û�id  favCategory ������ϲ���ĳ��� myListOpt �Ƿ�ѡ����� 
 * ��д��:�
 * ��дʱ��:2006-11-28
 * ����޸�ʱ��:2006-12-2
 * */
public class ProfileForm {
	private String userId;
	private String favCategory;
	private String myListOpt;
	private String bannerOpt;
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
