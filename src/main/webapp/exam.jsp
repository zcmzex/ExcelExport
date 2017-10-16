<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
	<center><h2>在线考试</h2></center>
	<form action = "/exam/examdeal/deal.do" method = "post" class = "examdeal ajax-form">
	<div style="margin-left:300px;width:700px;height:300px;border-style: groove" class = "main">
		</div>
	<div style="width:700px;height:50px;margin-left:300px;margin-top:20px;">
	<c:forEach begin="1" step="1" end="${num}" var = "i">
		<button style = "padding:0px;background-color: blue;" onclick = "fun('${i}','${subjectid}',event,this)">第${i}题</button>
	</c:forEach>
	</div> 
	<div style ="margin-left:300px" >
		<input type = "submit" value = "提交" onclick = "submits(event)"/>
	</div>
	</form>
	<script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
    	<script type="text/javascript">
    		var arr = new Array();
    		var arr2 = new Array();
    	$(function(){
			//$('a.ajax-link')
		
			$("body").on("click", "a.ajax-link",function(event) {
				event.preventDefault();
				var action = $("a.ques").attr("href");
				
				$.get(action,function(rt){
					$("div.main").html(rt);
				});
			});
			});
			function submits(event){
				event.preventDefault();
				var action = $("form.examdeal").attr("action");
				$.post(action,{arr:arr.toString(),arr2:arr2.toString()},function(rt){
					$("div.main").html(rt);
				});
			}
			function fun(index,subjectid,event,thiss){
					event.preventDefault();
					
					$(thiss).css("background-color", "red");
					var action = "/exam/queexam/deal.do";
					$.get(action,{index:index,subjectid:subjectid},function(rt){
						$("div.main").html(rt);
					});
				}
			function clicks(thiss){	
				var queid = $("li#que").val();
				var itemid = $(thiss).val();
				//如果要改变选项
				for(var i = 0;i<arr.length;i++){
					var a = arr[i];
					var str = a.split(":");
					if(queid == str[0]){
						arr[i] = queid+":"+itemid;
						return ;
					}
				}
				//做的是新的题
				var queitem = queid+":"+itemid;
				arr.push(queitem);
			}
			function clicks2(thiss){
				var queid = $("li#que").val();
				var itemid = $(thiss).val();
				for(var i = 0;i<arr2.length;i++){
					var a = arr2[i];
					if(a==null){
					continue;
					}
					var str = a.split(":");
					if(queid == str[0]){
						if(itemid==str[1]){
							arr2[i] = null;
							return;
						}
					}
				}
				//做的是新的题
				var queitem = queid+":"+itemid;
				arr2.push(queitem);
			}
	</script>
</body>
</html>