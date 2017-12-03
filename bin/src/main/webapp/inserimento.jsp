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
	<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
	<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
		<%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
 
	<jsp:include page="intestazione.jsp"/> 
	
 <table border="1" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
		<em>Da questa pagina puoi inserire un nuovo Cellulare</em> <br><br>
		
		<form name="insertNote" action="inserimento" method="get">
			<table border="0" align="center">
				<tr><td> <label>MARCA</label></td> <td><input type="text" name="marca"></td></tr>
				<tr><td> <label>MODELLO</label></td> <td><input type="text" name="modello"></td></tr>
				<tr><td> <label>DIMENSIONI</label></td> <td><input type="text" name="dimensioni"></td></tr>
				<tr><td> <label>FOTOCAMERA</label></td> <td><input type="text" name="fotocamera"></td></tr>
				<tr><td> <label>MEMORIA</label></td> <td><input type="text" name="memoria"></td></tr>
				<tr><td> <label>RISOLUZIONE SCHERMO</label></td><td><input type="text" name="risSchermo"></td></tr>
				<tr><td> <label>CONNETTIVITA'</label></td> <td> <select name="connettivita">
											<option selected>Bluetooth</option>
											<option>Infrarossi</option>
											<option>Bluetooth-Infrarossi</option>
											<option>USB</option>
										</select></td></tr>
				<tr><td> <label>IMMAGINE</label></td> <td><input type="file" name="immagine"></td></tr>
				<tr><td> <label>PREZZO</label></td> <td><input type="text" name="prezzo"></td></tr>
				<tr><td> <label>QUANTITA'</label></td> <td><select name="quantita">
										<option selected>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
										<option>10</option>
										<option>11</option>
										<option>12</option>
										<option>13</option>
										<option>14</option>
										<option>15</option>
										<option>16</option>
										<option>17</option>
										<option>18</option>
										<option>19</option>
										<option>20</option>
									   </select>
				</td></tr>
				<tr><td> &nbsp </td><td> &nbsp </td></tr>
				<tr align="center"><td> <input type="submit" value="INSERISCI" class="pulsante"> </td><td> <input type="reset" value="SVUOTA I CAMPI" class="pulsante"></td></tr>
				<tr><td> <input type="hidden" name="username" value="<%= Gestore.getUsername() %>"></td></tr>
			</table>
		    </form>
		    <a href="index.jsp">Indietro</a>
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
 </body>

</html>

