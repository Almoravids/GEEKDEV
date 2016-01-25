<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
 
 <script src="../Js/jquery-2.1.3.min.js"></script>
		<script src="../Js/jquery-ui.min.js"></script>
  		<style>
		body{
		/*
		http://img15.hostingpics.net/pics/224122canalmanga4820.jpg
		*/
			background:url('http://images2.alphacoders.com/568/568200.jpg') center top fixed;
			color:white;
			font-family:Palatino Linotype;
			}
		.blocks{
            border: 1px solid #101010;
            border-radius:3px;
            background: rgba(0,0,0,.8);
            }
			
		#animeInfos{
		width :70%;
		height:200px;
		margin:20px auto;
		margin-top:50px;
		}
		#animeInfos > div:not(#genre){
		border-radius:4px;
		box-shadow:inset 0 0 200px black;
		padding:10px;
		}
		#animeInfos span{
		text-transform:capitalize;
		float:right;
		padding-top:20px;
		}
		
		#fav,#animeInfos h2{
		display:inline;
		vertical-align:middle;
		}
		#animeInfos h2{
		font-size:40px;
		text-transform:capitalize;
		padding:0;
		margin:0;
		}
		#animeInfos #fav{
		width:32px;
		height:32px;
		padding:0;
		margin:0;
		padding-left:20px;
		}
		#animeInfos h3,#animeInfos h6{
		padding:0;
		margin:0;
		}
		#animeInfos h3{
		text-indent:15px;
		font-size:16px;
		text-transform:uppercase;
		}
		#animeInfos #desc{
		font-family:arial;
		width:90%;
		max-height:100px;
		overflow:hidden;
		margin:5px auto;
		padding:10px 0;
		}
		#genre h6{
		font-family:arial;
		font-size:14px;
		text-transform:capitalize;
		padding:8px;
		margin-top:5px;
		margin-left:5px;
		display:inline-block;
		}
	    #genre h6:hover{
		cursor:pointer;
		}
		
		
		
		/*Navigateur------------------------*/
		
			#navanime{
			margin-top:80px;
			width:70%;
			}
			#navanime ul{
				list-style:none;
			    margin:0;
			    margin-left:18.6%;
			    padding:0;
			}
			#navanime ul li {
				background-color:#003326;	
				display:inline-block;
				padding:10px;
				width:60px;
				padding:13px;
				margin-left:0.1px;
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
			#navanime,#searchForm{
			display:inline-block;
			}
			#searchForm{
			width:18%;
			padding:0;
			margin:0;
			}
			#searchForm img{
			vertical-align:middle;
			width:30px;
			padding:0;
			margin:0;
			margin-left:5px;
			cursor:pointer;
			}
			#searchForm input{
			color:white;
			height:20px;
			text-align:center;
			visibility:hidden;
			padding:0;
			margin:0;
			}
			#searchForm input,#searchForm img{
			display:inline-block;
			}
			hr{
			width:73.6%;
			border: solid #008563 2px;
			margin:0 auto;
			}
			
			/*Section ------------------------*/
			
					#EpsSec{
						width:73.6%;
						margin:0 auto;
						padding:1px;
						}
						
					#EpsSec img,#EpsSec figure{
						width:240px;
						}
						
					#EpsSec img{
						height:130px;
						}
					#EpsSec figure{
						margin:3px;
						height:150px;
						display:inline-block;
						}
						
					#EpsSec figure p{
						font-family:Label;
						font-size:11px;
						text-transform:capitalize;
						color:white;
						display:inline-block;
						margin:0px;
						padding:0px;
						position:relative;
						bottom:0px;
						}
					
					#EpsSec .EpLbl{
						width:60%;
						text-align:right;
						}
						
					#EpsSec .AnimeLbl{
						text-align:left;
						width:40%;
						}
						@font-face{
  font-family:Label;
  src:url('Fonts/Aspex.ttf');
}
		</style>
</head>
<body>



<header id="animeInfos">
<div>
	<h2>Dragon Ball Z</h2>        
		<img id="fav" src="Image/noFav.png"><span>ongoing</span>
		<h3>HXH , hunter x hunter</h3>
		<p id="desc">Anime is a diverse art form with distinctive 
		production methods and techniques that have been adapted 
		over time in response to emergent technologies.</p>
</div>
<div id="genre"><h6 class="blocks">#action</h6><h6 class="blocks">#adventure</h6><h6 class="blocks">#horror</h6></div>
</header>

         <nav id="navanime">
			<ul>
				<li>Saison 1</li>
				<li>Saison 2</li>
				<li>Saison 3</li>
			</ul>
			
		</nav>
		<form id="searchForm" action="" method=""><input type="text" class="blocks" placeholder="EP 1-24"/><img src="Image/targetLoupe.png"></form>
		<hr>
		
		<section id="EpsSec" class="blocks">
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			 
			  <p class="AnimeLbl">episode 1</p><p class="EpLbl">1 month ago</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" aalt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			 
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" aalt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure id="12">
			  <img  src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 12</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
			<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure>
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 1</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
		<figure id="24">
			  <img src="https://i.ytimg.com/vi/6F9cDSEizFM/maxresdefault.jpg" alt="Episode image">
			  
			  <p class="AnimeLbl">EPISODE 24</p><p class="EpLbl">ONE DAY AGO</p>
		</figure>
</section>
<hr>

<script>
$('#searchForm input').keypress(function(e){
if (e.keyCode==13){
var id='#'+$('#searchForm input').val();
if($(id).attr('id')){
$("#EpsSec figure").css('opacity','.5');
location.href=id;
$(id).css('opacity','1');
setTimeout(function(){
$("#EpsSec figure").css('opacity','1');},1000);}
}
});
$('#searchForm img').click(function(){
	if ($('#searchForm input').css('visibility')=='visible')
$('#searchForm input').css('visibility','hidden');
	else
$('#searchForm input').css('visibility','visible');
	});
</script>
</body>
</html>