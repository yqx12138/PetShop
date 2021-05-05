<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="arry" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="userId" scope="session" class="java.lang.String" />
<!-- 
    页面名:indexjsp
    功能: 主要负责个类的导航
    编辑者:王鹏
    时间:2006-11-29 17:43
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>PetShop</title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</head>

	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../indextopunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../indextoplogined.html" />
		</c:if>
		
		<table cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td colspan="4" valign="top">
					<img alt="" src="../Images/lizardC.gif" width="210" height="74">
				</td>
				<td rowspan="2" valign="top">
					<img src="../Images/space.gif" width="1" height="26">
					<br>
					<map name="mainMap">
						<area href="../categorydist/ProductListServlet?name=Birds"
							alt="Birds" coords="408,133,514,239" shape="RECT">
						<area href="../categorydist/ProductListServlet?name=Fish"
							alt="Fish" coords="2,250,108,356" shape="RECT">
						<area href="../categorydist/ProductListServlet?name=Dogs"
							alt="Dogs" coords="108,326,214,432" shape="RECT">
						<area href="../categorydist/ProductListServlet?name=Reptiles"
							alt="Reptiles" coords="348,254,454,358" shape="RECT">
						<area href="../categorydist/ProductListServlet?name=Cats"
							alt="Cats" coords="242,334,348,440" shape="RECT">
						<area href="../categorydist/ProductListServlet?name=Birds"
							alt="Birds" coords="280,180,350,250" shape="RECT">
					</map>
					<img src="../Images/splash.jpg" usemap="#mainMap" width="548"
						height="466" border="0">
				</td>
			</tr>
			<tr>
				<td valign="top" width="20">
					<img src="../Images/space.gif" width="20" height="1">
				</td>
				<td bgcolor="#f6e19e" valign="top" width="40">
					<img src="../Images/space.gif" width="40" height="1">
				</td>
				<td valign="top" bgcolor="#f6e19e" width="132">
					<a href="../categorydist/ProductListServlet?name=Fish"
						class="catLink">鱼类</a>
					<br>
					<font class="text">&nbsp;&nbsp;海水鱼<br> &nbsp;&nbsp;淡水鱼
						<p></p> </font><a href="../categorydist/ProductListServlet?name=Dogs"
						class="catLink">犬类</a>
					<br>
					<font class="text">&nbsp;&nbsp;狮子狗<br> &nbsp;&nbsp;巨型犬
						<p></p> </font><a href="../categorydist/ProductListServlet?name=Reptiles"
						class="catLink">爬行类</a>
					<br>
					<font class="text">&nbsp;&nbsp;蜥<br> &nbsp;&nbsp;蛇<br>
						&nbsp;&nbsp;龟
						<p></p> </font><a href="../categorydist/ProductListServlet?name=Cats"
						class="catLink">猫</a>
					<br>
					<font class="text">&nbsp;&nbsp;无尾家猫<br> &nbsp;&nbsp;波斯猫
						<p></p>
						<P>
					</font><a href="../categorydist/ProductListServlet?name=Birds"
						class="catLink">鸟类</a>
					<br>
					<font class="text"> &nbsp;&nbsp;金丝雀<br> &nbsp;&nbsp;鹦鹉
					</font>
					</P>
					<br>
					</FONT>
					<img src="../Images/space.gif" width="1" height="30">
					<br>
				</td>
				<td width="20">
					<img src="../Images/space.gif" width="20" height="1">
				</td>
			</tr>
		</table>

	</body>
</html>
