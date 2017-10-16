<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<center>
		<h3>添加教师</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="teacher/deal.do?method=add" method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">教师名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">教师年龄</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="age">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">教师职称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="title">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">email</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="email">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">phone</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="phone">
			</div>
		</div>
		<div class="radio" style="text-align: center">
			<label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios3" value="1"
				>在职
			</label> <label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios4" value="0"
				>离职
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
