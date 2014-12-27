<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.trip.bean.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script type="text/javascript" src="js/jquery-1.6.2.js"></script>
 <!--  
 <script src="editor/ckeditor_3.6.1/ckeditor/ckeditor.js" type="text/javascript"></script>
 -->
 <!--  
 <script type="text/javascript" src="<%=request.getContextPath()%>/editor/ckeditor_3.6.1/ckeditor.js"></script>
 -->
 
<script charset="utf-8" src="<%=request.getContextPath()%>/editor/kindeditor-3.5.5-zh_CN/kindeditor.js"></script>
  <%request.setCharacterEncoding("UTF-8"); %>
  
  <script type="text/javascript">
	
		KE.show({
				id : 'content1',
				resizeMode : 0,
				afterCreate : function(id) {
					KE.toolbar.disable(id, []);
					KE.readonly(id);
					KE.g[id].newTextarea.disabled = true;
				}
			});
	</script> 
  
  
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
<title>浏览文章</title>

<!-- 提交评论js -->

<script type="text/javascript"   language="javascript">
 function submit(str,str1)
  {
   alert("即将提交评论");
   var str2 = $("#comment").val();
   alert(str2);
    $.ajax({
					 
					  type:"POST",
					  url:"Article_comment_addComment.action",
					  dateType:"Json",
					  data:{'articleId': str,'article_comment.comment_person_id':str1,'article_comment.comment_content':str2},
					  
					  success: function(returnedData){
					      
					  alert(returnedData);  
					      
		              window.location.reload();     
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script>		


</head>




<body>
    <% User user = (User)session.getAttribute("user");
        int userId = user.getId();
        String userName = user.getNick_name();
        String nick_name =user.getNick_name();
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
	        
			<s:actionerror/>
			  
			  
			  
			  
			
			<p>&nbsp;</p>
			
			  
			  <!-- 查询所要修改的文章 -->
			   <s:action name="Article_searchArticleById"></s:action>
			   <% Article article = (Article)request.getAttribute("article"); %>    
			   
			   <!-- 查询所有的分类 -->
			   <s:action name="User_showArticleCategroy"></s:action> 
			   文章类别:<select name="categroy" id="categroy">
			      <%  
			       Set<Article_categroy> list = (Set)request.getAttribute("list");
			       Iterator iter = list.iterator();
			       while(iter.hasNext())
			       {
			       Article_categroy categroy = (Article_categroy)iter.next();
			       if(article.getArticle_categroy().getId()==categroy.getId())
			       {
			        %>
			          <option value="<%=categroy.getId()%>" selected="selected"><%=categroy.getCategroy_name()%></option>
			        <%}else{ %>
			          <option value="<%=categroy.getId()%>" selected="selected"><%=categroy.getCategroy_name()%></option>
			         <%} %>
			         <%} %>
			        </select><br/> 
			          
			   
			   
			   
			   文章标题：<input name="article.title" type="text" id="title" size="60" value="<%=article.getTitle()%> " readonly="readonly"/><br/>
			        <input type="hidden"  name=article.id  value="<%=article.getId()%>"/>
			     内容:<textarea id="content1" name="article.content"  style="width:700px;height:300px;visibility:hidden;"><%=article.getContent()%></textarea>  <br/>
			  
			  <!-- 向请求评论的action中加入请求参数 --> 
			  <% String articleId = request.getParameter("articleId"); 
                      request.setAttribute("articleId",articleId);
                 %> 
			  <!-- 加载评论 -->
				     <s:action name="Article_showComment" var="articleId">
				      </s:action>
				     
				     <s:iterator value="#request.list" id="us">
				       评论人：<s:property value="#us.comment_person_id" />&nbsp;&nbsp;&nbsp;
				       评论时间:<s:date name="#us.comment_time" format="yyyy-MM-dd hh:mm:ss"/><br/>
				       评论内容:<s:property value="#us.comment_content" escapeHtml="true"/>
				     </s:iterator>
				   <br/>  
			   
			   
			   <!-- 添加评论 -->
			   
			     评论：<textarea rows="3" cols="30" name="article_comment.commment_content" id="comment"></textarea><br/>
			     <input type="hidden"  name="articleId"  value=<%=request.getParameter("articleId")%> />
			     <input type="button" value="提交" onclick = "submit('<%=request.getParameter("articleId")%>','<%=userId%>')"/>
			        
			  
	
	      </div>



         <div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>


</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>