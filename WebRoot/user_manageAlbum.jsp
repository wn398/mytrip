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

	   <!--增加相片详情的js AJAX -->	
<script   type="text/javascript"   language="javascript">    
    function   addInfo(str){    
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
    button.onclick=removeObj;    
       
    function   removeObj(){//点击标题栏触发的事件    
        document.body.removeChild(bgObj);//删除背景层Div    
        document.getElementById("msgDiv").removeChild(title);//删除提示框的标题栏    
        document.body.removeChild(msgObj);//删除提示框层    
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
    txt.innerHTML="&nbsp;&nbsp;相片简介:<textarea name='photo.photo_introduction' id='introduction1'></textarea><br> <input type='button' align='center' value='确定' id='updatePhoto' >";
    document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt    
    //document.getElementById("msgDiv").appendChild(button);//在提示框div中添加按钮对象button 
    
       
    
    //保存相片介绍
    
    $("#updatePhoto").click(function()
	{
	  alert("即将保存相片介绍");
	   //alert($(this).parents().find("#photoId").val());
	  //alert(str);通过函数的参数传递photoId
	   alert($(this).parent().html());
	   $.ajax({
					 
					  type:"POST",
					  url:"Photo_updatePhoto.action",
					  dateType:"Json",
					  data:{'photo.id': str ,'photo.photo_introduction':$("#introduction1").val()},
					  success: function(returnedData){
					      $("#name").remove();
					      $("#introducton").remove();
					      $("#updatePhoto").remove();
					      document.getElementById("msgDiv").appendChild(button);
					      txt.innerHTML=returnedData;
					      
					       
					     
					  }
					  });
					  
						  
	  });
   
  
     
}    
</script> 

<!-- 删除相片的js -->
<script type="text/javascript"   language="javascript">
 function delPhoto(str)
  {
   alert("你确定要删除这张相片？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"Photo_deletePhoto.action",
					  dateType:"Json",
					  data:{'photo.id': str },
					  success: function(returnedData){
					      
					  alert(returnedData);  
					      
					  window.location.reload();     
					     
					  }
					  });
					  
						  
	 
  
  }


</script>

	
<!-- 设置相册封面的js -->
<script type="text/javascript"   language="javascript">
 function setPic(str,str1)
  {
   alert("确定要设置这张图片为本相册的封面？");
  
    $.ajax({
					 
					  type:"POST",
					  url:"Album_updateAlbum.action",
					  dateType:"Json",
					  data:{'album.id': str,'album.cover_picture':str1 },
					  
					  success: function(returnedData){
					      
					  alert(returnedData);  
					      
					       
					     
					  }
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
				<li><a href="#">关于我</a></li>
			</ul>
		</div>
		
		
		<!--此处为正文部分  -->
<div style="float:letf;">
	   <input type="button"  onclick="window.location.href='upload_photo.jsp?userId=<%=userId%>'" value=" 上传图片 " />
       <input   type="button"   value="增加相册"   onclick="sAlert('kw'); "  />  
       
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

	<a href="photo_show.jsp?photoId=<%=photo.getId()%>&photoAddress=<%=photo.getPersonal_photo()%>&photoIntro=<%=photo.getPhoto_introduction()%>"><img  src="upload/image/<%=photo.getPersonal_photo()%>"  width="150px" title="<%=photo.getPhoto_introduction()%>"></a><br/>
	<a  href="javascript:setPic('<%=request.getParameter("album.id")%>','<%=photo.getPersonal_photo()%>')">设为封面</a>
	
	<a href="javascript:addInfo('<%=photo.getId()%>')" >增加详情</a>
	<a href="javascript:delPhoto('<%=photo.getId()%>')">删除<img src="imageutil/delete.png" title="删除相片"/></a>
	
	


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
