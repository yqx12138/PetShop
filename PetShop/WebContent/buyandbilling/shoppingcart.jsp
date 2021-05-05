<!--
	名称：shoppingcart.jsp
	功能：显示购物车列表，并提供修改、删除、更新购物车信息的连接
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
			<script language="javascript">
			<!--
				function validateCartForm()
				{
			
					var flag = true;
					

					//验证产品数量
					var quantityRule = /^[0-9]{1,}$/;
						
					var i;
					for(i = 0; i < document.cartForm.elements.length; i++)
					{
						if(!quantityRule.test(document.cartForm.elements[i].value))
						{
							flag = false;
						}
					}
						
					if(flag)
					{
						document.all.quantityError.innerHTML="<font size=2 color=red></font>";
						document.cartForm.submit();
					}
					else
					{
						document.all.quantityError.innerHTML="<font size=2 color=red>产品数量不为空，并由0-9的数字组成</font>";
					}
					
					return flag;
				}
			//-->
		</script>
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
		<c:if test="${cart.itemCount > 0}">
			<form method="post" name="cartForm"
				action="../buyandbilling/UpdateItemInCartServlet">
				<table width="80%" border="0" cellpadding="0" cellspacing="0">
					<tr class="gridHead">
						<td>
							&nbsp;
						</td>
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
					<c:set var="index" value="0" scope="page" />
					<c:forEach var="cartItemForm" items="${cart.cartItems}">

						<tr class="gridItem">
							<td>
								<c:out value="${a}"></c:out>
								<a href="../buyandbilling/RemoveItemFromCartServlet?itemIndex=${index}"><img border="0" src="../Images/buttonRemove.gif"/></a>
							</td>
							<td>
								<c:out value="${cartItemForm.itemId}" />
							</td>
							<td>
								<a href="../productdist/QueryItemServlet?itemId=${cartItemForm.itemId}"><c:out value="${cartItemForm.product}" /></a>
							</td>
							<td>
								<c:out value="${cartItemForm.inStock}" />
							</td>
							<td>
								<c:out value="${cartItemForm.unitPrice}" />
							</td>
							<td>
								<input type="text" maxlength="5" size="5" name="quantity"
									value="${cartItemForm.quantity}" />
							</td>
							<td>
								<c:out value="${cartItemForm.subtotal}" />
							</td>
						</tr>
						<c:set var="index" scope="page" value="${index+1}" />
					</c:forEach>
					<tr class="gridFoot">
						<td colspan="7">
							<div align="left">
							<input type="image" src="../Images/button_update_cart.gif" onclick="return validateCartForm();">
							<span id="quantityError"></span>
							</div>
							<div align="right">
								物品数：
								<c:out value="${cart.itemCount}" />
								总价格：
								<c:out value="${cart.totalPrice}" />
							</div>
						</td>
					</tr>
				</table>
			</form>	
			<input type="image" src="../Images/button_proceed.gif" onclick="javascript:document.location.href='../buyandbilling/checkout.jsp'">	
		</c:if>
		<c:if test="${cart.itemCount == 0}">
			<div>
				购物车内没有物品！
			</div>
		</c:if>
		<br />
		<jsp:include flush="true" page="../favorit/favorit.jsp" />
	</body>
</html>
