<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <link href="/exam/res/Css/bootstrap.min.css" rel="stylesheet">
  </head>
  
  <body>
   
    <table class="table teacher_table" bgcolor="#FBE596">
 <center><h2 class = "h2">${subject.name}的所有试题</h2></center>
		<tr>
			<th>试题id</th>
			<th>试题题干</th>
			<th>试题类型</th>
			<th>试题状态</th>
			<th>添加选项</th>
		</tr>
		<c:forEach items="${que_list}" var="question">
			<tr>
				<th>${question.id}</th>
				<th>${question.con}</th>
				<th>${question.desrType}</th>
				<th>${question.desrStuts}</th>
				<th><a href="/exam/item/deal.do?method=add&id=${question.id}" class="btn btn-primary btn-lg"
				>添加选项</a></th>
			</tr>
		</c:forEach>
	</table>
  </body>
</html>
