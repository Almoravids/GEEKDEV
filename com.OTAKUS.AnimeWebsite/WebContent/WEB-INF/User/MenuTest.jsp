
<link href="/Css/MenuStyle.css" rel="stylesheet">

<nav>
	<div class="Menu">
		<a href="/"><img class="Logo" alt="logo"
			src="http://localhost:8090/Image/LOGO.png"></a>
		<div>
			<input type="search" placeholder="Try new Anime">
		</div>
		<div>
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="search">search</a></li>
			</ul>
		</div>
		<div>
			<img class="Profile" alt="profile"
				src="http://localhost:8090/Image/Avatars/003.png"> <img
				class="Notification" alt="notification"
				src="http://localhost:8090/Image/bell.png">
		</div>
		<div>
			<img class="Search" alt="search"
				src="http://localhost:8090/Image/Loupe.png"> <img
				class="SubMenuImg" alt="subMenu"
				src="http://localhost:8090/Image/subMenu.png">

		</div>
		<ul class="ProfileSubMenu">
			<li><a href="/profile">Profile</a></li>
			<li><a href="/edit">Edit</a></li>
			<li><a href="/SignOut">Sign out</a></li>
		</ul>
		<ul class="NotSubMenu">
			<li><a href="#"><p>Dragon ball super</p>
					<p>Episode 23</p></a></li>
			<li><a href="#"><p>Dragon ball super</p>
					<p>Episode 23</p></a></li>
			<li><a href="#"><p>Dragon ball super</p>
					<p>Episode 23</p></a></li>
			<li><a href="#"><p>Dragon ball super</p>
					<p>Episode 23</p></a></li>
		</ul>
	</div>
	<div class="SubMenu">
		<ul>
			<li><a href="/search?action=All">ALL</a></li>
			<li><a href="/search?action=Completed">Completed</a></li>
			<li><a href="/search?action=Ongoing">On going</a></li>
			<li><a href="/search?action=Comingsoon">Coming soon</a></li>
			<li><a href="/search?action=Favorite">Favorite</a></li>
			<li><a href="/search?action=Watched">Watched</a></li>
			<li><a href="/search?action=Watching">Watching</a></li>
			<li><a href="/search?action=Lastseen">Last seen</a></li>
			<li><a href="/search?action=Recommanded">Recommanded</a></li>
		</ul>
	</div>
</nav>

<script src="/Js/Menu.js"></script>



<%-- <%@page import="beans.Visitor"%> --%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%-- <c:if test="${user eq null}"> --%>
<%-- <%@include file="Dialoge.jsp" %> --%>
<%-- </c:if> --%>
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->

<!-- <link rel="stylesheet" href="/Css/AdminMenu.css"/> -->
<!-- <script src="/Js/jquery-2.1.3.min.js"></script> -->
<!-- <script src="/Js/jquery-ui.min.js"></script> -->
<!-- <link rel="icon" href="/Image/LOGO.png" /> -->
<!-- </head> -->
<!-- <body> -->

<!-- <nav id="MenuNav"> -->
	
<!-- 	<a href="/home"><img id="logo"src="/Image/LOGO.png" /></a>  -->
	
<%-- 	<c:choose> --%>
<%-- 	<c:when test="${user!=null}"> --%>
<!-- 	 <ul id="userNav" class="HiddenNav"> -->
<!-- 		<form action="/search"> -->
<!-- 	<input type="search" name="search" id="search" /> -->
<!-- 	</form> -->
<!-- 	<div> -->
<%-- 		<li>${user.userName}</li> --%>
<!-- 		<li>Search</li> -->
<!-- 		<li>Home</li> -->
<!-- 	</div> -->
<!-- 	</ul> -->
<%-- 		<img id="userImg" src="${user.imageLink}" /> --%>
		
<!-- 	 	<img  id="notifications"src="/Image/ringingBell.png" /> -->
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
<!-- 	<ul id="ulnav" class="HiddenNav"> -->
<!-- 	<form action="/search"> -->
<!-- 	<input type="search" name="search" id="search" /> -->
<!-- 	</form> -->
<!-- 	<div> -->
<!-- 		<li>Home</li> -->
<!-- 		<li>Search</li> -->
<!-- 		<li>Login</li> -->
<!-- 	</div> -->
	
<!-- 	</ul> -->
<%-- 	</c:otherwise> --%>
<%-- 	</c:choose> --%>

<!-- 	<img id="Loupe" src="/Image/Loupe.png" /> -->
<!-- </nav> -->