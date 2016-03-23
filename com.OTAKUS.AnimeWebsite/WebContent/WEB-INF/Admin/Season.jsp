<%@page import="beans.Statue"%>
<html lang="en">
	<head>
		<title>AddEpisode</title>
		<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1" />
		<link rel="stylesheet" href="../Css/AdminStyleM.css" />
<script src="../Js/jquery-2.1.3.min.js"></script>
		<script src="../Js/jquery-ui.min.js"></script>
		<script src="../Js/jqSecondeMenuA.js"></script>
	</head>
	<body>
	<center>
		
		<header id="nav">
		<ul>
			<li><a href="#" id="a1">Add Season</a></li>
			
			<li><a href="#" id="a2">Update Season</a></li>
			
			<li><a href="#" id="a3">Delete Season</a></li>
		</ul>
		</header>
		
		<section id="sec1">
		
		<form>
		<h2>Add Season</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>

			<tr ><td ><label >Statue:</label></td>
			<td><select id="statue" name="statue"><%
try{
Statue[] statues=Statue.values();
for (Statue statue: statues){
%>
<option value="<%=statue.getStatueId()%>" ><%=statue.getStatue()%></option>
<%;}}catch (Exception e){
	out.print(e.getMessage());
} %>
  </select></td></tr>
			</table>
			<input type="button" value="Add Season" name="addSeason" />
			
		</form>
		</section>
		<section id="sec2">
		
		<form>
		<h2>Update Season</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>

			<tr ><td ><label >Statue:</label></td>
			<td><select id="statue" name="statue"><%
try{
Statue[] statues=Statue.values();
for (Statue statue: statues){
%>
<option value="<%=statue.getStatueId()%>" ><%=statue.getStatue()%></option>
<%;}}catch (Exception e){
	out.print(e.getMessage());
} %>
  </select></td></tr>
			</table>
			<input type="button" value="Update Season" name="updateSeason" />
			
		</form>
		</section>
		<section id="sec3">
		
		<form>
		<h2>Delete Season</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>

			<tr ><td ><label >Season N°:</label></td>
			<td><select >
				<option value="a1">1</option>
				<option value="a2">2</option>
				<option value="a3">3</option>
			</select></td></tr>
			</table>
			<input type="button" value="Delete Season" name="deleteSeason" />
			
		</form>
		</section>
	</center>	
</html>		