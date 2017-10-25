<html>

  <head>
    <title>Benvenuti su Mobile's Infinity</title>
    <link rel="stylesheet" type="text/css" href="stile.css">
    <meta name="author" content="Attanasio Carmine">
    <meta name="description" content="Mobile Solutions">
    <meta name="generator" content="jEdit">
  </head>

  <body>
    <jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
    <jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
    <%@page import="java.util.*, com.didacusabella.mobilesolutions.beans.*, com.didacusabella.mobilesolutions.gestioneDB.*" %>
    <% ArrayList arr = new ArrayList();
      ArrayList array = new ArrayList();
      Vendite ven = new Vendite();
      Ordini ord = new Ordini();
      String cliente = Cliente.getUsername();
      String path = getServletContext().getRealPath("/");
      DBVendite db = new DBVendite(path + "WEB-INF/database/vendite.xml");
      arr = db.listaVendite(cliente);
      DBOrdini dbo = new DBOrdini(path + "WEB-INF/database/ordini.xml");
      array = dbo.listaOrdini(cliente); %>

    <jsp:include page="intestazione.jsp"/> 

    <table border="1" align="center" valign="top" width="900">
      <tr>
        <td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
        <td valign="top">
          <% if (arr.size() == 0) { %>
          <br><p align="center"><b> NON HAI EFFETTUATO ALCUN ACQUISTO </b></p>
          <br><br><br>
          <p align="center"><a href="index.jsp">Indietro</a></p>
          <% } else { %>


          <br><label><h3 align="center"><font color="red">Ecco tutti i tuoi ordini </font></h3></label>
          <table border="0"align="center">

            <% for (int i = 0; i < array.size(); i++) {
                ord = (Ordini) array.get(i);%>

            <tr><td><b>Id Ordine</b> </td><td><%=ord.getIdordine()%></td></tr>
            <tr><td><b>Data Ordine</b> </td> <td><%=ord.getDataInoltro()%> </td>  </tr>
            <tr><td><b>Modalità Spedizione</b></td><td><%=ord.getModalitaSpe()%></td></tr>
            <tr><td><b>Modalità Pagamento</b> </td><td><%=ord.getModalitaPay()%></td></tr>
            <tr><td> <b>Totale Pagamamento</b> </td><td> <%=ord.getTotalePag()%></td></tr>

            <% } %>


          </table>


          <br><label><p align="center"><font color="red">Relativi acquisti:</font></p></label>
          <table border="0"align="center">

            <% for (int i = 0; i < arr.size(); i++) {
                ven = (Vendite) arr.get(i);%>

            <tr><td><b>Marca</b></td><td><%=ven.getMarca()%></td></tr>
            <tr><td><b>Modello</b></td><td><%=ven.getModello()%></td></tr>
            <tr><td><b>Prezzo</b></td><td><%=ven.getPrezzo()%></td></tr>

            <% } %>
          </table>
          <hr>
          <br><br>
          <p align="center"><a href="index.jsp">Indietro</a></p>










          <% }%>	
        </td>
        <td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
      </tr>
    </table>

  </body>

</html>
