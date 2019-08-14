<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>加新帖</title>
</head>
<body>
	<div class="contentBox">
	<%Integer sid = (Integer)session.getAttribute("sid"); %>
	<form id = "content"  method = "post" action = "AddTopicAction">
		<input type="hidden" name = "sid" value = "<%=sid %>" >
		信息标题<br/><input type = "text" name = "title"></input><p/>
		信息内容<br/><textarea rows="3" cols="20" name = "content"></textarea><p/>
		<input type="submit" value = "确定">
	</form>
	</div>
</body>
</html>