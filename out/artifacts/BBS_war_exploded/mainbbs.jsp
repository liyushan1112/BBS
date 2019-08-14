<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*,pojos.Section" %>
<%
	String path = request.getContextPath();
	String basePath =
	request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<base href="<%=basePath%>">
<title>论坛</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>
	<%String name = session.getAttribute("name").toString(); 
	  Integer size = (Integer)application.getAttribute("size");	
	  List<Section> sections=(List<Section>)session.getAttribute("allSection");%>
	<h3>
	欢迎您，<%=name%> &nbsp;&nbsp;当前在线<%=size%>人
	</h3>
	<table>
		<tr>
			<th>分类名称</th>
		</tr>
	<% Iterator<Section> it = sections.iterator() ;
		while(it.hasNext()){
			Section section =it.next();
		%>		
		<tr>
			<td>
				<a href = "ShowSectionAction?sid=<%=section.getId()%>"><%=section.getName()%></a>
			</td>

		</tr>
	<%} %>
	</table>

</body>
</html>