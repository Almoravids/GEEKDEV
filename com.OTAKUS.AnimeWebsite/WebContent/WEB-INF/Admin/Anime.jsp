<!DOCTYPE html>
<%@page import="Dao.AnimeDao"%>
<%@page import="Dao.TypeDao"%>
<%@page import="beans.Anime"%>
<%@page import="beans.Statue"%>
<%@page import="beans.Alias"%>
<%@page import="beans.Type"%>
<%@page import="oracle.net.aso.a"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Anime"%>
<%@page import="java.util.List"%>
<%@page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Stylesheet" href="../Css/AdminStyleM.css">
<script src="../Js/Menu.js">
	
</script>
</head>
<body>
	<!-- <%/*
if (request.getParameter("op")!=null)
{
	if (request.getParameter("op").equals("add")&&request.getParameter("name")!=null){
	Anime anime;
	List list=new ArrayList<ALias>();
	list.add(new ALias(a.getId(),request.getParameter("name")));
	String[] alias=request.getParameter("allias").split(",");
	for (String alia : alias)
		list.add(new ALias(a.getId(),alia));
		a.setAlias(list);
	
		list=new ArrayList<Type>();
		String[] types=request.getParameter("types").split(",");
		for (String type : types)
		list.add(new Type(type));
		a.setGenre(list);
	a.setDesc(request.getParameter("desc"));
	a.setImageLink(request.getParameter("imgLink"));
	a.setStatue(Integer.parseInt(request.getParameter("statue")));
	h.insertAnime(a);
	System.out.println("ffhh");
	}
	else if (request.getParameter("op").equals("mod")){
		 h=(Method)Method.getcontext();
		Anime a=new Anime();
		a.setId(Integer.parseInt(request.getParameter("id")));
		List list=new ArrayList<String>();
		
		String[] alias=request.getParameter("allias").split(",");
		for (String alia : alias)
		list.add(alia);
		a.setAlias(list);
		
		list=new ArrayList<String>();
		String[] types=request.getParameter("types").split(",");
		for (String type : types)
		list.add(type);
		a.setGenre(list);
		a.setDesc(request.getParameter("desc"));
		a.setImageLink(request.getParameter("imgLink"));
		a.setStatue(Integer.parseInt(request.getParameter("statue")));
		h.updateAnime(a);}
	else if (request.getParameter("op").equals("del")){
		 h=(Method)Method.getcontext();
		h.deleteAnime(request.getParameter("animename"));
	}
	
}*/
%> -->
<%!AnimeDao animeDao=new AnimeDao(); %>
	<center>
		<header id="nav">
			<ul>
				<li><a href="#" id="addOnglet" onclick="changeState(this)">Add
						Anime</a></li>

				<li><a href="#" id="modOnglet" onclick="changeState(this)">Update
						Anime</a></li>

				<li><a href="#" id="delOnglet" onclick="changeState(this)">Delete
						Anime</a></li>
			</ul>
		</header>
		<section>
			<center>
				<form id="add" action="../AddAnime" method="post">
					<h2>Add Anime</h2>
					<input type="hidden" name="op" value="add">
					<table>
						<tr>
							<td><label for="name">Name</label></td>
							<td><input type="text" id="name" name="name"
								placeholder="name" required /></td>
						</tr>
						<tr>
							<td><label for="desc">Description : </label></td>
							<td><textarea rows="4" id="desc" name="desc"
									placeholder="description" required></textarea></td>
						</tr>
						<tr>
							<td><label for="type">Type : </label></td>
							<td><select id="type">
									<%
						try{
						TypeDao typeDao=new TypeDao();
						List<Type> typeList=typeDao.getAll();
						
						for (Type type: typeList){
						%>
						<option value="<%=type.getType()%>"><%=type.getType()%></option>
						<%}}catch (Exception e){
							out.print(e.getMessage());
							
						} %>
							</select> <input type="button" id="bType" name="add" value="Select"
								onclick="typeOnClick(this.name);"></td>
						</tr>
						<tr>
							<td><label for="types">Types : </label></td>
							<td><textarea id="types" name="types" placeholder="types"
									required></textarea></td>
						</tr>
						<tr>
							<td><label for="statue">Statue : </label></td>
							<td><select id="statue" name="statue">
									<%
						try{
						Statue[] statues=Statue.values();
						for (Statue statue: statues){
						%>
						<option value="<%=statue.getStatueId()%>"><%=statue.getStatue()%></option>
						<%}}catch (Exception e){
							out.print(e.getMessage());
						}%>
							</select></td>
						</tr>
						<tr>
							<td><label for="allia">Alias : </label></td>
							<td><input type="text" id="allia" /><input type="button"
								id="bAllia" name="add" value="Select"
								onclick="aliasOnClick(this.name);"></td>
						</tr>
						<tr>
							<td><label for="allias">Alias Selected: </label></td>
							<td><textarea id="allias" name="allias" placeholder="allias"
									required></textarea></td>
						</tr>
						<tr>
							<td><label for="imgLink">Image Link : </label></td>
							<td><input type="text" id="imgLink" name="imgLink"
								placeholder="Link" required /></td>
						</tr>
					</table>
					<input type="submit" value="Add Anime" />
				</form>
			</center>
			<!-- -----------------------------UPDATE------------------------ -->
			<form id="mod" action="anime" method="post">
				<h2>Update Anime</h2>
				<input type="hidden" name="op" value="mod">
				<table>
					<tr>
						<td><label for="upname">Name</label></td>
						<td><select id="upname" name="upname" onchange="a(this);">
								<option value="" disabled selected>Select Anime</option>
								<%	
try{
									for (Anime anime:animeDao.getAll()){%>%>
								<option value="<%=anime.getName()%>"><%=anime.getName()%></option>
								<%} }catch(Exception e){}%>
						</select></td>
					</tr>
					<input type="hidden" name="id" value="">
					<tr>
						<td><label for="desc">Description : </label></td>
						<td><textarea rows="4" id="desc" name="desc"
								placeholder="description" required></textarea></td>
					</tr>
					<tr>
						<td><label for="type">Type : </label></td>
						<td><select id="type">

								<%
							try{
								TypeDao typeDao=new TypeDao();
								List<Type> typeList=typeDao.getAll();
							
								for (Type type: typeList){
							%>
							<option value="<%=type.getType()%>"><%=type.getType()%></option>
							<%}}catch (Exception e){
								out.print(e.getMessage());
								
							} %>
						</select> <input type="button" id="bType" name="mod" value="Select"
							onclick="typeOnClick(this.name);"></td>
					</tr>
					<tr>
						<td><label for="types">Types : </label></td>
						<td><textarea id="types" name="types" placeholder="types"
								required></textarea></td>
					</tr>
					<tr>
						<td><label for="statue">Statue : </label></td>
						<td><select id="statue" name="statue">
								<%
						try{
						Statue[] statues=Statue.values();
						for (Statue statue: statues){
						%>
						<option value="<%=statue.getStatueId()%>"><%=statue.getStatue()%></option>
						<%}}catch (Exception e){
							out.print(e.getMessage());
						} %>
						</select></td>
					</tr>
					<tr>
						<td><label for="allia">Alias : </label></td>
						<td><input type="text" id="allia" /><input type="button"
							id="bAllia" name="mod" value="Select"
							onclick="aliasOnClick(this.name);"></td>
					</tr>
					<tr>
						<td><label for="allias">Alias Selected: </label></td>
						<td><textarea id="allias" name="allias" placeholder="allias"
								required></textarea></td>
					</tr>
					<tr>
						<td><label for="imgLink">Image Link : </label></td>
						<td><input type="text" id="imgLink" name="imgLink"
							placeholder="Link" required /></td>
					</tr>
				</table>
				<input type="submit" value="Update" />
			</form>

			<!-- -------------------------DELETE---------------------------- -->

			<form id="del" action="anime" method="post">
				<h2>Delete Anime</h2>
				<input type="hidden" name="op" value="del">
				<table>
					<tr>
						<td><label for="name">Name</label></td>
						<td><select name="animename">
								<%	
	try{
                                 for (Anime anime:animeDao.getAll()){%>
								<option><%=anime.getName()%></option>
								<%}}catch(Exception e){}%>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="delete">
			</form>
		</section>
	</center>
	<script>
		function typeOnClick(name) {
			checkAreasOption(document.querySelector('#' + name + ' #type'),
					document.querySelector('#' + name + ' #types'));
		};
		function aliasOnClick(name) {
			checkAreasTF(document.querySelector('#' + name + ' #allia'),
					document.querySelector('#' + name + ' #allias'));
		}
		function checkAreasOption(a, as) {
			if (as.value == "" || as.value.endsWith(','))
				as.value += a.options[a.selectedIndex].value;
			else {
				var b = false;
				var tab = as.value.split(',');
				for (var i = 0; i < tab.length; i++)
					if (a.options[a.selectedIndex].value == tab[i])
						b = true;

				if (!b)
					as.value += "," + a.options[a.selectedIndex].value;
			}
		}
		function checkAreasTF(a, as) {
			if (as.value == "" || as.value.endsWith(','))
				as.value += a.value;
			else {
				var b = false;
				var tab = as.value.split(',');
				for (var i = 0; i < tab.length; i++)
					if (a.value == tab[i])
						b = true;

				if (!b)
					as.value += "," + a.value;
			}

		}

		function a(a) {
			if (a.value != "Select Anime") {

				var form = document.querySelector("#mod table");
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
					if (xhttp.readyState == 4 && xhttp.status == 200) {
						form.innerHTML = xhttp.responseText;
					}
				};
				xhttp
						.open("GET", "../Listener.jsp?getAnime="
								+ escape(a.value));
				xhttp.send();
			}
		};
	</script>
</body>

</html>