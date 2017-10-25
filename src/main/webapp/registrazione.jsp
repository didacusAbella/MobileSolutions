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
	
 <table border="0" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
                        <br>  
			<p align=center><b>Registrati e diventa subito nostro cliente</b></p> <br><br><br>
			<form name="registra" action="registrazione" method="post">
			<table border="0" align="center">
				<tr><td> <label>NOME*</label></td> <td><input type="text" name="nome"></td></tr>
				<tr><td> <label>COGNOME *</label></td> <td><input type="text" name="cognome"></td></tr>
                                <tr><td> <label>CODICE FISCALE *</label></td><td><input type="text"name="cofiscale"></td></tr>
				<tr><td> <label>TIPO INDIRIZZO *</label></td> <td><select name="tipoindirizzo">
                                                                                 <option selected>Largo</option>
                                                                                 <option>Piazza</option>
                                                                                  <option>Porta</option>
                                                                                 <option>Via</option> 
                                                                                  <option>Viale</option>
                                                                                  <option>Vicolo</option>  
                                                                               </select></td></tr>
                                <tr><td> <label>INDIRIZZO *</label></td> <td><input type="text" name="indirizzo"></td></tr>
                                <tr><td> <label>CAP *</label></td> <td><input type="text" name="cap"></td></tr>
                                <tr><td> <label>CITTA' *</label></td> <td><input type="text" name="citta"></td></tr>
		                <tr><td> <label>PROVINCIA *</label></td> <td><select name="prov">
                                                                              <option selected>Agrigento</option>
						<option>Alessandria</option>
						<option>Ancona</option>
						<option>Aosta</option>
						<option>Arezzo</option>
						<option>Ascoli Piceno</option>
						<option>Asti</option>
						<option>Avellino</option>
						<option>Bari</option>
						<option>Belluno</option>
						<option>Benevento</option>
						<option>Bergamo</option>
						<option>Biella</option>
						<option>Bologna</option>
						<option>Bolzano</option>
						<option>Brescia</option>
						<option>Brindisi</option>
						<option>Cagliari</option>
						<option>Caltanisetta</option>
						<option>Campobasso</option>
						<option>Caserta</option>
						<option>Catania</option>
						<option>Catanzaro</option>
						<option>Chieti</option>
						<option>Como</option>
						<option>Cosenza</option>
						<option>Cremona</option>
						<option>Crotone</option>
						<option>Cuneo</option>
						<option>Enna</option>
						<option>Estero</option>
						<option>Ferrara</option>
						<option>Firenze</option>
						<option>Foggia</option>
						<option>Forli</option>
						<option>Forli-Cesena</option>
						<option>Frosinone</option>
						<option>Genova</option>
						<option>Gorizia</option>
						<option>Grosseto</option>
						<option>Imperia</option>
						<option>Isernia</option>
						<option>L'Aquila</option>
						<option>La Spezia</option>
						<option>Latina</option>
						<option>Lecce</option>
						<option>Lecco</option>
						<option>Livorno</option>
						<option>Lodi</option>
						<option>Lucca</option>
						<option>Macerata</option>
						<option>Mantova</option>
						<option>Massa Carrara</option>
						<option>Matera</option>
						<option>Messina</option>
						<option>Milano</option>
						<option>Modena</option>
						<option>Monza e Brianza</option>
						<option>Napoli</option>
						<option>Novara</option>
						<option>Nuoro</option>
						<option>Oristano</option>
						<option>Padova</option>
						<option>Palermo</option>
						<option>Parma</option>
						<option>Pavia</option>
						<option>Perugia</option>
						<option>Pesaro</option>
						<option>Pesaro-Urbino</option>
						<option>Pescara</option>
						<option>Piacenza</option>
						<option>Pisa</option>
						<option>Pistoia</option>
						<option>Pordenone</option>
						<option>Potenza</option>
						<option>Prato</option>
						<option>Ragusa</option>
						<option>Ravenna</option>
						<option>Reggio Calabria</option>
						<option>Reggio Emilia</option>
						<option>Rieti</option>
						<option>Rimini</option>
						<option>Roma</option>
						<option>Rovigo</option>
						<option>Salerno</option>
						<option>Sassari</option>
						<option>Savona</option>
						<option>Siena</option>
						<option>Siracusa</option>
						<option>Sondrio</option>
						<option>Taranto</option>
						<option>Teramo</option>
						<option>Terni</option>
						<option>Torino</option>
						<option>Trapani</option>
						<option>Trento</option>
						<option>Treviso</option>
						<option>Trieste</option>
						<option>Udine</option>
						<option>Varese</option>
						<option>Venezia</option>
						<option>Verbania</option>
						<option>Vercelli</option>
						<option>Verona</option>
						<option>Vibo Valentia</option>
						<option>Vicenza</option>
						<option>Viterbo</option>   
                                       </select>
				<tr><td> <label>TELEFONO/CASA</label></td> <td><input type="text" name="telcas" onkeypress="return solonum(event)"></td></tr>
                                <tr><td> <label>TELEFONO/CELLULARE *</label></td> <td><input type="text" name="telcel" onkeypress="return solonum(event)"></td></tr>
				<tr><td> <label>FAX </label></td> <td><input type="text" name="fax"></td></tr>
                                <tr><td> &nbsp </td><td> &nbsp </td></tr>
				<tr><td> <label>USERNAME *</label></td> <td><input type="text" name="username"></td></tr>
				<tr><td> <label>PASSWORD *</label></td> <td><input type="password" name="password"></td></tr>
				<tr><td> <label>CONFERMA PASSWORD *</label></td><td><input type="password" name="confpassword"></td></tr>
				
				<tr><td> <label>EMAIL *</label></td> <td><input type="text" name="email"></td></tr>
				<tr><td> &nbsp </td><td> &nbsp </td></tr>
</table>
		     <table border="0">

<tr><td><p align="center">Leggi l' INFORMATIVA relativa  trattamento dei tuoi dati personali: <a href="#" onclick="javascript:window.open('privacy.jsp','finestraPrivacy','width=550,height=500,left=30,top=30,resizable=no,scrollbars=yes');">Informativa</a>.</p></td></tr>
<tr><td><p align="justify"><b>Pienamente informato/a in base all'art.13 del D.Lgs. 196/2003 sul trattamento dei propri dati personali
                        ai sensi dell'art.23 dello stesso:</b></p></td></tr>
<tr><td> <ul><li><p align="justify">Esprimo il consenso al trattamento dei miei dati personali al fine di consentire che venga fornito il servizio o la prestazione richiesta.</p></li></ul></td>
<td><label>Si</label><input name="clausola1"type="checkbox" value="Si"></td><td><label>No</label><input name="clausola1"type="checkbox" value="No"></td></tr>

<tr><td> <ul><li><p align="justify">Esprimo il consenso al trattamento dei miei dati personali a terzi,che svolgono attività funzionalmente collegate all'esecuzione del servizio richiesto(può trattarsi 
di società italiane o estere). Non saranno in nessun caso ceduti a terzi per fini commerciali e/o marketing.</p></li></ul></td>
<td><label>Si</label><input name="clausola2"type="checkbox" value="Si"></td><td><label>No</label><input name="clausola2"type="checkbox" value="No"></td></tr>
<tr align="center"><td><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="submit" value="Invio" class="pulsante" onClick="return controllo()"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><input type="reset" value="Reset" class="pulsante"></td></tr>                 
			 

		
</table>                   
 </form>	


	
	     	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>   

		 

    <br>
                    <p align=center><b>Nota bene:</b> i campi contrassegnati con l'asterisco(*) sono obblibatori</p><br><br>
		    <p align="center"><a href="index.jsp">Indietro</a></p>
</body>

</html>
