package fire.petshop.categorydist.model;
/**
 * 类名:CategoryModel 
 * 功能:对应数据库表的字段,可以取出和写入 bll和dao可调用
 * 编辑者:王鹏
 * 时间:2006-11-28 18:00
 */
public class CategoryModel {
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