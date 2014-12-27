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
    
    <title>上传相片</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <link href="<%=basePath%>uploadify/uploadify.css" rel="stylesheet" type="text/css" />  
      <script type="text/javascript" src="<%=basePath%>uploadify/jquery-1.4.2.min.js"></script>   
      <script type="text/javascript" src="<%=basePath%>uploadify/swfobject.js"></script>  
      <script type="text/javascript" src="<%=basePath%>uploadify/jquery.uploadify.v2.1.4.js"></script>  
      
      
      
      <script type="text/javascript">   
          $(document).ready(function() {   
               $("#fileupload").uploadify({   
                      'uploader':'uploadify/uploadify.swf',  
                      'script'  : 'Photo_addPhotoAction.action',  
                      'cancelImg':'uploadify/cancel.png',  
                      'queueID'  : 'fileQueue', //和存放队列的DIV的id一致   
                      'fileDataName':'file', //和以下input的name属性一致   
                      'auto':false, //是否自动开始  
                      'multi':true, //是否支持多文件上传  
                      'buttonText':escape('添加上传图片'), //按钮上的文字   
                      'simUploadLimit':1, //一次同步上传的文件数目   
                      'sizeLimit' :409600000,  
                      'queueSizeLimit':999, //队列中同时存在的文件个数限制   
                      'method':'get',  
                      'removeCompleted':true,  
                      'fileDesc'       : '支持格式:jpg、gif、png', //如果配置了以下的'fileExt'属性，那么这个属性是必须的    
                      'fileExt'        : '*.jpg;*.gif;*.png',//允许的格式  
                      'scriptData'     :{'user':$('#id').val(),'username':$('#username').val(),'album':$('#album').val()}, // 使用参数方法应不get,多个参数用逗号隔开 'name':$('#name').val(),'num':$('#num').val(),'ttl':$('#ttl').val()  
                      onComplete: function (event, queueID, fileObj, response, data) { 
                                //截取参数中的字符第一个为图片地址，第二个为图片所在相册
                                var value = response ; 
                                var a = value.split("@");
                                var picname = a[0];
                                var albumid = a[1];
                                var   pic=document.createElement("img");//创建图片对象  
							    //定义div属性，即相当于    
							    
							    // <div   id="msgDiv"   align="center"   style="background-color:white;   border:1px   solid   #336699;   position:absolute;   left:50%;   top:50%;   font:12px/1.6em   Verdana,Geneva,Arial,Helvetica,sans-serif;   margin-left:-225px;   margin-top:npx;   width:400px;   height:100px;   text-align:center;   line-height:25px;   z-index:100001;"> </div>    
							    pic.setAttribute("src",picname); 
							    pic.style.width= "150px";
							    
							    //var  introduction=document.creatElement("textarea");
							    //introduction.setAttribut("name","photo.photo_introduction");
							     var di= $("<div></div>");
							     var picin=$("<p></p>")
							   	 //picin.style.width='200px';						     
							     
							     picin.html("相片介绍<br><textarea></textarea><br>设为相册封面<input type='radio'>")  
							     
							     
							     di.append(pic);
							     
							     di.append(picin);
							     
							     var dis = $("<div></div>");
							    // dis.style.width="25%";
							  /*
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
		                       */        
                               // $(".files").appendChild(pic);
                               //var text= document.creatElement("textarea");
                               //pic.append(text);
                               
                              //$('.files').innerHTML(pic+"相片简介：<br><textarea  style="'height':'130px'" name='photo.photo_introduction'></textarea>")
                              
                               
                               dis.appendTo('.files').html(di);
                               //$('<div></div>').appendTo('.files').html(di);
                              // $('<div></div>').appendTo('.files').html("相片简介：<br><textarea  style="'height':'130px'" name='photo.photo_introduction'></textarea>")
                              //$('<li></li>').appendTo('.files').html(pic);
                             // $('<li></li>').appendTo('.files').html("相片简介：<br><textarea  style="'height':'130px'" name='photo.photo_introduction'></textarea>")
                               //$(".files").innerHTML(response);           
                      },   
                      onError: function(event, queueID, fileObj) {   
                                 alert("文件:" + fileObj.name + "上传失败");   
                      },   
                      onCancel: function(event, queueID, fileObj){   
                                 alert("取消了" + fileObj.name);   
                      }   
               });  
          });  
  
  
  
         function uploadifyUpload(){   
         
                   $('#fileupload').uploadifySettings('scriptData',{'user':$('#id').val(),'username':$('#username').val(),'album':$('#album').val()});  
                   $('#fileupload').uploadifyUpload();   
          }   
  
      </script>  
      
 <link rel="stylesheet" type="text/css" href="CSS/default1.css" />  
  </head>
  
  <body>
    <% User user=(User)session.getAttribute("user");
       String userId= request.getParameter("userId");
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
	   <div  align="center">
	   
          <!-- 
   <s:action name="User_showMyAlbum"></s:action>
   
   <select name="photo.album" id="photo.album">
   
   <s:iterator  value="#request.list"  id="us">
   <option value="#us.id"><s:property  value="#us.album_name"/></option> 
   </s:iterator>
   
   </select>
     -->
   
  <!--  
    <s:action name="User_showMyAlbum"></s:action> 
   -->
   
   
   
   
   
   <div align="center">
      选择相册:<select name="album" id="album" >
      
      
    
    
        <% Set<Album> list = (Set)request.getAttribute("list");
          Iterator iter = list.iterator();
       while(iter.hasNext())
       { Album album = (Album)iter.next(); %>
       <option value="<%=album.getId()%>" > <%=album.getAlbum_name()%> </option>
        <%}%>       
      </select><br><br>
   
              
                   
                   <input type="hidden" value="<%=user.getId()%>" id="id">
                   <input type="hidden" value="<%=user.getUsername()%>" id="username">
                   <input type="file" name="file" id="fileupload" value="上传"/>
      
                   <div id="fileQueue" ></div>  
                    
                      <a href="javascript:;" onClick="javascript:uploadifyUpload()">开始上传</a>&nbsp;   
                      <a href="javascript:jQuery('#fileupload').uploadifyClearQueue()">取消所有上传</a><br/>   
                    
                   <!--  
                   <ol class=files ></ol>
                    --> 
                    <br/>
                   <a href="user_album.jsp?userId=<%=userId%>">返回浏览相册</a>
              
             </div>
            <div class=files align="left" style="'float':'left'"></div>
  
      
    
    
    
   
    
      
       
	   
	   
	   
	   
	   </div>



<div id="footer">
		
			&copy; My Website. All rights reserved. Design by <a href="#">无趾鸟</a>.
		
		</div>

	</div>

</div>
    
    
    
    
  
  
        
    
    
    
    
    
    
    
    
  </body>
</html>
