<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="/exam/res/Css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
  	.a:hover{
  		color : #E83038;
  	}
  	.sub{
  		height:120px;
  		width:270px;
  		margin:30px;
  		font-size:30px;
  		line-height: 50px;
  	}
  	.a{
  		cursor: pointer;
  		color: #FFFFFF;
  		
  	text-decoration: none
  	}
  </style>
  </head>
  <body>
	  <center><h2 class = "h2">按照科目查看所有试题</h2></center>
	<c:forEach items = "${sub_list}" var = "subject">
		<button type="button"  class="btn sub btn-primary btn-lg col-xs-3"><a href= "/exam/item/deal.do?method=sub_que&sub_id=${subject.id}" class = "a" >${subject.name}</a></button>
	</c:forEach>
  </body>
</html>
