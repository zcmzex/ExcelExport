<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
	<center>
		<h2 class="h2">试题信息</h2>
	</center>
	<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">试题题干</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="firstname" name="con" value= "${question.con}">
			</div>
	</div>
	<c:forEach items = "${itemlist}" var = "item">
	<c:if test="${item.istrue==1}">
			<div class="form-group has-success has-feedback">
			
			  <label class="control-label" for="inputSuccess2">選項内容</label>
			 
			  <input style="width:600px" type="text" class="form-control" id="inputSuccess2" value = "${item.con}"  readonly aria-describedby="inputSuccess2Status">
			 
			  <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
			</div>
	</c:if>
	<c:if test= "${item.istrue==0 }">
	<div class="form-group has-error has-feedback">
		  <label class="control-label"   for="inputError2">選項内容</label>
		 
		  <input style="width:600px" type="text" class="form-control" id="inputError2" readonly value = "${item.con }" aria-describedby="inputError2Status">
		
		  <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
	</div>
	</c:if>
	</c:forEach>
	<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default"><a class = "ajax-link" href = "question/deal.do?method=sub_que&sub_id=${sub_id}">确定</a></button>
    </div>
  </div>