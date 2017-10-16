<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<center>
		<h3>更改科目信息</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="/exam/subject/deal.do?method=change&id=${subject.id}"
		method="post">
		<input type = "hidden" id = "r3" value = "${subject.stuts}">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">科目名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name"
					value="${subject.name}">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">科目学分</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="credit"
					value="${subject.credit}">
			</div>
		</div>		
		<div class="radio" style="text-align:center">
			<label class="checkbox-inline"> <input type="radio"
				name="stuts" id="r1" value="0" 
				> 禁用
			</label> <label class="checkbox-inline"> <input type="radio"
				name="stuts" id="r2" value="1"
				> 正常
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更新</button>
			</div>
		</div>
	</form>

