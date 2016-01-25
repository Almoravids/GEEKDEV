<% if (session.getAttribute("user")!=null){%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>
<%!Visitor visitor;%>
<%visitor=(Visitor)session.getAttribute("user"); %>
<%=visitor.getName()%> Profile OTAKUS Anime web site</title>
</head>
<body>
<%@include file="WEB-INF/User/Menu.jsp" %>
<%@include file="WEB-INF/User/Profile.jsp" %>
<%@include file="WEB-INF/User/Footer.jsp" %>
</body>
</html>
<% }else
	response.sendRedirect("login");%>
