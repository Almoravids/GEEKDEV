<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
	
		
		<style>
			body{
			background:rgb(10,10,10);
			}
			#navprofile {
				margin-top:5%;
				margin-left:20%;	
			}
			#navprofile form input[type="button"]{
			
				font-variant: small-caps;
				text-transform:lowercase;
				border:1px #008563 solid;
				background-color:#003326;
				color:white;
				cursor:pointer;
				padding:0px;
				margin:0px;
				margin-left:30px;
				width:15%;
				height:10%;
				border-radius:5px;
			}
			#navprofile form input[type="button"]:hover{
				box-shadow: 0 0 20px 6px  #008563 inset;
				background-color:#003326;
				border:1px #003326 solid;
			
			}
			#navanime {
				color:white;
				margin-top:5%;
				margin-left:200px;
			}
			#navanime ul{
				margin-top:30px;
				list-style:none;
				padding:0;
			}
			#navanime ul li {
				background-color:#003326;	
				display:inline-block;
				padding:10px;
				width:60px;
				margin-left:0.1px;
				padding:13px;
				font-variant: small-caps;
				border-radius:5px 5px 0 0;
			}
			
			#navanime ul li:first-child{
				background-color:#008563;	
				padding:13px;
			}
			#navanime ul li:hover{
				background-color:#008563;	
				cursor:pointer;
			}
			
			
			#allsec{
				
				margin-left:200px;
				border:2px solid #008563;
				width:70%;
				margin-top:-16px;
				margin-bottom:20px;
				
			}
			#infoanime{
				width:100%;
				height:160px;
				border:1px solid #008563;
				margin:0;
				padding:0;
			}
			#infoanime,#desc,#favanime{
				display:inline-block;
				vertical-align:top;
				
			}
			#infoanime #imganime{
				margin:0;
				padding:0;
				width:30%;
				height:160px;
			}
			#infoanime #desc {
				margin-left:15px;
				width:60%;
				color:white;
				font-weight:normal;
				font-size:14px;
				padding-top:0;
			} 
			#favimg{
				width:32px;
				margin-top:30px;
				margin-right:20px;
				float:right;
			}
			
			#desc h3{
			font-size:20px;
			  width:85%;
			  margin:5px 0 0 0;
			  padding:0;
			}
		
			#desc h3,#desc h6{
			  display:inline-block;
			}
		
			#desc h5,#desc h6{
			font-size:15px;
			  font-variant:small-caps;
			  text-weight:normal;
			  text-transform:lowercase;
			display:inline;
			  margin:0;
			  padding:0 5px;
			}
			#desc p{
			font-family:arial,serif;
			  margin:0;
			  padding:5px 0;
			}
		
		</style>
		
	</head>
		<header id="navprofile">
			<form>
				
				<input type="button" id="lastseen" value="Last seen" />
				<input type="button" id="watching" value="Watching" />
				<input type="button" id="watched" value="Watched" />
				<input type="button" id="fav" value="Favorie" />
				<br><br>
				<input type="button" id="recommanded" value="Recommanded" />
				<input type="button" id="ongoing" value="Ongoing" />
				<input type="button" id="completed" value="Completed" />
				<input type="button" id="all" value="All" />
				
			</form>
		</header>
		
		<nav id="navanime">
			
			<ul>
				<li>Episode</li>
				<li>Movie</li>
			</ul>
		</nav>
		
		<div id="allsec">
		
		<section id="infoanime">
			<img src ="http://usercontent2.hubimg.com/12348073.jpg" id="imganime" />
			<article id="desc"><h3>Hunter x Hunter</h3><h6>completed</h6><br>
                   <h5>HXH</h5><h5>9anas</h5>                     
  <p>Seven kids are transported to the Digital World, a strange place where digital creatures called "Digimon" reside. A group of Digimon soon befriend them and keep the kids out of harm's way. The children then discover they are the Chosen Children, which protect the Digital World from evil Digimon like Devimon and Vamdemon.</p>
  <h6>action</h6><h6>adventure</h6>
  </article>
			<img  src ="Image/fav.png" id="favimg" />				
			
		</section>
		<section id="infoanime">
			<img src ="Image/slider/img3.png" id="imganime" />
			<article id="desc"><h3>Hunter x Hunter</h3><h6>completed</h6><br>
                   <h5>HXH</h5><h5>9anas</h5>                     
  <p>Seven kids are transported to the Digital World, a strange place where digital creatures called "Digimon" reside. A group of Digimon soon befriend them and keep the kids out of harm's way. The children then discover they are the Chosen Children, which protect the Digital World from evil Digimon like Devimon and Vamdemon.</p>
  <h6>action</h6><h6>adventure</h6>
  </article>
			<img src ="Image/fav.png" id="favimg" />				
			
		
			
		</section>
		<section id="infoanime">
			<img src ="Image/slider/img4.jpg" id="imganime" />
			<article id="desc"><h3>Digimon</h3><h6>ongoing</h6><br>
                   <h5>digimon</h5><h5>digital Heros</h5>                     
  <p>Seven kids are transported to the Digital World, a strange place where digital creatures called "Digimon" reside. A group of Digimon soon befriend them and keep the kids out of harm's way. The children then discover they are the Chosen Children, which protect the Digital World from evil Digimon like Devimon and Vamdemon.</p>
  <h6>action</h6><h6>adventure</h6>
  </article>
			<img src ="Image/noFav.png" id="favimg" />				
			
		</section>
		</div>
	
	