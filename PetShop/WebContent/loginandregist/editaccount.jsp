<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!--
	名称：editaccount.jsp
	功能：注册用户登陆后，在此页面进行对自己的相关信息进行修改
	编写者：刘洋
	最后更新日期：2006-12-04
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
			<span class="label">用户ID:</span>
			<c:out value="${array.userId}" />
				<br>
			<span class="label">Email:</span>
			<INPUT TYPE="text" NAME="email" value="${array.email}"><span id="EMail"></span>
				<br>
				<br>
				<br><h3>&#25105;&#30340;&#22320;&#22336;&#20449;&#24687;</h3> <br>
			<span class="label">名&nbsp;:&nbsp;</span>
			<INPUT TYPE="text" NAME="firstName" value="${array.firstName}"><span id="FirstName"></span>
				<br>
			<span class="label">姓&nbsp;:&nbsp;</span>
			<INPUT TYPE="text" NAME="lastName" value="${array.lastName}"><span id="LastName"></span>
				<br>
			<span class="label">地址:</span>
			<INPUT TYPE="text" NAME="addr1" value="${array.addr1}"><span id="Addr"></span>
				<INPUT TYPE="text" NAME="addr2" value="${array.addr2}">
				<br>
			<span class="label">城市:</span>
			<INPUT TYPE="text" NAME="city" value="${array.city}"><span id="City"></span>
				<br>
			<span class="label">省份:</span>
					<select name="state">
							<c:if test="${array.state != '陕西省'}">
								<option value="陕西省">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${array.state == '陕西省'}">
								<option value="陕西省" selected="selected">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${array.state != '河南省'}">
							<option value="河南省">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state == '河南省'}">
							<option value="河南省" selected="selected">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state != '四川省'}">
							<option value="四川省">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
							<c:if test="${array.state == '四川省'}">
							<option value="四川省" selected="selected">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
						</select>
			<span class="label">邮政编码:</span>
			<INPUT TYPE="text" NAME="zip" value="${array.zip}"><span id="Zip"></span>
				<br>
			<span class="label">国家:</span>		
			<SELECT NAME="country">
					<option value="中国">
						<c:out value="中国" />
					</option>

				</SELECT>			
			<span class="label">电话:</span>
			<INPUT TYPE="text" NAME="phone" value="${array.phone}"><span id="Telephone"></span>
				<br>
				<br>
				<br>
			<h3>我的宠物收藏夹设置</h3>
			<br>
			<span class="label">选择你喜欢的动物:</span>
			<SELECT NAME="favCategory">
						<c:if test="${array.favCategory != 'Fish'}">
							<option value="Fish">
								鱼类
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'Fish'}">
							<option value="Fish" selected="selected">
								鱼类
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'DOGS'}">
							<option value="DOGS">
								犬类
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'DOGS'}">
							<option value="DOGS" selected="selected">
								犬类
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'REPTILES'}">
							<option value="REPTILES">
								爬行类
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'REPTILES'}">
							<option value="REPTILES" selected="selected">
								爬行类
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'CATS'}">
							<option value="CATS">
								猫
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'CATS'}">
							<option value="CATS" selected="selected">
								猫
							</option>
						</c:if>
						<c:if test="${array.favCategory != 'BIRDS'}">
							<option value="BIRDS">
								鸟类
							</option>
						</c:if>
						<c:if test="${array.favCategory == 'BIRDS'}">
							<option value="BIRDS" selected="selected">
								鸟类
							</option>
						</c:if>
				</SELECT>
				<br>
				<c:if test="${array.myListOpt == 1}">
					<INPUT TYPE="checkbox" NAME="myListOpt" checked="checked"><span class="label">您是否希望在购物车页面显示您的宠物收藏夹?</span></type><br>
				</c:if>
				<c:if test="${array.myListOpt == 0}">
					<INPUT TYPE="checkbox" NAME="myListOpt"><span class="label"><span class="label">您是否希望在购物车页面显示您的宠物收藏夹?</span></type><br>
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
			vali = ['请输入正确的E-Mail格式如:fire@sina.com或fire@163.com.cn或fire@269.net','请输入你的姓','请输入你的名字','请输入你的住址','请输入你所在的城市','请输入你的邮编','请输入你的电话号码'];
		      
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
