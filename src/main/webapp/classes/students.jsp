<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="table teacher_table" bgcolor="#BFBFBF">
	<center ><h3 style = "display:inline" class = "h3">${name}学生列表</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success fanhui" ><a class = "ajax-link" href = "/exam/classes/deal.do?method=cls_list">返回列表</a></button>
		<tr>
			<th>学生名称</th>
			<th>学生学号</th>
			<th>学生bri</th>
			<th>学生性别</th>
			<th>学生成绩</th>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<th>${student.name}</th>
				<th>${student.loginnum}</th>
				<th> <fmt:formatDate value="${student.date}" pattern="yyyy-MM-dd"/></th>
				<th>${student.sexdesr}</th>
				<th>${student.grade}</th>
			</tr>
		</c:forEach>
</table>