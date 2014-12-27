<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="CSS/style.css" rel="stylesheet" type="text/css" />
    <title>更新个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 日期控件 -->
   <link rel="stylesheet" href="UI/themes/base/jquery.ui.all.css">
	<script src="UI/jquery-1.6.2.js"></script>
	<script src="UI/ui/jquery.ui.core.js"></script>
	<script src="UI/ui/jquery.ui.widget.js"></script>
	<script src="UI/ui/jquery.ui.datepicker.js"></script>
	<link rel="stylesheet" href="UI/demos/demos.css">
	<script type="text/javascript">
	$(function() {
		$( "#datepicker" ).datepicker({
			changeMonth: true,
			changeYear: true
		});
	});
	</script>
<!-- 处理表单中开如的空数据 使null当获得焦点是变空 -->
	<script type="text/javascript">
	$(function()
	{
	  $("input.nick_name").focus(function(){
	    var value = $(this).val();
	    if(value == 'null') 
	    {
	    $(this).val('');
	    }
	  });
	$("input.nick_name").blur(function(){
	   var value= $(this).val();
	  if(value == '')
	  {
	    $(this).val('null');
	  }
	
	});
	});
	
	
	$(function()
	{
	  $("#introduction").focus(function(){
	    var value = $(this).val();
	   
	    if("null"== value.toString()) 
	    {
	    $(this).val('');
	    }
	  });
	$("#introduction").blur(function(){
	   var value= $(this).val();
	  if(value == '')
	  {
	    $(this).val('null');
	  }
	
	});
	});
	</script>
	
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
    <% User user=new User();
       user=(User)session.getAttribute("user");   
     %>
    <s:actionerror/>
 
 <s:form action="User_updateAction" method="post" >  
 <table width="924" border="0" align="center" cellpadding="0" cellspacing="0" class="table-corners">
  <tr>
    <td width="20" class="corner1">&nbsp;</td>
    <td width="860" class="bg-white">&nbsp;</td>
    <td width="44" class="corner2">&nbsp;</td>
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
        <p align="center" class="STYLE1">完善个人信息</p>
     
<table width="543" border="2" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000" bgcolor="white">
<tr>
<td width="119" height="30" align="center">用户名</td>
<td width="414" height="30" align="center"><input type="text"  value="<%=user.getUsername()%>" name="user.username"/></td>
</tr>
<tr>
<td width="119" height="30" align="center">性别</td>
<td width="414" height="30" align="center"><input type="Radio" name="user.sex" value ="false"  <%if(user.isSex()==false){ %> checked="checked" <%} %>  >女性 
                                           <input type="Radio" name="user.sex"  value ="true"  <%if(user.isSex()==true){ %>checked="checked" <%} %> >男性</td>
</tr>

<tr>
<td width="119" height="30" align="center">昵称</td>
<td width="414" height="30" align="center"><input type="text" class="nick_name"  value="<%=user.getNick_name()%>" name="user.nick_name"/><br>
</td>
</tr>


<tr>
<td height="30" align="center">出生日期</td>
<td height="30" align="center"><input type="text" name=user.birthday id="datepicker" <%if (user.getBirthday()!= null){ %> value="<%=new SimpleDateFormat("MM/dd/yyyy").format(user.getBirthday())%>"<%} %>>
<div class="demo">
</div><!-- End demo -->  </td>
</tr>

<tr>
<td width="119" height="30" align="center">住址</td>
<td width="414" height="30" align="center"><input type="text" class="nick_name" value="<%=user.getAddress()%>" name="user.address"/></td>
</tr>
<tr>

<td height="30" align="center">自我介绍</td>
<td height="30" align="center"><textarea id="introduction" name="user.self_introduction"><%=user.getSelf_introduction() %>
          </textarea></td>
</tr>


<tr>
<td height="30" align="center">电子邮箱</td>
<td height="30" align="center"><input type="text" class="nick_name" value="<%=user.getEmail()%>" name="user.email"/></td>
</tr>

</table>



<p align="center" class="STYLE1">
  <input type="submit" value="提交"/>
  
  
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
</s:form>   
 
  </body>
</html>
