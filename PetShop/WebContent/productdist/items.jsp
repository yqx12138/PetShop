<!--
     名称:item.jsp 
     功能:只显示商品的 id,name,price是客户对商品有个初步认识~！
编写者:周艳龙
最后修改日期:2006-11-28 
-->
<%@ page language="java" import="fire.petshop.productdist.util.*"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="arrayList" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="pagel" scope="request"
	class="fire.petshop.common.util.PageUtil" />
<jsp:useBean id="productId" scope="request" class="java.lang.String" />
<jsp:useBean id="name" scope="request" class="java.lang.String" />
<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</head>
	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<form action="./ItemListServlet" method="post">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<h3>
						<c:out value="${name}" />
					</h3>
				</tr>
				<tr class="gridHead">
					<td>
						产品条目代号
					</td>
					<td>
						产品条目名称
					</td>
					<td>
						单位价格
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<c:forEach var="itemForm" items="${arrayList}">
					<tr class="gridItem">
						<td>
							<c:out value="${itemForm.itemId}" />
						</td>
						<td>
							<a href="./QueryItemServlet?itemId=${itemForm.itemId}"><c:out
									value="${itemForm.attr1}" /> </a>
						</td>
						<td>
							<c:out value="${itemForm.listPrice}" />
						</td>
						<td>
							<a
								href="../buyandbilling/AddItemToCartServlet?itemId=${itemForm.itemId}"><img
									border="0" src="../Images/buttonAdd.gif" />
							</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td align="left" colspan="2">
						<c:if test="${pagel.pageIndex>1}">
							<a
								href="../productdist/ItemListServlet?productId=${productId}&pagel=${pagel.pageIndex}&to=before"><img
									src="../Images/buttonPrev.gif" border="0" />
							</a>
						</c:if>
					</td>
					<td align="right" colspan="2">
						<c:if test="${pagel.pageIndex<pagel.pageCount}">
							<a
								href="../productdist/ItemListServlet?productId=${productId}&pagel=${pagel.pageIndex}&to=next"><img
									src="../Images/buttonMore.gif" border="0" />
							</a>
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
