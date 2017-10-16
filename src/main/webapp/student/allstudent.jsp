<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<table class="table teacher_table stumarger" bgcolor="#BFBFBF">
		<tr>
			<th>学生名称</th>
			<th>学生生日</th>
			<th>学生学号</th>
			<th>学生性别</th>
			<th>学生成绩</th>
			<th colspan="3">相关操作</th>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<th>${student.name}</th>
				<th><fmt:formatDate pattern="yyyy-MM-dd" value="${student.date}"></fmt:formatDate></th>
				<th>${student.loginnum }</th>
				<th>${student.sexdesr}</th>
				<th>${student.grade}</th>
				<th><a href="/exam/student/deal.do?method=update&id=${student.id}" class="btn btn-primary btn-lg ajax-link"
				>更新</a></th>
				<th><a href="#"  class="btn btn-primary btn-lg delete" 
				>删除</a></th>
				<th><a href="#"   class="btn btn-primary btn-lg look"
				>查看</a></th>
			</tr>
		</c:forEach>
		</table>