<!--
	名称：checkout.jsp
	功能：显示购物车中的条目信息，提示用户下一步结帐
	编写者：张少成
	最后更新日期：2006-12-04
-->
<%@ page language="java" pageEncoding="gb2312" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>购物车</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">

		<jsp:useBean id="cart" scope="session"
			class="fire.petshop.buyandbilling.cart.Cart" />

	</head>

	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<div>
			<h2>购物车</h2>
		</div>


		<table width="70%" border="0" cellpadding="0" cellspacing="0">
			<tr class="gridHead">
				<td>
					&nbsp; &#26465;&#30446;&#20195;&#21495;
				</td>
				<td>
					&nbsp; &#20135;&#21697;&#21517;&#31216;
				</td>
				<td>
					&nbsp; &#26159;&#21542;&#26377;&#36135;
				</td>
				<td>
					&#21333;&#20215;&nbsp;
				</td>
				<td>
					&#25968;&#37327;&nbsp;
				</td>
				<td>
					&#23567;&#35745;
					<br>
				</td>
			</tr>

			<c:forEach var="cartItemForm" items="${cart.cartItems}">

				<tr class="gridItem">
					<td>
						<c:out value="${cartItemForm.itemId}" />
					</td>
					<td>
						<c:out value="${cartItemForm.product}" />
					</td>
					<td>
						<c:out value="${cartItemForm.inStock}" />
					</td>
					<td>
						<c:out value="${cartItemForm.unitPrice}" />
					</td>
					<td>
						<c:out value="${cartItemForm.quantity}" />
					</td>
					<td>
						<c:out value="${cartItemForm.subtotal}" />
					</td>
				</tr>

			</c:forEach>
			<tr class="gridFoot">
				<td colspan="7">
					<div align="right">
						物品数：
						<c:out value="${cart.itemCount}" />
						总价格：
						<c:out value="${cart.totalPrice}" />
					</div>
				</td>
			</tr>
		</table>
		<br /><br /><br />
		<input type="image" src="../Images/button_continue.gif" onclick="javascript:document.location.href='./PrepareOrderBillingServlet'" />
		
	</body>
</html>
