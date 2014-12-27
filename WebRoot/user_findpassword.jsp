<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 
    <script type="text/javascript" src="js/jquery-1.6.2.js"></script>
    <script type="text/javascript">
	
	$(function()
	{
		$("#button1").click(function()
		{
		   alert("即将连接服务器－－－－");
			$.ajax({
				
				type: "POST",
				url: "User_findPassword.action",
				dateType: "Json",
				data: {'username': $("#name").val()},
				success: function(returnedData){
				  
				   $("#button1").remove();
				   $("#www").append("<br>您的密码问题为:"+returnedData+"<br><br>请输入您的密码答案:<input type='text' id='answer'><input type='button' id='button2' value='点击获取密码'><br>");
				   
				  //////////////////////////////////////以下为另一个AJAX 
				   $("#button2").click(function()
					 {
					 alert("即将连接服务器－－－－")
					 $.ajax({
					 
					  type:"POST",
					  url:"User_findPassword.action",
					  dateType:"Json",
					  data:{'answer': $("#answer").val()},
					  success: function(returnedData){
					      $("#button2").remove();
					      $("#www").append("<br>结果为:"+returnedData+"<br><br><a href='user_load.jsp'>返回登陆页面</a>");
					  }
					  });
					 });
				    //////////////////////////////////////////
				   }
				});
			});
		
		
    });
	
	</script>
	
  <link href="CSS/style.css" rel="stylesheet" type="text/css" />
  </head>
  
<body id="mybody">  
      
<table border="0" align="center" cellpadding="0" cellspacing="0" class="table-corners">
  <tr>
    <td class="corner1">&nbsp;</td>
    <td class="bg-white">&nbsp;</td>
    <td class="corner2">&nbsp;</td>
  </tr>
  
  <tr>
    <td class="bg-white">&nbsp;</td>
    
  <td>
    
    
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="main-table">
      <tr>
        <td colspan="2" class="top-img">
            <p><br />
              <br />  <span class="website-title">驴友天地，畅享旅程</span><br />
              <br />
            Enjoy the trip,enjoy the world!<br />
             </p>
         </td>
      </tr>
      
      <tr>
        <td colspan="2" class="menu">
       <p align="center" class="STYLE1">&nbsp;</p>

     <div align="center" class="style1" >

	<h3>根据提示输入信息，以便找回您的密码</h3>
	
	  <div align="center" id="www">
		  <label for="username">请输入您的用户名：</label>
		  <input type="text" name="user.username" id="name" />
		  <input type="button" value="提交用户名" id="button1" class="sss" /><br>
     </div>
</div>		

</td>       
  </tr>
</table>
</table>     

  </body>
</html>
