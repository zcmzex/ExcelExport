<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <link rel="icon" href="../../favicon.ico">
    <title>管理员登录</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link href="/exam/style/signin.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form class="form-signin teacher-login" action= "/exam/login/deal.do" method = "post">
        <h2 class="form-signin-heading">Please login</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name = "username" class="form-control form-input"  placeholder="Email address" required autofocus>
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
    			var username = $("#inputEmail").val();
    			var pass = $("#inputPassword").val();
    			var action = "/exam/check/deal.do";
    			$.get(action,{user:username,pass:pass},function(rt){
    					$("p.mes").html(rt);
    			});
    		});
		});
 	</script>
  </body>
</html>
