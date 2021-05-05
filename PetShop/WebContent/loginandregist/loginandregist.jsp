<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--
	名称：loginandregist.jsp
	功能：用户登陆，注册页面
	编写者：刘洋
	最后更新日期：2006-12-04
-->
<HTML>
	<HEAD>
		<title>Sign In</title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</HEAD>
	<body>
		<!-- top bar -->
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>
		<!-- third bar -->
		<!-- 
		<table cellspacing="0" cellpadding="0" width="100%" height="35"
			background="Images/top_stripe3.gif" border="0">
			<tr>
				<span id="areaMenu">
				<td valign="top" width="77">
					<img src="Images/liz_2.gif">
				</td>
				<td valign="top" align="left">
					<img src="Images/liz_3.gif">
					<br>
					<font class="menuBlack"><a
						href="Category.aspx?categoryId=FISH" class="menuBlack">Fish</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=DOGS" class="menuBlack">Dogs</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=REPTILES" class="menuBlack">Reptiles</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=CATS" class="menuBlack">Cats</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=BIRDS" class="menuBlack">Birds</a>
					</font>
			</tr>
		</table>
		<img src="Images/liz_4.gif" id="lizard4">
		 -->
		<blockquote>
			<form method="post" name="loginForm" action="../loginandregist/LoginServlet">

				<span class="title">你是新用户吗?</span>
				<p>
					<a href="../loginandregist/createaccount.jsp"><img
							src="../Images/buttonRegister.gif" alt="Register Now" border="0">
					</a>
				<p>
					<span class="title">是否注册?</span>
				<p>
				<table cellpadding="1" cellspacing="0">
					<tr>
						<td class="label">
							用户ID:
						</td>
						<td>
							<input name="userId" type="text" maxlength="20" size="15" /><span id="UserID"></span>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label">
							密码:
						</td>
						<td>
							<input name="password" type="password" maxlength="20" size="15" /><span id="PassWord"></span>
							&nbsp;
						</td>
					</tr>
				</table>
				<p>
					<input type="image" name="btnSubmit"
						onClick="return loginAccount();"
						language="javascript" id="btnSubmit" src="../Images/buttonSubmit.gif"
						alt="Submit" border="0" />
			</form>
		</blockquote>
	</body>
</HTML>


<SCRIPT LANGUAGE="JavaScript">
<!--
function loginAccount()
{
	var vali=new Array();
	var rlu=/^[\w]{6,18}$/;
	vali=['请输入用户姓名','密码长度在6到18位之间'];
	if(document.loginForm.userId.value=="")
	{
		document.all.UserID.innerHTML = '<font color=#FF0000 size=2>' + vali[0] + '</font>';
	    document.loginForm.userId.focus();
	}
	else
	{
		document.all.UserID.innerHTML = '';
	}
	if(!rlu.test(document.loginForm.password.value))
	{
		document.all.PassWord.innerHTML = '<font color=red size=2>' + vali[1] + '</font>';
	    document.loginForm.password.focus();
	}
	else
	{
		document.all.PassWord.innerHTML = '';
	}
	if((document.loginForm.userId.value == "")||(!rlu.test(document.loginForm.password.value)))
		{
			return false;
		}
	else
		{
			var form=document.loginForm;
			form.submit();
		}
}
//-->
</SCRIPT>