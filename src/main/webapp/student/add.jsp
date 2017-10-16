<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<center>
		<h3>添加学生</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="student/deal.do?method=addDeal" method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">学生名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name">
			</div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">学生学号</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="loginnum">
			</div>
            </div>
            <div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">学生生日</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="datepicker" name="date">
			</div>
		<script type="text/javascript">
		    var picker = new Pikaday(
		    {
		        field: document.getElementById("datepicker"),
		        firstDay: 1,
		        minDate: new Date('1990-01-01'),
		        maxDate: new Date('2020-12-31'),
		        yearRange: [2000,2020]
		    });
</script>
            </div>
			<div class="radio" style="text-align: center">
			<label class="checkbox-inline"> <input type="radio"
				name="sex" id="optionsRadios3" value="1"
				>男
			</label> <label class="checkbox-inline"> <input type="radio"
				name="sex" id="optionsRadios4" value="0"
				>女
			</label>
		</div>
		所属班級
		<select class="form-control select col-md-4" style="width:620px;margin-left:175px;" name = "class_id" >
			<c:forEach items="${list}" var="classe">
				<option value = "${classe.id}">${classe.name}</option>
			</c:forEach>
		</select>
		<br/><br/>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
