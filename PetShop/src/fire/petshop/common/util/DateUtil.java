package fire.petshop.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ������DateUtil
 * ���ܣ�Date���ͺ�String���໥ת����ת����ʽΪyyyy-MM-dd
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-11-28
 */


public class DateUtil {
	
	/**
	 * ��������dateFormatToString
	 * ������date��java.util.Date���ͣ����ڱ���
	 * ����ֵ��java.lang.String�����ڵ�yyyy-MM-dd�ַ�����ʽ 
	 * ���ܣ�ת��DateΪString����
	 */
	public static String dateFormatToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd");
		
		String res = sdf.format(date);
		
		return res;
	}
	
	/**
	 * ��������stringFormatToDate 
	 * ������datestr��java.lang.String�����ڵ�yyyy-MM-dd�ַ�����ʽ
	 * ����ֵ��java.util.Date���ͣ����ڱ���
	 * ���ܣ�ת��String����ΪDate
	 * �׳��쳣��ParseException
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
