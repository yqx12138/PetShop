package fire.petshop.common.util;

/**
 * 类名：PageUtil
 * 功能：用于分页的公共类
 * 编写者：张少成
 * 最后变更日期：2006-11-29
 */


public class PageUtil {

	private int pageIndex;				//当前页码

	private int itemCount;				//总记录数

	private int itemCountPerPage;		//一页中的记录数

	private int pageCount;				//页数
	
	
	/**
	 * 函数名：无参数的构造函数
	 * 功能：页码为1，其余都初始化为0
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public PageUtil() {
		pageIndex = 1;
		itemCount = 0;
		itemCountPerPage = 0;
		pageCount = 0;
	}
	
	
	/**
	 * 函数名：单参数的构造函数
	 * 参数：itemCount，int，记录数
	 * 功能：页码为1，一页中的记录数为5，页数根据其他数据计算
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public PageUtil(int itemCount) {
		this(1, itemCount);
	}

	
	/**
	 * 函数名：两参数的构造函数
	 * 参数：pageIndex，int，当前页码
	 * 		itemCount，int，记录数
	 * 功能：一页中的记录数为5，页数根据其他数据计算
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public PageUtil(int pageIndex, int itemCount) {
		this(1, itemCount, 5);
	}
	
	
	/**
	 * 函数名：两参数的构造函数
	 * 参数：pageIndex，int，当前页码
	 * 		itemCount，int，记录数
	 * 		itemCountPerPage，int，一页中的记录数
	 * 功能：页数根据其他数据计算
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
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
	 * 函数名：上一条记录
	 * 参数：无
	 * 返回值：无
	 * 功能：若页码大于1页码变为上一页
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public void privious()
	{
		if(pageIndex > 1)
			pageIndex--;
	}
	
	/**
	 * 函数名：下一条记录
	 * 参数：无
	 * 返回值：无
	 * 功能：若页码小于最大页码变为下一页
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public void next()
	{
		if(pageIndex < pageCount)
			pageIndex++;
	}
	
	/**
	 * 函数名：第一条记录
	 * 参数：无
	 * 返回值：无
	 * 功能：页码变为1
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public void first()
	{
		pageIndex = 1;
	}
	
	
	/**
	 * 函数名：最后一条记录
	 * 参数：无
	 * 返回值：无
	 * 功能：页码变为最大页码
	 * 编写者：张少成
	 * 最后更改日期：2006-11-29
	 */
	public void last()
	{
		pageIndex = pageCount;
	}
	
}
