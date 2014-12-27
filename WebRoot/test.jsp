<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title> New Document </title>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
 <script language="javascript" type="text/javascript">
        function getFullPath(obj)
        {
            if(obj)
            {
                //ie
                if (window.navigator.userAgent.indexOf("MSIE")>=1)
                {
                    obj.select();
                    return document.selection.createRange().text;
                }
            //firefox
                else if(window.navigator.userAgent.indexOf("Firefox")>=1)
                {
                    if(obj.files)
                    {
                        return obj.files.item(0).getAsDataURL();
                    }
                        return obj.value;
                 }
                return obj.value;
            }
        }

        function yulan() 
        { 
            filename=document.getElementById('UpFile').value; 
            var fileText =filename.substring(filename.lastIndexOf("."),filename.length); //获取文件扩展名 

              var filePath =getFullPath(document.getElementById('UpFile')); 
               alert(filePath);
            var fileName =fileText.toLowerCase(); 
           if ((fileName!='.jpg')&&(fileName!='.gif')&&(fileName!='.jpeg')&&(fileName!='.png')&&(fileName!='.bmp')) 
           { 
              alert("对不起，系统仅支持标准格式的照片，请您调整格式后重新上传，谢谢 ！"); 
              document.form1.UpFile.focus(); 
           } 
           else 
           { 
              document.getElementById("preview").innerHTML="<img src='"+filePath+"' width=120 style='border:6px double #ccc'>"; 
           } 
        }

</script>

 </head>

 <body>
 

<form name=form1>
<input type="file" id="UpFile" class="stylebtn" name="UpFile" onchange="yulan()" />;
</form>
<!--
<asp:Button ID="btnUpload" runat="server" Text="上  传" 
onclick="btnUpload_Click" Height="22px" CssClass="stylebtn"/>-->
<div id="preview"></div>

 </body>
</html>
