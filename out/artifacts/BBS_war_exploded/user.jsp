<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,pojos.User" %>
 <%
	String path = request.getContextPath();
	String basePath =
	request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../style.css" type="text/css" />
<title>�û�����</title>
</head>
<body>
	<form id="search" method="post" action="FindUserAction">
		<input type="text" name ="search"></input><input type="submit" value = "�û�������"></input>
	</form>
	<table>
		<tr>
			<th>
			id
			</th>
			<th>
			�û���
			</th>
			<th>
			����
			</th>
		</tr>
	<%List<User> userlist = (List<User>)session.getAttribute("userList");
	  Iterator<User> it = userlist.iterator();
	  while(it.hasNext()){
		  User user = it.next();
	   %>
		<tr>
			<td>
				<%=user.getId() %>
			</td>
			<td>
				<%=user.getUserName() %>
			</td>
			<td>
				<a href = "UserTransferAction?id=<%=user.getId() %>">�޸�</a>&nbsp;<a href = "DelUserAction?id=<%=user.getId() %>">ɾ��</a>
			</td>
			</tr>
		<%}%>
		</table>
		</br>
		<a href = "QueryAllAction">������ҳ</a><br/>
</body>
</html>