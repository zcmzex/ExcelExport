<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<form class="form-horizontal ajax-form" role="form"
		action="question/deal.do?method=change&id=${question.id}"
		method="post">
		<center><h2>${question.subject.name}题</h2></center>
		<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "question/deal.do?method=sub_que">返回上一步</a></button>
		<input type="hidden" id="r3" value="${question.stuts}">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">试题题干</label>
			<div class="col-sm-8">
				<textarea class="form-control" name="con" rows="3">${question.con}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">试题类型</label> <input
				type="hidden" id="quetype" value="${question.type}">
			<div class="col-sm-8">
				<input class="form-control" id="disabledInput" type="text"
					placeholder="${question.desrType}" disabled>
			</div>
		</div>
		<c:forEach items="${question.list}" var="item">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">试题选项</label>
				<c:if test="${question.type==0}">
					<div class="col-sm-6">
						<input type="text" class="form-control radios" id="firstname" name="itemcon"
							value="${item.con}"><input type ="hidden" name = "itemid" value= "${item.id}"> <input type="radio" class = "radios" name="istrue"				
							value="${item.id}"> 正确
					</div>
				</c:if>
				<c:if test="${question.type==1}">
					<input type="text" id="firstname" name="itemcon" value="${item.con}">
					<div class="checkbox">
						<label> <input type="checkbox" value="${item.id }"
							name="istrue"> 正确
						</label>
					</div>
				</c:if>
			</div>
		</c:forEach>
		<div class="radio">
			<label class="checkbox-inline"> <input type="radio"
				name="stuts" id="r1" value="0"> 禁用
			</label> <label class="checkbox-inline"> <input type="radio"
				name="stuts" id="r2" value="1"> 正常
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更新</button>
			</div>
		</div>
	</form>