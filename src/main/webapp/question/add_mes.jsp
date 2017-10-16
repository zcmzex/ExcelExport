<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
    <META http-equiv="Refresh" content="3; url=/exam/question/deal.do?method=que_item&que_id=${que_id}"/>
<META http-equiv="content-type" content='text/html; charset=UTF-8'>
	<link href="/ecam/res/Css/bootstrap.min.css" rel="stylesheet">
 <link href="/ecam/res/Css/bootstrap.min.css" rel="stylesheet">
   <script type= "text/javascript" src="/exam/res/js/jquery.min.js"></script>
  <script type="text/javascript">
        var timeout;
        var count = 3; // 倒数十下
        $(function() {
            timeout = setTimeout(BtnCount, 1000); // 1s执行一次BtnCount
        });
        BtnCount = function() {
               // 启动按钮
               if (count == 0) {
                $('#btnSubmit').val("ok");
                clearTimeout(timeout);           // 可取消由 setTimeout() 方法设置的 timeout
            }
            else {
               	count--;
                $('#btnSubmit').val(count.toString());
                setTimeout(BtnCount, 1000);
            }
        };
    </script>
  </head>
  
  <body>
   		<div class="alert alert-success col-xs-6">
   			${requestScope.message}<input type = "button" id = "btnSubmit" value = "3"></button>秒后自动跳转
		</div>
  </body>
</html>
