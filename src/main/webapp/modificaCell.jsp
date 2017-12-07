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
		<%@page import="java.util.ArrayList,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
		<%ArrayList arr = new ArrayList();
		   	String path = getServletContext().getRealPath("/");
			DBCell db = new DBCell(path+"WEB-INF/database/cellulari.xml");
				arr.clear();
				arr = db.listaCell(); %>
 
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
	<td valign="top">
		<p>Scegli il Cellulare da modificare</p>
		<form action="modificaCellulare">
			<table border="0" align="center">
				<tr><td> &nbsp </td> <td> &nbsp </td></tr>
				<tr><td> &nbsp </td> <td> &nbsp </td></tr>
				 <tr><td><label>SCEGLI IL CELLULARE</label></td> <td><select name="modelloCell">
				 			<% for (int i=0;i<arr.size();i++) 
							    {
							      String app=(String)arr.get(i);%>
								<option><%=app%></option>
							 <% } %>
								     </select></td></tr>
				<tr><td> &nbsp </td> <td> &nbsp </td></tr>
				<tr><td> &nbsp </td> <td> &nbsp </td></tr>
				<tr><td><input type="submit" value="MODIFICA IL CELLULARE" class="pulsante"></td></tr>
			</table>
		    </form>
		    	<br><br><br>
		    <a href="index.jsp">Indietro</a>
	
	
	
	</td>
  </tr>
 </table>
    
</body>

</html>
