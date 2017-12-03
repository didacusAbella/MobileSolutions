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


<% if (Cliente.isLoggato()==true) { %>
	<p align="center"><label> BENTORNATO <%= Cliente.getNome() %> </label></p> <br><br>
	
	<table border="0">
           

		<tr><td> <a href="carrello.jsp">Visualizza Carrello</a> </td></tr>
		<tr><td> <a href="acquisti.jsp">Visualizza Acquisti</a> </td></tr>
                <tr><td> <a href="modificaCli.jsp">Modifica Profilo</a> </td></tr>
		<tr><td> <a href="cancellaCli.jsp">Chiudi l'account</a> </td></tr>
	</table>
	<br><br>
	<form action="logout_cliente">
		<input type="submit" value="LOGOUT" class="pulsante">
	</form>
<% } %>


<% if ((Gestore.isLoggato()==false) && (Cliente.isLoggato()==false))  { %>

<table border="0" align="center">

  <form name="login_cliente" method="post" action="login_cliente">
   
    <tr> <td> <label>USERNAME</label> </td> <td> <input type="text" name="username"size="11"> </td> </tr>
    <tr> <td> <label>PASSWORD</label> </td> <td> <input type="password" name="password"size="11"> </td> </tr>
    <tr> <td> &nbsp; </td> <td> &nbsp; </td> </tr>
    <tr> <td> <input type="submit" value="LOGIN" class="pulsante"> </td> <td> <input type="reset" value="RESET" class="pulsante"> </td> </tr>
    
</form>
</table>


<table border="0" align="center">

  <form name="login_gestore" method="post" action="login_gestore">
    <tr> <td> <label>USERNAME</label> </td> <td> <input type="text" name="username"size="11"> </td> </tr>
    <tr> <td> <label>PASSWORD</label> </td> <td> <input type="password" name="password"size="11"> </td> </tr>
    <tr> <td> &nbsp; </td> <td> &nbsp; </td> </tr>
    <tr> <td> <input type="submit" value="LOGIN" class="pulsante"> </td> <td> <input type="reset" value="RESET" class="pulsante"> </td> </tr>

 </form>

</table>



<% } %>
