<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>登陆</title>
</head>
<body>
<h3>欢迎您，请登录或注册</h3>
<div class = "loginBox">
	<!-- 通过form提交网页上的信息 -->
	<form id="login" method="post" action="login">
		用户名<br/>
		<input type="text" name="username"/><br/>
		密&nbsp;&nbsp;码<br/>
		<input type="password" name="password"/><br/>
		<br/>
		<input type="submit" value = "登陆">
		<input type="button" value = "注册" onclick = "window.location.href('register.jsp')"> 
	</form>
	</div>
</body>
</html>