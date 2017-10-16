<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
  <head>
  	<link href="/exam/style/pikaday.css" rel="stylesheet">
    	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="/exam/style/dashboard.css" rel="stylesheet">
		<link href="/exam/res/Css/bootstrap-datetimepicker.css" rel="stylesheet">
		<script src="/exam/res/js/bootstrap.min.js"></script>
		<script src="/exam/style/pikaday.min.js"></script>
		<script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
		<script src="/exam/res/js/bootstrap-datetimepicker.js"></script>
		<script type="text/javascript" src="/exam/res/js/jquery.min.js"></script>
  </head>
  <body>
   <table class="table teacher_table" bgcolor="#BFBFBF">
	<center ><h3 style = "display:inline" class = "h3">考试安排列表</h3></center>
		<tr>
			<th>场次</th>
			<th>考试科目</th>
			<th>考试班级</th>
			<th>考试时长</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>考试状态</th>
			<th>相关操作</th>
		</tr>
		<c:forEach items="${list}" var="examitem">
			<tr>
				<th>1</th>
				<th>${examitem.subject.name}</th>
				<th>${examitem.classes.name}</th>
				<th>${examitem.etime}</th>
				<th>${examitem.stime}</th>
				<th>${examitem.etime}</th>
				<th>${examitem.stateDesr}</th>
				<c:if test="${examitem.state==2}" >
				<th><a href="/exam/exam/deal.do?subjectid=${examitem.subject.id}&radionum=${examitem.radionum}&radiofen=${examitem.radiofen}&checknum=${examitem.checknum}&checkfen=${examitem.checkfen}" class="btn btn-primary btn-lg"
				>开始考试</a></th>
				</c:if>
				<c:if test = "${examitem.state!=2}">
				<th></th>
				</c:if>
			</tr>
		</c:forEach>
</table>
  </body>
</html>
