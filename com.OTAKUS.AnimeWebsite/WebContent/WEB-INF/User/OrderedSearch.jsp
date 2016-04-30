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
        padding: 2.4% 0;
        margin: 0;
}



article.AnimeList figure{
  margin: 0;
  padding:.5% 5%;
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
   margin: 0;
   padding:0;
}
</style>

<% AnimeImpl animeImpl=new AnimeImpl();
List<Anime> animes=animeImpl.getAll();
animes.stream().sorted();
%>
<c:out value="${animes.size()}"></c:out>
<c:forEach var="anime" items="${animes}" >
<c:out value="${anime.name}"></c:out>
</c:forEach>
  <ul id="alphaNav">
    
    <a href="##"><li>#</li></a>
   <a href="#a"><li>a</li></a>
    <a href="#b"><li>b</li></a>
    <a href="#c"><li>c</li></a>
    <a href=""><li>d</li></a>
    <a href=""><li>e</li></a>
    <a href=""><li>f</li></a>
    <a href=""><li>g</li></a>
    <a href=""><li>h</li></a>
    <a href=""><li>i</li></a>
    <a href=""><li>j</li></a>
    <a href=""><li>k</li></a>
    <a href=""><li>l</li></a>
    <a href=""><li>m</li></a>
    <a href=""><li>n</li></a>
    <a href=""><li>o</li></a>
    <a href=""><li>p</li></a>
    <a href=""><li>q</li></a>
    <a href=""><li>r</li></a>
    <a href=""><li>s</li></a>
    <a href=""><li>t</li></a>
    <a href=""><li>u</li></a>
    <a href=""><li>v</li></a>
    <a href=""><li>w</li></a>
    <a href=""><li>x</li></a>
    <a href=""><li>y</li></a>
    <li><a href="">z</a></li>
  </ul>
  <article class="AnimeList">
    <h3 id="#">#</h3>
        <figure>
      <a href=""><span class="AnimeName">Hunter x Hunter [3]</span></a> 
      <span>completed</span>           
      </figure>
   
  </article>
  
  <article class="AnimeList">
    <h3 id="a">a</h3>
   
       <figure>
      <a href=""><span class="AnimeName">Hunter x Hunter</span></a> 
      <span>copmleted</span>           
      </figure>
   
     
   
  </article>
