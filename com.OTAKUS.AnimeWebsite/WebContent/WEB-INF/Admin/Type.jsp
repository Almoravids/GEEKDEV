<!DOCTYPE html>
<%@page import="beans.Type"%>
<%@page import="Dao.TypeDao"%>
<%@page import="java.util.List"%>
<html>
<head>
  <link rel="stylesheet" href="../Css/AdminStyleM.css"/>
  <script src="../Js/Menu.js"></script>
</head>
<body>
<%!TypeDao typeDao=new TypeDao(); %>
<%
if (request.getParameter("DelOp")!=null){
if (request.getParameter("DelOp").equals("add")){
	try{

typeDao.insert(new Type(request.getParameter("type")));
}catch(Exception e){}
}else if (request.getParameter("DelOp").equals("del")){
	try{
	typeDao.delete(request.getParameter("type"));
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

List<Type> typeList=typeDao.getAll();

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