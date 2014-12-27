<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
    <title>粉底霜发生地</title>  
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
                      'method':'post',  
                      'removeCompleted':true,  
                      'fileDesc'       : '支持格式:jpg、gif、png', //如果配置了以下的'fileExt'属性，那么这个属性是必须的    
                      'fileExt'        : '*.jpg;*.gif;*.png',//允许的格式  
                        //  'scriptData'     :{'name':$('#name').val()}, // 使用参数方法应不get,多个参数用逗号隔开 'name':$('#name').val(),'num':$('#num').val(),'ttl':$('#ttl').val()  
                      onComplete: function (event, queueID, fileObj, response, data) {   
                                $('<li></li>').appendTo('.files').text(response);           
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
                   $('#fileupload').uploadifyUpload();   
          }   
  
      </script> 
  </head>  
    
  <body>  
        <center>  
               <div>  
                   <input type="file" name="file" id="fileupload" value="苏三"/>   
                   <div id="fileQueue"></div>  
                   <p>   
                      <a href="javascript:;" onClick="javascript:uploadifyUpload()">开始上传</a>&nbsp;   
                      <a href="javascript:jQuery('#fileupload').uploadifyClearQueue()">取消所有上传</a>   
                   </p>   
                   <ol class=files ></ol>   
              </div>  
         </center>  
  </body>  
</html>  
