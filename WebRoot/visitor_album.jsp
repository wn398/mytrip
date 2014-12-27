<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的相册</title>
    
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
  //将用户Id放入请求中 向action中传入参数
  request.setAttribute("userId",visitorId);
  User user = (User)session.getAttribute("user");
%>
<label>欢迎你</label><label><a href="user_index.jsp?userId=<%=user.getId()%>">返回我的博客</a></label>
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
	    <s:action name="User_showMyAlbum"></s:action> 	
	 <%  
       Set<Album> list = (Set)request.getAttribute("list");
       Iterator iter = list.iterator();
       while(iter.hasNext())
       {
       Album album = (Album)iter.next();
       if(album.getCover_picture()==null)
       {
        album.setCover_picture("images.jpg");
       }
    %>
	
	
	
	<div id="album" style="width:250px;float: left;">   
       相册名称：<%=album.getAlbum_name()%><br>
            <!--相册封面图片  默认使用头像照片-->
   <img id="imgSrc" width="150px" height="150px" src="upload/image/<%=album.getCover_picture()%>"/><br>
   <a href="visitor_search_album.jsp?album.id=<%=album.getId()%>&avatar=<%=avatar%>&visitorId=<%=visitorId%>">查看相册<img src="imageutil/search.png" title="查看相册"></a> 
   
       
       相册简介：<%=album.getAlbum_introduction()%><br>
     
             
       创建时间：<%=album.getAlbum_dateline()%>   
       <!--<s:date  name="#us.album_dateline" format="yyyy-MM-dd HH:mm:ss"/>-->
   </div>  
   <%} %>
	   
	   
	   
	   
	   </div>



<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>































  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
    
   
    
   
  
        
    
 