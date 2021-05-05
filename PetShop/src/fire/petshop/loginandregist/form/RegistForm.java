package fire.petshop.loginandregist.form;
/**
 * 类名称:RegistForm 
 * 功能:得到试图层的数据
 * 编写:刘洋
 * 编写时间:2006-11-28
 * 最后修改时间:2006-12-1
 * 
 * */
public class RegistForm {

	private String userId;

	private String password;

	private String email;

	private String firstName;

	private String lastName;

	private String status;

	private String addr1;

	private String addr2;

	private String city;

	private String state;

	private String zip;

	private String country;

	private String phone;

	private String favCategory;

	private int myListOpt;

	private int bannerOpt;

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getBannerOpt() {
		return bannerOpt;
	}

	public void setBannerOpt(int bannerOpt) {
		this.bannerOpt = bannerOpt;
	}

	public String getFavCategory() {
		return favCategory;
	}

	public void setFavCategory(String favCategory) {
		this.favCategory = favCategory;
	}

	public int getMyListOpt() {
		return myListOpt;
	}

	public void setMyListOpt(int myListOpt) {
		this.myListOpt = myListOpt;
	}

}
