<%@page import="java.util.List"%>
<%@page import="Service.AnimeImpl"%>
<%@page import="beans.Anime"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style >
body{
  background:rgb(10,10,10);
  padding:0;
  margin:0;
}
ul#alphaNav{
  width:75%;
  padding:0;
  margin:5% auto;
}
ul#alphaNav li{
  background:black;
  display:inline-block;
  border:1px rgb(10,10,10) solid;
  padding:.7% 1.2%;
  margin:0.05% -2px;
}
ul#alphaNav  a{
  color:#008563;
  text-transform:uppercase;
  text-decoration:none;
   padding:0;
  margin:0;
}

ul#alphaNav a:hover{
  color:black;
}
ul#alphaNav li:hover{
  background:#008563;
}
article.AnimeList{
  
    vertical-align:top; 
    color:#008563;
    background:rgba(0,0,0,.5);
    text-transform:capitalize;
  	width:45%;
    border-radius:2px 2px 0 0;
    display:inline-block;
    margin:2%
}
article.AnimeList h3{
  	    color:white;
				background:#008563;
        text-indent:4%;
        text-transform:uppercase;
        font-weight:normal;
				border:2px #008563 solid;
				border-radius:2px;
        padding: 1% 0;
        margin: 0;
}



article.AnimeList figure{
  margin: 0;
  padding:.8% 5%;
  border-bottom:1px solid rba(10,10,10);
}
article.AnimeList figure a{
  color:#008563;
}
article.AnimeList figure span.AnimeName{
  display:inline-block;
}
article.AnimeList figure a+span{
   color:gray;
  font-size:12px;
  float:right;
   margin: 0;
   padding:0;
}
</style>

  <ul id="alphaNav">
    
    <li><a href="##">#</a></li>
   <li><a href="#a">a</a></li>
    <li><a href="#b">b</a></li>
    <li><a href="#c">c</a></li>
    <li><a href="#d">d</a></li>
    <li><a href="#e">e</a></li>
    <li><a href="#f">f</a></li>
    <li><a href="#g">g</a></li>
    <li><a href="#h">h</a></li>
    <li><a href="#i">i</a></li>
    <li><a href="#j">j</a></li>
    <li><a href="#k">k</a></li>
    <li><a href="#l">l</a></li>
    <li><a href="#m">m</a></li>
    <li><a href="#n">n</a></li>
    <li><a href="#o">o</a></li>
    <li><a href="#p">p</a></li>
    <li><a href="#q">q</a></li>
    <li><a href="#r">r</a></li>
    <li><a href="#s">s</a></li>
    <li><a href="#t">t</a></li>
    <li><a href="#u">u</a></li>
    <li><a href="#v">v</a></li>
    <li><a href="#w">w</a></li>
    <li><a href="#x">x</a></li>
    <li><a href="#y">y</a></li>
    <li><a href="z">z</a></li>
  </ul>
  <jsp:useBean id="animeImpl" class="Service.AnimeImpl" />
  <jsp:useBean id="episodeImpl" class="Service.EpisodeImpl" />
  <c:set var="letter" value=""  target="String"/>
<c:forEach var="anime" items="${animeImpl.all}">

<c:if test="${!letter.equals(anime.name.charAt(0))}">

<c:if test="${!letter.equals('')}">
  </article>
</c:if>
<article class="AnimeList">
</c:if>
  <c:choose>
  <c:when test="${anime.name.matches('^[a-zA-Z].*$')}">
  <c:set var="letter" value="${anime.name.charAt(0)} " target="String"/>
  </c:when>
  <c:otherwise>
  <c:set var="letter" value="#" target="String"/>
  </c:otherwise>
  </c:choose> 
    <h3 id="${letter}">${letter}</h3>
        <figure>
      <a href="/anime/${anime.name.replace(' ','_')}"><span class="AnimeName">${anime.name} [${episodeImpl.getLast(anime.animeId).episode}]</span></a> 
      <span>${anime.stringStatus}</span>           
      </figure>
   
    
  
 </c:forEach>
       </article>