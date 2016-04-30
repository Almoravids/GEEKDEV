<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				width:70%;
				border-top:3px solid #008563;
				border-bottom:3px solid #008563;
				margin-top:-16px;
				margin-bottom:20px;
				
			}
			#infoanime{
			
			background:black;
			border-radius:4px;
				width:100%;
				height:160px;
				margin:.3% 0;
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
		<c:if test="${animes.size() eq 0}">
		<c:out value="Result Not Found"></c:out>
		</c:if>
		<c:forEach  var="anime" items="${animes}">
		<a id="infoanime" href="anime/${anime.name.replace(' ','_')}">
			<img src ="${anime.imageLink}" id="imganime" />
			<article id="desc"><h3>${anime.name}</h3><h6>${anime.stringStatue}</h6><br>
			<c:forEach var="alias" items="${anime.alias}" >
                   <h5>${alias.alias}</h5>
             </c:forEach>                   
  <p>${anime.description}</p>
 <c:forEach var="genre" items="${anime.genre}" >
                   <h5>genre.type</h5>
             </c:forEach>  
  </article>
			<img  src ="Image/fav.png" id="favimg" />				
			
		</a>
		</c:forEach>
		</div>
	
	