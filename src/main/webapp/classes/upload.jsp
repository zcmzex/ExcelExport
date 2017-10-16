<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<form action = "/exam/classes/deal.do?method=upload" mothod = "post" class = "ajax-form"  enctype="multipart/form-data" >
	  <div class="form-group">
	    <label for="exampleInputFile">学生信息上传</label>
	    <input type="file" id="exampleInputFile" name = "students">
	    <p class="help-block"></p>
	  </div>
	  <input type="submit" class="btn btn-default" value = "添加学生到班级">
	</form>