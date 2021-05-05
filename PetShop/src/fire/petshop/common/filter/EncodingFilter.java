package fire.petshop.common.filter;

import java.io.*;
import javax.servlet.*;


/**
 * 类名：EncodingFilter
 * 功能：过滤http请求内容的编码格式为gb2312
 * 编写者：张少成
 * 最后变更日期：2006-11-28
 */

/*
 * 页面请求编码过滤器，注意在servlet中的表单提交设为POST，为get时不能顺利转换
 */
public class EncodingFilter implements Filter {
	protected String encoding = null;

	protected FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		// 从web.xml配置文件中获取编码配置
		this.encoding = filterConfig.getInitParameter("Encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getCharacterEncoding() == null) {
			String encode = getEncoding();
			if (encode != null) {
				// 设置request的编码方式
				request.setCharacterEncoding(encode);
			}
		}
		chain.doFilter(request, response);
	}

	public String getEncoding() {
		return encoding;
	}

	public void destroy() {

	}
}
