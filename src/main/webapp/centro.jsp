<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>
	<%@page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*"%>

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