<html>
	
	<head>
		<title>Connection</title>
		<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
		
		
		<style>
			body{
				font-family:arial;
				background:rgb(10,10,10);
				
			}
			#connbox{
				color:#008563;
				margin:0 auto;
				margin-top:15%;
				padding:3% 0.5%;
				width:40%;
				background:black;
			}
			#connbox form,table{
				width:100%;
			}
			#connbox input[type="text"],input[type="password"],input[type="submit"]{
				padding:7px;
				width:50%;
				margin-left:26%;
				margin-top:2px;
				border-radius:2px;
				border:1px solid black;
			}
			#connbox h3{
				font-size:1.9em;
				width:100%;
				margin-top:-20px;
				margin-bottom:0px;
				margin-left:43%;
			}
			#connbox input[type="submit"]{
				
				margin-top:10px;
				padding-top:10px;
				padding-bottom:10px;
				border:1px  #003326 solid;
				background-color:#003326;
				color:white;
				
			}
			#connbox input[type="submit"]:hover{
				border:1px  #008563 solid;
				background-color :#008563;
				color:white;
				cursor:pointer;
				
			}
			#connbox a{
				margin-left:39%;
				color:#008563;
				text-decoration:none;
				opacity:0.8;
			}
			#connbox a:hover{
				text-decoration:underline;
			}
			#connbox hr{
				
				padding:0;
				width:99%;
				border:2px solid rgb(10,10,10);
				margin-bottom:25px;
			}
			
		
			
			
		</style>
	</head>	

	<body>
		<section id="connbox">
			<h3>Login </h3>
			<hr>
			
			<form action="SignIn" method="post">
				<table>
					<tr><td><input type="text" name="username" id="username" placeholder="Username" /></td></tr>
					<tr><td><input type="password" name="password" id="pass" placeholder="Password" /></td></tr>
					
				</table>
					<input type="submit" value="Sign In">
			</form>
			<a href="signup">Sign Up to Otakus</a>
		</section>
	</body>


</html>