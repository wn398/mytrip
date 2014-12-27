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
    
    <title>日志分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<!-- 根据文章的分类显示相应文章 js -->
<script type="text/javascript"   language="javascript">
 function toArticle(str)
  {
   alert("显示这个分类的文章？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"Article_categroy_showCategroyArticle.action",
					  dateType:"Json",
					  data:{'categroyId': str },
					  success: function(returnedData){
					  alert(returnedData.length);
					  var html="<div id='rightcontent'><table border='1px' align='center'><tr><th>文章名称</th><th>发表时间</th><th>评论数</th><th>删除</th><th>修改</th></tr>";
					  for(var i=0;i<returnedData.length;i++)
					  {
					    var article = returnedData[i];
					    var id = article.id;
					    var title = article.title;
					    var dateline = article.dateline;
					    var read_count = article.read_count;
					    var comment_count = article.comment_count;
					    //由于日期格式的转换相当麻烦所以将日期转为字符串放在了content这个字段中
					    var content = article.content;
					    
					    html+="<tr><td><a href='show_Article.jsp?articleId="+id+"'>"+title+"</a></td><td>"+content+"</td><td>"+comment_count+"</td><td><a href='javascript:del("+id+")'>删除</a></td><td><a href='update_Article.jsp?articleId="+id+"'>修改</a></td></tr>";
					  
					  }
					  html+="</table></div>";
					  //alert(returnedData.length);
					  $("#rightcontent").remove();
					  $("#right").append(html);
					      
					       
					     
					  }
					  });
					  
						  
	 
  
  }


</script>


<!-- 显示所有的文章 js -->
<script type="text/javascript"   language="javascript">
 function allArticle(str1)
  {
   alert("显示所有的文章？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"User_ajaxShowAllArticle.action",
					  dateType:"Json",
					  data:{'userId': str1 },
					  success: function(returnedData){
					      
					  alert(returnedData.length);
					  var html="<div id='rightcontent'><table border='1px' align='center'><tr><th>文章名称</th><th>发表时间</th><th>评论数</th><th>删除</th><th>修改</th></tr>";
					  for(var i=0;i<returnedData.length;i++)
					  {
					    var article = returnedData[i];
					    var id = article.id;
					    var title = article.title;
					    var dateline = article.dateline;
					    var read_count = article.read_count;
					    var comment_count = article.comment_count;
					    //由于日期格式的转换相当麻烦所以将日期转为字符串放在了content这个字段中
					    var content = article.content;
					    
					     html+="<tr><td><a href='show_Article.jsp?articleId="+id+"'>"+title+"</a></td><td>"+content+"</td><td>"+comment_count+"</td><td><a href='javascript:del("+id+")'>删除</a></td><td><a href='update_Article.jsp?articleId="+id+"'>修改</a></td></tr>";
					  
					  }
					  html+="</table></div>"
					  //alert(returnedData.length);
					  $("#rightcontent").remove();
					  $("#right").append(html); 
					     
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
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />


  </head>
  
  <body>
   <%String visitorId = request.getParameter("visitorId");
     User user = (User)session.getAttribute("user");
     String avatar = request.getParameter("avatar");
     request.setAttribute("userId",visitorId);
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
	   
	          <div id="mainer" style="float:left;">
        <div id="left" style="width:240px;float:left;">
      
      <!-- 请求本用户的文章分类 -->
      <s:action name="User_showArticleCategroy"/>
      <%Set categroyList = (Set)request.getAttribute("list");
        Iterator iter = categroyList.iterator(); 
        while(iter.hasNext())
        { Article_categroy categroy = (Article_categroy)iter.next(); 
      %>
      
          分类名称:<a href="javascript:toArticle('<%=categroy.getId()%>')"><%=categroy.getCategroy_name()%></a><br/>
     <%} %>      
          分类名称：<a href="javascript:allArticle('<%=visitorId%>')">所有文章</a>   
    </div>
    
    
    <div id="right" style="width:650px;float:left">
        <div id="rightcontent">
       <!-- 默认显示的本用户所有的文章 -->
       <s:action name="User_showAllArticle"/>
       
       <table border="1px" align="center"><tr><th>文章名称</th><th>发表时间</th><th>评论数</th><th>删除</th><th>修改</th></tr>
       <%Set articleList = (Set)request.getAttribute("list"); 
         Iterator iter1 = articleList.iterator();
         
         while(iter1.hasNext())
         {
         Article article = (Article)iter1.next();
        %>
         <tr>
           <td><a href="visitor_show_Article.jsp?articleId=<%=article.getId()%>&visitorId=<%=visitorId%>&avatar=<%=avatar%>"><%=article.getTitle()%></a></td>
                           <td><%=article.getDateline()%></td>
                           <td><%=article.getComment_count()%></td>
         
          
        
        </tr>
        <%} %>
       </table>
       
       </div>
    
    </div>
   
 </div> 
    
	  



<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
   
   
  </body>
</html>
