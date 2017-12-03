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
				
	<jsp:include page="intestazione.jsp"/> 
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
			<em>Inserisci la scorta minima</em>
			<br><br><br>
			<table align="center">
			<form name="scortaMinima" action="scortaMinima" method="get">
			<tr><td><label>Scorta minima: </td><td><select name="scorta">
						<option selected>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>10</option>
						<option>15</option>
					     </select> </label></td></tr>
			<br><br>
			<tr><td><input type="submit" value="INVIA" class="pulsante"></td></tr>
			</table>
		<br><br><br>
		<p align="center"><a href="index.jsp">Indietro</a></p>
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
