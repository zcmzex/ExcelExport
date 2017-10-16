<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      	<link href="/exam/style/pikaday.css" rel="stylesheet">
    	<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="/exam/style/dashboard.css" rel="stylesheet">
		<link href="/exam/res/Css/bootstrap-datetimepicker.css" rel="stylesheet">
		<script src="/exam/res/js/bootstrap.min.js"></script>
		<script src="/exam/style/pikaday.min.js"></script>
		<script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
		<script src="/exam/res/js/bootstrap-datetimepicker.js"></script>
		<script type="text/javascript" src="/exam/res/js/jquery.min.js"></script>
		
    <title>在线考试系统</title>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">qst在线考试</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#" >${sessionScope.user.name}</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li ><a class = "ajax-link" href="teacher/deal.do?method=list">教师管理<span class="sr-only">(current)</span></a></li>
            <li><a class = "ajax-link" href="subject/deal.do?method=list">科目管理</a></li>
            <li><a class = "ajax-link" href="question/deal.do?method=sub_list">试题管理</a></li>
            <li><a class = "ajax-link" href="classes/deal.do?method=cls_list">班级管理</a></li>
            <li><a class = "ajax-link" href="student/deal.do?method=list">学生管理</a></li>
              <li><a class = "ajax-link" href="examitem/deal.do?method=list">考试安排</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        </div>
      </div>
    </div>
    	<script type="text/javascript" src = "/exam/res/js/jquery.js"></script>
    	<script type="text/javascript">
    	$(function(){
			//$('a.ajax-link')
			$("body").on("click", "a.ajax-link",function(event) {
				event.preventDefault();
				$("div.main").load($(this).attr("href"));
			});
			$("body").on("submit","form.ajax-form",function(event){
				event.preventDefault();
				var data = $("form.ajax-form").serialize();
				var action = $("form.ajax-form").attr("action");
				$.post(action,data,function(rt){
					$("div.main").html(rt);
				});
			});
			$("body").on("submit","form.teacherlogin",function(event){
				event.preventDefault();
				var data = $("form.teacherlogin").serialize();
				var action = $("form.teacherlogin").attr("action");
				$.post(action,data,function(rt){
					$("div.usnmes").html(rt);
				})
			})
			$("button.history").bind("click",function(){
				history.back();
				location.reload();
			});
			$("body").on("submit","form.stumarger",function(event){
				event.preventDefault();
				var data = $("form.stumarger").serialize();
				var action = $("form.stumarger").attr("action");
				$.post(action,data,function(rt){
					$("div.students").html(rt);
				});
			});
			
		});
         
    	</script>
    	<script type="text/javascript">

    var picker = new Pikaday(
    {
        field: document.getElementById('datepicker'),
        firstDay: 1,
        minDate: new Date('2010-01-01'),
        maxDate: new Date('2020-12-31'),
        yearRange: [2000,2020]
    });

</script>
  </body>
</html>
