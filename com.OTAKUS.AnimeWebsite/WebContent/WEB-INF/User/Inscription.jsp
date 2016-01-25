<%@page import="pack.Method"%>
<%@page import="pack.Visitor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype HTML>
<html>
	<head>
		
		<meta charset="ISO-8859-1" />
		<script src="../Js/jquery-2.1.3.min.js"></script>
		<script src="../Js/jquery-ui.min.js"></script>
		<style>
			body{
				
				-webkit-touch-callout: none;
				-webkit-user-select: none;
				-moz-user-select: none;
				-ms-user-select: none;
				user-select: none;
				font-family:Palatino Linotype;
				padding:0;
				margin:0;
				background:url('Image/InscriptionBody.png') no-repeat 50% 80% rgb(10,10,10);
			}
			
			#form table input[type="text"],#form table input[type="password"],#form table input[type="email"]{
				padding :3px;
				width:300px;
				border-radius:3px;
				
			}
			
			#form input[type="file"]{
			color:white;
			}
			#form form label{
				color:white;
				font-size:18px;
				
			}
			
			#form table td:first-child{
				padding-right:100px;
				color:white;
				
			}
		
			#form table td label sup {
				color:red;
			}
			#form table td{
				padding-top:25px;
			}
			
			#form input[type="submit"],input[type="reset"]{
				
				border:1px  #003326 solid;
				background-color:#003326;
				color:white;
				margin:5px;
				padding:5px;
				margin-top:15px;
				padding:10px;
				padding-left:20px;
				padding-right:20px;
				border-radius:2px;
				margin-bottom:10px;
			} 
			#form input[type="reset"]{
				margin-left:380px;
			}

			#form input[type="submit"]:hover,input[type="reset"]:hover{
				border:1px  #008563 solid;
				background-color:#008563;
				color:white;
				cursor:pointer;
				
			}
			#form form{
				background:rgba(0,0,0,0.6);
				color:black;
				margin-top:30px;
				margin-bottom:30px;				
				min-height:74%;
			}
		
			#form form hr{
				border:3px rgb(10,10,10) solid;
				margin:0px;
				padding:0px;
			}
			#form form h1{
				margin:0;
				padding:0;
				padding-bottom:10px;
				padding-top:10px;
				color:#008563 ;
			}
			
			@font-face{
			
				font-family:am;
				src:url('../Fonts/Roboto-Regular.ttf');
			} 
			
			                                                    /**NEW MODIFICATION**/
			
			#form #avatar {
				width:310px;
				height:60px;
				overflow:hidden;
				padding:2px 5px;
			}
			
			#form #avatar figure img{
				width:60px;
			    margin:0;
				padding: 0;
				box-shadow:inset 0 0 20px rgba(0,0,0,.7);
			}
			#form #avatar  img:hover{
				cursor:pointer;
			}
			
			.arrows{
			  width:16px;
			  height:16px;
			  margin:0;
			  padding:0;
			  position:relative;
			  bottom:40px;
			  cursor:pointer;	
			  opacity:.6;
			}
			.arrows:hover{
			  opacity:1;
			}
			#leftArrow{
			  left:0%;
			}
			#rightArrow{
			float:right;
			}
			#form #avatar figure {
				width: 1020px;
				height:300px;
				margin: 0;
				padding: 0;
			}
			#radios{
			margin:0;
			padding:10px 0;
			}
			#form div span{
			color:white;
			margin:0 5px;
			padding:0;
			vertical-align:middle;
			}
			#link,#upload{
			display:none;}
			#uploadr,#avatarr,#linkr{
			color:white;
			margin:0;
			padding:0;
			vertical-align:middle;
			}
	
		</style>
	</head>
	<%
	if (request.getParameter("name")!=null){
		Method h=(Method)Method.getcontext();
		Visitor visitor=new Visitor();
		visitor.setUserName(request.getParameter("username"));
		visitor.setName(request.getParameter("name"));
		visitor.setLastName(request.getParameter("lastName"));
		visitor.setEmail(request.getParameter("email"));
		visitor.setPassword(request.getParameter("password"));
		if (request.getParameter("avatar")!=null)
		visitor.setImageLink(request.getParameter("avatar"));
		else if (request.getParameter("upload")!=null)
		visitor.setImageLink(request.getParameter("upload"));
		else if (request.getParameter("link")!=null)
			visitor.setImageLink(request.getParameter("link"));
		visitor.setType(request.getParameter("type"));
		h.insertUser(visitor);
	}
	%>
	<body>
	
		<section id="form"  method="get">
			<form>
				<center>
				<h1><%="Inscription"%></h1>
				<hr>
				<table>
					<tr><td><label>Username:<sup>*</sup></label></td><td><input type="text" name="username" required></td></tr>
					<tr><td><label>Name:<sup>*</sup></label></td><td><input type="text" name="name" required></td></tr>
					<tr><td><label>Last Name:<sup>*</sup></label></td><td><input type="text" name="lastName" required></td></tr>
					<tr><td><label>Email:<sup>*</sup></label></td><td><input type="email" name="email" required></td></tr>
					<tr><td><label>Password:<sup>*</sup></label></td><td><input type="password" name="password" required></td></tr>
					<tr><td><label>Confirm Password:<sup>*</sup></label></td><td><input type="password"  required></td></tr>
					<tr><td ><label>Choice image:<sup>*</sup></label></td><td>
			           <div id="radios">
			           		<span>Avatars</span><input type="radio" id="avatarr" value="avatarr" name="imgChoice" checked>
						    <span>Upload</span><input type="radio" id="uploadr" value="uploadr" name="imgChoice">
							<span>Link</span><input type="radio" id="linkr" value="linkr" name="imgChoice">
				       </div>
						<div id="avatar">
						<input type="hidden" name="avatar">
								<figure>
								<img src="Image/Avatars/001.png" alt="avatar"/>
								<img src="Image/Avatars/002.png" alt="avatar"/>
								<img src="Image/Avatars/003.png" alt="avatar"/>
								<img src="Image/Avatars/004.png" alt="avatar"/>
								<img src="Image/Avatars/005.png" alt="avatar"/>
								<img src="Image/Avatars/006.png" alt="avatar"/>
								<img src="Image/Avatars/007.png" alt="avatar"/>
								<img src="Image/Avatars/008.png" alt="avatar"/>
								<img src="Image/Avatars/009.png" alt="avatar"/>
								<img src="Image/Avatars/010.png" alt="avatar"/>
								<img src="Image/Avatars/011.png" alt="avatar"/>
								<img src="Image/Avatars/0012.png" alt="avatar"/>
								<img src="Image/Avatars/0013.png" alt="avatar"/>
								<img src="Image/Avatars/0014.png" alt="avatar"/>
								<img src="Image/Avatars/0015.png" alt="avatar"/>
								</figure>
						</div>
						<img  class="arrows" id="leftArrow" src="Image/left-slider.png" alt="" onclick="slideright()" >
						 <img class="arrows" id="rightArrow" src="Image/right-slider.png" alt="" onclick="slideleft()">
						
						<input type="file" name="upload" id="upload">
						<input type="text" name="link" id="link">
						
					</td></tr>
				</table>	
				<input type="reset" value="Clear" />
				<input type="submit" value="Sing in" />
				</center>
				
			</form>
				
		</section>
		<script>
		var $sl=$("#form #avatar figure");
		var s=document.querySelector('#form #avatar figure img').offsetWidth+4.5;
		var length=$("#form #avatar figure img").length;
		var c=1;
		function slideleft(){
			if(c<length-5){
				c++;
			$sl.animate({'margin-left' : '-='+s+'px'},100);
			}
		}
		function slideright(){
			if(c>1){
				c--;
			$sl.animate({'margin-left' : '+='+s+'px'},100);
			}
		}
		$("#form #avatar figure img").click(function (){
			$("#form #avatar figure img").css('box-shadow','inset 0 0 20px rgba(0,0,0,.7)');
			$(this).css('box-shadow','0 0 25px  #008563 inset');
		    $("#form #avatar input[type='hidden']").val($("#form #avatar figure img").attr('src'));
		});
		$("#form #radios input[type='radio']").change(function(){
			$("#form #avatar").css('display','none');
			$("#form  .arrows").css('display','none');
			$("#form #upload").css('display','none');
			$("#form #link").css('display','none');
			if($("#form #radios input[type='radio']:checked").attr('id')=="avatarr"){
				$("#form #avatar").css('display','block');
				$("#form  .arrows").css('display','inline');
			}
			else if ($("#form #radios input[type='radio']:checked").attr('id')=="linkr"){
				$("#form #link").css('display','block');
			}
			else
				$("#form #upload").css('display','block');
			
		});
		
		</script>
	
			
	</body>


</html>