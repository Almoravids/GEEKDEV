<%@page import="pack.Visitor"%>
<%@page import="pack.Method"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="Js/jquery-2.1.3.min.js"></script>
		<script src="Js/jquery-ui.min.js"></script>
		<style>
			body{
				background:rgb(10,10,10);
				font-family:arial;
			}
			#edit h1{
				
				margin-left:50px;
				color:#008563;
				font-family:arial;
			}
			#edit{
				margin-left:300px;
				margin-top:120px;
			}
			#edit ul {
				list-style:none;
				
			}
			#edit ul li{
				color:white;
				margin-top:10px;
				
				background:black ;
				width:60%;
				border-radius:6px;
				
				border:2px rgb(10,10,10) solid;
			}
			
			#edit ul li span{
				float:right;
				color:#008563 ;
			}
			#edit ul li #div1,#div2,#div3,#div4,#div5 {
				margin-top:30px;
				margin-left:70px;
				display:none;
			
				
			}
			#edit ul li div input{
				padding:2px;
				width:200px;	
				border:1px solid #008563;
				border-radius:2px;
			}
		
			#edit ul li div input[type="button"]{
				width:100px;
				border:1px  #003326 solid;
				background-color: #008563;
				color:white;
				margin:5px;
				padding-top:5px;
				padding-bottom:5px;
				padding-left:15px;
				padding-right:15px;
				border-radius:2px;
				margin-left:400px;
				border-radius:3px;
			}
			#edit ul li div input[type="button"]:hover{
				
				cursor:pointer;
			}
			#edit ul li div label{
				margin-right:10px;
				color:white;
			}
			#edit ul li span + header {
				padding:20px;
				color:white;
				
				
			}
			#edit ul li span + header:hover{
				cursor:pointer;
			}
			#edit ul li header b{
				margin-left:10px;
				vertical-align:middle;
				
			}
			
		</style>
	</head>
	<%
	Method method=(Method)Method.getcontext();
	Visitor visitor=(Visitor)session.getAttribute("user"); %>
	<body>
		
		<section id="edit">
		<h1>Edit Profile</h1>
			<ul>
				<li><span></span><header id="div11">First Name<b><%=visitor.getName()%></b><span>edit</span></header>
					<div id="div1">
						
						<label>First Name:</label><input type="text" name="name" /><br>
						<input type="button" value="Save" />
					</div>
				</li>
				
				<li><span></span><header id="div12">Last Name<b><%=visitor.getLastName()%></b><span>edit</span></header>
					<div id="div2">
						
						<label>Last Name:</label><input type="text" name="name" /><br>
						<input type="button" value="Save" />
					
					</div>
				</li>
				<li><span></span><header id="div13">Email<b><%=visitor.getEmail()%></b><span>edit</header></div>
					<div id="div3">
						<table>
						<tr><td><label>Email:</label></td><td><input type="Email" name="email" /></td></tr>
						<tr><td><label>Password:</label></td><td><input type="password" name="pass" /></td></tr>
						
						</table>
						<input type="button" value="Save" />
					</div>
				</li>
				<li><span></span><header id="div14">Password<b>**********</b><span>edit</span></header>
					<div id="div4">
						
						<table>
						<tr><td><label>Old Password:</label></td><td><input type="password" name="Opass" /></td></tr>
						<tr><td><label> New Password:</label></td><td><input type="password" name="Npass" /></td></tr>
						<tr><td><label> Confirm Password:</label></td><td><input type="password" name="NCpass" /></td></tr>
						
						</table>
						<input type="button" value="Save" />
					</div>
				</li>
				
			</ul>	
		</section>	
	</body>
	<script>
	
		$("#edit ul li #div11").click(function (){
			$("#edit ul li header").css("background-color","black");
			$(this).css("background","#003326");
			
			if(!$("#edit ul li #div1").is(':visible')){
			$("#edit ul li div:not(#div1)").slideUp();
			}else{$(this).css("background","black");}
			
			$("#edit ul li #div1").slideToggle();
		});
		$("#edit ul li #div12").click(function (){
			$("#edit ul li header").css("background-color","black");
			
			$(this).css("background-color","#003326");
			if(!$("#edit ul li #div2").is(':visible'))
			$("#edit ul li div:not(#div2)").slideUp();
			else{$(this).css("background","black");}
			$("#edit ul li #div2").slideToggle();
		});
		$("#edit ul li #div13").click(function (){
			$("#edit ul li header").css("background-color","black");
			$(this).css("background-color","#003326");
			
			if(!$("#edit ul li #div3").is(':visible'))
			$("#edit ul li div:not(#div3)").slideUp();
			else{$(this).css("background","black");}
			$("#edit ul li #div3").slideToggle();
		});
		$("#edit ul li #div14").click(function (){
			$("#edit ul li header").css("background-color","black");
			$(this).css("background-color","#003326");
			
			if(!$("#edit ul li #div4").is(':visible'))
			$("#edit ul li div:not(#div4)").slideUp();
			else{$(this).css("background","black");}
			$("#edit ul li #div4").slideToggle();
		});
		$("#edit ul li #div15").click(function (){
			$("#edit ul li header").css("background-color","black");
			$(this).css("background-color","#003326");
			
			if(!$("#edit ul li #div5").is(':visible'))
			$("#edit ul li div:not(#div5)").slideUp();
			else{$(this).css("background","black");}
			$("#edit ul li #div5").slideToggle();
			
		});
		
	</script>
</html>