<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@ page import = "pojos.User"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
	String path = request.getContextPath();
	String basePath =
	request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="../style.css" type="text/css" />
<title>ע��</title>
</head>
<body>
	<div class="regBox">
	<%User user = (User)session.getAttribute("user"); %>
	<form id="register" method="post" action="ModUserAction">
		<input type="hidden" name="id" value = "<%=user.getId()%>">
		�û���<br/><input type="text" name="username" value="<%=user.getUserName()%>"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="password" name="password"value="<%=user.getPassword()%>"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="realname" value="<%=user.getRealname()%>"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/>
		
		<%String sex =user.getSex();
		if(sex.equals("��")){	%>
		<input type="radio" name="sex" value="��" checked= "checked "/>��&nbsp;<input type="radio" name="sex" value="Ů"/>Ů<br/>
		<%} %>	
		<%if(sex.equals("Ů")){	%>
		<input type="radio" name="sex" value="��" />��&nbsp;<input type="radio" name="sex" value="Ů" checked= "checked "/>Ů<br/>
		<%} %>	
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="tel" value="<%=user.getTel()%>"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><input type="text" name="home" value="<%=user.getHome()%>"/><br/>
		��&nbsp;&nbsp;&nbsp;��<br/><textarea rows="5" cols="30" name="favorite"><%=user.getFavorite()%></textarea>
		<input type="submit" value = "�޸�">
		
	</form>
	</div>
</body>
</html>