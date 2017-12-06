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
    <jsp:useBean id="Cellulari" class="com.didacusabella.mobilesolutions.beans.Cellulari" scope="session"/>
    <%@ page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>


    <table border="1" align="center" valign="top" width="900">
      <tr>
        <td valign="top">
          <p> Da questa pagina puoi modificare le caratteristiche del Cellulare </p>
          <form action="modCaratt" method="post">
            <table border="0" align="center">
              <tr><td><label>MARCA</label></td> <td><input type="text" name="marca" value="<%=Cellulari.getMarca()%>"></td></tr>
              <tr><td><label>MODELLO</label></td> <td><input type="text" name="modello" value="<%=Cellulari.getModello()%>"></td></tr>
              <tr><td><label>IMMAGINE</label></td> <td><input type="text" name="immagine" value="<%=Cellulari.getImmagine()%>"></td></tr>
              <tr><td><label>DIMENSIONI</label></td> <td><input type="text" name="dimensioni" value="<%=Cellulari.getDimensioni()%>"></td></tr>
              <tr><td><label>FOTOCAMERA</label></td> <td><input type="text" name="fotocamera" value="<%=Cellulari.getFotocamera()%>"></td></tr>
              <tr><td><label>MEMORIA</label></td> <td><input type="text" name="memoria" value="<%=Cellulari.getMemoria()%>"></td></tr>
              <tr><td><label>RISOLUZIONE SCHERMO</label></td> <td><input type="text" name="risSchermo" value="<%=Cellulari.getRisSchermo()%>"></td></tr>
              <tr><td><label>CONNETTIVITA'</label></td> <td><input type="text" name="connettivita" value="<%=Cellulari.getConnettivita()%>"></td></tr>
              <tr><td><label>PREZZO</label></td> <td><input type="text" name="prezzo" value="<%=Cellulari.getPrezzo()%>"></td></tr>

              <tr><td><label>QUANTITA' DA AGGIUNGERE</label></td> <td><select name="quantita">
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
                </td>
              </tr>
              <tr><td> &nbsp </td> <td> &nbsp </td></tr>
              <tr><td align="center"><input type="submit" value="MODIFICA IL CELLULARE" class="pulsante"></td></tr>
              <tr><td><input type="hidden" name="username" value="<%= Gestore.getUsername()%>"></td></tr>				
            </table>
          </form>
          <br>
          <a href="javascript:history.go(-1)"> Indietro </a>	
        </td>
        <td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
      </tr>
    </table>

  </body>

</html>
