<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="description" content="interneto svetainių kūrimas" />
<meta name="keywords" content="dizainas" />
<meta name="author" content="Romano studija | http://www.roman.lt/ | Copyright (C) 2007. All rights reserved." />
<meta name="robots" content="index, follow" />
<link href="CSS/style.css" rel="stylesheet" type="text/css" />
    <base href="<%=basePath%>">
    
    <title>登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  </head>
  
  <body>
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="table-corners">
  <tr>
    <td class="corner1">&nbsp;</td>
    <td class="bg-white">&nbsp;</td>
    <td class="corner2">&nbsp;</td>
  </tr>
  <tr>
    <td class="bg-white">&nbsp;</td>
    <td><table border="0" align="center" cellpadding="0" cellspacing="0" class="main-table">
      <tr>
        <td colspan="2" class="top-img">
            <p><br />
              <br />  <span class="website-title">驴友天地，畅享旅程</span><br />
              <br />
          Enjoy the trevaling,enjoy the world!<br />
          </p>
          </td>
      </tr>
      
     
      <tr>
        <td colspan="2" class="menu">
     
        <p align="center" class="STYLE1">&nbsp;</p>

 <p align="center" class="STYLE1">
 
 	  <s:actionerror/>
   <s:form action="User_loadAction">
<div id="sidebar">
	<h3>请输入登录的用户名和密码</h3>
	<form method="post" action="index.html">

	
		<p align="center">
		  <s:form action="User_loadAction">
		  <label for="username">用户名</label>
		  <input type="text" name="username"/><br/><br>
		  <label for="password">密码：</label>
		  <input type="password" name="password"/><br><br>
		  <input type="submit" value="登陆">&nbsp;<input type="reset" value="重置">&nbsp;
          <s:a href="user_findpassword.jsp">忘记密码?</s:a>
          </s:form>
		</p>
		
		 
		<p>&nbsp; </p>
    </form>
</div>
 </s:form>
</p>
</table>  
  </table>

    
  </body>
</html>