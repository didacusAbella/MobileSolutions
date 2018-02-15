<html>

  <head>
    <title>BENVENUTI SU MOBILE MANIA</title>
    <link rel="stylesheet" type="text/css" href="stile.css">

    <meta name="author" content="Attanasio Carmine">
    <meta name="description" content="MOBILE MANIA">
    <meta name="generator" content="jEdit">
  </head>

  <body>
    <jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
    <jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
    <%@page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>


    <table border="1" align="center" valign="top" width="900">
      <tr>
        <td valign="top">
          <% int pagina;
            if (request.getParameter("page") != null) {
              pagina = Integer.parseInt(request.getParameter("page"));
            } else {
              pagina = 1;
            }

            String path = getServletContext().getRealPath("/");
            DBCell db = new DBCell(path + "WEB-INF/database/cellulari.xml");
            ArrayList lista = new ArrayList();
            lista.clear();
            lista = (ArrayList) session.getAttribute("lis");
            if (lista.size() != 0) {
              int n = lista.size() / 5;
              if ((lista.size() % 5) != 0) {
                n += 1;
                    }
                    int elem = 5;%>
          <br><p align="center"><b>Si possono acquistare oltre <%=lista.size()%> modelli diversi di cellulari </b></p>


          Visualizza la pagina
          <% for (int i = 1; i <= n; i++) {%>
          <a href="lista.jsp?page=<%=i%>"> <%=i%> </a>
          <% } %>
          <% for (int i = (pagina * elem) - elem; ((i < (pagina * (elem))) & (i < lista.size())); i++) {
                                    Cellulari cell = (Cellulari) lista.get(i);%>

          <table border="0">
            <tr> <td> &nbsp; </td> </tr>
            <tr>
              <td>
                <p>MARCA: <label><%=cell.getMarca()%></label></p>
                <p>MODELLO: <label><%=cell.getModello()%></label></p>
                <p>PREZZO: <label><%=cell.getPrezzo()%> euro</label></p>

              </td>
              <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
              <td><a href="#" onclick="javascript:window.open('img/cell/<%=cell.getImmagine()%>', 'Cellulare', 'width=300,height=500,left=30,top=30,resizable=no,scrollbars=yes');"><img src="img/cell/<%=cell.getImmagine()%>" alt="<%=cell.getImmagine()%>" width="50" height="80"></a></td>
            </tr>



          </table>
          <br>
          <table>
            <tr>
              <td></td><td></td><td></td><td></td><td></td><td></td><td></td>   
              <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>   
              <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>   
              <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>   
              <td></td><td></td><td></td><td></td><td></td><td></td> <td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td><td></td>        
              <td> <a href="completaCell?mod=<%=cell.getModello()%>">Visualizza Caratteristiche </a></td></tr>
          </table>
          <hr>
          <% }
                                } else { %>
          <br><br>
          <p>AL MOMENTO NON E' DISPONIBILE NESSUN CELLULARE</p>
          <% }%>
        </td>
      </tr>
    </table>

  </body>

</html>
