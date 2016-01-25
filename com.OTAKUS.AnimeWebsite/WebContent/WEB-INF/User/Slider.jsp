<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<meta charset="ISO-8859-1" />
		<script src="Js/jquery-2.1.3.min.js"></script>
		<script src="Js/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="Css/SliderStyle.css"/>
	</head>
	<body>
	
		<center>
		<div id="slider">
		<ul class="slides"></ul>
			<p id="dec">
		</p>
		<canvas id="mon_canvas" width="950" height="400" >
        </canvas>
		</div>
	
		
		</center>
		<script >
		
		$(document).ready(function (){
			var s,slideWidth=950,px='-='+slideWidth+'px',slideHeight=400;
			var c=1,angle=1.5;
			var link='Image/slider/';
			var imgsTab=[{image :link+'img1.jpg',desc : "HXH"},
			             {image :link+'img2.jpg',desc : "Killua"},
			             {image :link+'img3.png',desc : "DBZ SUPER"},
			             {image :link+'img4.jpg',desc : "DIGIMON"},
			             {image :link+'img5.jpg',desc : "ONE PIECE"},
			             {image :link+'img6.jpg',desc : "DEATH NOTE"},
			             {image :link+'img1.jpg',desc : "HXH"}];

			document.querySelector('#slider ul').style.width=slideWidth*imgsTab.length+'px';
			for (var i=0;i<imgsTab.length;i++){
				var li=document.createElement('li');
				li.className='slide';
				var img=document.createElement('img');
				img.src=imgsTab[i].image;
					li.appendChild(img);
				document.querySelector('#slider ul').appendChild(li);}
		
		
		var $sl=$("#slider .slides");
		var pImg=new Image();
		var plyImg=new Image();
		
		var canvas = document.getElementById('mon_canvas');
		var context = canvas.getContext('2d');
		document.getElementById("dec").innerText=imgsTab[c-1].desc;
		function startslide(){
			 
		vv=1;
		  s=setInterval(function (){
			  
			$sl.animate({'margin-left' : px},1000,function (){
				
			c++;
			document.getElementById("dec").innerText=imgsTab[c-1].desc;
			if(c==imgsTab.length){
			c=1;
			$sl.css('margin-left', 0);
			}
			
			});
		},5000);
		}
		
		function stopslide(){
		vv=0;
			clearInterval(s);
		}
		document.querySelector("#slider .slides").onmouseover=function (){document.getElementById('mon_canvas').style.visibility='visible';};
		document.querySelector("#slider canvas").onmouseout=function (){document.getElementById('mon_canvas').style.visibility='hidden';};
		startslide();
		
		
				var img=new Image();
		img.src='Image/arrows.png';
		pImg.src='Image/pause2.png';
		plyImg.src='Image/play.png';
	
img.onload=function (){
context.drawImage(img, 0,0,32,64,0,(slideHeight/2)-32,32,64);
context.drawImage(img,32,0,32,64,slideWidth-30,(slideHeight/2)-32,32,64);
context.drawImage(pImg,slideWidth-40,20,20,20);
};
var y=canvas.offsetTop;
var x=canvas.offsetLeft;


canvas.addEventListener('click',function (e){
if (e.clientX>690+x && e.clientX<slideWidth+x&&e.clientY>slideHeight/2-32+y&&e.clientY<slideHeight/2+32+y){
stopslide();

if (c<=imgsTab.length-2){
context.clearRect(slideWidth-40,20,20,20);
context.drawImage(plyImg,slideWidth-40,20,20,20);
c++;
$sl.animate({'margin-left' : px},1000);

setTimeout(function(){
document.getElementById("dec").innerText=imgsTab[c-1].desc;},1000);}
/*else{
$sl.css('margin-left', 0);
c=1;
$sl.animate({'margin-left' : px},2000);
c=2;
}*/
}



if (e.clientX>0+x && e.clientX<32+x&&e.clientY>slideHeight/2-32+y&&e.clientY<slideHeight/2+32+y){
stopslide();
if (c>=2){
context.clearRect(slideWidth-40,20,20,20);
context.drawImage(plyImg,slideWidth-40,20,20,20);
$sl.animate({'margin-left' : '+=950px'},1000);
c--;
setTimeout(function(){
document.getElementById("dec").innerText=imgsTab[c-1].desc;},1000);
}
/*else{
$sl.css('margin-left', '-3600px');
c=6;
$sl.animate({'margin-left' : '+=950px'},2000);
c=5;
}*/
}



if (e.clientX>slideWidth-40+x && e.clientX<slideWidth-20+x&&e.clientY>20+y&&e.clientY<40+y){
if(vv==0){
startslide();
context.clearRect(slideWidth-40,20, 20,20);
context.drawImage(pImg,slideWidth-40,20,20,20);
}
else{
stopslide();
context.clearRect(slideWidth-40,20,20,20);
context.drawImage(plyImg,slideWidth-40,20,20,20);
}

}
},false);
});


		</script>
	
</html>