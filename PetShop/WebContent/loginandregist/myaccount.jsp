<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0057)http://192.168.0.1/MSpetshop/MyAccount.aspx?action=update -->
<!--
	���ƣ�myaccount.jsp
	���ܣ��û�����ע�ᡣ��½�Ͷ��Լ������Ϣ�����޸ĺ����Ϣ����ҳ������ʾ�û��Ƿ��½�ɹ�
	��д�ߣ�����
	���������ڣ�2006-12-04
--> 
<HTML>
	<HEAD>
		<TITLE>MyAccount</TITLE>
		<META http-equiv=Content-Type content="text/html;charset=gb2312">
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
		<jsp:useBean id="flag" scope="request" class="java.lang.String"></jsp:useBean>
		<jsp:useBean id="userId" scope="session" class="java.lang.String"></jsp:useBean>
	</HEAD>
	<BODY>
		<!-- top bar -->
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>
		<!-- third bar -->




		<BLOCKQUOTE>
			<h3>
				�ҵ��ʻ�
			</h3>

			<h4>
				<c:if test="${flag == 'login'}">
	    ��½�ɹ�! 
	  </c:if>
				<c:if test="${flag == 'regist'}">
    	ע��ɹ���
	  </c:if>
				<c:if test="${flag == 'updateregist'}">
    	ע���޸ĳɹ���
	  </c:if>
				<c:if test="${flag == 'logout'}">
	  	ע���ɹ���
	  	</c:if>
			</h4>


		</BLOCKQUOTE>
		</SPAN>
	</BODY>
</HTML>
