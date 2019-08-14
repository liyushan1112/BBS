<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" />
<title>回复</title>
</head>
<body>
<div class ="contentBox">
<%Integer id = (Integer)session.getAttribute("id");
Integer pid = (Integer)session.getAttribute("pid");
Integer sid = (Integer)session.getAttribute("sid");%>
	<form id = "content"  method = "post" action = "ReplyTopicAction">
		<input type="hidden" name = "id" value = <%=id %>></input>
		<input type = "hidden" name = "pid" value =  <%=pid %>></input>
		<input type = "hidden" name = "sid" value =  <%=sid %>></input>
		回复内容<br/> <textarea rows="3" cols="20" name = "content"></textarea><p/>
		<input type="submit" value = "确定">
	</form>
	</div>
</body>
</html>