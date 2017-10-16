<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@  taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <center><h2 style= "display:inline-block" class = "h2">按照科目查看试题</h2></center>
   <button type="button" style="color:#2B5C9C;display:inline;float:right" class="btn btn-success"><a class = "ajax-link" href = "question/deal.do?method=sub_tea_all">添加试题</a></button>
		<br/>
		<br/>
	<c:forEach items = "${sub_list}" var = "subject">
		<button type="button"  class="btn sub btn-primary btn-lg col-xs-3"><a href= "question/deal.do?method=sub_que&sub_id=${subject.id}" style= "display:inline-block;margin:0;" class = "a ajax-link" ><font color = "#E2F0E7">${subject.name}</font></a></button>
	</c:forEach>
