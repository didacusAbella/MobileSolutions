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
    <jsp:useBean id="Magazzino" class="com.didacusabella.mobilesolutions.beans.Magazzino" scope="session"/>

    <%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>

    <jsp:include page="intestazione.jsp"/> 

    <table border="1" align="center" valign="top" width="900">
      <tr>
        <td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
        <td valign="top">
          <br>
          <p align="center"><b>LE DISPONIBILITA PER QUESTO MODELLO SONO:</b></p>
          <br>
          <table border="0" align="center">

            <tr> <td><label>MODELLO</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Magazzino.getModello()%></p></td> </tr>
            <tr> <td><label>QUANTITA'ORDINABILE</label></td> <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> <td><p><%=Magazzino.getQuantita()%></p></td> </tr>

          </table>



          <p align="center"><a href="javascript:history.go(-1)"> Indietro </a></p>

        </td>
        <td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
      </tr>
    </table>

  </body>

</html>

