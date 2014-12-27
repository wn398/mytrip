<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="uploadify/uploadify.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="uploadify/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="uploadify/swfobject.js"></script>
	<script type="text/javascript" src="uploadify/jquery.uploadify.v2.1.4.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  $('#file_upload').uploadify({
	  'uploader'    : 'uploadify/uploadify.swf',
	  'script'      : '/uploadify/uploadify.php',
	  'cancelImg'   : 'uploadify/cancel.png',
	  'folder'      : '/upload',
	  'multi'       : true
	});
	});
  </script>
  </head>
  
  <body>
    <input type="file" id="file_upload" name="file_upload" />
    <a href="javascript:$('#file_upload').uploadifyUpload();">Upload Files</a>

  </body>
</html>
