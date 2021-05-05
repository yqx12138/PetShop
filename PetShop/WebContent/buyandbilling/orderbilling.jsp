<!--
	名称：orderbilling.jsp
	功能：显示订单信息收集表单并提交处理
	编写者：张少成
	最后更新日期：2006-12-04
-->
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="accountBean" scope="request"
	class="fire.petshop.loginandregist.model.AccountBean" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>填写订单信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="../css/Styles.css">
		<script language="javascript">
			<!--
				function validateBuildOrderForm()
				{
					var flag = true;
					
					with(document.buildOrderForm)
					{
						//验证卡号
						var creditCardRule = /^[0-9]{1,}$/;
						
						if(!creditCardRule.test(creditCard.value))
						{
							document.all.creditCardError.innerHTML="<font size=2 color=red>证件号码不能为空，并由0-9的数字组成</font>";
							flag = false;
						}
						else
						{
							
							document.all.creditCardError.innerHTML="";
						}
						//验证名字
						var billToFirstNameRule = /^[\w\u4e00-\u9fa5]{1,}$/;
						
						if(!billToFirstNameRule.test(billToFirstName.value))
						{
							document.all.billToFirstNameError.innerHTML="<font size=2 color=red>必须填写名字</font>";
							flag = false;
						}
						else
						{
							document.all.billToFirstNameError.innerHTML="";
						}
						//验证姓氏
						var billToLastNameRule = /^[\w\u4e00-\u9fa5]{1,}$/;
						
						if(!billToLastNameRule.test(billToLastName.value))
						{
							document.all.billToLastNameError.innerHTML="<font size=2 color=red>必须填写姓氏</font>";
							flag = false;
						}
						else
						{
							document.all.billToLastNameError.innerHTML="";
						}
						//验证地址1
						var billAddr1Rule = /^[\w\u4e00-\u9fa5]{1,}$/;
						
						if(!billAddr1Rule.test(billAddr1.value))
						{
							document.all.billAddr1Error.innerHTML="<font size=2 color=red>必须填写地址1</font>";
							flag = false;
						}
						else
						{
							document.all.billAddr1Error.innerHTML="";
						}
						//验证城市
						var billCityRule = /^[\w\u4e00-\u9fa5]{1,}$/;
						
						if(!billCityRule.test(billCity.value))
						{
							document.all.billCityError.innerHTML="<font size=2 color=red>必须填写地址1</font>";
							flag = false;
						}
						else
						{
							document.all.billCityError.innerHTML="";
						}
						//验证邮编
						var billZipRule = /^[0-9]{6}$/;
						
						if(!billZipRule.test(billZip.value))
						{
							document.all.billZipError.innerHTML="<font size=2 color=red>邮政编码必须由6位0-9的数字组成</font>";
							flag = false
						}
						else
						{
							document.all.billZipError.innerHTML="";
						}
					}
					
					if(flag)
					{
						document.buildOrderForm.submit();
					}
					else
					{
						return flag;
					}
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

		<h3>
			请输入基本信息
		</h3>
		<br />
		<form method="post" action="./BuildOrderServlet" name="buildOrderForm">
			<table width="100%" border="0">
				<tr>
					<td width="20%">
						&#21345;&#31867;&#22411;&#65306;
					</td>
					<td width="80%">
						<select name="cardType">
							<option value="信用卡">
								&#20449;&#29992;&#21345;
							</option>
							&nbsp;
						</select>
						<br>
					</td>
					<td width="10%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#21345;&#21495;&#65306;
					</td>
					<td>
						<input type="text" maxlength="20" size="20" name="creditCard" />
						<span id="creditCardError"></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#36807;&#26399;&#26085;&#26399;&#65306;
					</td>
					<td>
						&#24180;&#65306;
						<select name="year">
							<c:forEach var="i" begin="2005" end="2050" step="1">
								<option value="${i}">
									<c:out value="${i}" />
								</option>
							</c:forEach>
						</select>
						&#26376;&#65306;
						<select name="month">
							<c:forEach var="i" begin="1" end="12" step="1">
								<option value="${i}">
									<c:out value="${i}" />
								</option>
							</c:forEach>
						</select>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
			</table>
			<h3>
				请输入支付人地址
			</h3>
			<br />
			<table width="100%" border="0">
				<tr>
					<td width="20%">
						&#21517;&#65306;
					</td>
					<td width="80%">
						<input type="text" maxlength="25" size="25" name="billToFirstName"
							value="${accountBean.firstName}">
						<span id="billToFirstNameError"></span>
					</td>
					<td width="10%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22995;&#65306;
					</td>
					<td>
						<input type="text" maxlength="25" size="25" name="billToLastName"
							value="${accountBean.lastName}">
						<span id="billToLastNameError"></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;1&#65306;
					</td>
					<td>
						<input type="text" maxlength="70" size="70" name="billAddr1"
							value="${accountBean.addr1}">
						<span id="billAddr1Error"></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22320;&#22336;2&#65306;
					</td>
					<td>
						<input type="text" maxlength="70" size="70" name="billAddr2"
							value="${accountBean.addr2}">
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22478;&#24066;&#65306;
					</td>
					<td>
						<input type="text" maxlength="70" size="70" name="billCity"
							value="${accountBean.city}">
						<span id="billCityError"></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#30465;&#20221;&#65306;
					</td>
					<td>
						<select name="billState">
							<c:if test="${accountBean.state != '陕西省'}">
								<option value="陕西省">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${accountBean.state == '陕西省'}">
								<option value="陕西省" selected="selected">
									&#38485;&#35199;&#30465;
								</option>
							</c:if>
							<c:if test="${accountBean.state != '河南省'}">
							<option value="河南省">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${accountBean.state == '河南省'}">
							<option value="河南省" selected="selected">
								&#27827;&#21335;&#30465;
							</option>
							</c:if>
							<c:if test="${accountBean.state != '四川省'}">
							<option value="四川省">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
							<c:if test="${accountBean.state == '四川省'}">
							<option value="四川省" selected="selected">
								&#22235;&#24029;&#30465;
							</option>
							</c:if>
						</select>
						<br>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#37038;&#32534;&#65306;
					</td>
					<td>
						<input type="text" maxlength="15" size="15" name="billZip"
							value="${accountBean.zip}">
						<span id="billZipError"></span>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						&#22269;&#23478;&#65306;&nbsp;
					</td>
					<td>
						<select name="billCountry" value="${accountBean.country}">
							<option selected value="${accountBean.country}">
								<c:out value="${accountBean.country}" />
							</option>
							<option value="中国">
								&#20013;&#22269;
							</option>
						</select>
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="3">
						&nbsp;
						<input type="checkbox" checked="true" name="shiptobillingaddr">
						&#36135;&#29289;&#26159;&#21542;&#37038;&#23492;&#33267;&#25903;&#20184;&#20154;&#22320;&#22336;
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="image" src="../Images/button_submit.gif"
							onclick="return validateBuildOrderForm();" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
