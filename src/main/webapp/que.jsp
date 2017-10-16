<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix ="c"%>
<ul>
	<li id = "que" value = "${question.id}">${question.con}</li>
	<c:if test ="${question.type==0}">
		<c:forEach items = "${itemList}" var = "item">
			<li><input type = "radio" name ="radio" value ="${item.id}" dirname="${item.id}" onclick="clicks(this)">${item.con}</li>
		</c:forEach>
	</c:if>
	<c:if test ="${question.type==1}">
		<c:forEach items = "${itemList}" var = "item">
			<li><input type = "checkbox" name = "radio" value ="${item.id}" dirname="${item.id}" onclick="clicks2(this)">${item.con}</li>
		</c:forEach>
	</c:if>
</ul>
<script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
<script type = "text/javascript">

	$(function(){
		var queid = $("#que").val();
		for(var i = 0;i<arr.length;i++){
			var a = arr[i];
			var str = a.split(":");
			if(queid == str[0]){
				var itemid = str[1];
				$("input[dirname="+itemid+"]").attr("checked","checked");
			}
		}
			for(var i = 0;i<arr2.length;i++){
			var a = arr2[i];
			var str = a.split(":");
			if(queid == str[0]){
				var itemid = str[1];
				$("input[dirname="+itemid+"]").attr("checked","checked");
			}
		}
	});
	
</script>