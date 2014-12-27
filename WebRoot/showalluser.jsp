<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showalluser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
   
   <script type="text/javascript">
   function del()
   {
     if(confirm("你真的想删除该记录么？"))
		{
			return true;
		}
		return false;
   }
   
   
   </script>
  </head>
  
  <body>
    <h1><font color="green" >所有用记信息</font></h1>
    <table border="1" align="center" width="80%">
    <tr>
      
      
      <td>用户名
      </td>
      
      <td>密码
      </td>
      
      <td>ID
      </td>
    
      <td>删除
      </td>
    
      <td>更新
      </td>    
    
    </tr>
    
    <s:iterator  value="#request.list"  id="us">
    <tr> 
       
       <td><s:property  value="#us.username"/>
       </td>
       
       <td><s:property  value="#us.password"/>
       </td>
       
       <td><s:property value="#us.id"/>
       </td>
       
       <td><s:a href="deleteuser.action?user.id=%{#us.id}" onclick="return del()">delete</s:a>
       </td>
       
       <td><s:a href="updatePUser.action?user.id=%{#us.id}">update</s:a>
       </td>
       
     </tr>  
  </s:iterator>
    
    
   </table> 
  </body>
</html>
