<html>

<head>
   <title>Benvenuti su Mobile's Infinity</title>
   <link rel="stylesheet" type="text/css" href="stile.css">
   <LINK REL="shortcut icon" HREF="img/favicon.ICO">
   <meta name="author" content="Attanasio Carmine">
   <meta name="description" content="Mobile's Infinity">
   <meta name="generator" content="jEdit">
</head>

<body>
 	<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
	<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
		<%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		<% ArrayList arr = new ArrayList();
			Cliente cli = new Cliente();
			String path = getServletContext().getRealPath("/");
			DBCliente db = new DBCliente(path+"WEB-INF/database/cliente.xml");
			arr = db.listaClienti(); 
			
			 ArrayList arrVen = new ArrayList();
			 	arrVen.clear();
				Vendite ven = new Vendite();
			    	String path2 = getServletContext().getRealPath("/");
				DBVendite dbVen = new DBVendite(path2+"WEB-INF/database/vendite.xml");
				
				
			%>
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
	<td valign="top">
		<% if (arr.size()==0) { %>
				<br><label><p align="center"> NON E' REGISTRATO NESSUN CLIENTE</p> </label>
					<br><br><br>
				<a href="index.jsp">Indietro</a>
			<% } else { %>
				<br><label><p align="center">ELENCO DEI CLIENTI REGISTRATI</p></label>
					<br><br><br>
				<table border="0" width="500" align="center">
				  <!-- <tr> 
				      <td><label>USERNAME</label></td>
				      <td><label>COGNOME</label></td>
				      <td><label>NOME</label></td>
				      <td><label>TEL.CELL</label></td>
				      <td><label>EMAIL</label></td>
				   </tr>
				   <tr> 
				      <td> &nbsp; </td>
				      <td> &nbsp; </td>
				      <td> &nbsp; </td>
				      <td> &nbsp; </td>
				      <td> &nbsp; </td>
				   </tr>-->
				   
					<% for (int i=0; i<arr.size(); i++)
					    {
					    	cli = (Cliente)arr.get(i); %>

				      <label>USERNAME</label>: <%=cli.getUsername()%></td> <br>
				      <label>COGNOME</label>: <%=cli.getCognome()%></td> <br>
				      <label>NOME</label>: <%=cli.getNome()%></td> <br>
				      <label>TEL.CELL</label>: <%=cli.getTelcell()%></td> <br>
				      <label>EMAIL</label>: <%=cli.getEmail()%></td><br>
				      
				      <p align="center"><a href="completaAcquisti?cliente=<%=cli.getUsername()%>"> Visualizza gli Acquisti </a></p
				      
				      <br><hr><br>

					<% } %>
				</table>
					<br><br>
				<p align="center"><a href="index.jsp">Indietro</a></p>
				<% } %>
	</td>
  </tr>
 </table>
    
</body>

</html>
