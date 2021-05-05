<!--
    ����:itemdetails.jsp
    ����:��ϸ��ʾ��Ʒ�ĵĸ��������Ϣ,�ǿͻ��Բ�Ʒ�и�ȫ�����ʶ~��
��д��:������
����޸�����:2006-11-28
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
				<h3>��Ʒ���ƣ�<c:out value="${itemDetailForm.attr1}" /></h3>
			</tr>
			<br>
			<tr>
				<h4>��λ�۸�<c:out value="${itemDetailForm.listPrice}" /></h4>
			</tr>
			<br>
			<tr>
				<h4>���������<c:out value="${itemDetailForm.qty}" /></h4>
			</tr>
			<br>
			<tr>
			<h4>
				ͼƬ������
				<CODE>
					${itemDetailForm.descn}
				</CODE>
				</h4>
			</tr>
			<a href="../buyandbilling/AddItemToCartServlet?itemId=${itemDetailForm.itemId}"><img border="0" src="../Images/buttonAdd.gif"/></a>
		</table>
	</body>
</html>
