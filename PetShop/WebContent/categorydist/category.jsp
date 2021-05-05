<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
	页面名:category.jsp
	主要功能:展示某个分类的产品,并将一个值的传给productdist模块
	编辑者:王鹏
	时间:2006-11-29-12:30
 -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<jsp:useBean id="name" scope="request" class="java.lang.String"></jsp:useBean>
	<jsp:useBean id="arry" scope="request" class="java.util.ArrayList"></jsp:useBean>
	<jsp:useBean id="pagebean" scope="request"
		class="fire.petshop.common.util.PageUtil"></jsp:useBean>
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

		<h3>
			<c:out value="${name}"></c:out>
		</h3>

		<form name="productListForm"
			action="../categorydist/ProductListServlet">
			<table cellspacing="0" cellpadding="0">
				<tr class="gridHead">
					<td>
						编号
					</td>
					<td>
						名称
					</td>
				</tr>
				<c:forEach var="productform" items="${arry}">
					<tr class="gridItem">
						<td align="center">
							<c:out value="${productform.productId}" />
						</td>
						<td width="70%">
							<A
								HREF="../productdist/ItemListServlet?productId=${productform.productId}"><c:out
									value="${productform.name}" /> </A>
						</td>
					</tr>

				</c:forEach>
				<tr>
					<td align="left">
						<c:if test="${pagebean.pageIndex > 1}">
							<a
								href="../categorydist/ProductListServlet?name=${name}&pageIndex=${pagebean.pageIndex}&to=privious"><img
									src="../Images/buttonPrev.gif" border="0" />
							</a>
						</c:if>
					</td>
					<td align="right">
						<c:if test="${pagebean.itemCount > 4}">
							<c:if test="${pagebean.pageIndex< pagebean.pageCount}">
								<a
									href="../categorydist/ProductListServlet?name=${name}&pageIndex=${pagebean.pageIndex}&to=next"><img
										src="../Images/buttonMore.gif" border="0" />
								</a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>


