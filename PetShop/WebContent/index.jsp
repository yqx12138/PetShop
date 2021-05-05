<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
    页面名:indexjsp
    功能: 主要负责个类的导航
    编辑者:王鹏
    时间:2006-11-29 17:43
 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <jsp:useBean id="arry" scope="request" class="java.util.ArrayList"></jsp:useBean>
  <body onload="javascript:document.location.href='./categorydist/CategoryListServlet'">
  </body>
</html>
