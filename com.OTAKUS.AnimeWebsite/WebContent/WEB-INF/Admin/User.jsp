<!DOCTYPE html>
<%@page import="Dao.VisitorDao"%>
<%@page import="beans.Visitor"%>
<%@page import="java.util.List"%>
<html>
<head>
  <meta charset="utf-8">
  <title>JS Bin</title>
  <link rel="stylesheet" href="../Css/AdminStyleM.css"/>
  <script src="../Js/Menu.js"></script>
  
</head>
<body>
<%!Visitor visitor;
VisitorDao visitorDao=new VisitorDao();%>
<%

if (request.getParameter("op")!=null){
if (request.getParameter("op").equals("upg")&&request.getParameter("username")!=null){
	visitor=new Visitor();
	visitor.setUserName(request.getParameter("username"));
	visitor.setType(request.getParameter("grade"));
	visitorDao.grade(visitor);
	}else if (request.getParameter("op").equals("del")&&request.getParameter("username")!=null){
		visitorDao.delete((String)request.getParameter("username"));
	}}
%>
  <center>
  <header id="nav">
		<ul>
			<li><a href="#" id="UpgOnglet" onclick="changeState(this)">Upgrade User</a></li>
			
			<li><a href="#" id="delOnglet" onclick="changeState(this)">Delete User</a></li>
		</ul>
		</header>
		
		<section >
	
        <form action="user" id="upg" method="post">
    <h2>Upgrade User</h2>
    <input type="hidden" name="op" value="upg">
    <table><tr>
      <td><label for="user">Username : </label></td>
      <td><select  id="username" name="username">
      
       <option selected disabled value="">Select User</option> 
        <%
        List<Visitor> listVisitor=visitorDao.getAll();
      for (Visitor visitor:listVisitor){%>
    	 <option value="<%=visitor.getUserName()%>"><%=visitor.getUserName()%></option>  
      <%}%>
      </select></td>
      </tr>
       <td><label for="user">Grade : </label></td>
      <td><select  id="grade" name="grade">
       <option selected disabled value="">Select Grade</option> 
     <option value="user">User</option> 
       <option value="admin">Admin</option> 
         <option value="adminSup">Sup Admin</option> 
      </select></td></tr>
    </table>
      <input type="submit" value="Upgrade">
    
  </form>

		
   
       <form action="user" id="del">
    <h2>Delete User</h2>
    <input type="hidden" name="op" value="del">
    <table><tr>
      <td><label for="">Username : </label></td>
      <td><select  id="username" name="username">
       <option selected disabled value="user">Select User</option> 
       <%
      for (Visitor visitor:listVisitor){%>
    	 <option value="<%=visitor.getUserName()%>"><%=visitor.getUserName()%></option>  
      <%}%>
      </select></td>
      </tr>
      </table>
	  <input type="submit" value="Delete">
  </form>
  </section>
  </center>
  <script type="text/javascript">
  document.querySelector('#upg #username').onchange=function(){
	  var conn=new XMLHttpRequest();
	  conn.onreadystatechange=function(){
		  if (conn.readyState == 4 && conn.status == 200)
			
			  for (var i=0;i<document.querySelector('#upg #grade').options.length;i++){
				  if (document.querySelector('#upg #grade').options[i].value==conn.responseText.trim())
                  document.querySelector('#upg #grade').options[i].selected="true";
	  }}
	  var option=document.querySelector('#upg #username');
	  conn.open('get','../Listener.jsp?getGrade='+escape(option.options[option.selectedIndex].value));
	  conn.send();
  }
  </script>
  </body>
</html>