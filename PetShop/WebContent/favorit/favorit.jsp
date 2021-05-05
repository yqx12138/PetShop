<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
	名称:favorit.jsp
	功能:显示一类宠物的信息
	编写者:杨凡
	最后修改时间:2006-12-2
-->

<jsp:useBean id="arrayList" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="pages" scope="request"
	class="fire.petshop.common.util.PageUtil" />
<jsp:useBean id="ifDisplay" scope="request" class="java.lang.String" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</head>
	<body>
		<c:if test="${ifDisplay == 'yes' }">
			<h2>
				收藏夹
			</h2>
			<br />
			<form action="../favorit/FavoritListServlet" method="post">
				<!-- 
			<input type="hidden" name="pages" value="${pages.pageIndex}" />
			 <input type="hidden" name="userId" value="${userId} }" />-->

				<TABLE width="30%">
					<tr class="gridHead">
						<td colspan="2">
							宠物名称
						</td>
					</tr>
					<c:forEach var="array" items="${arrayList}">
						<TR class="gridItem">
							<TD colspan="2">
								<a
									href='../productdist/ItemListServlet?productId=${array.productId}'><c:out
										value="${array.name}"></c:out>(<c:out
										value="${array.productId}"></c:out>)</a>
							</TD>
						</TR>
					</c:forEach>
					<tr>
						<td align="left">
							<c:if test="${pages.pageIndex>1}">
								<!-- 
							<input type="hidden" name="to" value="before" />
							<input type="image" src="../Images/buttonPrev.gif"
								onclick="javascript:document.forms[0].submit()" />
								 -->
								<a
									href="../favorit/FavoritListServlet?pages=${pages.pageIndex}&to=before"><img
										src="../Images/buttonPrev.gif" border="0" /> </a>
							</c:if>
						</td>
						<td align="right">
							<c:if test="${pages.pageIndex<pages.pageCount}">
								<!-- 
							<input type="hidden" name="to" value="next" />
							<input type="image" src="../Images/buttonMore.gif"
								onclick="javascript:document.forms[0].submit()" />
								 -->
								<a
									href="../favorit/FavoritListServlet?pages=${pages.pageIndex}&to=next"><img
										src="../Images/buttonMore.gif" border="0" /> </a>
							</c:if>
						</td>
					</tr>
				</TABLE>
			</form>
		</c:if>
	</body>
</html>
