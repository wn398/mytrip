<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="com.trip.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>更新头像</title>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
 
 <script type="text/javascript">
 function checkFileType(inputFile){ //file onchange时，验证文件的格式是否为正确格式
    var patrn=new RegExp("([.]jpg)|([.]JPG)|([.]gif)|([.]GIF)$");//限制文件类型
    if (!patrn.test(inputFile.value)){
     inputFile.outerHTML=inputFile.outerHTML;//清空input file
     alert("请选择JGP或GIF图片！");
    }
   }
 function imgSrc(){
  var imgSrcValue = getFullPath(document.getElementById("picFile").value);
  alert(imgSrcValue);
  document.getElementById("imgDiv").style.display = "";
  document.getElementById("imgSrc").src=imgSrcValue;
 }
 function uploadPic(){
  var imgSrcValue = document.getElementById("picFile").value;
  if(imgSrcValue == ""){
   alert("请选择文件");
  }else{
   return true;
  }
 }
</script>

  <link href="CSS/style.css" rel="stylesheet" type="text/css" />

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

	<h3>点击浏览选择一张酷的图片作为你的头像吧</h3>
	
	  <div align="center" id="www">
	       <s:form action="User_updateAavatarAction" enctype="multipart/form-data" id="form1" name="form1">
	        <label for="username">请选择图片:</label>
	        <input type="file" name="file" id="picFile" onchange="imgSrc(),checkFileType(this)"> <br />
            <input type="submit" value="提交" onclick="return uploadPic()">
	      </s:form>
     <%User user=(User)session.getAttribute("user"); 
       String filename = user.getAvatar();
      %>
      <div id="imgDiv" style="display: true">
        <font color="blue">当前头像</font>
    <table border="1" bordercolor="red" >
    <tr><td>
     <img id="imgSrc" width="100px" src="upload/avatar/<%=filename%>"/>
      </td></tr>
</table>
	
     </div>
     
     </div>
</div>		

</td>       
  </tr>
</table>
</table>     



















 
</div>
</body>
</html>

