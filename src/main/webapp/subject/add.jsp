<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<center>
		<h3>添加科目</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="subject/deal.do?method=add" method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">科目名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">科目学分</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" onkeypress="testnum(this)" id="lastname" name="credit">
			</div>
		</div>
		<div class="radio" style = "text-align:center">
			<label class="checkbox-inline"> <input type="radio"
				name="stuts" id="optionsRadios3" value="0"
				>禁用
			</label> <label class="checkbox-inline"> <input type="radio"
				name="stuts" id="optionsRadios4" value="1"
				>正常
			</label>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>