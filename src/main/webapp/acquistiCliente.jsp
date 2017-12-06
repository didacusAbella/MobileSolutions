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
	
		<%@page import="java.util.*, com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
				
	  
  <table border="1" align="center" valign="top" width="900">
  <tr>
  	
	<td valign="top">
			<% ArrayList arr = new ArrayList();
			   arr.clear();
			   String cli = (String)session.getAttribute("cli");
			   arr = (ArrayList)session.getAttribute("ven"); %>
			   
			<% if (arr.size()!=0) { %>
				<br><label><p align="center">ECCO TUTTI GLI ACQUISTI DI: <%=cli%> </p></label>
				<br><br>
				<table border="0" align="center">
                                         <tr>
					   <td></td>
					   <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                                             <td> <b>Marca</b> </td>
                                             <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                                           <td> <b>Modello</b> </td>
                                              <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                                           <td> <b>Prezzo</b> </td>
                                        </tr>
					<% for (int i=0; (i<arr.size()); i++)
					    {
					    	Vendite vend = (Vendite)arr.get(i); %>
					<tr>
					   <td> <b><%= i+1 %></b> </td>

					   <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
					   <td> <p><%=vend.getMarca()%></p> </td>
                                           <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
					   <td> <p><%=vend.getModello()%></p> </td>
                                           <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
					   <td> <p><%=vend.getPrezzo()%></p> </td>
					</tr>
                                             <% } %>

				</table>
				<br><br><br>
				<p align="center"><a href="javascript:history.go(-1)"> Indietro </a></p>
			<% } else { %>
				<br><label><p align="center"> IL CLIENTE NON HA EFFETTUATO ALCUN ACQUISTO</p> </label>
					<br><br><br>
				<p align="center"><a href="javascript:history.go(-1)"> Indietro </a></p>
				<% } %>	
	
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
