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
    
    <title>主页</title>
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

  
<link rel="stylesheet" type="text/css" href="CSS/default1.css" />
 <script type="text/javascript" src="js/jquery-1.6.2.js"></script>

<!-- 通过AJAX添加好友 -->
<script type="text/javascript"   language="javascript">
 function addFriend(str)
  {
   alert("你确定要添加这个用户为好友吗？");
   alert ("这一步首先加载你的好友分类");
    $.ajax({
					 
					  type:"POST",
					  url:"User_showFriendCategroy.action",
					  dateType:"Json",
					  data:{'id': str },
					  success: function(returnedData){
					  
		               ////////////
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
						  
						    var   txt=document.createElement("div");//创建一个p对象（提示框提示信息）    
						    //定义p的属性，即相当于    
						    // <p   style="margin:1em   0;"   id="msgTxt"> 测试效果 </p>    
						    txt.style.margin="1em   0" 
						    //txt.setAttribute("align","center");
						    txt.setAttribute("id",'msgTxt');    
						     //txt.innerHTML="相册名称:<input type='text' name='album.album_name' id='name'><br>相册简介:<textarea name='album.album_introduction' id='introduction'></textarea><br><input type='button' value='确定' id='saveAlbum' >";
						    
						    var html="选择分类<select id='select'>";
						   for(var i=0;i<returnedData.length;i++)
					       {
					        var categroy = returnedData[i];
					        var id = categroy.id;
					        var name = categroy.friend_categroy_name;
					        html+= "<option value=" + id + ">" + name + "</option>";
						   }
						    html+="</select><br/><input type='button' value='确定' id='add'>";
						    txt.innerHTML=html;
						    
						    document.getElementById("msgDiv").appendChild(txt);//在提示框div中添加提示信息对象txt    
						    alert($("#select").val());
						    //document.getElementById("msgDiv").appendChild(button);//在提示框div中添加按钮对象button 
						    
						       
						    
						    //添加好友
						    
						    $("#add").click(function()
							{
							  alert("即将添加好友");
							   $.ajax({
											 
											  type:"POST",
											  url:"Friend_addFriend.action",
											  dateType:"Json",
											  data:{'visitorId': $("#visitorId").val(),'friendCategroy_id':$('#select').val() },
											  success: function(returnedData){
											      $("#select").remove();
											      $("#add").remove();
											      document.getElementById("msgDiv").appendChild(button);
											      txt.innerHTML=returnedData;
											      
											       
											     
											  }
											  });
											  
												  
							  });
						    
									    
											     
											     
											  }
											  });
							  
						  
	 
  
  }


</script>

</head>
<body>


<% User user=(User)session.getAttribute("user");
    String nick_name = user.getNick_name();
    
    User visitor = new User();
    
    Integer visitorId ;
    String avatar = null; 
    
    if(request.getAttribute("visitor")!=null)
    {
     visitor = (User)request.getAttribute("visitor");
     visitorId = visitor.getId();
     avatar = visitor.getAvatar(); 
    }
    else
    {
     visitorId = Integer.parseInt(request.getParameter("visitorId"));
     avatar = request.getParameter("avatar");
    }
    
    
     request.setAttribute("userId",visitorId);
     request.setAttribute("id",visitorId);       
        if(avatar==null)
        {
          avatar="avatar.jpg";
        }
          %>
<label>欢迎你：<%=nick_name%></label><label><a href="user_index.jsp?userId=<%=user.getId()%>">返回我的博客</a></label>
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
              	
				<li class="first"><a href="visitor_index.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">主页</a></li>
				<li><a href="visitor_search_article.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">日志</a></li>
				<li><a href="visitor_album.jsp?visitorId=<%=visitorId%>&avatar=<%=avatar%>">相册</a></li>
				<li><a href="#">好友</a></li>
				<li><a href="User_random.action">随便看看</a></li>
				<li><a href="#">关于我</a></li>
			</ul>

		
		</div>
	

		<div id="primarycontent">
		
			<!-- primary content start -->
		   <s:action name="User_showAllArticle"></s:action>
		   <s:iterator  value="#request.list"  id="us">
			<div class="post">
				<div class="header">
					<h3><s:property  value="#us.title"/><br><sup>1.0</sup> <%=visitor.getNick_name()%></h3>
					<div class="date"><s:date  name="#us.dateline" format="yyyy-MM-dd HH:mm:ss"/></div>
				</div>
				<div class="content" style="clear:both;overflow:hidden; position:relative">
					<s:property  value="#us.content" escapeHtml="false"/>
				</div>			
				
				<div class="footer">
					<ul>
						<li class="printerfriendly"><a href="#">Printer Friendly</a></li>
						<li class="comments"><a href="#">评论(18)</a></li>
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
				<p><a href="javascript:addFriend('<%=visitorId%>','<%=avatar%>')">加为好友</a></p>
				<input type="hidden" value="<%=visitorId%>" id="visitorId"/>
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


    
    
    
    
    
    
    
	
  
  
