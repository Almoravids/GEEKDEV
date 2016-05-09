
function changeState(a){
	var add=document.getElementById('add');
	var upg=document.getElementById('upg');
	var mod=document.getElementById('mod');
	var del=document.getElementById('del');
	if (add!=null)
	add.style.display='none';
	if (mod!=null)
	mod.style.display='none';
    if (del!=null)
	del.style.display='none';
	if (upg!=null)
	upg.style.display='none';
	if (a.id=="addOnglet")
		add.style.display='inline-block';
	if (a.id=="modOnglet")
	mod.style.display='inline-block';
	if (a.id=="delOnglet")
		del.style.display='inline-block';
	if(a.id=="UpgOnglet")
		upg.style.display='inline-block';
}
$(".SubMenuImg").click(function(){  $(".NotSubMenu").hide();
$(".ProfileSubMenu").hide();
$(".SubMenu").slideToggle(100);

});

$(".Profile").click(function(){

$(".NotSubMenu").hide();
$(".ProfileSubMenu").fadeToggle(100);
});


$(".Notification").click(function(){

$(".ProfileSubMenu").hide();
$(".NotSubMenu").fadeToggle(100);
});

$(".Search").click(function(){
if ($(".Menu > div:nth-child(2)").css('display')=="none"){
	$(".NotSubMenu").hide();
	$(".ProfileSubMenu").hide();
$(".Menu > div:nth-child(3)").css('display','none');
$(".Menu > div:nth-child(2)").css('display','inline-block');
}
else{
	$(".NotSubMenu").hide();
	$(".ProfileSubMenu").hide();
$(".Menu > div:nth-child(2)").css('display','none');
$(".Menu > div:nth-child(3)").css('display','inline-block');
 
}
});

document.onscroll=function(){
	var a=window.pageYOffset;
	if(a>=60 && document.body.offsetHeight >=800){
		$('nav .Menu').parent().css({'position':'fixed','top':'0px','width':'100%','opacity':'0.5px'});
		$('nav .Menu').parent().css("opacity",".8");
		}
	else{
		$('nav .Menu').parent().css("opacity","1");
		$('nav .Menu').parent().css({'position':'relative','width':'auto'});}

}
