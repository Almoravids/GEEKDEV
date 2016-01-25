<!DOCTYPE html>
<%@page import="pack.Type"%>
<%@page import="java.util.List"%>
<%@page import="pack.Method"%>
<html>
<head>
  <link rel="stylesheet" href="../Css/AdminStyleM.css"/>
  <script src="../Js/Menu.js"></script>
</head>
<body>

<%
if (request.getParameter("DelOp")!=null){
if (request.getParameter("DelOp").equals("add")){
	try{
Method h=(Method)Method.getcontext();
h.insertGenre(request.getParameter("type"));
}catch(Exception e){}
}else if (request.getParameter("DelOp").equals("del")){
	try{
	Method h=(Method)Method.getcontext();
	h.deleteGenre(request.getParameter("type"));
	}catch(Exception e){
		out.print(e.getMessage());
	}
}
}
%>
 <center>
		<header id="nav">
		<ul>
			<li><a href="#" id="addOnglet" onclick="changeState(this)">Add Type</a></li>
			
			<li><a href="#" id="delOnglet" onclick="changeState(this)">Delete Type</a></li>
		</ul>
	   </header>
		
	<section>
	
	<form action="type" id="add" method="post">
    <h2 >Add type</h2>
    <input type="hidden" name="DelOp" value="add">
    <table><tr>
      <td><label for="type">Type : </label></td>
      <td><input type="text" id="type" name="type" /></td>
      </tr>
    </table>
	<input type="submit" value="Add" />
  
  </form>
  
 <!----------------------------------------->
  
	 <form action="type" id="del" method="post">
    <h2 name="del">Delete type</h2>
    <input type="hidden" name="DelOp" value="del">
    <table><tr>
      <td><label for="type">Type : </label></td>
      <td><select  id="type" name="type" />
      <%
try{
Method h=(Method)Method.getcontext();
List<Type> typeList=h.getTypes();

for (Type type: typeList){
%>
<option value="<%=type.getType()%>"><%=type.getType()%></option>
<%}}catch (Exception e){
	out.print(e.getMessage());
	
} %>
      </select></td>
      </tr></table>
	  <input type="submit" value="delete" />
  </form>

  </section>
  </center>
  
  </body>
</html>