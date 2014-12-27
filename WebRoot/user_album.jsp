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
   
	
   <!--增加相册的js AJAX -->	
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
    //txt.setAttribute("align","center");
    txt.setAttribute("id",'msgTxt');    
    //txt.innerHTML="<div>相册名称:<input type='text' name='album.album_name' id='name'></div><div>相册简介:<textarea name='album.album_introduction' id='introduction'></textarea></div><div><input type='button' value='确定' id='saveAlbum' ></div>";//来源于函数调用时的参数值    
    txt.innerHTML="相册名称:<input type='text' name='album.album_name' id='name'><br>相册简介:<textarea name='album.album_introduction' id='introduction'></textarea><br><input type='button' value='确定' id='saveAlbum' >";
    document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt    
    //document.getElementById("msgDiv").appendChild(button);//在提示框div中添加按钮对象button 
    
       
    
    //保存相册
    
    $("#saveAlbum").click(function()
	{
	  alert("即将保存相册");
	   $.ajax({
					 
					  type:"POST",
					  url:"Album_addAlbum.action",
					  dateType:"Json",
					  data:{'album.album_name': $("#name").val(),'album.album_introduction':$('#introduction').val() },
					  success: function(returnedData){
					      $("#name").remove();
					      $("#introducton").remove();
					      $("#saveAlbum").remove();
					      document.getElementById("msgDiv").appendChild(button);
					      txt.innerHTML=returnedData;
					      
					       
					     
					  }
					  });
					  
						  
	  });
   
     
     
}    
</script>  


<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
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
				<li><a href="user_update.jsp?userId=<%=userId%>">关于我</a></li>
			</ul>
		</div>
		
		<!--此处为正文部分  -->
	   <div style="float:letf;">
	   <input type="button"  onclick="window.location.href='upload_photo.jsp?userId=<%=userId%>'" value=" 上传图片 " />
       <input   type="button"   value="增加相册"   onclick="sAlert('kw'); "  />  
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
   <a href="user_manageAlbum.jsp?album.id=<%=album.getId()%>&userId=<%=userId%>">管理相册<img src="imageutil/search.png" title="查看相册"></a> 
   <a href="Album_delAlbum.action?album.id=<%=album.getId()%>&userId=<%=userId%>">删除相册<img src="imageutil/delete.png" title="删除相册"></a><br/> 
       
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































  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
    
    
   
    
   
  
        
    
 