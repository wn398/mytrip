<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="CSS/style1.css" rel="stylesheet" type="text/css" />
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
        <td colspan="2" class="menu"><a class="menu-link" href="index.html">MANU</a> <a class="menu-link" href="info/html/index.html">资讯</a> <a class="menu-link" href="user_load.jsp">博文</a> <a class="menu-link" href="index.html">指南</a> <a class="menu-link" href="index.html">XX</a> </td>
      </tr>
      <tr>
        <td class="content"><h1>资讯</h1>
          <p>这里有最热门的旅游资讯，有最热门的景点介绍，有最丰富的图片详析， <a title="Interneto svetainių kūrimas" href="info/html/index.html">点击这里</a>，马上进入精彩资讯，让你足不出户畅游世界！</p>
          <h1>交友</h1>
          <p>点缀旅途，流光炫彩—————这里有最酷的交流平台，最炫的旅游时讯，全由你一手掌握！还等什么，赶快加入吧朋友，让旅途不再孤单，让路上的风景成为我们生活的点滴回忆。。。。。。。 </p>
          <p><a title="赶快加入我们吧" href="user_register.jsp"><em>注册驴友</em></a></p></td>
        <td width="200" class="content-right"><a class="menu-right" href="info/html/index.html">资讯</a>
            <a class="menu-right" href="user_load.jsp">登陆</a>
            <a class="menu-right" href="user_register.jsp">注册</a>
          <a class="menu-right" href="about.jsp">关于我们</a>
		  <a class="menu-right" href="#">意见征求</a></td>
      </tr>
      <tr>
        <td colspan="2"><span class="made-in_text">Design by <!-- You can use this template for any purpose you want, but you have to leave this link --><a class="made-in" title="Interneto svetainių kūrimas" href="index.jsp">版权所有，盗版枪毙！</a></span></td>
      </tr>
    </table></td>
    <td class="bg-white">&nbsp;</td>
  </tr>
  <tr>
    <td class="corner3">&nbsp;</td>
    <td class="bg-white">&nbsp;</td>
    <td class="corner4">&nbsp;</td>
  </tr>
</table>
<p class="style1">&nbsp;</p>
</body>
</html>

