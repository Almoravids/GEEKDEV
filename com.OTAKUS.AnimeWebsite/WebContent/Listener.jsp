
<%@page import="pack.Statue"%>
<%@page import="pack.Type"%>
<%@page import="pack.ALias"%>
<%@page import="pack.Visitor"%>
<%@page import="java.util.List"%>
<%@page import="pack.Anime"%>
<%@page import="pack.Method"%>

<%
if(request.getParameter("getAnime")!=null){
	 Method h=(Method)Method.getcontext();
	 List<Anime> list=h.getAnimes();
	 for (Anime a:list){
		if (request.getParameter("getAnime").equals(a.getName())){%>

			<tr><td><label for="name">Name</label></td><td>
			<select id="upname" name="upname" onchange="a(this);">
			<option value="" disabled selected>Select Anime</option>
			<%	
			for (Anime anime:list){
			if (anime.getName().equals(request.getParameter("getAnime"))){%>
				
			<option selected value="<%=anime.getName()%>"><%=anime.getName()%></option>
			<%}
			else{%><option value="<%=anime.getName()%>" ><%=anime.getName()%></option><%}} %>
			</select></td></tr>
		
			<input type="hidden" name="id" value="<%=a.getId()%>">
			<tr><td><label for="desc">Description : </label></td><td><textarea rows="4"id="desc" name="desc" placeholder="description"  required><%=a.getDesc()%></textarea>
			</td></tr>
		<tr><td><label for="type">Type : </label></td><td><select id="type">  
<%
try{
h=(Method)Method.getcontext();
List<Type> typeList=h.getTypes();

for (Type type: typeList){
%>
<option value="<%=type.getType()%>"><%=type.getType()%></option>
<%}}catch (Exception e){
	out.print(e.getMessage());
	
} %>
  </select>
  <input type="button" id="bType"   name="mod" value="Select" onclick="typeOnClick(this.name);">
</td></tr>
<%
String genres=a.getGenre().get(0).getType();
for (int i=1;i<a.getGenre().size();i++)
	genres+=","+a.getGenre().get(i).getType();
%>
<tr><td><label for="types">Types : </label></td><td><textarea id="types" name="types" placeholder="types" required><%=genres%></textarea>
</td></tr>
	<tr><td><label for="statue">Statue : </label></td><td><select id="statue" name="statue"><%
try{
Statue[] statues=Statue.values();
for (Statue statue: statues){
	if (statue.getId()==a.getStatue()){
%>
<option selected value="<%=statue.getId()%>" ><%=statue.getStatue()%></option>
<%
	}else{%>
		<option value="<%=statue.getId()%>" ><%=statue.getStatue()%></option>
	<% }
	}}catch (Exception e){
	out.print(e.getMessage());
} %>
  </select>
</td></tr>		

<tr><td>
<label for="allia">Alias : </label></td><td><input type="text" id="allia" /><input type="button" id="bAllia" name="mod" value="Select" onclick="aliasOnClick(this.name);">
</td></tr>
<%
String aliasStr=a.getAlias().get(1).getAlias();

for (int i=2;i<a.getAlias().size();i++)
	aliasStr+=","+a.getAlias().get(i).getAlias();
%>
<tr><td><label for="allias">Alias Selected: </label></td><td><textarea id="allias" name="allias" placeholder="allias" required><%=aliasStr%></textarea>
</td></tr>
<tr><td><label for="imgLink">Image Link : </label></td><td><input type="text" id="imgLink" name="imgLink" placeholder="Link" value="<%=a.getImageLink()%>"required/>
</td></tr>


<%
}}}else if (request.getParameter("getGrade")!=null){
	Method method=(Method)Method.getcontext();
	Visitor visitor=new Visitor();
	visitor=method.getUser(request.getParameter("getGrade"));
	out.print(visitor.getType());
}
%>