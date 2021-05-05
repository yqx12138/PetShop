<!--
	名称：shoppingsuccess.jsp
	功能：显示订单已处理成功，以及订单和购物车的信息
	编写者：张少成
	最后更新日期：2006-12-04
-->
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>订单处理完成</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
		<jsp:useBean id="order" scope="request"
			class="fire.petshop.buyandbilling.form.OrdersForm" />
		<jsp:useBean id="userId" scope="session" class="java.lang.String" />
		<jsp:useBean id="cartlist" scope="request" class="java.util.ArrayList" />
	</head>

	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<h2>
			订单处理完成
		</h2>
		<br>
		<h3>
			订单信息
		</h3>
		<table width="70%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td width="20%">
						&#29992;&#25143;ID&#65306;
						<br>
					</td>
					<td width="70%">
						&nbsp;
						<c:out value="${userId}" />
					</td>
					<td width="10%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#35746;&#21333;&#26085;&#26399;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.orderDate}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#35746;&#21333;ID&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.orderId}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#25903;&#20184;&#20449;&#24687;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.cardType}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.creditCard}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
					</td>
					<td>
						&#36807;&#26399;&#26085;&#26399;&#65306;
						<BR />
						<c:out value="${order.exprDate}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#25903;&#20184;&#20154;&#20449;&#24687;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.billToLastName}" />
						<c:out value="${order.billToFirstName}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
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
						&nbsp;
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
						<br>
					</td>
					<td>
						&nbsp;
						<c:out value="${order.billState}" />
						<c:out value="${order.billCity}" />
						#
						<c:out value="${order.billZip}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#21457;&#36135;&#20449;&#24687;&#65306;&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.shipToLastName}" />
						<c:out value="${order.shipToFirstName}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;
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
						&nbsp;
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
						&nbsp;
					</td>
					<td>
						&nbsp;
						<c:out value="${order.shipState}" />
						<c:out value="${order.shipCity}" />
						#
						<c:out value="${order.shipZip}" />
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</tbody>
		</table>
		<br />
		<h3>
			购物清单
		</h3>
		<br />
		<table width="70%" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr class="gridHead">
					<td width="20%">
						&#26465;&#30446;&#20195;&#21495;&nbsp;
					</td>
					<td width="20%">
						&#20135;&#21697;&#21517;&#31216;
					</td>
					<td width="20%">
						&#21333;&#20215;
					</td>
					<td width="20%">
						&#25968;&#37327;
					</td>
					<td width="20%">
						&#23567;&#35745;
					</td>
				</tr>
				<c:forEach var="cartItem" items="${cartlist}">
					<tr class="gridItem">
						<td>
							&nbsp;
							<c:out value="${cartItem.itemId}" />
						</td>
						<td>
							&nbsp;
							<c:out value="${cartItem.product}" />
						</td>
						<td>
							&nbsp;
							<c:out value="${cartItem.unitPrice}" />
						</td>
						<td>
							&nbsp;
							<c:out value="${cartItem.quantity}" />
						</td>
						<td>
							&nbsp;
							<c:out value="${cartItem.subtotal}" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<a href="../index.jsp">返回主页</a>
	</body>
</html>
