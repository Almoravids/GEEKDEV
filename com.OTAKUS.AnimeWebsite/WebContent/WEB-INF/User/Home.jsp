<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!doctype HTML>
<html>
<head>
  
<style >
/*BLOCKs*/


body{
  background: url('Image/gokuKamehameha.png') no-repeat  100% 15% ,
  url('Image/opFist.png') -4% 18% no-repeat,
  rgb(14,14,14);
  -webkit-touch-callout: none;
 -webkit-user-select: none;
 -moz-user-select: none;
 -ms-user-select: none;
 user-select: none;
}
.blocks{
border: 1px solid #101010;
border-radius:3px;
background: rgba(0,0,0,.8);

}
header{
padding:0px;
margin-bottom:30px;
max-width:80%;
height:170px;
}
section{
width:77.12%;
}
aside{
width:20%;
}
section,aside{
display:inline-block;
vertical-align:top;
padding-bottom:20px;
margin-bottom:40px;
}

hr {
border: solid #101010 2px;
margin:0px;
padding:0px;
}

/*IMG + FIgure*/
.blocks img,figure{
  width:250px;
  display:inline-block;
}
.blocks img{
height:130px;
width:250px;
}

.blocks figure{
  margin:2px;
  height:155px;
}

 
 
header p:not(.head){
background : rgba(0,0,0,.7);
position:relative;
bottom:20.5px;
height:20px;
}
.blocks figure p,.head{
  font-family:Label;
  font-size:11px;
  color:white;
  display:inline-block;
  margin:0;
  padding:0px;
}
section.blocks figure p,aside.blocks figure p{
 margin-top:7px;
}

.EpLbl{
  width:40%;
  text-align:right;
  margin:0;
}
.AnimeLbl{
  text-align:left;
   width:60%;
}
.head{
padding-top:10px;
padding-bottom:4px;
width:60%;
}
@font-face{
  font-family:Label;
  src:url('Fonts/Aspex.ttf');
}

			
</style>
</head>

		<jsp:useBean id="animes" class="Service.AnimeImpl"></jsp:useBean>
        <jsp:useBean id="episodes" class="Service.EpisodeImpl"></jsp:useBean>
<body>
<center>
	<header class="blocks">
		<p class="head">Popular </p> <br>
		<hr>
		<c:forEach var="anime" items="${animes.popular}">
		<figure>
			  <a href="anime/${anime.name.replace(' ','_')}"> <img src="${anime.imageLink}" alt=""></a>
			   
			  <p class="AnimeLbl">${anime.name}</p><p class="EpLbl">${episodes.getLast(anime.animeId).episode} epiosdes</p>
		</figure>
</c:forEach>
		 
</header>
<section class="blocks">
			  <p class="head">Recently Added </p><br>
			  <hr>
		<c:forEach var="episode" items="${episodes.recent}">
		<figure>
			  <a href="watch/${episode.anime.name.replace(' ','_')}/season_${episode.season.season}/episode_${episode.episode}"><img src="${episode.imageLink}" alt="${episode.anime.name}"></a>
			   
			  <p class="AnimeLbl">${episode.anime.name}</p><p class="EpLbl">episode ${episode.episode}</p>
		</figure>
</c:forEach>
		
</section>
<aside class="blocks">
			<p class="head">New Animes </p><br>
			<hr>
		<c:forEach var="anime" items="${animes.recently}">
		<figure>
			   <a href="anime/${anime.name.replace(' ','_')}"><img src="${anime.imageLink}" alt=""></a>
			   
			  <p class="AnimeLbl">${anime.name}</p><p class="EpLbl">${episodes.getLast(anime.animeId).episode} epiosdes</p>
		</figure>
</c:forEach>
</aside>
</center>
</body>
</html>