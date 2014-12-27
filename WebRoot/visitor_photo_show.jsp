<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.trip.bean.*" %>
<%@ page import="java.net.URLDecoder"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
             
    <title>展示相片</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>	
	
<!-- 提交评论js -->

<script type="text/javascript"   language="javascript">
 function submit(str,str1)
  {
   alert("即将提交评论");
   var str2 = $("#comment").val();
   alert(str2);
    $.ajax({
					 
					  type:"POST",
					  url:"Photo_comment_addComment.action",
					  dateType:"Json",
					  data:{'photoId': str,'photo_comment.commenter_id':str1,'photo_comment.comment_content':str2},
					  
					  success: function(returnedData){
					      
					  alert(returnedData);  
					      
		              window.location.reload();     
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script>		
	
	
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
  </head>
  
  <body>
  <% User user = (User)session.getAttribute("user");
     int userId = user.getId();
     String userName = user.getNick_name();
     String nick_name = userName;
     String avatar = request.getParameter("avatar");
     String visitorId = request.getParameter("visitorId");
     request.setAttribute("userId",visitorId);
     request.setCharacterEncoding("utf-8");
   %>
 <label>欢迎你：<%=nick_name%></label><label><a href="user_index.jsp?userId=<%=user.getId()%>">返回我的博客</a></label>  
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
	   <div  align="center">
	   
    <img id="imgSrc"  src="upload/image/<%=request.getParameter("photoAddress")%>"/><br>
    <input type="hidden" value="<%=request.getParameter("photoId")%>">
    <%String photoIntro1=new String(request.getParameter("photoIntro").getBytes("ISO8859_1"),"UTF-8");  %>
              相片介绍：<label><%=photoIntro1%></label> <br/>
    
    <!-- 向下面加载评论的action中传入页面参数  这个问题困扰了很久，之前一直想通过s:param去解决 -->
    <% String photoId = request.getParameter("photoId"); 
       request.setAttribute("photoId",photoId);
    %>
    
    
    
    
    <!-- 加载评论 -->
     <s:action name="Photo_showComment" var="photoId">
      </s:action>
     
     <s:iterator value="#request.list" id="us">
       评论人：<s:property value="#us.commenter_id" />&nbsp;&nbsp;&nbsp;
       评论时间:<s:date name="#us.comment_time" format="yyyy-MM-dd hh:mm:ss"/><br/>
       评论内容:<s:property value="#us.comment_content" escapeHtml="true"/>
     </s:iterator>
   <br/> 
    
      
           评论：<textarea rows="3" cols="30" name=photo_comment.comment_content id="comment"></textarea><br/>
           <input type="hidden" value="<%=request.getParameter("photoId")%>" name="photoId" id="photoId"/>
           <input type="hidden" value="<%=userId%>" name="photo_comment.commenter_id"/>
         <input type="button" value='提交' onclick = "submit('<%=request.getParameter("photoId")%>','<%=userId%>')"/>
	   
	   
	   
	   
	   </div>



<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>

		  
   
   
   
   
   
   
   
   
   
  </body>
</html>
