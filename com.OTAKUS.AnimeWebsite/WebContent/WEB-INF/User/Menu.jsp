<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/Css/MenuStyle.css" rel="stylesheet">
<nav>
	<div class="Menu">
		<a href="/"><img class="Logo" alt="logo"
			src="http://localhost:8090/Image/LOGO.png"></a>
		<div>
		<form action="/search" method="get">
			<input type="search" placeholder="Try new Anime" name="search" >
			</form>
		</div>
		<c:choose>
		<c:when test="${user eq null}">
		<div>
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="/search">search</a></li>
				<li><a href="/signin">login</a></li>
			</ul>
		</div></c:when>
		<c:otherwise>
		<div class="Floated">
			<ul>
				<li><a href="/profile">Profile</a></li>
				<li><a href="/search">Search</a></li>
				<li><a href="/">Home</a></li>
			</ul>
		</div>
		</c:otherwise>
		</c:choose>
		
		<div>
		<c:if test="${user ne null}">
			<img class="Profile" alt="profile"
				src="${user.imageLink}"> <img
				class="Notification" alt="notification"
				src="http://localhost:8090/Image/bell.png">
				</c:if>
		</div>
		<div>
			<img class="Search" alt="search"
				src="http://localhost:8090/Image/Loupe.png"> <img
				class="SubMenuImg" alt="subMenu"
				src="http://localhost:8090/Image/subMenu.png">

		</div>
		<ul class="ProfileSubMenu">
			<a href="/profile"><li>Profile</li></a>
			<a href="/edit"><li>Edit</li></a>
			<a href="/SignOut"><li>Sign out</li></a>
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
<script src="/Js/jquery-2.1.3.min.js"></script>
<script src="jquery-ui.min.js"></script>
<script src="/Js/Menu.js"></script>
