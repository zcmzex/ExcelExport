<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c" %>
  <table class="table teacher_table" bgcolor="#FBE596">
 <center><h2 class = "h2" style= "display:inline-block">${subject.name}的所有试题</h2></center>
 <button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "question/deal.do?method=sub_list">返回上一步</a></button>
		<tr>
			<th>试题id</th>
			<th>试题题干</th>
			<th>试题类型</th>
			<th>试题出题人</th>
			<th>试题状态</th>
			<th colspan="3">相关操作</th>
		</tr>
		<c:forEach items="${que_list}" var="question">
			<tr>
				<th>${question.id}</th>
				<th>${question.con}</th>
				<th>${question.desrType}</th>
				<th>${question.teacher.name}</th>
				<th>${question.desrStuts}</th>
				<th><a href="question/deal.do?method=update&id=${question.id}" class="ajax-link btn btn-primary btn-lg"
				>更新</a></th>
				<th><a href="#"  class="btn btn-primary btn-lg delete" 
				>删除</a></th>
				<th><a href="#"   class="btn btn-primary btn-lg look"
				>查看</a></th>
			</tr>
		</c:forEach>
	</table>