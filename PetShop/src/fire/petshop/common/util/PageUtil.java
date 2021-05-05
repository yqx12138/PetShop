package fire.petshop.common.util;

/**
 * ������PageUtil
 * ���ܣ����ڷ�ҳ�Ĺ�����
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-11-29
 */


public class PageUtil {

	private int pageIndex;				//��ǰҳ��

	private int itemCount;				//�ܼ�¼��

	private int itemCountPerPage;		//һҳ�еļ�¼��

	private int pageCount;				//ҳ��
	
	
	/**
	 * ���������޲����Ĺ��캯��
	 * ���ܣ�ҳ��Ϊ1�����඼��ʼ��Ϊ0
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public PageUtil() {
		pageIndex = 1;
		itemCount = 0;
		itemCountPerPage = 0;
		pageCount = 0;
	}
	
	
	/**
	 * ���������������Ĺ��캯��
	 * ������itemCount��int����¼��
	 * ���ܣ�ҳ��Ϊ1��һҳ�еļ�¼��Ϊ5��ҳ�������������ݼ���
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public PageUtil(int itemCount) {
		this(1, itemCount);
	}

	
	/**
	 * ���������������Ĺ��캯��
	 * ������pageIndex��int����ǰҳ��
	 * 		itemCount��int����¼��
	 * ���ܣ�һҳ�еļ�¼��Ϊ5��ҳ�������������ݼ���
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public PageUtil(int pageIndex, int itemCount) {
		this(1, itemCount, 5);
	}
	
	
	/**
	 * ���������������Ĺ��캯��
	 * ������pageIndex��int����ǰҳ��
	 * 		itemCount��int����¼��
	 * 		itemCountPerPage��int��һҳ�еļ�¼��
	 * ���ܣ�ҳ�������������ݼ���
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public PageUtil(int pageIndex, int itemCount, int itemCountPerPage) {
		this.pageIndex = pageIndex;
		this.itemCount = itemCount;
		this.itemCountPerPage = itemCountPerPage;
		
		calculatePageCount();
	}
	
	private void calculatePageCount()
	{
		pageCount = itemCount/itemCountPerPage;
		if(itemCount%itemCountPerPage > 0)
			pageCount++;
	}
	
	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
		calculatePageCount();
	}

	public int getItemCountPerPage() {
		return itemCountPerPage;
	}

	public void setItemCountPerPage(int itemCountPerPage) {
		this.itemCountPerPage = itemCountPerPage;
		calculatePageCount();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	/**
	 * ����������һ����¼
	 * ��������
	 * ����ֵ����
	 * ���ܣ���ҳ�����1ҳ���Ϊ��һҳ
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public void privious()
	{
		if(pageIndex > 1)
			pageIndex--;
	}
	
	/**
	 * ����������һ����¼
	 * ��������
	 * ����ֵ����
	 * ���ܣ���ҳ��С�����ҳ���Ϊ��һҳ
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public void next()
	{
		if(pageIndex < pageCount)
			pageIndex++;
	}
	
	/**
	 * ����������һ����¼
	 * ��������
	 * ����ֵ����
	 * ���ܣ�ҳ���Ϊ1
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public void first()
	{
		pageIndex = 1;
	}
	
	
	/**
	 * �����������һ����¼
	 * ��������
	 * ����ֵ����
	 * ���ܣ�ҳ���Ϊ���ҳ��
	 * ��д�ߣ����ٳ�
	 * ���������ڣ�2006-11-29
	 */
	public void last()
	{
		pageIndex = pageCount;
	}
	
}
