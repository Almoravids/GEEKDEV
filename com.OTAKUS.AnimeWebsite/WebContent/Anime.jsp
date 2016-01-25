<%@page import="pack.Visitor"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@page import="pack.Anime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.context.*" %>
    <%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel OTAKUS anime website</title>

</head>
<body>

<% Visitor visit;
if (session.getAttribute("user")!=null){
	visit=(Visitor)session.getAttribute("user");
if(!visit.getType().equals("user")){%>

<%@include file="WEB-INF/Admin/Menu.jsp" %>
<%@include file="WEB-INF/Admin/Anime.jsp" %>

<% }}else
	response.sendRedirect("../home");
	%>
</body>
</html>