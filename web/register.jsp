<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>ע��</title>
</head>
<body>
	<div class="regBox">
	<form id="register" method="post" action="BBS/RegisterAction">
		�û���<br/><input type="text" name="username"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="password" name="password"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="realname"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="radio" name="sex" value="��">��&nbsp;<input type="radio" name="sex" value="Ů">Ů<br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="tel"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="home"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><textarea rows="5" cols="30" name="favorite"></textarea>
		<input type="submit" value = "ע��">
		
	</form>
	</div>
</body>
</html>