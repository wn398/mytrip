<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<meta name="description" content="interneto svetainių kūrimas" />
<meta name="keywords" content="dizainas" />
<meta name="author" content="Romano studija | http://www.roman.lt/ | Copyright (C) 2007. All rights reserved." />
<meta name="robots" content="index, follow" />
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
  
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 
   <script type="text/javascript">		 
		function refresh()
        {
            var img = document.getElementById("img_validation_code")
            img.src = "ValidationCode?" + Math.random();            
        }
       
		function checkLogin()
		{
		    var username = document.getElementsByName("user.username")[0];

    		// 用户名必须输入
    		if(username.value == "")
    		{
        		alert("必须输入用户名!");
        		username.focus();
        		return false;
    		}
    		
			var password = document.getElementsByName("user.password")[0];
   			 // 密码必须输入
   			if(password.value == "")
    		{
        		alert("必须输入密码!");
        		password.focus();
        		return false;
    		}
    		
    		var repassword = document.getElementsByName("user.repassword")[0];
    		if(repassword.value == "")
    		{
    		    alert("必须输入重复密码!");
        		repassword.focus();
        		return false;
    		
    		}
    	
    	    if(password.value != repassword.value)
    	    
    	    {
    	     alert("密码不一致，请重新输入");
			 repassword.focus();
			 return false;
    	    }
    	    
    	    var question=document.getElementsByName("user.question")[0];
    	    if(""==question.value)
    	    {
    	     alert("密码问题不能为空");
    	     question.focus();
			 return false;
    	    }
    	    
    	    var answer = document.getElementsByName("user.answer")[0];
    	    if("" == answer.value)
    	    {
    	      alert("密码答案不能为空！");
    	      answer.focus();
			  return false;
    	    }   
    	 
    		var validation_code = document.getElementById("validation_code");
    		
    		if(validation_code.value == "")
    		{
    		    alert("验证码必须输入!");
        		validation_code.focus();
        		return false;
    		}
    		
    		// 必须输入验证码
   			return true;
		}  
        
		 
	</script>


  </head>
  
  <body>
  
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
        <p align="center" class="STYLE1">个人资料注册</p>
        
        
        
         <p class="style1">&nbsp;</p>
          <s:actionerror/>
          <s:fielderror></s:fielderror>
  <s:form action="User_registerAction" method="post">
        
<table width="543" border="3" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000" bgcolor="white">

    
  



<tr>
<td width="119" height="30" align="center">用户名</td>
<td width="414" height="30" align="center"><input type="text" name="user.username"/></td>
</tr>

<tr>
<td height="30" align="center">密码</td>
<td height="30" align="center"><input type="password" name="user.password" /></td>
</tr>
<tr>
<td width="119" height="30" align="center">确认密码</td>
<td width="414" height="30" align="center"><input type="password" name="user.repassword"/></td>
</tr>
<tr>
<td height="30" align="center">密保问题</td>
<td height="30" align="center"><a target="_blank" title="设置密保请慎重，并牢记问题"><input type="text" name="user.question" /></a></td>
</tr>
<tr>
<td height="30" align="center">密保答案</td>
<td height="30" align="center"><a target="_blank" title="请牢记密保答案，以便找回遗忘的密码"><input type="text" name="user.answer"/></a></td>
</tr>


<tr>
<td height="30" align="center">验证码</td>
<td height="30" align="center"><a target="_blank" title="请牢记密保答案，以便找回遗忘的密码"><input type="text" id="validation_code" name="validation_code"/>
         <img id="img_validation_code" src="ValidationCode"/>
         <input type="button" value="刷新" onclick="refresh()" /></a></td>
</tr>
 
  
  
</table>
<p align="center" class="STYLE1">
  <input type="submit" value="提交"  onclick="return checkLogin()"/>
  <input type="reset" value="重置"/>
  <input type="button"  value="退出" />
</p>
     </s:form>


</td>


  
      </tr>
      
   
    
      
      
    </table>

    
    </td>
    <td class="bg-white">&nbsp;</td>
  </tr>
  <tr>
    <td class="corner3">&nbsp;</td>
    <td class="bg-white">&nbsp;</td>
    <td class="corner4">&nbsp;</td>
  </tr>
</table>

    
   
    
    
  </body>
</html>
