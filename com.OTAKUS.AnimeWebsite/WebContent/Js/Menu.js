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