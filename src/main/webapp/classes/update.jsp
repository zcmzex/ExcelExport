<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<center>
		<h3>更改班級信息</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="/exam/classes/deal.do?method=change&id=${classes.id}"
		method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">班級名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name"
					value="${classes.name}">
			</div>
		</div>		
		<div class="radio" style="text-align:center">
			<label class="checkbox-inline"> <input type="radio"
				name="type" id="r1" value="1" checked="${classes.type==1?'checked':''}"
				> 本科
			</label> <label class="checkbox-inline"> <input type="radio"
				name="type" id="r2" value="0" checked="${classes.type==0?'checked':''}"
				> 专科
			</label>
		</div>
				<div class="radio" style="text-align:center">
				<label class="checkbox-inline">
				<input type="radio" name="state" id="r1" value="0" checked="${classes.state==0?'checked':''}"> 毕业
					</label>
			 <label class="checkbox-inline"> <input type="radio"
				name="state" id="r2" value="1" checked="${classes.state==1?'checked':''}"
				> 在校
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更新</button><label class="checkbox-inline"> 
			</label>
			</div>
		</div>
	</form>


