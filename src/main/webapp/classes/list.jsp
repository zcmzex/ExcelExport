<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<table class="table teacher_table" bgcolor="#BFBFBF">
	<center ><h3 style = "display:inline" class = "h3">教师列表</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "classes/add.jsp">添加班级</a></button>
		<tr>
			<th>班级名称</th>
			<th>班级类型</th>
			<th>班级状态</th>
			<th>班级创建者</th>
			<th colspan="4">相关操作</th>
		</tr>
		<c:forEach items="${list}" var="classes">
			<tr>
				<th>${classes.name}</th>
				<th>${classes.typedesr}</th>
				<th>${classes.stateDesr}</th>
				<th>${sessionScope.user.name}</th>
				<th><a href="/exam/classes/deal.do?method=update&id=${classes.id}" class="btn btn-primary btn-lg ajax-link"
				>更新</a></th>
				<th><a href="/exam/classes/deal.do?method=look&id=${classes.id}" class="btn btn-primary btn-lg ajax-link"
				>查看</a></th>
				<th><a href="/exam/classes/deal.do?method=getStudents&id=${classes.id}&name=${classes.name}"  class="btn btn-primary btn-lg delete ajax-link" 
				>查看学生</a></th>
				<th><a href="/exam/classes/deal.do?method=upload&id=${classes.id} }"   class="btn btn-primary btn-lg look ajax-link"
				>导入学生</a></th>
			</tr>
		</c:forEach>
</table>
