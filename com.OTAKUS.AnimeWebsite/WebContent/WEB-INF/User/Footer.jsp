<!doctype HTML>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
		<script src="../Js/jquery-2.1.3.min.js"></script>
		<script src="../Js/jquery-ui.min.js"></script>
		<style>
		#footer{
				margin-top:50px;
				position:relative;
				bottom:0;
				padding:0;
				background:black;
				width:99.74%;
				height:100px;
				border:2px solid black;
			}
		
			#footer img:nth-child(1){
			
				margin-left:500px;
			}
			
			#footer #up{
		
				position:absolute;
				width:30px;
				margin-top:-40px;
				margin-left:1300px;
				float:left;
			}
			#footer img {
				margin-top:10px;
				width:50px;
				margin-left:20px;
				opacity:0.8;	
				
			}
			#footer img:hover{
				opacity:1;
				cursor:pointer;
			} 
			
			#footer #s1{
			
				display:inline-block;
				margin-top:26px;
				color:white;
				margin-left:10px;
				vertical-align:top;
				display:none;
			}
			#footer hr{
				border:2px solid rgb(10,10,10);
			}
			#footer #team{
		
				padding-top:10px;
				color:white;
				font-size:0.8em;
				margin-left:540px;
			}
			#footer #copy{
			margin:0;
			padding:0;
				color:white;
				font-size:0.6em;
				margin-left:558px;
				margin-top:-10px;
			}
			#footer #f2{
				margin-top:-5px;
				width:100%;
				background-color:#003326;
				height:60px;	
			}
			
			
		</style>
	</head>
	
	<body>
		
		<footer id="footer">
			<img src="/Image/facebook.png" >
			<img src="/Image/twitter.png" >
			<img src="/Image/gmail.png" >
			<img src="/Image/phone.png" >
			<span id="s1">+212671424705</span><br>
			<img src="/Image/nav.png"  id="up">
			
			<div id="f2">
				<p id="team">Created with &#10084 By Otakus team</p>
				<p id="copy">Copyright &copy; 2015 all right reserved</p>
				
			</div>
		</footer>
	
	<script>
		
		$("#footer img:nth-child(4)").click(function (){
				$("#footer #s1").slideToggle(1000);
		});
		$("#footer #up").click(function (){
				$("body").animate({"scrollTop":"0"},1000);
		});
		
	
	</script>
	
	</body>
	
</html>