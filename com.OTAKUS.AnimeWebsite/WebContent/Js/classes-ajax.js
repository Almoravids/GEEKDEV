function Anime(id, name, statue, imageLink, description, alias, types) {
	this.id = id;
	this.name = name;
	this.statue = statue;
	this.imageLink = imageLink;
	this.description = description;
	this.alias = alias;
	this.types = types;
}

function Season(id, season, date, anime) {
	this.id = id;
	this.season = season;
	this.date = date;
	this.anime = anime;
}
function Episode(id, name, episode, imageLink, link, season) {
	this.id = id;
	this.name = name;
	this.episode = episode
	this.imageLink = imageLink;
	this.link = link;
	this.season = season;
}
function User(userName,firstName,lastName,imageLink) {
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.imageLink = imageLink;
}
function Comment(id,episode,comment,user,time){
	this.id=id;
	this.episode=episode;
	this.comment=comment;
	this.user=user;
	this.time=time;
}

function ajaxConnection(url,method) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			return xhttp.responseText;
		}
	};
	xhttp.open(method, url, true);
	xhttp.send();
}

function fillScript(url,script){

	var script = document.getElementById(script);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			script.appendChild(new document.createTextNode(xhttp.responseText));
			alert(script.textContent)
		}
	};
	xhttp.open(method, url, true);
	xhttp.send();
}

function Params(paramName,param){
	this.paramName=paramName;
	this.param=param;
}

function urlMaker(url,params){
	if (params!=null){
    //noprotect
	for(var i=0;i<params.length;i++){
   
		if (i>0)
    url+="&"+params[i].paramName+"="+params[i].param;
    else
     url+="?"+params[i].paramName+"="+params[i].param;
	}
	}
	return url;
}

function extractCookie(str){
	 alert(document.cookie);
		alert(str.exec(document.cookie));
		return RegExp;
}
		function loadEpisode(onglet) {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (xhttp.readyState == 4 &&xhttp.status==200) {
			   var ajax= document.getElementById('otksajax');
			   ajax.textContent="";
			   ajax.appendChild(document.createTextNode(xhttp.responseText));
			   $('#EpsSec').html("");
			   $('body').append('<section id="EpsSec" class="blocks"></section>');
			   episodes.forEach(function(episode,i,t){
				   $('#EpsSec').append('<figure id="'+episode.episode+'"><a href="/watch/'+$("#animeInfos div h2").text().replace(/\ /g, '_')+'/season_'+onglet.id+'/episode_'+episode.episode+'"> <img src="'+episode.imagelink+'" alt="Episode image"></a> <p class="AnimeLbl">episode '+episode.episode+'</p> <p class="EpLbl">'+episode.time+'</p></figure>');
				   });
			   
			    }
			  };

			  xhttp.open("GET", "/Episodes?anime="+escape($("#animeInfos div h2").text())+"&season="+onglet.id, true);
			  xhttp.send();
			
		}
	
		
		function loadMovie(onglet,action,search) {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (xhttp.readyState == 4 ) {
			   var ajax= document.getElementById('otksajax');
			   ajax.textContent="";
			   ajax.appendChild(document.createTextNode(xhttp.responseText));
			   $('#allsec').html("");
			   $('body').append('<div id="allsec" ></div>');
			   movies.forEach(function(movie,i,t){
				   $('#allsec').append('<a id="infoanime" href="/watch/AnimeNAme/movie/'+movie.name+'">' +
				   		'<img src ="'+anime.imageLink+'" id="imganime" />' +
				   				'<article id="desc"><h3>'+movie.name+'</h3><h6>'+movie.stringStatus+'</h6><br>' +
				   						'<p>'+movie.description+'"</p>' +
				   						'<c:forEach var="genre" items="${anime.genre}" >' +
				   								'<h5>genre.type</h5>');
				   });
			   
			    }
			  };

			  xhttp.open("GET", "/Movies?action="+action+"&search="+search, true);
			  xhttp.send();
			
		}