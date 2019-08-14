<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>注册</title>
</head>
<body>
	<div class="regBox">
	<form id="register" method="post" action="BBS/RegisterAction">
		用户名<br/><input type="text" name="username"/><br/>
		密&nbsp;&nbsp;&nbsp;码<br/><input type="password" name="password"/><br/>
		真&nbsp;&nbsp;&nbsp;名<br/><input type="text" name="realname"/><br/>
		性&nbsp;&nbsp;&nbsp;别<br/><input type="radio" name="sex" value="男">男&nbsp;<input type="radio" name="sex" value="女">女<br/>
		电&nbsp;&nbsp;&nbsp;话<br/><input type="text" name="tel"/><br/>
		籍&nbsp;&nbsp;&nbsp;贯<br/><input type="text" name="home"/><br/>
		爱&nbsp;&nbsp;&nbsp;好<br/><textarea rows="5" cols="30" name="favorite"></textarea>
		<input type="submit" value = "注册">
		
	</form>
	</div>
</body>
</html>