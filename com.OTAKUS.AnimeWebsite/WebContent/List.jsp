<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List OTAKUS anime website</title>
</head>
<body>

	<%@include file="WEB-INF/User/Menu.jsp"%>
	<c:choose>
		<c:when test="${param.search eq null and param.tag eq null}">
			<%@include file="WEB-INF/User/OrderedSearch.jsp"%>
		</c:when>
		<c:otherwise>
			<%@include file="WEB-INF/User/List.jsp"%>
		</c:otherwise>
	</c:choose>
	<%@include file="WEB-INF/User/Footer.jsp"%>
</body>
</html>