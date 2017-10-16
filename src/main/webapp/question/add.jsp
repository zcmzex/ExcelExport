<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<center>
		<h3>添加试题</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="/exam/question/deal.do?method=add" method="post">
		<select class="form-control select" name = "subject" style="width:600px;text-align:center;margin-left:200px">
			<c:forEach items="${sub_list}" var="subject">
				<option value = "${subject.id}">${subject.name}</option>
			</c:forEach>
		</select>
		 <select class="form-control select" name="teacher" style="margin-top:30px;width:600px;text-align:center;margin-left:200px">
			<c:forEach items="${tea_list}" var="teacher">
				<option value ="${teacher.id }">${teacher.name}</option>
			</c:forEach>
		</select>
		<div class="form-group" style="margin-top:20px">
			<label for="firstname" class="col-sm-2 control-label lable">试题题干</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstname" name="con">
			</div>
		</div>
		<div class="inputtype" style = "text-align: center;margin-bottom: 30px;">
			<label> <input type="radio" class = "radioxx" name="quetype"
				 value="0" > 单选题
			</label>
			<label> <input type="radio" class = "radioxx" name="quetype"
				 value="1"> 多选题
			</label>
		</div>
	<c:forEach begin="1" end="4" step="1" var="i">
	<div class="form-group" style="margin-top:20px">
	<label for="firstname" class="col-sm-2 control-label lable">选项${i}</label>
		<div class="input-group  col-sm-8" >
	      <input type="text" class="form-control" name = "itemcon" aria-describedby="inputGroupSuccess3Status">    <span class="input-group-addon"><input type = "radio" class = "xxtype" name = "istrue" value = "${i}"></span>
	    </div>
	    </div>
	</c:forEach>
		<div class="form-group" style="margin-left:500px">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
<script type="text/javascript">
				$(function(){
						$(".radioxx").bind("click",function(){
							if($(this).val()==0){
							$(".xxtype").attr("type","radio")}
							else {
							$(".xxtype").attr("type","checkbox")}
						});
				});
			
		</script>
