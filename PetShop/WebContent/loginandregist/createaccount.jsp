<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<HTML>
<!--
	���ƣ�createaccount.jsp
	���ܣ��û�ע��ʱ��д�����Ϣҳ��
	��д�ߣ�����
	���������ڣ�2006-12-04
-->
	<HEAD>
		<title>Create Account</title>
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
	</HEAD>
	<body>

		<!-- top bar -->
		<c:if test="${userId == ''}">
			<jsp:include flush="true" page="../topunlogined.html" />
		</c:if>
		<c:if test="${userId != ''}">
			<jsp:include flush="true" page="../toplogined.html" />
		</c:if>
		<!-- third bar -->
		<!--
		<table cellspacing="0" cellpadding="0" width="100%" height="35"
			background="Images/top_stripe3.gif" border="0">
			<tr>
				<span id="areaMenu">
				<td valign="top" width="77">
					<img src="Images/liz_2.gif">
				</td>
				<td valign="top" align="left">
					<img src="Images/liz_3.gif">
					<br>
					<font class="menuBlack"><a
						href="Category.aspx?categoryId=FISH" class="menuBlack">Fish</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=DOGS" class="menuBlack">Dogs</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=REPTILES" class="menuBlack">Reptiles</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=CATS" class="menuBlack">Cats</a>&nbsp;&nbsp;|&nbsp;
						<a href="Category.aspx?categoryId=BIRDS" class="menuBlack">Birds</a>
					</font>
			</tr>
		</table>
		<img src="Images/liz_4.gif" id="lizard4">
		<blockquote>
		  -->
		<jsp:useBean id="error" scope="request" class="java.lang.String"></jsp:useBean>
		<form method="post" action="./CreateAccountServlet" name="accountForm">
			<span class="title">�ҵ��ʻ�</span>
			<p>
			<table cellpadding="1" cellspacing="0">
				<tr>
					<td class="label" width="125">
						�û�ID:
					</td>
					<td colspan="3">
						<input name="userId" type="text" maxlength="20" size="15" />
						<span id="UserID"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td class="label">
						����:
					</td>
					<td colspan="3">
						<input name="password" type="password" maxlength="20" size="15" />
						<span id="PassWord"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td class="label">
						E-mail:
					</td>
					<td colspan="3">
						<input name="email" type="text" maxlength="80" size="30" />
						<span id="EMail"></span> &nbsp;
					</td>
				</tr>
			</table>
			<p>
				<span class="title">�ҵĵ�ַ��Ϣ</span>
			<p>
			<table cellpadding="1" cellspacing="0">
				<tr>
					<td class="label" width="125">
						��:
					</td>
					<td>
						<input name="firstName" type="text" maxlength="80" size="30" />
						<span id="FirstName"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td class="label">
						��:
					</td>
					<td>
						<input name="lastName" type="text" maxlength="80" size="30"
							id="addr_txtLastName" />
						<span id="LastName"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td class="label">
						��ַ:
					</td>
					<td>
						<input name="addr1" type="text" maxlength="80" size="55" />
						<span id="Addr"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input name="addr2" type="text" maxlength="80" size="55" />
					</td>
				</tr>
				<tr>
					<td class="label">
						����:
					</td>
					<td>
						<input name="city" type="text" maxlength="80" size="55" />
						<span id="City"></span> &nbsp;
					</td>
				</tr>
				<tr>
					<td class="label">
						ʡ��:
					</td>
					<td>
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<select name="state">
										<option value="����ʡ">
											&#38485;&#35199;&#30465;
										</option>
										<option value="����ʡ">
											&#27827;&#21335;&#30465;
										</option>
										<option value="�Ĵ�ʡ">
											&#22235;&#24029;&#30465;
										</option>
									</select>
								</td>
								<td class="label" width="100">
									��������:
								</td>
								<td>
									<input name="zip" type="text" maxlength="20" size="12" />
									<span id="Zip"></span> &nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="label">
						����:
					</td>
					<td>
						<select name="country">
							<option value="USA">
								�й�
							</option>


						</select>
					</td>
				</tr>
				<tr>
					<td class="label">
						�绰:
					</td>
					<td>
						<input name="phone" type="text" maxlength="20" size="20" />
						<span id="Telephone"></span> &nbsp;
					</td>
				</tr>
			</table>

			<p>
				<span class="title">�ҵĳ����ղؼ�����</span>
			<p>
			</p>
			<br>
			<table cellpadding="1" cellspacing="0">
				<tr>
					<td colspan="2">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>
									&nbsp;
								</td>

							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td>
									��ϲ���ĳ�����:&nbsp;
								</td>
								<td>
									<select name="favCategory">
										<option value="FISH">
											����
										</option>
										<option value="DOGS">
											Ȯ��
										</option>
										<option value="REPTILES">
											������
										</option>
										<option value="CATS">
											è
										</option>
										<option value="BIRDS">
											����
										</option>

									</select>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="myListOpt" checked="checked" />
					</td>
					<td>
						���Ƿ�ϣ���ڹ��ﳵҳ����ʾ���ĳ����ղؼ�?
					</td>
				</tr>
			</table>

			<p>
				<input type="image" name="submit" src="../Images/buttonSubmit.gif"
					onclick="return createAccount()" />
		</form>
		</P>
		</blockquote>
	</body>
</HTML>

<script language="javascript">
<!--
	function createAccount()
	{       
		    var rlu=/^[\w]{6,18}$/;
			var remail=/^[\w]+@{1}[A-Za-z|\d]+\.{1}(com|com.cn|com.net)$/;	
			var vali = new Array();
			vali =
			['����������û���','���볤����6��18λ֮��','��������ȷ��E-Mail��ʽ��:fire@sina.com��fire@163.com.cn��fire@269.net','�����������','�������������','���������סַ','�����������ڵĳ���','����������ʱ�','��������ĵ绰����'];
				if(document.accountForm.userId.value == "")
				{
					document.all.UserID.innerHTML = '<font color=red size=2>' + vali[0] + '</font>';
					document.accountForm.userId.focus();
				}
				else
				{
					document.all.UserID.innerHTML = '';
				}
				
				if(!rlu.test(document.accountForm.password.value))
				{
					document.all.PassWord.innerHTML = '<font color=red size=2>' + vali[1] + '</font>';
					document.accountForm.password.focus();
				}
				else
				{
					document.all.PassWord.innerHTML = '';
				}
				
				if(!remail.test(document.accountForm.email.value))
				{
					document.all.EMail.innerHTML = '<font color=red size=2>' + vali[2] + '</font>';
					document.accountForm.email.focus();
				}
				else
				{
					document.all.EMail.innerHTML = '';
				}
				
				if(document.accountForm.firstName.value == "")
				{
					document.all.FirstName.innerHTML = '<font color=red size=2>' + vali[3] + '</font>';
					document.accountForm.firstName.focus();
				}
				else
				{
					document.all.FirstName.innerHTML = '';
				}
				
				if(document.accountForm.lastName.value == "")
				{
					document.all.LastName.innerHTML = '<font color=red size=2>' + vali[4] + '</font>';
					document.accountForm.lastName.focus();
				}
				else
				{
					document.all.LastName.innerHTML = '';
				}
				
				/*if(document.accountForm.addr1.value == "")
				{
					document.all.Addr.innerHTML = '<font color=red size=2>' + vali[5] + '</font>';
					document.accountForm.addr1.focus();
				}
				else
				{
					document.all.Addr.innerHTML = '';
				}
				*/
				if(document.accountForm.city.value == "")
				{
					document.all.City.innerHTML = '<font color=red size=2>' + vali[6] + '</font>';
					document.accountForm.city.focus();
				}
				else
				{
					document.all.City.innerHTML = '';
				}
				if(document.accountForm.zip.value == "")
				{
					document.all.Zip.innerHTML = '<font color=red size=2>' + vali[7] + '</font>';
					document.accountForm.zip.focus();
				}
				else
				{
					document.all.Zip.innerHTML = '';
				}
				if(document.accountForm.phone.value == "")
				{
					document.all.Telephone.innerHTML = '<font color=red size=2>' + vali[8] + '</font>';
					document.accountForm.phone.focus();
				}
				else
				{
					document.all.Telephone.innerHTML = '';
				}
				if((document.accountForm.userId.value == "")||(!rlu.test(document.accountForm.password.value))||(!remail.test(document.accountForm.email.value))||(document.accountForm.firstName.value == "")||(document.accountForm.lastName.value == "")||/*(document.accountForm.addr1.value == "")||*/(document.accountForm.city.value == "")||(document.accountForm.zip.value == "")||(document.accountForm.phone.value == ""))
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
