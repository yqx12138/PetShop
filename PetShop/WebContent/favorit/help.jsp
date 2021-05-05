<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
	名称:help.jsp
	功能:小组成员信息
	编写者:杨凡
	最后修改时间:2006-12-2
-->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0057)http://192.168.0.1/MSpetshop/MyAccount.aspx?action=update -->
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
			项目名称: Pet Shop
			<BR/>
			项目周期:四天
			<BR/>
			所用技术:MVC
			<BR/>
		</BLOCKQUOTE>
		</SPAN>
	</BODY>
</HTML>
