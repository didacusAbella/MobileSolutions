<html>

  <head>
    <title>Benvenuti su Mobile's Infinity</title>
    <link rel="stylesheet" type="text/css" href="stile.css">
    <LINK REL="shortcut icon" HREF="img/favicon.ICO">
    <SCRIPT Language=Javascript src="controlli.js"></SCRIPT>
    <meta name="author" content="Attanasio Carmine">
    <meta name="description" content="Mobile's Infinity">
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
          <br>
          <p align="center"><b>Modifica i tuoi dati personali.</b></p> <br>
          <form name="modificaCliente" action="modificaCli" method="get">
            <table border="0" align="center">
              <tr><td> <label>NOME *</label></td> <td><input type="text" name="nome" value="<%=Cliente.getNome()%>"></td></tr>
              <tr><td> <label>COGNOME *</label></td> <td><input type="text" name="cognome" value="<%=Cliente.getCognome()%>"></td></tr>
              <tr><td> <label>CODICE FISCALE *</label></td> <td><input type="text" name="cofiscale" value="<%=Cliente.getCodicefiscale()%>"></td></tr>
              <tr><td> <label>TIPO INDIRIZZO *</label></td> <td><select name="tipoindirizzo">
                    <option><%=Cliente.getTipoindirizzo()%></option>
                    <option>Largo</option>
                    <option>Piazza</option>
                    <option>Porta</option>
                    <option>Via</option> 
                    <option>Viale</option>
                    <option>Vicolo</option>  
                  </select></td></tr>

              <tr><td> <label>INDIRIZZO *</label></td> <td><input type="text" name="indirizzo" value="<%=Cliente.getIndirizzo()%>"></td></tr>
              <tr><td> <label>CAP *</label></td> <td><input type="text" name="cap" value="<%=Cliente.getCap()%>"></td></tr>
              <tr><td> <label>CITTA' *</label></td> <td><input type="text" name="citta" value="<%=Cliente.getCitta()%>"></td></tr>
              <tr><td> <label>PROVINCIA *</label></td> <td><select name="prov">
                    <option><%=Cliente.getProvincia()%></option>
                    <option>Agrigento</option>
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
                  </select></td></tr>
              <tr><td> <label>TELEFONO/CASA</label></td> <td><input type="text" name="telcas" value="<%=Cliente.getTelcasa()%>" onkeypress="return solonum(event)"></td></tr>
              <tr><td> <label>TELEFONO/CELLULARE *</label></td> <td><input type="text" name="telcel" value="<%=Cliente.getTelcell()%>" onkeypress="return solonum(event)"></td></tr>
              <tr><td> <label>FAX </label></td> <td><input type="text" name="fax" value="<%=Cliente.getFax()%>"></td></tr>
              <tr><td> <label>EMAIL *</label></td> <td><input type="text" name="email"  value="<%=Cliente.getEmail()%>"></td></tr>
              <tr><td> <label>PASSWORD *</label></td><td><input type="password" name="password" value="<%=Cliente.getPassword()%>"></td></tr>
              <tr><td> &nbsp </td><td> &nbsp </td></tr>
              <tr><td> &nbsp </td> <td><input type="hidden" name="username" value="<%=Cliente.getUsername()%>"></td></tr>
              <tr><td> &nbsp </td><td> &nbsp </td></tr>

            </table>
            <table align="center">  
              <tr align="center"><td> <input type="submit" value="MODIFICA" class="pulsante" onClick="return mod()"> </td></tr>
            </table>	    
          </form>
          <p align="center"> <a href="index.jsp">Indietro</a></p>
        </td>
        <td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
      </tr>
    </table>

  </body>

</html>
