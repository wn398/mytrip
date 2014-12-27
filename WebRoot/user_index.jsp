<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的主页</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
</head>
<body>


<% User user=(User)session.getAttribute("user");
        String avatar = user.getAvatar();
        //将用户Id放在请求中
        request.setAttribute("userId",user.getId());
        request.setAttribute("id",user.getId());
        int userId = user.getId();
        if(avatar==null)
        {
          avatar="avatar.jpg";
        }
          %>
<div id="outer">

	<div id="upbg"></div>

	<div id="inner">

		<div id="header">
			<h1><span>这是</span>我的博客</h1>
			<h2>世界因心而精彩</h2>
		</div>
	
		<div id="splash"></div>
	
		<div id="menu">
			<ul>
               		
				<li class="first"><a href="user_index.jsp?userId=<%=userId%>">主页</a></li>
				<li><a href="user_manage_article.jsp?userId=<%=userId%>">管理日志</a></li>
				<li><a href="user_album.jsp?userId=<%=userId%>">相册</a></li>
				<li><a href="add_Article.jsp?userId=<%=userId%>">发表文章</a></li>
				<li><a href="user_updateAvatar.jsp?userId=<%=userId%>">更新头像</a></li>
                <li><a href="user_manage_friends.jsp?userId=<%=userId%>">好友</a></li>
				<li><a href="User_random.action">随便看看</a></li>
				<li><a href="user_update.jsp?userId=<%=userId%>">关于我</a></li>
			</ul>

		
		</div>
	

		<div id="primarycontent">
		
			<!-- primary content start -->
		   <s:action name="User_showAllArticle"></s:action>
		   <s:iterator  value="#request.list"  id="us">
			<div class="post">
				<div class="header">
					<h3><s:a href="show_Article.jsp?articleId=%{#us.id}"><s:property  value="#us.title"/></s:a><br><sup>1.0</sup> <%=user.getNick_name()%></h3>
					<div class="date"><s:date  name="#us.dateline" format="yyyy-MM-dd HH:mm:ss"/></div>
				</div>
				<div class="content" style="clear:both;overflow:hidden; position:relative">
					<s:property  value="#us.content" escapeHtml="false"/>
				</div>			
				
				
				
				<div class="footer">
					<ul>
					   						
						<li class="comments"><s:a href="show_Article.jsp?articleId=%{#us.id}">评论<s:property value="#us.comment_count"/></s:a></li>
						<li class="readmore"><a href="#">更多</a></li>
					</ul>
				</div>
			</div>
		  </s:iterator>
			

			
			<!-- primary content end -->
	
		</div>
		
		<div id="secondarycontent">

			<!-- secondary content start -->
		
			<h3>关于我</h3>
			<div class="content">
				<img id="imgSrc"  src="upload/avatar/<%=avatar%>" class="picB" alt=""/>
				<p><strong>我的愿望：</strong>我愿你更幸福更快乐！！<a href="#">更多 ...</a></p>
			</div>
			
			<h3>好友</h3>
			
			<div class="content" align="center">
　　　　　　<s:action name="User_showAllFriend"/>
       
       　　　　　<%List FriendList = (List)request.getAttribute("list1"); 
            Iterator iter1 = FriendList.iterator();
             while(iter1.hasNext())
             {
               User user3 = (User)iter1.next();  
             %>
				<div class="content2">
				<a href="visitor_index.jsp?visitorId=<%=user3.getId()%>&avatar=<%=user3.getAvatar()%>"><img alt="" src="upload/avatar/<%=user3.getAvatar()%>" style="width:100px;height:100px;"></a>
				<a href="visitor_index.jsp?visitorId=<%=user3.getId()%>&avatar=<%=user3.getAvatar()%>"><%=user3.getPassword()%></a>
				</div>
			<%} %>	
				
				
								
						 
				</div>

			<!-- secondary content end -->

		</div>
	
		<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>

</body>
</html>


    
    
    
    
    
    
    
	
  
  
