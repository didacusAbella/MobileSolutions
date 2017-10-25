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
        <%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*" %>
			<% ArrayList arr = new ArrayList();
				String cliente = Cliente.getUsername();
				Vendite ven = new Vendite();
                                
			    	String path = getServletContext().getRealPath("/");
				DBVendite db = new DBVendite(path+"WEB-INF/database/vendite.xml");
				arr = db.listaVendite(cliente);

                                  int totaleEsc=0;
                                  int speRaccGest=10; 
                                  int speCorrGest=12;
                                  int tot1=0;
                                  int tot2=0;
                                    %>
                            

    <% for(int i=0;i<arr.size();i++)
		    {
			ven=(Vendite)arr.get(i); 
			
			int t=Integer.parseInt(ven.getPrezzo());
			int totF=t;
			totaleEsc=totaleEsc+totF; %>
	  
          
  <% } %>

	<% {
          tot1=totaleEsc+speRaccGest;
          tot2=totaleEsc+speCorrGest;
         %>
       <% } %>
      



	<jsp:include page="intestazione.jsp"/> 
	
 <table border="0" align="center" valign="top" width="900">
  <tr>
  	<td valign="top" width="160"> <jsp:include page="sinistra.jsp"/> </td>
	<td valign="top">
                        <br>  
			<h2 align=center>Spedizione e Pagamento</h2> <br><br><br>




<p align="center"><b> La spesa attuale esclusi i costi è = <%= (int)totaleEsc %> euro </b></p>


		<p align="center"><b><font color="red">Spedizione</font></b></p>
        <form name="ordine" action="invioOrdini" method="post">	
<table border="0" align="center">
        <tr>  <td class="colore">Seleziona</td><td></td><td></td>  <td class="colore">Tipo Spedizione</td><td></td><td></td> <td class="colore">Trasporto</td><td></td><td></td> <td class="colore">Gestione(*)</td> <td></td><td></td><td class="colore">Totale Pagamento</td> </tr>			
       
        <tr align="center"><td><input name="modalitaSpe" type="radio" value="raccomandata"></td> <td></td><td></td>  <td><b><font color="black">Posta Raccoman.</font></b></td> <td></td><td></td> <td><b>+<font color="blue">&</font>8.00</b></td><td></td><td></td>  <td><b>+<font color="blue">&</font>2.00</b></td><td></td><td></td>  <td><b><%=tot1%> euro</b></td> </tr>
        <tr align="center"><td><input name="modalitaSpe" type="radio" value="corriere"></td> <td></td><td></td>  <td><b><font color="black">Corriere Espresso</font></b></td> <td></td><td></td> <td><b>+<font color="blue">&</font>10.00</b></td><td></td><td></td>  <td><b>+<font color="blue">&</font>2.00</b></td><td></td><td></td>  <td><b><%=tot2%> euro</b></td> </tr> 
        <tr>  <td></td>  <td></td> <td></td> <td></td> <td></td> </tr>
       
</table>
<hr>


<p align="center"><b><font color="red">Informa pagamento</font></b></p>
<table border="0" align="center">
        <tr>  <td class="colore">Seleziona</td><td><td class="colore">Totale Pagamento</td> </tr>			
       
        <tr align="center"><td><input name="totalePag" type="radio" value="<%=tot1%>"></td><td></td><td><b><%=tot1%> euro</b></td></tr>
        <tr align="center"><td><input name="totalePag" type="radio" value="<%=tot2%>"></td><td></td><td><b><%=tot2%> euro</b></td></tr> 
     
       
</table>
	<hr>
<p align="center"><b><font color="red">Modalità pagamento(esterni all'ordine)</font></b></p>
<table border="0" align="center">
        <tr>  <td class="colore">Seleziona</td><td></td><td></td>  <td class="colore">Tipo di pagamento</td><td></td><td></td><td class="colore">Costo servizio</td> <td></td><td></td><td class="colore">Costi esterni </td> </tr>			
    
        <tr align="center"><td><input name="modalitaPay" type="radio" value="paypal"></td> <td></td><td></td>  <td><b><font color="black">PayPal</font></b></td> <td></td><td></td> <td><b><font color="black">Gratuito</font></b></td> <td></td><td></td><td><b>//</b></td> </tr>
      
        <tr align="center"><td><input name="modalitaPay" type="radio" value="postapay"></td> <td></td><td></td>  <td><b><font color="black">PostPay</font></b></td> <td></td><td></td> <td><b><font color="black">1 euro</font></b></td> <td></td><td></td><td><b>1 euro</b></td> </tr> 
     
        <tr align="center"><td><input name="modalitaPay" type="radio" value="concopostale"></td> <td></td><td></td>  <td><b><font color="black">C/C Postale</font></b></td> <td></td><td></td> <td><b><font color="black">1 euro</font></b></td> <td></td><td></td><td><b>1 euro</b></td> </tr> 
  
        <tr align="center"><td><input name="modalitaPay" type="radio" value="contrassegno"></td> <td></td><td></td>  <td><b><font color="black">Contrassegno</font></b></td> <td></td><td></td> <td><b><font color="black">//</font></b></td> <td></td><td></td><td><b>//</b></td> </tr>   
     
        <tr align="center"><td><input name="modalitaPay" type="radio" value="bonificobank"></td> <td></td><td></td>  <td><b><font color="black">Bonifico bank</font></b></td> <td></td><td></td> <td><b><font color="black">3 euro</font></b></td> <td></td><td></td><td><b>3 euro</b></td> </tr> 

        <tr align="center"><td><input name="modalitaPay" type="radio" value="vagliapost"></td> <td></td><td></td>  <td><b><font color="black">Vaglia postale</font></b></td> <td></td><td></td> <td><b><font color="black">5 euro</font></b></td> <td></td><td></td><td><b>5 euro</b></td> </tr> 
</table>	    
	

 <br>
<p align="center">(*).Costi relativi alla gestione dell'ordine.</p>
	

     <input type="hidden" name="nome" value="<%=Cliente.getNome()%>">
      <input type="hidden" name="cognome" value="<%=Cliente.getCognome()%>">
      <br>

       <input type="hidden" name="datainoltro" value="<%=new java.util.Date()%>">

		    	<p align="center"><input type="submit" value="Invia Ordine" class="pulsante"></p>
			<input type="hidden" name="username" value="<%=Cliente.getUsername()%>">
                     
</form>

	     	


</td>
	<td valign="top" width="160"> <jsp:include page="destra.jsp"/> </td>
  </tr>
 </table>   

		 

    <br>
                   
		    <p align="center"><a href="index.jsp">Indietro</a></p>
</body>

</html>
