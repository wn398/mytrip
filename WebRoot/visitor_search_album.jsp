<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>
<%@ page import="java.net.URLEncoder" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理相册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
		<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
   
	
 

	
 <link rel="stylesheet" type="text/css" href="CSS/default1.css" />
 </head>
  
<body>
<% String visitorId = request.getParameter("visitorId");
   String avatar = request.getParameter("avatar");
   request.setAttribute("userId",visitorId);
 %>
<div id="outer" >

	<div id="upbg"></div>

	<div id="inner">

		<div id="header">
			<h1><span>这是</span>我的博客</h1>
			<h2>世界因心而精彩</h2>
		</div>
	
		<div id="splash"></div>
	
		<div id="menu">
			<ul>
				<li class="first"><a href="visitor_index.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">主页</a></li>
				<li><a href="visitor_search_article.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">日志</a></li>
				<li><a href="visitor_album.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">相册</a></li>
				<li><a href="#">好友</a></li>
				<li><a href="User_random.action">随便看看</a></li>
				<li><a href="#">关于我</a></li>
			</ul>
		</div>
		
		
		<!--此处为正文部分  -->
<div style="float:letf;">
	         
	   <br/><br/>
	   
	   
	   <!-- 向服务器请求显示相册中的图片 -->
	 <s:action name="Album_showMyPhoto"></s:action>	
	 
	 <%Set list=(Set)request.getAttribute("list"); 
      request.setCharacterEncoding("utf-8");
      Iterator iter = list.iterator();
      while(iter.hasNext()){
      Photo photo = (Photo)iter.next();
      
      if(photo.getPersonal_photo()==null)
      {
      //默认图片
      photo.setPersonal_photo("album_pic.jpg");
      }
      //解决链接传递参数中文乱码问题
     // String photoIntro = photo.getPhoto_introduction();
     // String photoIntro1 = java.net.URLEncoder.encode(photoIntro,"UTF-8");   
      %>
    
	<div  style="width:180px; height:280px;float:left;">

	<a href="visitor_photo_show.jsp?photoId=<%=photo.getId()%>&photoAddress=<%=photo.getPersonal_photo()%>&photoIntro=<%=photo.getPhoto_introduction()%>&visitorId=<%=visitorId%>&avatar=<%=avatar%>"><img  src="upload/image/<%=photo.getPersonal_photo()%>"  width="150px" title="<%=photo.getPhoto_introduction()%>"></a><br/>
	
  </div> 	
  <%} %>
</div>



<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>
		















    
    
    
  </body>
</html>
