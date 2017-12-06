<html>

<head>
   <title>Benvenuti su Mobile's Infinity</title>
   <link rel="stylesheet" type="text/css" href="stile.css">
   <LINK REL="shortcut icon" HREF="img/favicon.ICO">
   <meta name="author" content="Attanasio CArmine">
   <meta name="description" content="Mobile's Infinity">
   <meta name="generator" content="jEdit">
</head>

<body>
 	<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
	<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
		<%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		 
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
	<td valign="top">
                <br>
		<p align="center"><b>Chiudendo il tuo account i tuoi dati verranno persi</b></p>
			<br><br>
			<form action="cancella" method="get">
			<p align="center"><b>Sign. <%=Cliente.getNome()%> <%=Cliente.getCognome()%>, il suo account sta per essere chiuso.</b></p><br><br>
				<p align="center"><input type="submit" value="CHIUDI ACCOUNT" class="pulsante"></p>
					<input type="hidden" name="username" value="<%=Cliente.getUsername()%>">
			</form>
				<br><br>
			<p align="center"><a href="index.jsp">Indietro</a></p>
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
