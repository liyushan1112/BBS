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
<title>注册</title>
</head>
<body>
	<div class="regBox">
	<%User user = (User)session.getAttribute("user"); %>
	<form id="register" method="post" action="ModUserAction">
		<input type="hidden" name="id" value = "<%=user.getId()%>">
		用户名<br/><input type="text" name="username" value="<%=user.getUserName()%>"/><br/>
		密&nbsp;&nbsp;&nbsp;码<br/><input type="password" name="password"value="<%=user.getPassword()%>"/><br/>
		真&nbsp;&nbsp;&nbsp;名<br/><input type="text" name="realname" value="<%=user.getRealname()%>"/><br/>
		性&nbsp;&nbsp;&nbsp;别<br/>
		
		<%String sex =user.getSex();
		if(sex.equals("男")){	%>
		<input type="radio" name="sex" value="男" checked= "checked "/>男&nbsp;<input type="radio" name="sex" value="女"/>女<br/>
		<%} %>	
		<%if(sex.equals("女")){	%>
		<input type="radio" name="sex" value="男" />男&nbsp;<input type="radio" name="sex" value="女" checked= "checked "/>女<br/>
		<%} %>	
		电&nbsp;&nbsp;&nbsp;话<br/><input type="text" name="tel" value="<%=user.getTel()%>"/><br/>
		籍&nbsp;&nbsp;&nbsp;贯<br/><input type="text" name="home" value="<%=user.getHome()%>"/><br/>
		爱&nbsp;&nbsp;&nbsp;好<br/><textarea rows="5" cols="30" name="favorite"><%=user.getFavorite()%></textarea>
		<input type="submit" value = "修改">
		
	</form>
	</div>
</body>
</html>