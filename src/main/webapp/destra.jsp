<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>

<%@page import="com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.*"%>

<% if (Gestore.isLoggato()==true)  { %>
	<p align="center"><label> BENTORNATO <%= Gestore.getUsername() %> </label></p> <br><br>
	
	<table border="0">
		<tr><td> <a href="inserimento.jsp">Inserisci Cellulare</a> </td></tr>
		<tr><td> <a href="modificaCell.jsp">Modifica Cellulare</a> </td></tr>
		<tr><td> <a href="cancellaCell.jsp">Cancella Cellulare</a> </td></tr>
		<tr><td> <a href="clienti.jsp">Visualizza Clienti</a> </td></tr>
		<tr><td> <a href="esaurimento.jsp">Esaurimento Cellulari</a> </td></tr>
		<tr><td> <a href="importazione.jsp">Importa XML esterno</a> </td></tr>
	</table>
	<br><br>
	<form action="logout_gestore">
		<input type="submit" value="LOGOUT" class="pulsante">
	</form>
<% } %>


<!--<p align="center"><label> BENTORNATO <%= Cliente.getNome() %> </label></p> <br><br>-->
	
