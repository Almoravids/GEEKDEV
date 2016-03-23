
<%@page import="Dao.VisitorDao"%>
<%@page import="beans.Visitor"%>
<%@page import="beans.Alias"%>
<%@page import="Dao.AliasDao"%>
<%@page import="beans.Statue"%>
<%@page import="beans.Type"%>
<%@page import="Dao.TypeDao"%>
<%@page import="beans.Anime"%>
<%@page import="Dao.AnimeDao"%>
<%@page import="java.util.List"%>

<%!AnimeDao animeDao = new AnimeDao();%>
<%
	if (request.getParameter("getAnime") != null) {

		List<Anime> list = animeDao.getAll();
		for (Anime a : list) {
			if (request.getParameter("getAnime").equals(a.getName())) {
%>

<tr>
	<td><label for="name">Name</label></td>
	<td><select id="upname" name="upname" onchange="a(this);">
			<option value="" disabled selected>Select Anime</option>
			<%
				for (Anime anime : list) {
								if (anime.getName().equals(request.getParameter("getAnime"))) {
			%>

			<option selected value="<%=anime.getName()%>"><%=anime.getName()%></option>
			<%
				} else {
			%><option value="<%=anime.getName()%>"><%=anime.getName()%></option>
			<%
				}
							}
			%>
	</select></td>
</tr>

<input type="hidden" name="id" value="<%=a.getAnimeId()%>">
<tr>
	<td><label for="desc">Description : </label></td>
	<td><textarea rows="4" id="desc" name="desc"
			placeholder="description" required><%=a.getDescription()%></textarea>
	</td>
</tr>
<tr>
	<td><label for="type">Type : </label></td>
	<td><select id="type">
			<%
				try {
								TypeDao typeDao = new TypeDao();
								List<Type> typeList = typeDao.getAll();

								for (Type type : typeList) {
			%>
			<option value="<%=type.getType()%>"><%=type.getType()%></option>
			<%
				}
							} catch (Exception e) {
								out.print(e.getMessage());

							}
			%>
	</select> <input type="button" id="bType" name="mod" value="Select"
		onclick="typeOnClick(this.name);"></td>
</tr>
<%
	String genres = a.getGenre().get(0).getType();
				for (int i = 1; i < a.getGenre().size(); i++)
					genres += "," + a.getGenre().get(i).getType();
%>
<tr>
	<td><label for="types">Types : </label></td>
	<td><textarea id="types" name="types" placeholder="types" required><%=genres%></textarea>
	</td>
</tr>
<tr>
	<td><label for="statue">Statue : </label></td>
	<td><select id="statue" name="statue">
			<%
				try {
								Statue[] statues = Statue.values();
								for (Statue statue : statues) {
									if (statue.getStatueId() == a.getStatue()) {
			%>
			<option selected value="<%=statue.getStatueId()%>"><%=statue.getStatue()%></option>
			<%
				} else {
			%>
			<option value="<%=statue.getStatueId()%>"><%=statue.getStatue()%></option>
			<%
				}
								}
							} catch (Exception e) {
								out.print(e.getMessage());
							}
			%>
	</select></td>
</tr>

<tr>
	<td><label for="allia">Alias : </label></td>
	<td><input type="text" id="allia" /><input type="button"
		id="bAllia" name="mod" value="Select"
		onclick="aliasOnClick(this.name);"></td>
</tr>
<%         String aliasStr="";
			for (Alias alias:a.getAlias())
					aliasStr += "," + alias.getAlias();
%>
<tr>
	<td><label for="allias">Alias Selected: </label></td>
	<td><textarea id="allias" name="allias" placeholder="allias"
			required><%=aliasStr%></textarea></td>
</tr>
<tr>
	<td><label for="imgLink">Image Link : </label></td>
	<td><input type="text" id="imgLink" name="imgLink"
		placeholder="Link" value="<%=a.getImageLink()%>" required /></td>
</tr>


<%
	}
		}
	} else if (request.getParameter("getGrade") != null) {
		VisitorDao visitorDao=new VisitorDao();
		Visitor visitor = new Visitor();
		visitor =visitorDao.get(request.getParameter("getGrade"));
		out.print(visitor.getType());
	}
%>