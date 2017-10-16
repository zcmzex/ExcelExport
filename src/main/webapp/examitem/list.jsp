<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<table class="table teacher_table" bgcolor="#BFBFBF">
	<center ><h3 style = "display:inline" class = "h3">考试安排列表</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "/exam/examitem/deal.do?method=add">添加考试</a></button>
		<tr>
			<th>考试场次</th>
			<td>考试科目</td>
			<th>考试班级</th>
			<th>考试开始时间</th>
			<th>考试结束时间</th>
			<th>单选个数</th>
			<th>单选分数</th>
			<th>多选个数</th>
			<th>多选分数</th>
			<td>考试状态</td>
			<th colspan="2">相关操作</th>
		</tr>
		<c:forEach items="${list}" var="examitem" varStatus="index">
			<tr>
					<th>${index.count}</th>
					<th>${examitem.subject.name}</th>
					<th>${examitem.classes.name}</th>
					<th>${examitem.stime}</th>
					<th>${examitem.etime}</th>
					<th>${examitem.radionum}</th>
					<th>${examitem.radiofen}</th>
					<th>${examitem.checknum}</th>
					<th>${examitem.checkfen}</th>
					<th>${examitem.stateDesr}</th>
				<th><a href="/exam/examitem/deal.do?method=update&id=${classes.id}" class="btn btn-primary btn-lg ajax-link"
				>更新</a></th>
				<th><a href="/exam/examitem/deal.do?method=delete&id=${classes.id}" class="btn btn-primary btn-lg ajax-link"
				>删除</a></th>
			</tr>
		</c:forEach>
</table>