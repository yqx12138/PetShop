<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--
     ����:searchItems.jsp 
     ����:��ͻ��ṩһ��ģ����ѯ�Ĺ���,�������뵥���ַ�.ȫ�����ƻ�����������
��д��:������
����޸�����:2006-11-28
-->
<jsp:useBean id="searchArray" scope="request"
	class="java.util.ArrayList"></jsp:useBean>
<jsp:useBean id="PageU" scope="request"
	class="fire.petshop.common.util.PageUtil"></jsp:useBean>
<jsp:useBean id="searchItem" scope="request" class="java.lang.String">
</jsp:useBean>
<jsp:useBean id="search" scope="request" class="java.lang.String">
</jsp:useBean>

<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
		<!-- 
		<script lagnguage="javascript">
			<!--
				function 
			-->
		</script>
	</head>
	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<form method="post" action="./SearchItemServlet" name="searchForm">
			<c:if test="${search=='wo'}">
				<table border="0" cellpadding="0" cellspacing="0" width="70%">
					<tr class="gridHead">

						<td width="20%">
							��Ʒ����
						</td>
						<td width="20%">
							��Ʒ����
						</td>
						<td width="60%">
							����
						</td>
					</tr>
					<c:forEach var="searchForm" items="${searchArray}">
						<tr class="gridItem">
							<td>
								<c:out value="${searchForm.productId}" />
							</td>
							<td>
								<a href="./ItemListServlet?productId=${searchForm.productId}"><c:out
										value="${searchForm.attr1}" /> </a>
							</td>
							<td>
								<CODE>
									${searchForm.description}
								</CODE>
							</td>
						</tr>
					</c:forEach>
					<tr class="gridFoot">
						<td colspan="3">
							<div class="label" align="right">
								�鵽��
								<c:out value="${count}" />
								����¼
							</div>
						</td>
					</tr>
					<tr>
						<td align="left">
							<c:if test="${PageU.pageIndex>1}">
								<a href="../productdist/SearchItemServlet?searchItem=${searchItem}&currentPage=${PageU.pageIndex}&next=before"><img src="../Images/buttonPrev.gif" border="0"/></a>
							</c:if>
						</td>
						<td colspan="2" align="right">
							<c:if test="${PageU.pageIndex<PageU.pageCount}">
								<a href="../productdist/SearchItemServlet?searchItem=${searchItem}&currentPage=${PageU.pageIndex}&next=next"><img src="../Images/buttonMore.gif" border="0"/></a>
							</c:if>
						</td>
					</tr>
				</table>
			</c:if>
		</form>
		<c:if test="${search!='wo'}">
			<c:out value="${search}" />
		</c:if>
	</body>
</html>
