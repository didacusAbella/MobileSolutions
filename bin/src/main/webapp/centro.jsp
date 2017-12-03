<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
	<%@page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*"%>

<p align="center"> <OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/
swflash.cab#version=5,0,0,0" WIDTH=160 HEIGHT=140 >
<PARAM NAME=movie VALUE="img/novità.swf">
<PARAM NAME=quality VALUE=high>
<EMBED src="novità.swf" quality=high width=160 HEIGHT=140
type="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?
P1_Prod_Version=ShockwaveFlash"></EMBED>
</OBJECT></p>

	<% ArrayList arr = new ArrayList();
		String path = getServletContext().getRealPath("/");
		DBCell db = new DBCell(path+"WEB-INF/database/cellulari.xml"); 
		arr=db.novita();
		Cellulari cell = new Cellulari();	%>
		
	<table border="0" align="center" width="400">
		<tr align="center"><% if (arr.size()>4) {
			for (int i=0;i<3;i++) {
				cell = (Cellulari)arr.get(i); %>
			<td> 
				<label><b><%=cell.getMarca()%></b></label>
				<br>
				<a href="#" onclick="javascript:window.open('img/cell/<%=cell.getImmagine()%>','Cellulare','width=300,height=500,left=30,top=30,resizable=no,scrollbars=yes');"><img src="img/cell/<%=cell.getImmagine()%>" alt="<%=cell.getImmagine()%>" width="70" height="100"></a>
				<a href="completaCell?mod=<%=cell.getModello()%>"> <p><%=cell.getModello()%></p> </a>

			</td>
				<% } } %>
		</tr>
	<tr> <td> &nbsp </td> <td> &nbsp </td> <td> &nbsp </td> </tr>
		<tr align="center"><% if (arr.size()>4) {
			for (int i=3;i<6;i++) {
				cell = (Cellulari)arr.get(i); %>
			<td> 
				<label><b><%=cell.getMarca()%></b></label>
				<br>
				<a href="#" onclick="javascript:window.open('img/cell/<%=cell.getImmagine()%>','Cellulare','width=300,height=500,left=30,top=30,resizable=no,scrollbars=yes');"><img src="img/cell/<%=cell.getImmagine()%>" alt="<%=cell.getImmagine()%>" width="70" height="100"></a>
				<a href="completaCell?mod=<%=cell.getModello()%>"> <p><%=cell.getModello()%></p> </a>
			</td>
				<% } } else { %> <p>NON CI SONO NOVITA' IN MAGAZZINO</p> <% } %>
		
       </tr>
	
       </table>
<br>
<em>Usiamo i più sicuri sistemi di pagamento per le transazioni, oltre a quelli tradizionali</em>
<p align="center"><img src="img/paypal.bmp" alt="paypal"width="60" height="32"><img src="img/postpay.gif" alt="ppay"width="60" height="32"></p>
 
 <hr>
<p align="center"><em> Questo sito &egrave; ottimizzato per una risoluzione 1024x768 pixel <br> 
            Testato su Internet Explorer  </em> <img src="img/explorer.gif" alt="Internet Explorer" width="18" height="18"> <br>
    <strong> &copy; Attanasio Carmine 2007-2008 </strong></p>
