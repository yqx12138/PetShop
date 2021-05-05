package fire.petshop.categorydist.form;
/**
 *类名:CategoryForm  功能:从jsp页面获得相对应的值保存在CategoryForm里面,
 *	  可以写进也可取出,在servlet和bll调用
 *编辑者:王鹏
 *时间:2006-11-28 18:00
 **/
public class CategoryForm {
	private String  catId;
	private String  name;
	private String  descn;
	public void setCatId(String catId)
	{
		this.catId=catId;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setDescn(String descn)
	{
		this.descn=descn;
	}
	public String getCatId()
	{
		return catId;
	}
	public String getName()
	{
		return name;
	}
	public String getDescn()
	{
		return descn;
	}
}
