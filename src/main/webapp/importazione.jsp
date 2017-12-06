<html>

<head>
   <title>BENVENUTI SU MOBILE MANIA</title>
   <link rel="stylesheet" type="text/css" href="stile.css">
   <LINK REL="shortcut icon" HREF="img/favicon.ICO">
   <meta name="author" content="Galdi Luca">
   <meta name="description" content="MOBILE MANIA">
   <meta name="generator" content="jEdit">
</head>

<body>
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
	<td valign="top">
		<p>DA QUESTA PAGINA PUOI IMPORTARE UN FILE XML ESTERNO<br>
		    Ricorda di inserire il file XML esterno nella cartella database di WEB-INF prima di importarlo.<br>
		     Inoltre il file XML esterno deve avere un ulteriore tag quantita</p>
		 <br><br><br>
		<form name="importazione" method="post" action="importazione">
		  <table border="0">
		   <tr><td><label>Scegli il file XML esterno</label><input type="file" name="esterno"></td></tr>
		   <tr><td> &nbsp; </td></tr>
		   <tr><td><input type="submit" value="IMPORTA" class="pulsante"><input type="reset" value="SVUOTA I CAMPI" class="pulsante"></td></tr>
		  </table> 
		</form>
	<br><br><br>
	<a href="index.jsp">Indietro</a>
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
