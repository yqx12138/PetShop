<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0057)http://192.168.0.1/MSpetshop/MyAccount.aspx?action=update -->
<!--
	名称：myaccount.jsp
	功能：用户进行注册。登陆和对自己相关信息进行修改后的信息返回页面来提示用户是否登陆成功
	编写者：刘洋
	最后更新日期：2006-12-04
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
				我的帐户
			</h3>

			<h4>
				<c:if test="${flag == 'login'}">
	    登陆成功! 
	  </c:if>
				<c:if test="${flag == 'regist'}">
    	注册成功！
	  </c:if>
				<c:if test="${flag == 'updateregist'}">
    	注册修改成功！
	  </c:if>
				<c:if test="${flag == 'logout'}">
	  	注销成功！
	  	</c:if>
			</h4>


		</BLOCKQUOTE>
		</SPAN>
	</BODY>
</HTML>
