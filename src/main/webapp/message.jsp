<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <META http-equiv="Refresh" content="3; url=/exam/teacher/deal.do?method=list">
<META http-equiv="content-type" content='text/html; charset=UTF-8'>
	<link href="/ecam/res/Css/bootstrap.min.css" rel="stylesheet">
   <script type= "text/javascript" src="/exam/res/js/jquery.min.js"></script>
   <script>
   var timeout;
   var count = 3;
   		$(function(){
   			timeout = setTimeout(writ, 1000);   			
   		});
   	writ = function(){
   		if(count==0){
   			clearTimeout(timeOut); 
   			return true;
   		}else{
   			count --;
   			$("#time").val(count);
   			setTimeout(writ, 1000); 
   		}
   	
   	}
   </script>
  </head>
  
  <body>
		<div class="alert alert-success col-xs-6">
   			${requestScope.message}<input type = "button" id = "time" value = "3"/>秒后自动跳转
		</div>
  </body>
</html>
