<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<table class="table teacher_table" bgcolor="#BFBFBF">
	<center><h3  style = "display:inline" class = "h3">科目列表</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "subject/add.jsp">添加科目</a></button>
		<tr>
			<th>科目id</th>
			<th>科目名称</th>
			<th>科目学分</th>
			<th>科目状态</th>
			<th colspan="3">相关操作</th>
		</tr>
		<c:forEach items="${list}" var="subject">
			<tr>
				<th>${subject.id}</th>
				<th>${subject.name }</th>
				<th>${subject.credit}</th>
				<th>${subject.descStuts}</th>
				<th><a href="subject/deal.do?method=update&id=${subject.id}" class="ajax-link btn btn-primary btn-lg"
				>更新</a></th>
				<th><a href="#"  class="btn btn-primary btn-lg delete" 
				>删除</a></th>
				<th><a href="#"   class="btn btn-primary btn-lg look"
				>查看</a></th>
			</tr>
		</c:forEach>
	</table>