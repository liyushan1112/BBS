<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
 <%@ page import="java.util.*,pojos.Topic,util.Page"%>
 <%
	String path = request.getContextPath();
	String basePath =
	request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link rel="stylesheet" href="style.css" type="text/css" /><title>����</title>
</head>
<body>
<%Integer pid = (Integer) session.getAttribute("pid") ;
	Integer sid=(Integer)session.getAttribute("sid");
	List<Topic> contents = (List<Topic>) session.getAttribute("contentList");
	Page page1=(Page)session.getAttribute("page");
%>
		<a href = "TransferAction?pid=<%=pid%>">�ظ�</a> &nbsp;&nbsp;&nbsp;&nbsp;<a href = "ShowSectionAction?sid=<%=sid%>">����</a>
		</br>
		<table>
		<%Iterator<Topic> it = contents.iterator();
		while(it.hasNext()){
		Topic topic=it.next();%>
		<tr>
			<td>
				<%=topic.getContent() %>
			</td>
			</tr>
		<%} %>
			</table>
			</br>
	
		<%--ҳ����ת���־�̬�Ͷ�̬���� --%>
		<%if (page1.getCurrentPage()<=1) {%>

			��һҳ
		<%} %>
		<%if (page1.getCurrentPage()>1) {%>
		
			<a href = "ShowTopicAction?id=<%=pid%>&sid=<%=sid%>&currentPage=<%=page1.getCurrentPage()-1%>">��һҳ</a>
		<%} %>
		&nbsp;&nbsp;
		<%if (page1.getCurrentPage()>=page1.getTotalPage()) {%>
	
			��һҳ
		<%} %>
		<%if (page1.getCurrentPage()<page1.getTotalPage()) {%>
	
		<a href = "ShowTopicAction?id=<%=pid%>&sid=<%=sid%>&currentPage=<%=page1.getCurrentPage()+1%>">��һҳ</a>
		<%} %>
		&nbsp;&nbsp;��<%=page1.getTotalPage() %>ҳ&nbsp;&nbsp;��ǰ��<%=page1.getCurrentPage()%>ҳ
</body>
</html>