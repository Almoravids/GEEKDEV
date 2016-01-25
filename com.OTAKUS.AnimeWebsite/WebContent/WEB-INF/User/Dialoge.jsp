<%@page import="pack.Method"%>
<%@page import="pack.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="Stylesheet" href="Css/dialoge.css">
		<script src="Js/jquery-2.1.3.min.js"></script>
		<script src="Js/jquery-ui.min.js"></script>
	</head>
	<%
	if (request.getParameter("username")!=null&&request.getParameter("username")!=""&&request.getParameter("password")!=null
			&&request.getParameter("password")!=""&&request.getParameter("email")==null){
	Method method=(Method)Method.getcontext();
	Visitor visitor=method.getUser(request.getParameter("username"));
	if (visitor.getPassword().equals(request.getParameter("password"))){
		session.setAttribute("user", visitor);
	           response.sendRedirect("home");
	           
	       }
	}
	%>
	<body>

	
		<form id="background" method="get">
			<div id="dg">
				<img src="Image/closeDialog.png">
				<center>
			
				<h2>Login</h2>
				<div id="c">
					<table>
						<tr><td><label>Username :</label></td><td><input type="text" name="username" request/></td></tr>
					
						<tr><td ><label>Pass :</label></td><td><input type="password" name="password" request/></td></tr>
					
					</table>
						<input id="signup" type="button" value="sing up"/><input type="submit" value="Login"/>
						</center>
				</div>
			</div>	
		</form >
	</body>
	
	<script>
		$(document).ready(function (){
		
			$("#dg img").click(function (){
				
				$("#background").css('visibility','hidden');
			});	
			$("#signup").click(function (){
				window.open('signup','_top');
			});	
				
				
		});
	
	</script>

</html>