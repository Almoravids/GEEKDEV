<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile OTAKUS anime website</title>
</head>
<body>

<% if (session.getAttribute("user")!=null){%>
<%@include file="WEB-INF/User/Menu.jsp" %>
<%@include file="WEB-INF/User/Edit.jsp" %>
<% }else
	response.sendRedirect("login");%>
</body>
</html>