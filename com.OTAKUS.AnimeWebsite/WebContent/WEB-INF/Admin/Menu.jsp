<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../Css/AdminMenu.css"/>
<script src="../Js/jquery-2.1.3.min.js"></script>
		<script src="../Js/jquery-ui.min.js"></script>
</head>
<body>

<nav id="MenuNav">

	<a href="../home"><img id="logo"src="../Image/LOGO.png" /></a> 
    <ul id="ulnav" class="HiddenNav">
	<input type="text" name="search" id="search" />
	<div>
	<li>Anime</li>
	<li>Season</li>
	<li>Episode</li>
	<li>Type</li>
	<li>User</li>
	</div>
		
	</ul>	
</nav>	
<script>
$('#ulnav li').click(function(){
	window.open($(this).text().toLowerCase(),'_top');
});

document.onscroll=function(){
	var a=window.pageYOffset;

	if (window.offsetHeight>730)
	if(a>=60){
		$('#ulnav').css({'position':'fixed','top':'0px','width':'97%'});
		}
	else
		$('#ulnav').css('position','relative');
}

</script>
</body>
</html>