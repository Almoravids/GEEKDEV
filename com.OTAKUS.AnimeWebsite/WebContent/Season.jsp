<%@page import="pack.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Season Panel OTAKUS anime website</title>
</head>
<body>

<% Visitor visit;
if (session.getAttribute("user")!=null){
	visit=(Visitor)session.getAttribute("user");
if(!visit.getType().equals("user")){%>

<%@include file="WEB-INF/Admin/Menu.jsp" %>

<%@include file="WEB-INF/Admin/Season.jsp" %>
<% }}else
	response.sendRedirect("login");
	%>
</body>
</html>