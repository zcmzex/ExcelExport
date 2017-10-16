<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<center>
		<h3>添加考试</h3>
	</center>
	<form class="form-horizontal ajax-form" role="form"
		action="examitem/deal.do?method=addDeal" method="post">
		<input type = "hidden" name = "state" value = "2">
		 <select class="form-control select" name = "subjectid" style="width:650px;text-align:center;margin-left:170px">
			<c:forEach items="${sub_list}" var="subject">
				<option value = "${subject.id}">${subject.name}</option>
			</c:forEach>
		</select>
		 <select class="form-control select" name = "classid" style="width:650px;text-align:center;margin-top:20px;margin-bottom:20px;margin-left:170px">
			<c:forEach items="${cla_list}" var="classes">
				<option value = "${classes.id}">${classes.name}</option>
			</c:forEach>
		</select>
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">开考时间</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" id="datepicker1" name="stime">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">结束时间</label>
		    <div class="col-sm-8">
		     <input type="text" class="form-control" id="datepicker2" name="etime">
		    </div>
		  </div>
		  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">单选数量</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" name = "radionum" id="inputEmail3">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">单选分数</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputPassword3" name = "radiofen">
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">多选数量</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputEmail3" name ="checknum">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">多选分数</label>
    <div class="col-sm-8">
      <input type="text" class="form-control" id="inputPassword3" name = "checkfen">
    </div>
  </div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">添加</button>
			</div>
		</div>
	</form>
		<script type="text/javascript">
		    var picker = new Pikaday(
		    {
		        field: document.getElementById("datepicker1"),
		        firstDay: 1,
		        minDate: new Date('1990-01-01'),
		        maxDate: new Date('2020-12-31'),
		        yearRange: [1900,2020]
		    });
		    
		</script>
		<script type="text/javascript">
		    var picker = new Pikaday(
		    {
		        field: document.getElementById("datepicker2"),
		        firstDay: 1,
		        minDate: new Date('1990-01-01'),
		        maxDate: new Date('2020-12-31'),
		        yearRange: [1900,2020]
		    });
		</script>