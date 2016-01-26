<!DOCTYPE html>

<html>
<head>
  <meta charset="utf-8">
  <title>Page Not Found</title>

<style >
body{
  background:rgb(10,10,10);
  padding:0;margin:0;
  width:100%;
  color:#008563;
}
header{
  margin:0;
  padding:0;
}
header img{
  width:100%;
  height:24em;
  margin:0;
  padding:0;
}
footer {
  width:100%;
   margin:1% auto;
   padding:0;
}
footer h6{
  font-size:20px;
  margin:0 30%;
  padding:0;
}
footer input,footer p,footer img{
  display:block;
  text-align:center;
}
footer form{
  margin:2% auto;
}
footer input[type="search"],footer input[type="submit"]{
  color:#008563 ;
  background:rgb(10,10,10);
  opacity:.9;
  height:3em;
  display:inline-block;
  
  border:#008563  solid 1px;
}
footer input[type="search"]{
  width:40%;
   padding:0;
  outline:none;
  margin-left:28%;
  border-radius:5px 10px;
}
footer input[type="submit"]{
  margin-left:1%;
  border-radius:10px 5px;
  outline:none;
}
footer p{
  display:inline;
  margin:0 3%;
  margin-top:5%;
  padding:5% 0;
}
footer p.fstP{
  margin-left:38%;
}
footer p a{
  color:#008563;
  text-decoration:none;
}
footer img{
  opacity:.6;
  width:8%;
  height:55px;
  margin:2% auto;
  padding:0;
  margin-left:45.5%;
}
</style>
</head>
<body>
<header><img src="Image/404.png" alt="404"></header>
<footer>
  <h6>Find Animes</h6>
  <form method="post">
  <input type="search"  ><input type="submit" value="search">
  </form>
  <p class="fstP"><a href="home">HOME</a></p>-<p><a href="list">LIST</a></p>-
  <%if(session.getAttribute("user")!=null){ %>
  <p><a href="profile">PROFILE</a></p><%}
  else{
	  %><p><a href="login">LOGIN</a></p><% 
  }
  %>
  <a href="home"><img src="Image/WLOGO.png" alt="OTAKUS LOGO"></a>
</footer>
</body>
</html>