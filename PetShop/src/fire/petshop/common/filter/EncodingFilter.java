package fire.petshop.common.filter;

import java.io.*;
import javax.servlet.*;


/**
 * ������EncodingFilter
 * ���ܣ�����http�������ݵı����ʽΪgb2312
 * ��д�ߣ����ٳ�
 * ��������ڣ�2006-11-28
 */

/*
 * ҳ����������������ע����servlet�еı��ύ��ΪPOST��Ϊgetʱ����˳��ת��
 */
public class EncodingFilter implements Filter {
	protected String encoding = null;

	protected FilterConfig config;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		// ��web.xml�����ļ��л�ȡ��������
		this.encoding = filterConfig.getInitParameter("Encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request.getCharacterEncoding() == null) {
			String encode = getEncoding();
			if (encode != null) {
				// ����request�ı��뷽ʽ
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
