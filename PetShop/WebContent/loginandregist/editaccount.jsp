<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
	���ƣ�editaccount.jsp
	���ܣ�ע���û���½���ڴ�ҳ����ж��Լ��������Ϣ�����޸�
	��д�ߣ�����
	���������ڣ�2006-12-04
-->
<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</head>
	<jsp:useBean id="arrayList" scope="request" class="java.util.ArrayList" />
	<jsp:useBean id="catelist" scope="request" class="java.util.ArrayList" />

	<body>
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>

		<FORM method="post" action="../loginandregist/UpdateAccountServlet" name="accountForm">
			<c:forEach var="array" items="${arrayList}"><h3>&#25105;&#30340;&#24080;&#25143; </h3><br>
			<span class="label">�û�ID:</span>
			<c:out value="${array.userId}" />
				<br>
			<span class="label">Email:</span>
			<INPUT TYPE="text" NAME="email" value="${array.email}"><span id="EMail"></span>
				<br>
				<br>
				<br><h3>&#25105;&#30340;&#22320;&#22336;&#20449;&#24687;</h3> <br>
			<span class="label">��&nbsp;:&nbsp;</span>
			<INPUT TYPE="text" NAME="firstName" value="${array.firstName}"><span id="FirstName"></span>
				<br>
			<span class="label">��&nbsp;:&nbsp;</span>
			<INPUT TYPE="text" NAME="lastName" value="${array.lastName}"><span id="LastName"></span>
				<br>
			<span class="label">��ַ:</span>
			<INPUT TYPE="text" NAME="addr1" value="${array.addr1}"><span id="Addr"></span>
				<INPUT TYPE="text" NAME="addr2" value="${array.addr2}">
				<br>
			<span class="label">����:</span>
			<INPUT TYPE="text" NAME="city" value="${array.city}"><span id="City"></span>
				<br>
			<span class="label">ʡ��:</span>
					<select name="state">
							<c:if test="${array.state != '����ʡ'}">
								<option value="����ʡ">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${array.state == '����ʡ'}">
								<option value="����ʡ" selected="selected">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${array.state != '����ʡ'}">
							<option value="����ʡ">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state == '����ʡ'}">
							<option value="����ʡ" selected="selected">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state != '�Ĵ�ʡ'}">
							<option value="�Ĵ�ʡ">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state == '�Ĵ�ʡ'}">
							<option value="�Ĵ�ʡ" selected="selected">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
						</select>
			<span class="label">��������:</span>
			<INPUT TYPE="text" NAME="zip" value="${array.zip}"><span id="Zip"></span>
				<br>
			<span class="label">����:</span>		
			<SELECT NAME="country">
					<option value="�й�">
						<c:out value="�й�" />
					</option>

				</SELECT>			
			<span class="label">�绰:</span>
			<INPUT TYPE="text" NAME="phone" value="${array.phone}"><span id="Telephone"></span>
				<br>
				<br>
				<br>
			<h3>�ҵĳ����ղؼ�����</h3>
			<br>
			<span class="label">ѡ����ϲ���Ķ���:</span>
			<SELECT NAME="favCategory">
						<c:if test="${array.favCategory != 'Fish'}">
							<option value="Fish">
								����
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'Fish'}">
							<option value="Fish" selected="selected">
								����
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'DOGS'}">
							<option value="DOGS">
								Ȯ��
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'DOGS'}">
							<option value="DOGS" selected="selected">
								Ȯ��
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'REPTILES'}">
							<option value="REPTILES">
								������
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'REPTILES'}">
							<option value="REPTILES" selected="selected">
								������
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'CATS'}">
							<option value="CATS">
								è
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'CATS'}">
							<option value="CATS" selected="selected">
								è
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'BIRDS'}">
							<option value="BIRDS">
								����
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'BIRDS'}">
							<option value="BIRDS" selected="selected">
								����
							</option>
						</c:if>
				</SELECT>
				<br>
				<c:if test="${array.myListOpt == 1}">
					<INPUT TYPE="checkbox" NAME="myListOpt" checked="checked"><span class="label">���Ƿ�ϣ���ڹ��ﳵҳ����ʾ���ĳ����ղؼ�?</span></type><br>
				</c:if>
				<c:if test="${array.myListOpt == 0}">
					<INPUT TYPE="checkbox" NAME="myListOpt"><span class="label"><span class="label">���Ƿ�ϣ���ڹ��ﳵҳ����ʾ���ĳ����ղؼ�?</span></type><br>
				</c:if>
				<br>
			</c:forEach>
			<input type="image" src="../Images/buttonSubmit.gif" onclick="return editAccount()"/>
		</FORM>
	</body>
</html>


<script language="javascript">
<!--
	function editAccount()
	{       
		    var remail=/^[\w]+@{1}[A-Za-z|\d]+\.{1}(com|com.cn|com.net)$/;
			var vali = new Array();
			vali = ['��������ȷ��E-Mail��ʽ��:fire@sina.com��fire@163.com.cn��fire@269.net','�����������','�������������','���������סַ','�����������ڵĳ���','����������ʱ�','��������ĵ绰����'];
		      
				if(!remail.test(document.accountForm.email.value))
				{
					document.all.EMail.innerHTML = '<font color=red size=2>' + vali[0] + '</font>';
					document.accountForm.email.focus();
				}
				else
				{
					document.all.EMail.innerHTML = '';
				}
				
				if(document.accountForm.firstName.value == "")
				{
					document.all.FirstName.innerHTML = '<font color=red size=2>' + vali[1] + '</font>';
					document.accountForm.firstName.focus();
				}
				else
				{
					document.all.FirstName.innerHTML = '';
				}
				
				if(document.accountForm.lastName.value == "")
				{
					document.all.LastName.innerHTML = '<font color=red size=2>' + vali[2] + '</font>';
					document.accountForm.lastName.focus();
				}
				else
				{
					document.all.LastName.innerHTML = '';
				}
				
				/*if(document.accountForm.addr1.value == "")
				{
					document.all.Addr.innerHTML = '<font color=red size=2>' + vali[3] + '</font>';
					document.accountForm.addr1.focus();
				}
				else
				{
					document.all.Addr.innerHTML = '';
				}
				*/
				if(document.accountForm.city.value == "")
				{
					document.all.City.innerHTML = '<font color=red size=2>' + vali[4] + '</font>';
					document.accountForm.city.focus();
				}
				else
				{
					document.all.City.innerHTML = '';
				}
				if(document.accountForm.zip.value == "")
				{
					document.all.Zip.innerHTML = '<font color=red size=2>' + vali[5] + '</font>';
					document.accountForm.zip.focus();
				}
				else
				{
					document.all.Zip.innerHTML = '';
				}
				if(document.accountForm.phone.value == "")
				{
					document.all.Telephone.innerHTML = '<font color=red size=2>' + vali[6] + '</font>';
					document.accountForm.phone.focus();
				}
				else
				{
					document.all.Telephone.innerHTML = '';
				}
				if((!remail.test(document.accountForm.email.value))||(document.accountForm.firstName.value == "")||(document.accountForm.lastName.value == "")||/*(document.accountForm.addr1.value == "")||*/(document.accountForm.city.value == "")||(document.accountForm.zip.value == "")||(document.accountForm.phone.value == ""))
				{
					return false;
				}
				else
				{
					var form=document.accountForm;
					form.submit();
				}
	}
//-->
</script>
