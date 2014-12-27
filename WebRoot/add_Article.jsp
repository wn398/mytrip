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
			imageUploadJson : '../../jsp/upload_json.jsp',
			fileManagerJson : '../../jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function(id) {
				KE.event.ctrl(document, 13, function() {
					KE.util.setData(id);
					document.forms['example'].submit();
				});
				KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {
					KE.util.setData(id);
					document.forms['example'].submit();
				});
			}
		});
	</script>
  
   
	
   <!--增加文章分类的js AJAX -->	
<script   type="text/javascript"   language="javascript">    
    function   sAlert(str){    
    var   msgw,msgh,bordercolor;    
    msgw=400;//提示窗口的宽度    
    msgh=200;//提示窗口的高度    
    titleheight=25   //提示窗口标题高度    
    bordercolor="#336699";//提示窗口的边框颜色    
    titlecolor="#99CCFF";//提示窗口的标题颜色    
  
    var   sWidth,sHeight;    
    sWidth=document.body.offsetWidth;//浏览器工作区域内页面宽度    
    sHeight=screen.height;//屏幕高度（垂直分辨率）    
  
  
  
    //背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）    
    var   bgObj=document.createElement("div");//创建一个div对象（背景层）    
       
    //定义div属性，即相当于    
    // <div   id="bgDiv"   style="position:absolute;   top:0;   background-color:#777;   filter:progid:DXImagesTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75);   opacity:0.6;   left:0;   width:918px;   height:768px;   z-index:10000;"> </div>    
    bgObj.setAttribute("id","bgDiv");   
    //alert("***********")   
    bgObj.style.position="absolute";    
    bgObj.style.top="0";    
    bgObj.style.background="#777";    
    bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";    
    bgObj.style.opacity="0.6";    
    bgObj.style.left="0";    
    bgObj.style.width=sWidth   +  "px";    
    bgObj.style.height=sHeight   +  "px";    
    bgObj.style.zIndex   =  "10000";    
    document.body.appendChild(bgObj);//在body内添加该div对象    
  
  
  
    var   msgObj=document.createElement("div")//创建一个div对象（提示框层）    
    //定义div属性，即相当于    
    // <div   id="msgDiv"   align="center"   style="background-color:white;   border:1px   solid   #336699;   position:absolute;   left:50%;   top:50%;   font:12px/1.6em   Verdana,Geneva,Arial,Helvetica,sans-serif;   margin-left:-225px;   margin-top:npx;   width:400px;   height:100px;   text-align:center;   line-height:25px;   z-index:100001;"> </div>    
    msgObj.setAttribute("id","msgDiv");    
    msgObj.setAttribute("align","center");    
    msgObj.style.background="white";    
    msgObj.style.border="1px   solid  "   +   bordercolor;    
    msgObj.style.position   =  "absolute";    
    msgObj.style.left   =  "50%";    
    msgObj.style.top   =  "50%";    
    msgObj.style.font="12px/1.6em   Verdana,   Geneva,   Arial,   Helvetica,   sans-serif";    
    msgObj.style.marginLeft   =  "-225px"   ;    
    msgObj.style.marginTop   =   -75+document.documentElement.scrollTop+"px";    
    msgObj.style.width   =   msgw   +  "px";    
    msgObj.style.height   =msgh   +  "px";    
    msgObj.style.textAlign   =  "center";    
    msgObj.style.lineHeight   ="25px";    
    msgObj.style.zIndex   =  "10001";    
    //alert("***********")   
    var   title=document.createElement("h4");//创建一个h4对象（提示框标题栏）    
    //定义h4的属性，即相当于    
    // <h4   id="msgTitle"   align="right"   style="margin:0;   padding:3px;   background-color:#336699;   filter:progid:DXImageTransform.Microsoft.Alpha(startX=20,   startY=20,   finishX=100,   finishY=100,style=1,opacity=75,finishOpacity=100);   opacity:0.75;   border:1px   solid   #336699;   height:18px;   font:12px   Verdana,Geneva,Arial,Helvetica,sans-serif;   color:white;   cursor:pointer;"   onclick=""> 关闭 </h4>    
    title.setAttribute("id","msgTitle");    
    title.setAttribute("align","right");    
    title.style.margin="0";    
    title.style.padding="3px";    
    title.style.background=bordercolor;    
    title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20,   startY=20,   finishX=100,   finishY=100,style=1,opacity=75,finishOpacity=100);";    
    title.style.opacity="0.75";    
    title.style.border="1px   solid  "   +   bordercolor;    
    title.style.height="18px";    
    title.style.font="12px   Verdana,   Geneva,   Arial,   Helvetica,   sans-serif";    
    title.style.color="white";    
    title.style.cursor="pointer";    
    title.innerHTML="关闭";    
    title.onclick=removeObj;    
  
    var   button=document.createElement("input");//创建一个input对象（提示框按钮）    
    //定义input的属性，即相当于    
    // <input   type="button"   align="center"   style="width:100px;   align:center;   margin-left:250px;   margin-bottom:10px;"   value="关闭">    
    button.setAttribute("type","button"); 
    button.setAttribute("id","return")   
    button.setAttribute("value","关闭");    
    button.style.width="60px";    
    button.style.align="center";    
    button.style.marginLeft="250px";    
    button.style.marginBottom="10px";    
    button.style.background=bordercolor;    
    button.style.border="1px   solid  "+   bordercolor;    
    button.style.color="white";    
    button.onclick=removeObj1;    
       
    function   removeObj(){//点击标题栏触发的事件    
        document.body.removeChild(bgObj);//删除背景层Div    
        document.getElementById("msgDiv").removeChild(title);//删除提示框的标题栏    
        document.body.removeChild(msgObj);//删除提示框层    
    }
    
    function  removeObj1(){//点击关闭按钮触发的事件
    
           window.location.reload();
    }   
    document.body.appendChild(msgObj);//在body内添加提示框div对象msgObj    
    document.getElementById("msgDiv").appendChild(title);//在提示框div中添加标题栏对象title    
  
    var   txt=document.createElement("p");//创建一个p对象（提示框提示信息）    
    //定义p的属性，即相当于    
    // <p   style="margin:1em   0;"   id="msgTxt"> 测试效果 </p>    
    txt.style.margin="1em   0"    
    txt.setAttribute("id",'msgTxt');    
    //txt.innerHTML="<div>相册名称:<input type='text' name='album.album_name' id='name'></div><div>相册简介:<textarea name='album.album_introduction' id='introduction'></textarea></div><div><input type='button' value='确定' id='saveAlbum' ></div>";//来源于函数调用时的参数值    
    txt.innerHTML="分类名称:<input type='text' name='article_categroy.categroy_name' id='name'><br><input type='button' value='确定' id='saveCategroy' >";
    document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt    
    //document.getElementById("msgDiv").appendChild(button);//在提示框div中添加按钮对象button 
    
       
    
    //增加文章分类
    
    $("#saveCategroy").click(function()
	{
	  alert("即将保存分类");
	   $.ajax({
					 
					  type:"POST",
					  url:"Article_categroy_add_catergroy.action",
					  dateType:"Json",
					  data:{'article_categroy.categroy_name': $("#name").val()},
					  success: function(returnedData){
					      $("#name").remove();
					      $("#saveCategroy").remove();
					      document.getElementById("msgDiv").appendChild(button);
					      txt.innerHTML=returnedData;
					      
					       
					     
					  }
					  });
					  
						  
	  });
   
     
     
}    
</script>  
  
<script type="text/javascript" src="js/jquery-1.6.2.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
<title>发表博文</title>
</head>




<body>
<% String userId = request.getParameter("userId");
   request.setAttribute("userId",userId);
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
				<li class="first"><a href="user_index.jsp?userId=<%=userId%>">主页</a></li>
				<li><a href="user_manage_article.jsp?userId=<%=userId%>">管理日志</a></li>
				<li><a href="user_album.jsp?userId=<%=userId%>">相册</a></li>
				<li><a href="add_Article.jsp?userId=<%=userId%>">发表文章</a></li>
				<li><a href="user_updateAvatar.jsp?userId=<%=userId%>">更新头像</a></li>
                <li><a href="user_manage_friends.jsp?userId=<%=userId%>">好友</a></li>
				<li><a href="User_random.action">随便看看</a></li>
				<li><a href="#">关于我</a></li>
			</ul>
		</div>
			<!--此处为正文部分  -->
	     <div  align="left">
	        <s:action name="User_showArticleCategroy"></s:action> 
			<s:actionerror/>
			  <%=htmlData%>
			<p>请您输入您的博文内容</p>
			<p>&nbsp;</p>
			<s:form id="form1" name="form1" method="post" action="Article_addArticleAction">
			      
			  文章类别:<select name="categroy" id="categroy">
			      <%  
			       Set<Article_categroy> list = (Set)request.getAttribute("list");
			       Iterator iter = list.iterator();
			       while(iter.hasNext())
			       {
			       Article_categroy categroy = (Article_categroy)iter.next();
			       %>
			          <option value="<%=categroy.getId()%>"><%=categroy.getCategroy_name()%></option>
			       <%} %>
			        </select> 
			        <input   type="button"   value="增加分类"   onclick="sAlert('kw'); "  /> <br/>  
			   
			   文章标题：<input name="article.title" type="text" id="title" size="60" /><br/>
			   
			     内容:<textarea id="content1" name="article.content" style="width:700px;height:300px;visibility:hidden;">
			       </textarea>  <br/>
			            <input type="submit" name="button2" id="button2" value="提交" />
			    </s:form>
	
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