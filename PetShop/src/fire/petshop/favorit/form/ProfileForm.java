package fire.petshop.favorit.form;
/**类名称:ProfileForm
 * 描述:封装消费者的基本信息
 * 属性:getXXX()活得属性  setXXX(String x)设置属性
 * 变量:userId 用户id  favCategory 消费者喜欢的宠物 myListOpt 是否选择宠物 
 * 编写者:杨凡
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-2
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
