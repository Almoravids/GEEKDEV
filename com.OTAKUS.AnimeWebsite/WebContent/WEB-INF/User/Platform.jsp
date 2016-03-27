<%@page import="beans.Season"%>
<%@page import="beans.Anime"%>
<%@page import="com.sun.org.apache.xpath.internal.FoundIndex"%>
<%@page import="java.util.List"%>
<%@page import="beans.Episode"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
<link rel="stylesheet" href="/Css/" />
<script src="/Js/jquery-2.1.3.min.js"></script>
<script src="/Js/jquery-ui.min.js"></script>
<style>

/*scroll */

/* Let's get this party started */
::-webkit-scrollbar {
	width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(10, 10, 10, 0.8);
	-webkit-border-radius: 10px;
	border-radius: 10px;
}

/* Handle */
::-webkit-scrollbar-thumb {
	-webkit-border-radius: 10px;
	border-radius: 10px;
	background: #008563;
}

/*
			::-webkit-scrollbar-thumb:window-inactive {
				background:#008563; 
			}
			*/
/***************************************************/
body {
	background: #111;
	font-family: palatino linotype;
}

#infoEp {
	color: white;
	margin-left: 200px;
}

#infoEp h3 {
	display: inline-block;
	vertical-align: baseline;
}

#infoEp #h3ep {
	margin-top: -5px;
}

#infoEp #imgfav {
	width: 30px;
	margin-left: 10px;
}

#infoEp h3:nth-child(2) {
	font-size: 1em;
}

#secP {
	margin: 10px auto;
}

#secP #videoy {
	width: 700;
	height: 380px;
	margin-left: 200px;
	border: 3px solid black;
}

#secP #videoy, #episodes {
	display: inline-block;
	vertical-align: middle;
}

#episodes ul {
	list-style: none;
	margin: 0;
	padding: 0;
	color: white;
	background: rgba(10, 10, 10, 0.8);
	border: 3px solid rgba(10, 10, 10, 0.8);
	width: 250px;
	height: 380px;
	margin-left: 20px;
	overflow: scroll;
	overflow-x: hidden;
	border-radius: 5px;
}

#episodes li {
	text-align: center;
	border-bottom: 1px #111 solid;
	margin: 0;
	padding: 4px 0;
	vartical-align: middle;
	color: #008563;
}

#episodes li p {
	padding: 0;
	margin: 1px;
	font-size: 0.8em;
	opacity: 0.8;
}

#episodes li a {
	text-decoration: none;
	color: white;
	opacity: 0.8;
}

#episodes li a:hover {
	opacity: 1;
}

#infoEp #h31 {
	text-transform: capitalize;
	font-size: 1.5em;
}

#infoEp #h31+h3 {
	text-indent: 10px;
	text-weight: normal;
}

#comments {
	background: rgba(10, 10, 10, 0.8);
	width: 708;
	margin-left: 200px;
	padding-bottom: 30px;
	display: none;
}

#hcomm p, img {
	color: white;
	display: inline-block;
	vertical-align: middle;
}

#hcomm {
	border-radius: 5px;
	background: rgba(10, 10, 10, 0.8);
	margin-left: 200px;
	width: 708;
	border-bottom: 3px solid #111;
	padding-top: 5px;
	padding-bottom: 5px;
}

#hcomm img {
	margin-left: 550px;
}

#hcomm img:hover {
	cursor: pointer;
}

#hcomm p {
	padding-left: 20px;
	opacity: 0.8;
}

#comments #img2 {
	position: relative;
	top: 65px;
	left: -180px;
	width: 50px;
	height: 50px;
	border-radius: 5px;
}

#comments input[type="textarea"] {
	position: relative;
	width: 520px;
	height: 50px;
	font-size: 1.2em;
	border-radius: 5px;
	top: 10px;
	left: 100px;
	color: #008563;
}

#comments input[type="button"] {
	margin-left: 640px;
	margin-top: -35px;
	height: 40px;
	padding-left: 20px;
	padding-right: 20px;
	border: 1px solid white;
	border-radius: 0 0 2px 2px;
	background:
		URL('https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_keyboard_arrow_right_48px-48.png')
		no-repeat center center white;
	color: black;
	border-radius: 5px;
}

#comments input[type="button"]:hover {
	cursor: pointer;
}

#comments #img1 {
	position: relative;
	top: 0px;
	left: 400px;
}

#comments #img1:hover {
	cursor: pointer;
}

#comments span:nth-child(3) {
	position: relative;
	top: 0px;
	left: 500px;
	color: white;
	font-size: 1em;
}

#comments span:nth-child(1) {
	position: relative;
	top: 0px;
	left: 20px;
	color: white;
	font-size: 1em;
}

#comments span:nth-child(2) {
	position: relative;
	top: 0px;
	left: 30px;
	color: white;
	font-size: 1em;
}

#comments hr {
	margin-top: 30px;
	border: 2px solid #111;
	width: 96%;
}

#comments #img3 {
	float: left;
	width: 70px;
	height: 70px;
}

#comments #infocom {
	width: 550px;
	min-height: 70px;
	max-height: 500px;
	overflow: hidden;
	color: white;
}

#comments  #infocom p {
	margin-left: 30px;
}

#comments article {
	margin: 20px;
	border-bottom: 1px solid #008563;
}

#comments article #infocom span:nth-child(1) {
	color: #008563;
}

#comments article #infocom span:nth-child(2) {
	opacity: 0.8;
	font-size: 0.8em;
}
</style>
</head>
<body>
	<div id="infoEp">


		<h3 id="h31">${requestScope.anime.name}</h3>
		<h3>Season ${requestScope.season.season}</h3>
		<br>
		<h3 id="h3ep">Episode ${requestScope.episode.episode}&nbsp; :
			&nbsp; &nbsp; &nbsp;${requestScope.episode.name}</h3>
	</div>
	<c:set var="found" value="false" />
	<section id="secP"> <iframe id="videoy"
		src="${requestScope.episode.getLink()}" frameborder="0"
		allowfullscreen></iframe> <aside id="episodes">

	<ul>
		<c:forEach var="episode" items="${allEpisodes}">
			<c:if test="${episode.episode > requestScope.episode.episode}">
				<c:set var="link"
					value="/watch/${anime.name.replace(' ','_')}/season_${season.season}/episode_${episode.episode}"></c:set>
				<li><a href="${link}">Episode ${episode.episode}</a>
					<p>${anime.name}</p></li>
				<c:set var="found" value="true" />
			</c:if>

		</c:forEach>
		<c:if test="${found==false}">
			<li><a href="#"> No Other Episodes </a>
				<p>${anime.name}</p></li>
		</c:if>
	</ul>


	</aside> </section>


	<div id="hcomm">
		<p>Comments</p>
		<img
			src="https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_keyboard_arrow_down_48px-32.png"
			id="imgcom" />
	</div>
	<section id="comments"> <span>3 Comments</span> <span>Otakus</span>
	<span>Login</span> <img
		src="http://icons.iconarchive.com/icons/hopstarter/malware/32/Notification-icon.png"
		id="img1" /> <img
		src="http://1.gravatar.com/avatar/
			d8b77337f59c435c2588af2c26561357?s=256&d=http%3A%2F%2F1.gravatar.com%2Favatar%2Fad516503a11cd5ca435acc9bb6523536%3Fs%3D256&r=G"
		id="img2" /> <input type="textarea" placeholder="Join the discussion" />
	<br>
	<input type="button" />
	<hr>
	<article> <img src="/Image/Avatars/001.png" id="img3" />

	<div id="infocom">
		<span>Wassim</span><span>5 Day ago</span>
		<p>Nice Episode</p>
	</div>
	</article> <article> <img src="/Image/Avatars/002.png" id="img3" />

	<div id="infocom">
		<span>Mahdi</span><span>5 Day ago</span>
		<p>dragon ball is the best</p>
	</div>
	</article> <article> <img src="/Image/Avatars/003.png" id="img3" />

	<div id="infocom">
		<span>Anas</span><span>7 Day ago</span>
		<p>i hate tokyo goul</p>
	</div>
	</article> </section>

</body>
<script>
	$(document).ready(function() {
		$("#imgcom").click(function() {
			$("#comments").slideToggle();
			$('html, body').animate({
				scrollTop : 100
			}, 800);
		});

	});
</script>
</html>