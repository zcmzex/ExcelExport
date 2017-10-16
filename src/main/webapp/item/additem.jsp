<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<style>
.form {
	text-align: center;
	font-size: 30px;
}

.select {
	width: 650px;
	margin-left: 185px;
	margin-top: 16px;
}

.radio {
	margin-left: 300px;
}

.con {
	margin-top: 20px;
	margin-left: 250px;
}

.add {
	margin-left: 200px;
}
</style>
</head>

<body>
	<center>
		<h3>添加选项</h3>
	</center>
	<form class="form-horizontal" role="form"
		action="/exam/item/deal.do?method=adddeal" method="post">
		<input type="hidden" name="question_id" value="${question_id}">
		<div class="form-group con">
			<label for="firstname" class="col-sm-2 control-label lable">选项内容</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="con">
			</div>
		</div>
		<div class="radio">
			<label class="checkbox-inline"> <input type="radio"
				name="istrue" id="optionsRadios3" value="1"
				>正确
			
		</div>
			<div class="radio">
			<label class="checkbox-inline"> <input type="radio"
				name="istrue" id="optionsRadios3" value="0"
				>错误
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
</body>
</html>
