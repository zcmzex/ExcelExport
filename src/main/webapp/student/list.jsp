<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<form style="margin-left:100px;margin-bottom: 50px" class="form-inline stumarger" action = "/exam/student/deal.do?method=getStudent" method = "post">
	<center><h3>学生管理</h3></center>
	<button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "student/deal.do?method=add">添加学生</a></button>
	<select class="form-control select " name = "identify" >
			<c:forEach items="${classlist}" var="classe">
				<option value = "${classe.id}">${classe.name}</option>
			</c:forEach>
	</select>
  <div class="form-group">
    <label for="exampleInputName2">name</label>
    <input type="text" class="form-control" id="exampleInputName2" name = "name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">number</label>
    <input type="text" class="form-control" id="exampleInputEmail2" name = "loginnum">
  </div>
  <button type="submit" class="btn btn-default">查询</button>
</form>
<div class ="students">
</div>