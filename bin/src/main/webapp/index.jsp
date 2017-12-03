<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ms" %>

<ms:layout title="Benvenuto su Mobile Solutions">
  <jsp:attribute name="header">
    <jsp:include page="intestazione.jsp"/>
  </jsp:attribute>
  <jsp:attribute name="footer">
    <jsp:include page="centro.jsp"/>
  </jsp:attribute>
  <jsp:body>
    <h1>Welcome</h1>
  </jsp:body>
</ms:layout>
   <!--   jsp:include page="intestazione.jsp"/>
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

    </table>
  </form>

  <p align="center">Effettua una ricerca personalizzata alle tue esigenze seguendo il link <a href="ricercaAvanzata.jsp">Ricerca Avanzata</a></p>


  <table border="0" align="center" valign="top" width="900">

    <tr>
      <td valign="top" width="160"> jsp:include page="sinistra.jsp"/> </td>
      <td valign="top"> jsp:include page="centro.jsp"/> </td>
      <td valign="top" width="160"> jsp:include page="destra.jsp"/> </td>
    </tr>
  </table>-->
