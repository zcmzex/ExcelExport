<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style>
.form {
	text-align: center;
	font-size: 30px;
}

.radio {
	margin-right: 600px;
	float: right;
}
</style>
	<center>
		<h3>更改教师信息</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="/exam/teacher/deal.do?method=change&id=${teacher.id}"
		method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">教师名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name"
					value="${teacher.name}">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">教师年龄</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="age"
					value="${teacher.age}">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">教师职称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="title"
					value="${teacher.title}">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">email</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="email"
					value="${teacher.email}">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">phone</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastname" name="phone"
					value="${teacher.phone}">
			</div>
		</div>
		<div class="radio">
			<label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios3" value="1"
				checked="${teacher.state==1?'checked':'' }"> 在职
			</label> <label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios4" value="0"
				checked="${teacher.state==0?'checked':'' }"> 离职
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">更新</button>
			</div>
		</div>
	</form>

