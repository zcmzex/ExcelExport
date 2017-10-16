<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>考生登录</title>
    <script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="/exam/style/signin.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
  </head>
  <body>
    <div class="container">
      <form class="form-signin teacher-login" action= "/exam/login/deal.do?method=student" method = "post">
        <h2 class="form-signin-heading">Please login</h2>
        <label for="inputEmail" class="sr-only">学号</label>
        <input type="text" id="inputEmail" name = "loginnum" value="${cookie.name.value }" class="form-control form-input"  placeholder="loginnum" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name ="pass" class="form-control form-input" placeholder="Password" required>
        	<p class = "mes"></p>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
    </div> <!-- /container -->
	<script type="text/javascript" src = "/exam/res/js/jquery-3.0.0.js"></script>
    <script type="text/javascript">
    $(function(){
    		$("body").on("change","input.form-input",function(event){
    			event.preventDefault();
    			var loginnum = $("#inputEmail").val();
    			var pass = $("#inputPassword").val();
    			var action = "/exam/checkstu/deal.do";
    			$.get(action,{loginnum:loginnum,pass:pass},function(rt){
    					$("p.mes").html(rt);
    			});
    		});
		});
 	</script>
  </body>
</html>
