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
		
		<% ArrayList carr = (ArrayList)session.getAttribute("Carr");
			Cellulari cell = new Cellulari(); 
			int totale=0; %>
			
	<jsp:include page="intestazione.jsp"/> 
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
		<% if (carr.size()==0) { %>
			<p align="center"><img src="img/carrello.jpg" alt="CARRELLO" width="70" height="50"></p><br>
			<p align="center"><b> IL CARRELLO NON CONTIENE CELLULARI </b></p>
			<br><br><br><br><br>
			<p align="center"><a href="index.jsp">Indietro</a></p>
		<% } else {%>
	        <br>
		<p align="center"><b>PRODOTTI PRESENTI NEL CARRELLO</b></p>
			<br> 
                         
                  
		<% for(int i=0;i<carr.size();i++)
		    {
			cell=(Cellulari)carr.get(i); 
			
			int t=Integer.parseInt(cell.getPrezzo());
			int totF=t;
			totale=totale+totF; %>
		    
		  
                     <table>   
		    <tr><td><label>MARCA</label>: <%=cell.getMarca()%></td></tr>
                    <tr><td><label>MODELLO</label>: <%=cell.getModello()%></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td><img src="img/carrello.jpg" alt="CARRELLO" width="70" height="50"></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td><label>PREZZO</label>: <%=cell.getPrezzo()%> euro</td></tr>
	            <tr></tr>
			</table>
			   <form action="rimuoviCarrello">
					<p align="center"><input type="submit" value="RIMUOVI" class="pulsante"></p>
					<input type="hidden" name="modello" value="<%=cell.getModello()%>">
				 </form>
			     
			
			   
		    <hr>
		    <% } %>
		    	<p align="center"><b> LA SPESA TOTALE ESCLUSI I COSTI E'DI= <%= (int)totale %> euro </b></p>
		        <p align="center">Per acquistare i prodotti del tuo carrello clicca su "<b>Acquista il contenuto</b>"</p>
                     <form action="acquistaCarrello" method="get">
		    	<p align="center"><input type="submit" value="ACQUISTA IL CONTENUTO" class="pulsante"></p>
			<input type="hidden" name="username" value="<%=Cliente.getUsername()%>">
		    </form>
		   <% } %>

	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
