<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@ page import="java.util.*,pojos.Topic" %>
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
	<%Integer sid = (Integer)session.getAttribute("sid"); %>
	<a href = "newContent.jsp?sid=<%=sid%>">发布信息</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href = "BBS/QueryAllAction">首页</a>
	<table>
		<tr>
			<th>id</th>
			<th>内容</th>
		</tr>
		<tr>
	<%List<Topic> list = (List<Topic>)session.getAttribute("allContent");
	  Iterator<Topic> it = list.iterator();
	  while(it.hasNext()){
		  Topic topic = it.next();
	   %>
		<tr>
			<td>
				<%=topic.getId() %>
			</td>
			<td>
				<a href = "ShowTopicAction?id=<%=topic.getId()%>&sid=<%=sid%>&currentPage=1"><%=topic.getTitle()%></a>
			</td>
		</tr>
		<%} %>
	</table>

</body>
</html>