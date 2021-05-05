package fire.petshop.favorit.model;
/**类名称:Profile
 * 功能:
 * 属性:getXXX()活得属性  setXXX(String x)设置属性
 * 变量:userId 用户Id  favCateGory 宠物名称  myListOpt 是否选择宠物
 * 编写者:杨凡
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-2
 * */
public class Profile {
	private String userId;
	private String favCategory;
	private String myListOpt;
	private String bannerOpt;
	
	public Profile()
	{
		
	}
	/**方法名称:Profile
	 * 编写者:杨凡
	 * 编写时间:2006-11-28
	 * 最后修改时间:2006-12-2
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
