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
		 <% ArrayList lista = new ArrayList();
			lista=(ArrayList)session.getAttribute("esaur"); %>
				
	<jsp:include page="intestazione.jsp"/> 
	
  <table border="1" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
			<%if (lista.size()!=0)
				{ %>
			    	<p> CI SONO <%=lista.size()%> CELLULARI CHE STANNO PER FINIRE </p>
				<% for (int i=0; (i<lista.size()); i++) 
					{
						Magazzino mag = (Magazzino)lista.get(i); %>
					<table border="0">
						<tr> <td> &nbsp; </td> </tr>
						<tr>
							<td>
							  <p>MODELLO: <label><%=mag.getModello()%></label></p>
							  <p>QUANTITA': <label><%=mag.getQuantita()%></label></p>
							</td> 
						</tr>
					</table>
					 <hr>
				<% } %>
					<br><br> <a href="javascript:history.go(-1)"> Indietro </a>
				<% } else { %>
					<br><br>
					   <em>NON SONO PRESENTI CELLULARI CHE STANNO PER FINIRE!!!</em>
					   <br><br><br><br><br><br><br>
					   <a href="javascript:history.go(-1)"> Indietro </a>
				<% } %>
	
		
	</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>
    
</body>

</html>
