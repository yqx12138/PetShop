<!--
	名称：showorderbilling
	功能：显示您填入的订单中的地址信息
	编写者：张少成
	最后更新日期：2006-12-04
-->
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>确定地址信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
		<jsp:useBean id="order" scope="session"
			class="fire.petshop.buyandbilling.form.OrdersForm" />
	</head>

	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>
		<h4>
		&#35831;&#30830;&#35748;&#20197;&#19979;&#22320;&#22336;&#20449;&#24687;&#26159;&#21542;&#27491;&#30830;&#65292;&#28982;&#21518;&#28857;&#20987;Continue&#25353;&#38062;&#22788;&#29702;&#35746;&#21333;&#65281;
		</h4>
		<br />
		<h3>
		&#25903;&#20184;&#20154;&#22320;&#22336;&#65306;
		</h3>
		<br />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td width="20%">
						&#22995;&#21517;&#65306;
					</td>
					<td width="80%">
						<c:out value="${order.billToLastName}" />
						&nbsp;
						<c:out value="${order.billToFirstName}" />
					</td>
					<td width="10%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;1&#65306;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.billAddr1}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;2&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.billAddr2}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#21306;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.billState}" />
						<c:out value="${order.billCity}" />
						<c:out value="# ${order.billZip}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
		<h3>
		&#37038;&#23492;&#22320;&#22336;&#65306;
		</h3>
		<br />
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td width="20%">
						&#22995;&#21517;&#65306;
						<br>
					</td>
					<td width="80%">
						<c:out value="${order.shipToLastName}" />
						&nbsp;
						<c:out value="${order.shipToFirstName}" />
					</td>
					<td width="10%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;1&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.shipAddr1}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;2&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.shipAddr2}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#21306;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.shipState}" />
						<c:out value="${order.shipCity}" />
						<c:out value="# ${order.shipZip}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
		<br />
		<br />
		<br />
		<input type="image" src="../Images/button_continue.gif" onclick="javascript:document.location.href='./ProcessOrderServlet'"/>
	</body>
</html>
