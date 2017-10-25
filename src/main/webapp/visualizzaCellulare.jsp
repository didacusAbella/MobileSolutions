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
	     <%@ page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		
	<jsp:include page="intestazione.jsp"/> 
	

<table align="center">
        <form name="ricerca" action="ricerca" method="get">

<tr><td><OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/
swflash.cab#version=5,0,0,0" WIDTH=120 HEIGHT=100 >
<PARAM NAME=movie VALUE="img/ric24b.swf">
<PARAM NAME=quality VALUE=high>
<EMBED src="ric24b.swf" quality=high width=120 HEIGHT=100
type="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?
P1_Prod_Version=ShockwaveFlash"></EMBED>
</OBJECT></td>

                                                 <td><label>MARCA:</label></td> <td><select name="marca">
							   	<option selected>nokia</option>
								<option>Nokia</option>
								<option>samsung</option>
								</select></td>
							   	
	     <td><label>MODELLO:</label></td> <td><input type="text" name="modello"></td>
	     <td><input type="submit" value="Start" class="pulsante"></td>
<td><OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/
swflash.cab#version=5,0,0,0" WIDTH=120 HEIGHT=100 >
<PARAM NAME=movie VALUE="img/ric24b.swf">
<PARAM NAME=quality VALUE=high>
<EMBED src="ric24b.swf" quality=high width=120 HEIGHT=100
type="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?
P1_Prod_Version=ShockwaveFlash"></EMBED>
</OBJECT></td></tr>
 </form>
</table>

  <table border="1" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
		<% String ris=(String)session.getAttribute("Risultato");
				if (ris.equals("PRODOTTO NON TROVATO"))
				{ %>
			<p align="center"> ATTENZIONE </p>
			<p align="center">Cellulare non presente nel nostro negozio</p>
				<br><br><br><br>
			<p align="center"><a href="index.jsp">Vai alla Home Page</a></p>
			
				<% } else { %>
				
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

			<p align="center"><a href="index.jsp">Vai alla Home Page</a></p>
				<% } %>
	
	
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>

    
</body>

</html>
