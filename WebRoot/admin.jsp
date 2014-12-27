<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="style.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<!-- 所有的用户 -->   
<script type="text/javascript"   language="javascript">
   function  allUser()
  {
   alert("显示所有用户信息？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"User_ajaxAllUser.action",
					  dateType:"Json",
					  data:{},
					  success: function(returnedData){
					  alert(returnedData.length);
					  var html="<div id='post'><table border="1px" align="center"><tr><th>用户名</th><th>发表文章数</th><th>相片数</th><th>好友数</th><th>注册时间</th><th>删除</th></tr>";
					  for(var i=0;i<returnedData.length;i++)
					  {
					    var user = returnedData[i];
					    var id = user.id;
					    var username = user.username;
					    //文章数
					    var password = user.password;
					    //相片数
					    var question = user.question;
					    //好友数
					    var answer = user.answer;
					    //注册时间
					    var time = user.register_time;
					    //由于日期格式的转换相当麻烦所以将日期转为字符串放在了content这个字段中
					    var content = article.content;
					    
					    html+="<tr id='"+str+"'><td>"+username+"</td><td>"+password+"</td><td>"+question+"</td><td>"+answer+"</td><td>"+time+"</td><td><a href='javascript:deluser("+id+")'>删除</a></td></tr>";
					  
					  }
					  html+="</table></div>";
					  //alert(returnedData.length);
					  $("#post").remove();
					  $("#infotable").append(html);
					      
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script>  


<!-- 所有的文章 -->
<script type="text/javascript"   language="javascript">
 function allarticle()
  {
   alert("显示所有的文章？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"Article_showAllArticleAction.action",
					  dateType:"Json",
					  data:{ },
					  success: function(returnedData){
					  alert(returnedData.length);
					  var html="<div id='post'><table border='1px' align='center'><tr><th>文章题目</th><th>发表时间</th><th>评论数</th><th>所属用户</th><th>删除</th></tr>";
					  for(var i=0;i<returnedData.length;i++)
					  {
					    var article = returnedData[i];
					    var id = article.id;
				
					    var title = article.title;
					    var time = article.time;
					    var comment_count = article.comment_count;
					    //所属用户
					    var user = article.content;
					    //所属用户id
					    var user_id = article.read_count;
					
					    html+="<tr id='"+id+"'><td>"+title+"</td><td>"+time+"</td><td>"+comment_count+"</td><td>"+user+"</td><td><a href='javascript:delarticle("+id+")'>删除</a></td></tr>";
					  
					  }
					  html+="</table></div>";
					  //alert(returnedData.length);
					  $("#post").remove();
					  $("#infotable").append(html);
					      
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script>  




<!-- 所有的相片 -->
<script type="text/javascript"   language="javascript">
 function allphoto()
  {
   alert("显示所有的相片？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"Photo_allPhoto.action",
					  dateType:"Json",
					  data:{},
					  success: function(returnedData){
					  alert(returnedData.length);
					  var html="<div id='post'>";
					  for(var i=0;i<returnedData.length;i++)
					  {
					    var photo = returnedData[i];
					    var id = photo.id;
					    //相片地址
					    var personal_photo = photo.personal_photo;
					    //相片主人
					    var photo_user = photo.photo_user;
					    //相片主人id
					    var user_id = photo.user_id;
					    //相片的评论数
					    var photo_introduction = photo.photo_introduction;
					    
					   
					    
					    html+="<div id='"+id+"' style='float:left;width:150px;height:210px;'><img src='upload/image/"+personal_photo+"' width=115px;><p><a href='#'>"+photo_user+"</a>评论("+photo_introduction+")<a href='javascript:delphoto("+id+")'>删除</a></p></div>";
					  
					  }
					  html+="</div>";
					  //alert(returnedData.length);
					  $("#post").remove();
					  $("#infotable").append(html);
					      
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script> 



<!--删除用户  -->
<script type="text/javascript"   language="javascript">
 function deluser(str)
  {
   alert("确定要删除这个用户？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"User_delUser.action",
					  dateType:"Json",
					  data:{'userId': str },
					  success: function(returnedData){
					  
					  alert(returnedData);
					      
					  window.location.reload();    
					     
					  }
					  });
					  
						  
	 
  
  }



</script> 
<!-- 删除相片 -->
<script type="text/javascript"   language="javascript">
 function delphoto(str)
  {
   alert("确定要删除这个相片？");
  　 
    
    $.ajax({
					 
					  type:"POST",
					  url:"Photo_deletePhoto.action",
					  dateType:"Json",
					  data:{'photo.id': str },
					  success: function(returnedData){
					  
					  alert(returnedData.length);
					  var id = str;    
					  $("#"+str).remove();    
					     
					  }
					  });
					  
						  
	 
  
  }



</script> 

<!-- 删除文章 -->
<script type="text/javascript"   language="javascript">
 function delarticle(str)
  {
   alert("确定要删除这篇文章？");
  　 
    alert($("#"+str).html());
    $.ajax({
					 
					  type:"POST",
					  url:"Article_deletArticle.action",
					  dateType:"Json",
					  data:{'articleId': str },
					  success: function(returnedData){
					  
					  alert(returnedData);
					  var id = str;    
					  $("#"+str).remove();    
					     
					  }
					  });
					  
						  
	 
  
  }



</script> 
<style type="text/css">
*{font-family:Tahoma, Arial, Helvetica, Sans-serif;}
table{
width:700px;
margin:0px auto;
font:Georgia 11px;
font-size:12px;
color:#333333;
text-align:center;
border-collapse:collapse;/*细线表格*/
}
table td{
border:1px solid #999;/*细线条颜色*/
height:22px;
}
caption{text-align:center;font-size:12px;font-weight:bold;margin:0 auto;}
tr.t1 td {background-color:#fff;}/* 交替行第一行的背景色 */
tr.t2 td {background-color:#eee;}/* 交替行第二行的背景色 */
tr.t3 td {background-color:#ccc;}/* 鼠标经过时的背景色 */
th,tfoot tr td{font-weight:bold;text-align:center;background:#c5c5c5;}
th{line-height:30px;height:30px;}
tfoot tr td{background:#fff;line-height:26px;height:26px;}
thead{border:1px solid #999;}
thead tr td{text-align:center;}
#page{text-align:center;float:right;}
#page a,#page a:visited{width:60px;height:22px;line-height:22px;border:1px black solid;display:block;float:left;margin:0 3px;background:#c9c9c9;
text-decoration:none;}
#page a:hover{background:#c1c1c1;text-decoration:none;}
.grayr {padding:2px;font-size:11px;background:#fff;float:right;}
.grayr a {padding:2px 5px;margin:2px;color:#000;text-decoration:none;;border:1px #c0c0c0 solid;}
.grayr a:hover {color:#000;border:1px orange solid;}
.grayr a:active {color:#000;background: #99ffff}
.grayr span.current {padding:2px 5px;font-weight:bold; margin:2px; color: #303030;background:#fff;border:1px orange solid;}
.grayr span.disabled {padding:2px 5px;margin:2px;color:#797979;background: #c1c1c1;border:1px #c1c1c1 solid;}
</style>

</head>
  
  <body bgcolor="#FFFFFF"> 
<!--left是左面内容选项的大DIV-->


<!--infolead是左面内容项的DIV,内容选项有多个,则其可以有多个-->
<div id="top" align="center"><img  src="images/houtaitop.jpg" width="1100" height="179"></div>
<div style="float:left;">
<div id="left" style="float:left;width: 300px;">
   
   <p><a href="javascript:allUser()">所有用户信息</a></p> 
   <P><a href="javascript:allarticle()">所有文章信息</a></P>
   <p><a href="javascript:allphoto()">所有相片信息</a></p> 
   
   
 </div>
  
    
    
<div id="infotable" style="float:left;width:650px;">
    
    <div id="post">
     
     <!-- 页面正常请求显示所有的用户 -->
        <s:action name="User_allUser"></s:action>
        <table border="1px" align="center"><tr><th>用户名</th><th>发表文章数</th><th>相片数</th><th>好友数</th><th>注册时间</th><th>删除</th></tr>
        <s:iterator  value="#request.list" id="us">
        <tr id="%{#us.id}"><td><s:a href="visitor_index.jsp?visitorId=%{#us.id}&avatar=%{#us.avatar}"><s:property value="#us.username"/></s:a></td><td><s:property value="#us.password"/></td>
        <td><s:property value="#us.question"/></td><td><s:property value="#us.answer"/></td>
        <td><s:date name="#us.register_time" format="yyyy-MM-dd hh:mm:ss"/></td><td><s:a href="javascript:deluser(%{#us.id})">删除</s:a></td></tr>
        
        </s:iterator>
        </table>   
    </div>
    
 </div>
    
</div>



</body>
</html>
