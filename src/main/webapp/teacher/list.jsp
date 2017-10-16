<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
	<table class="table teacher_table" bgcolor="#BFBFBF">
	<center ><h3 style = "display:inline" class = "h3">教师列表</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "teacher/add.jsp">添加教师</a></button>
		<tr>
			<th>教师id</th>
			<th>教师名称</th>
			<th>教师年龄</th>
			<th>email</th>
			<th>phone</th>
			<th>教师职称</th>
			<th>教师状态</th>
			<th colspan="3">相关操作</th>
		</tr>
		<c:forEach items="${list}" var="teacher">
			<tr>
				<th>${teacher.id}</th>
				<th>${teacher.name }</th>
				<th>${teacher.age }</th>
				<th>${teacher.email }</th>
				<th>${teacher.phone }</th>
				<th>${teacher.title }</th>
				<th>${teacher.desrState}</th>
				<th><a href="/exam/teacher/deal.do?method=update&id=${teacher.id}" class="btn btn-primary btn-lg ajax-link"
				>更新</a></th>
				<th><a href="#"  class="btn btn-primary btn-lg delete" 
				>删除</a></th>
				<th><a href="#"   class="btn btn-primary btn-lg look"
				>查看</a></th>
			</tr>
		</c:forEach>
</table>
