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
	script.appendChild(new document.createTextNode(ajaxConnection(url, "GET")));
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