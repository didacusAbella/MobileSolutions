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
	
	     <%@page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		
<table align="center">
        <form name="ricerca" action="ricerca" method="get">

<tr>
                                         <td><label>MARCA:</label></td> <td><select name="marca">
							   	<option selected>nokia</option>
								<option>Nokia</option>
								<option>samsung</option>
								</select></td>
							   	
	     <td><label>MODELLO:</label></td> <td><input type="text" name="modello"></td>
	     <td><input type="submit" value="Start" class="pulsante"></td>

</tr>
</table>
</form>

  <table border="1" align="center" valign="top" width="900">
  <tr>
  	
	<td valign="top">
		<%   
		ArrayList lista = new ArrayList(); 
					lista.clear();
					lista = (ArrayList)session.getAttribute("Cellulari");

				if (lista.size()!=0)
				{ %>
			    	<p align="center"><b>Sono presenti <%=lista.size()%> cellulari con le caratteristiche richieste</b></p>
				<br><br>
				<% for (int i=0; (i<lista.size()); i++) 
					{
						Cellulari cell = (Cellulari)lista.get(i); %>
					<table border="0">
						<tr> <td> &nbsp; </td> </tr>
						<tr>
							<td>
							<p>MARCA: <label><%=cell.getMarca()%></label></p>
							<p>MODELLO: <label><%=cell.getModello()%></label></p>
							<p>PREZZO: <label><%=cell.getPrezzo()%> euro</label></p>
							</td>
							<td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
							<td><a href="#" onclick="javascript:window.open('img/cell/<%=cell.getImmagine()%>','Cellulare','width=300,height=500,left=30,top=30,resizable=no,scrollbars=yes');"><img src="img/cell/<%=cell.getImmagine()%>" alt="<%=cell.getImmagine()%>" width="50" height="80"></a></td>
						</tr>
					</table>
						<p><a href="completaCell?mod=<%=cell.getModello()%>"> Visualizza Caratteristiche </a></p>
					 <hr>
				<% } %>
					<br><br> <p align="center"><a href="ricercaAvanzata.jsp">Ritorna a Ricerca Avanzata</a></p>
				<% } else { %>
					<br><br>
					   <p align="center"><b>Non sono presenti cellulari che soddisfano le tue richieste</b></p>
                                           <p align="center"><b>Rieffettua una ricerca semplice oppure linkati per quella avanzata</b></p>
                                           <br><br><br>
					   <p align="center"><a href="ricercaAvanzata.jsp">Ritorna a Ricerca Avanzata</a></p>
				<% } %>
	
	
	</td>
  </tr>
 </table>
    
</body>

</html>
