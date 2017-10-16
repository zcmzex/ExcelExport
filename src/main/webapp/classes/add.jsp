<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<center>
		<h3>添加教师</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="classes/deal.do?method=add" method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">班级名称</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="name">
			</div>
		</div>
			<div class="radio" style="text-align: center">
			<label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios3" value="0"
				>毕业
			</label> <label class="checkbox-inline"> <input type="radio"
				name="state" id="optionsRadios4" value="1"
				>在校
			</label>
		</div>
		</div>
			<div class="radio" style="text-align: center">
			<label class="checkbox-inline"> <input type="radio"
				name="type" id="optionsRadios3" value="0"
				>专科
			</label> <label class="checkbox-inline"> <input type="radio"
				name="type" id="optionsRadios4" value="1"
				>本科
			</label>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>