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
	<jsp:useBean id="Cellulari" class="com.didacusabella.mobilesolutions.beans.Cellulari" scope="session"/>
       
		<%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
	<td valign="top">
        <br>
	<p align="center"><b>SCHEDA TECNICA DEL CELLULARE</b></p>
				<br>
			<table border="0" align="center">
				<tr> <td><label>MARCA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getMarca()%></p></td> </tr>
				<tr> <td><label>MODELLO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getModello()%></p></td> </tr>
				<tr> <td><label>CLICCA FOTO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><a href="#" onclick="javascript:window.open('img/cell/<%=Cellulari.getImmagine()%>','Cellulare','width=300,height=500,left=30,top=30,resizable=no,scrollbars=yes');"><img src="img/cell/<%=Cellulari.getImmagine()%>" alt="<%=Cellulari.getImmagine()%>" width="100" height="150"></a></td> </tr>
                                <tr> <td><label>TECNOLOGIA/SISTEMA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getTecnologia()%></p></td> </tr>
                                <tr> <td><label>RETE</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getRete()%></p></td> </tr>
                                <tr> <td><label>SISTEMA OPERATIVO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getSisoper()%></p></td> </tr>
                                <tr> <td><label>PESO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getPeso()%></p></td> </tr>
                                <tr> <td><label>DIMENSIONI</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getDimensioni()%></p></td> </tr>
				<tr> <td><label>FOTOCAMERA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getFotocamera()%></p></td> </tr>
				<tr> <td><label>MEMORIA INT.</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getMemoriaint()%></p></td> </tr>
				<tr> <td><label>MEMORIA EST.</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getMemoriaest()%></p></td> </tr>
                                <tr> <td><label>DISPLAY-SCHERMO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getRisSchermo()%></p></td> </tr>
				<tr> <td><label>CONNETTIVITA'</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getConnettivita()%></p></td> </tr>
				<tr> <td><label>VIBRAZIONE</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getVibrazione()%></p></td> </tr>
		                <tr> <td><label>BATTERIA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getBatteria()%></p></td> </tr>
			        <tr> <td><label>AUTONOMIA CONV</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getAutonomia()%></p></td> </tr>
                                <tr> <td><label>AUTONOMIA STAND-BY</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getAutonomiast()%></p></td> </tr>
                                <tr> <td><label>ANTENNA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getAntenna()%></p></td> </tr>	
                                <tr> <td><label>BROWSER</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getBrowser()%></p></td> </tr>
                                <tr> <td><label>GIOCHI</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getGiochi()%></p></td> </tr>
                                <tr> <td><label>MESSAGGISTICA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getMessaggi()%></p></td> </tr>
                                <tr> <td><label>JAVA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getJava()%></p></td> </tr> 
                                <tr> <td><label>VIDEOCHIAMATA</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getVideochiamata()%></p></td> </tr>
                                <tr> <td><label>GPS</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getGps()%></p></td> </tr>
                                <tr> <td><label>LETTORE MP3/WMA/MPEG</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getLettori()%></p></td> </tr>
                                <tr> <td><label>VIVAVOCE</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getVivavoce()%></p></td> </tr>
                                <tr> <td><label>RADIO FM</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getRadio()%></p></td> </tr>
                                <tr> <td><label>SUONERIE SCARICABILI</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getSuonerie()%></p></td> </tr>
                                <tr> <td><label>PREZZO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Cellulari.getPrezzo()%> euro</p></td> </tr>
                              
</table>
  <p align="center"><a href="completaDispon?mod=<%=Cellulari.getModello()%>">Visualizza quantità ordinabili</p> </a>                        
				<% if (Cliente.isLoggato()==true) { %>
                              <table align="center">
			<tr><td> <form action="insertCarrello" method="post">
					<input type="submit" value="INSERISCI NEL CARRELLO" class="pulsante">
					   <input type="hidden" name="username" value="<%=Cliente.getUsername()%>">
					   <input type="hidden" name="modello" value="<%=Cellulari.getModello()%>">
				 </form>
			</td></tr>
                           </table>
				<% } %>
                   
		
			<p align="center"><a href="javascript:history.go(-1)"> Indietro </a></p>
	
	</td>
  </tr>
 </table>
    
</body>

</html>

