<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="notificationImpl" class="Service.NotificationImpl"></jsp:useBean>
<c:set var="notifications" value="${notificationImpl.watchingAnimesNotification(user.userName)}" target="java.util.ArrayList"/>
<link href="/Css/MenuStyle.css" rel="stylesheet">
<link href="/Css/style.css" rel="stylesheet">
<nav>
	<div class="Menu">
		<a href="/"><img class="Logo" alt="logo"
			src="/Image/LOGO.png"></a>
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
				src="${user.imageLink}">
				
				<c:choose>
				<c:when test="${notifications.size() eq 0}">
				<img
				class="Notification" alt="notification"
				src="/Image/bell.png">
				</c:when>
				<c:otherwise>
				<img
				class="Notification" alt="notification"
				src="/Image/ringingBell.png">
				</c:otherwise>
				</c:choose> 
				</c:if>
		</div>
		<div>
			<img class="Search" alt="search"
				src="/Image/Loupe.png"> <img
				class="SubMenuImg" alt="subMenu"
				src="/Image/subMenu.png">

		</div>
		<ul class="ProfileSubMenu">
			<a href="/profile"><li>Profile</li></a>
			<a href="/edit"><li>Edit</li></a>
			<c:if test="${user.type ne 'user'}">
			<a href="/panel/anime"><li>Panel</li></a>
			</c:if>
			<a href="/SignOut"><li>Sign out</li></a>
		</ul>
		<ul class="NotSubMenu">
		<c:forEach var="notification" items="${notifications}" >
			<li><a href="watch/${notification.anime.name.replace(' ','_')}/season_${notification.season.season}/episode_${notification.episode}"><p>${notification.anime.name}</p>
					<p>Episode ${notification.episode}</p></a></li>
			</c:forEach>
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
<script id="otksajax" ></script>
<script src="/Js/classes-ajax.js" ></script>
<script src="/Js/jquery-2.1.3.min.js"></script>
<script src="jquery-ui.min.js"></script>
<script src="/Js/Menu.js"></script>
