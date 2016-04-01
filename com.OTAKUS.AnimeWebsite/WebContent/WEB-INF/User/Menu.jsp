<%@page import="beans.Visitor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user eq null}">
<%@include file="Dialoge.jsp" %>
</c:if>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="/Css/AdminMenu.css"/>
<script src="/Js/jquery-2.1.3.min.js"></script>
<script src="/Js/jquery-ui.min.js"></script>
<link rel="icon" href="/Image/LOGO.png" />
</head>
<body>

<nav id="MenuNav">
	
	<a href="/home"><img id="logo"src="/Image/LOGO.png" /></a> 
	
	<c:choose>
	<c:when test="${user!=null}">
	 <ul id="userNav" class="HiddenNav">
		<input type="search" name="search" id="search" />
	<div>
		<li>${user.userName}</li>
		<li>Search</li>
		<li>Home</li>
	</div>
	</ul>
		<img id="userImg" src="${user.imageLink}" />
		
	 	<img  id="notifications"src="/Image/ringingBell.png" />
	</c:when>
	<c:otherwise>
	<ul id="ulnav" class="HiddenNav">
	<input type="search" name="search" id="search" />
	<div>
		<li>Home</li>
		<li>Search</li>
		<li>Login</li>
	</div>
	
	</ul>
	</c:otherwise>
	</c:choose>

	<img id="Loupe" src="/Image/Loupe.png" />
</nav>
<script>
	$(document).ready(function (){
		$("#Loupe").click(function (){

			   $('.HiddenNav div').fadeToggle(20);
				$('.HiddenNav #search').fadeToggle(20);
		});
		
		$('.HiddenNav li').click(function(){
			if($(this).text().toLowerCase()=='search'||$(this).text().toLowerCase()=='home')
			window.open("/"+$(this).text().toLowerCase(),'_top');
			else if($(this).text().toLowerCase()=='login')
				$('#background').css('visibility','visible');
			else window.open('/profile','_top');
		});
		
		document.onscroll=function(){
			var a=window.pageYOffset;
			if(a>=60 && document.body.offsetHeight >=700){
				$('#MenuNav').css({'position':'fixed','top':'0px','width':'100%','opacity':'0.5px'});
				}
			else
				$('#MenuNav').css({'position':'relative','width':'auto'});
		}
		});

</script>
</body>
</html>