package fire.petshop.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类名：DateUtil
 * 功能：Date类型和String的相互转换，转换格式为yyyy-MM-dd
 * 编写者：张少成
 * 最后变更日期：2006-11-28
 */


public class DateUtil {
	
	/**
	 * 方法名：dateFormatToString
	 * 参数：date，java.util.Date类型，日期变量
	 * 返回值：java.lang.String，日期的yyyy-MM-dd字符串格式 
	 * 功能：转换Date为String类型
	 */
	public static String dateFormatToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		
		String res = sdf.format(date);
		
		return res;
	}
	
	/**
	 * 方法名：stringFormatToDate 
	 * 参数：datestr，java.lang.String，日期的yyyy-MM-dd字符串格式
	 * 返回值：java.util.Date类型，日期变量
	 * 功能：转换String类型为Date
	 * 抛出异常：ParseException
	 */
	public static Date stringFormatToDate(String datestr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		Date date = null;
		
		date = sdf.parse(datestr);
		
		return date;
	}
}
