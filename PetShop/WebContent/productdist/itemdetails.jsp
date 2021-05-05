<!--
    名称:itemdetails.jsp
    功能:详细显示商品的的各项相关信息,是客户对产品有个全面的认识~！
编写者:周艳龙
最后修改日期:2006-11-28
-->
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</head>
	<jsp:useBean id="itemDetailForm" scope="request"
		class="fire.petshop.productdist.form.ItemDetailForm">
	</jsp:useBean>
	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<table>
			<tr>
				<h3>产品名称：<c:out value="${itemDetailForm.attr1}" /></h3>
			</tr>
			<br>
			<tr>
				<h4>单位价格：<c:out value="${itemDetailForm.listPrice}" /></h4>
			</tr>
			<br>
			<tr>
				<h4>库存数量：<c:out value="${itemDetailForm.qty}" /></h4>
			</tr>
			<br>
			<tr>
			<h4>
				图片描述：
				<CODE>
					${itemDetailForm.descn}
				</CODE>
				</h4>
			</tr>
			<a href="../buyandbilling/AddItemToCartServlet?itemId=${itemDetailForm.itemId}"><img border="0" src="../Images/buttonAdd.gif"/></a>
		</table>
	</body>
</html>
