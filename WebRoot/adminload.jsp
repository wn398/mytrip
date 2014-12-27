<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="CSS/style.css" rel="stylesheet" type="text/css" />





<style type="text/css">
<!--
body,td,th {
font-family: 宋体;
font-size: 14px;
}
.STYLE1 {
font-size: 24px;
font-weight: bold;
}
-->
</style>
    
  </head>
  
 <body>
<s:form action="AdminAction.action" method="post">  
<table width="924" border="0" align="center" cellpadding="0" cellspacing="0" class="table-corners">
<tr>&nbsp;</tr>

<tr>&nbsp;</tr>
  <tr>
    <td width="20" class="corner1">&nbsp;</td>
    <td width="860" class="bg-white">&nbsp;</td>
    <td width="44" class="corner2">&nbsp;</td>
  </tr>
  <tr>
    <td class="bg-white">&nbsp;</td>
    <td><table border="0" align="center" cellpadding="0" cellspacing="0" class="main-table">
      <tr>
        <td background="images/top-bg.jpg"><object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0" width="850" height="250">
                    <param name="movie" value="images/flashbg/flashbg-0013.swf">
                    <param name="quality" value="high">
                    <param name="wmode" value="transparent">
                    <embed src="images/flashbg/flashbg-0013.swf" width="850" height="250" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" wmode="transparent"></embed></object>
            <!--<p><br />
              <br />  <span class="website-title">驴友天地，畅享旅程</span><br />
              <br />
          Enjoy the trevaling,enjoy the world!<br />
          </p>-->
          </td>
      </tr>
      <tr>
        <td height="274" colspan="2" class="menu">
        
        
        
        
        
        
        
        
        <p align="center" class="STYLE1">&nbsp;</p>
        <br/>
        <br/>
        
       <p align="center" class="STYLE1">管理员登陆</p>
    
<table width="230" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="grey" bgcolor="white">
<tr><s:actionerror/></tr>
<tr>
<td width="80" height="30" align="center" >用户名</td>
<td width="150" height="30" align="center"><input  type="text" name="username"  ></td>
</tr>



<tr>
<td height="30" align="center">密码</td>
<td height="30" align="center"><input type="text" name="password" ></td>
</tr>


<tr>

</tr>



</table>


<p align="center" class="STYLE1">
  <input type="reset"  value="重置" />
  <input type="submit" title="登陆"  value="登陆" />
  <input type="button" title="退出" onclick="window.location.href='index.jsp'" value="退出" />
</p></td>
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
</s:form>
</body>
</html>
