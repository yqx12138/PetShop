package fire.petshop.categorydist.model;
/**
 * ����:CategoryModel 
 * ����:��Ӧ���ݿ����ֶ�,����ȡ����д�� bll��dao�ɵ���
 * �༭��:����
 * ʱ��:2006-11-28 18:00
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