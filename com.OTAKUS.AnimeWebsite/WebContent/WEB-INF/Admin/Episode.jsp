
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
			<li><a href="#" id="a1">Add Episode</a></li>
			
			<li><a href="#" id="a2">Update Episode</a></li>
			
			<li><a href="#" id="a3">Delete Episode</a></li>
		</ul>
		</header>
		
		<!-- Add Episode -->
		<section id="sec1">
		
		<form>
		<h2>Add Episode</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			<tr><td><label>Season N:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			<tr class="episodeN"><td ><label class="episodeN">Episode N°:</label></td>
			<td><select class="episodeN">
				<option value="a1">1</option>
				<option value="a2">2</option>
				<option value="a3">3</option>
				<option value="a4">4</option>
			</select></td></tr>
			
			<tr><td><label >Episode Name:</label></td>
			<td><input type="link" name="episode_name" placeholder="EX:HunterxHunter" /></td></tr>
			
			<tr><td><label>Link Episode:</label></td>
			<td><input type="link" name="link_episode" placeholder="https://..." /></td></tr>
			
			<tr><td><label>Image Episode:</label></td>
			<td><input type="link" name="img_episode" placeholder="https://..." /></td></tr>
			
			<tr><td><label>Type Episode:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			</table>
			<input type="button" value="Add Episode" name="addepisode" />
			
		</form>
		</section>
		
		<!--Update episode-->
		<section id="sec2">
		<form>
		
		<h2>Update Episode</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			<tr><td><label>Season N:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			<tr><td><label>Episode Name:</label></td>
			<td><input type="link" name="episode_name" placeholder="EX:HunterxHunter"/></td></tr>
			
			<tr><td><label>Link Episode:</label></td>
			<td><input type="link" name="link_episode" placeholder="https://..." /></td></tr>
			
			<tr><td><label>Image Episode:</label></td>
			<td><input type="link" name="img_episode" placeholder="https://..." /></td></tr>
			
			<tr><td><label>Type Episode:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			</table>
			<input type="button" value="Update Episode" />
			
		</form>
		</section>
		
		<!--Delete episode-->
		<section id="sec3">
		
		<form>
		<h2>Delete Episode</h2>
			<table>
			<tr><td><label>Anime Name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			<tr><td><label>Season N°:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			<tr><td><label>Episode name:</label></td>
			<td><select>
				<option value="a1">A1</option>
				<option value="a2">A2</option>
				<option value="a3">A3</option>
				<option value="a4">A4</option>
			</select></td></tr>
			
			</table>
			<input type="button" value="Delete Episode" />
			
		</form>
		</section>
		
	</center>
	
	</body>


</html>