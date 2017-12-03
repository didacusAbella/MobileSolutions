<jsp:useBean id="Gestore" class="com.didacusabella.mobilesolutions.beans.Gestore" scope="session"/>
<jsp:useBean id="Cliente" class="com.didacusabella.mobilesolutions.beans.Cliente" scope="session"/>

<%@page import="java.util.*,com.didacusabella.mobilesolutions.beans.*,com.didacusabella.mobilesolutions.gestioneDB.*"%>

<script type="text/javascript">
 <!--
 function PopupCentro() {
   var w = 700;
   var h = 700;
   var l = Math.floor((screen.width-w)/2);
   var t = Math.floor((screen.height-h)/2);
      window.open("contatti.html","","width=" + w + ",height=" + h + ",top=" + t + ",left=" + l);
 }
 //-->
</script> 





<% if (Gestore.isLoggato()==true)  {%>
	
<br><br>
	<table>
<tr><td>
	
<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
 codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"
 WIDTH=130 HEIGHT=416>
<PARAM NAME=movie VALUE="img/menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Istruzioni&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=javascript:PopupCentro()">
<PARAM NAME=loop VALUE=false>
<PARAM NAME=menu VALUE=false>
<PARAM NAME=quality VALUE=high>
<PARAM NAME=scale VALUE=noborder>
<PARAM NAME=salign VALUE=LT>
<PARAM NAME=wmode VALUE=transparent>
<PARAM NAME=bgcolor VALUE=#000000>

<EMBED src="menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Istruzioni&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=contatti.html" loop=false menu=false quality=high scale=noborder salign=LT wmode=transparent bgcolor=#000000  WIDTH=130 HEIGHT=336 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED>

</OBJECT>

<a href="http://www.guistuff.com/"><img border="0" src="http://www.guistuff.com/images/11dot.gif" width="1" height="1"></a>

<script language = "javascript">
<!--
theObjects = document.getElementsByTagName("object");
for (var i = 0; i < theObjects.length; i++) {
theObjects[i].outerHTML = theObjects[i].outerHTML;}
//-->
</script>

</td></tr>
<tr><td><br><br><br><br></td></tr>
<tr align="center"><td><a href="mailto:info@mobilesinfinity.com">    
   <img src="img/mail.gif" width="60" height="60"></a>
</td></tr>
	</table>
<% } %>
<% if (Cliente.isLoggato()==true) { %>
	
<br><br>
	<table>
<tr><td>

<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
 codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"
 WIDTH=130 HEIGHT=416>
<PARAM NAME=movie VALUE="img/menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Istruzioni&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=javascript:PopupCentro()">
<PARAM NAME=loop VALUE=false>
<PARAM NAME=menu VALUE=false>
<PARAM NAME=quality VALUE=high>
<PARAM NAME=scale VALUE=noborder>
<PARAM NAME=salign VALUE=LT>
<PARAM NAME=wmode VALUE=transparent>
<PARAM NAME=bgcolor VALUE=#000000>

<EMBED src="menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Istruzioni&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=contatti.html" loop=false menu=false quality=high scale=noborder salign=LT wmode=transparent bgcolor=#000000  WIDTH=130 HEIGHT=336 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED>

</OBJECT>

<a href="http://www.guistuff.com/"><img border="0" src="http://www.guistuff.com/images/11dot.gif" width="1" height="1"></a>

<script language = "javascript">
<!--
theObjects = document.getElementsByTagName("object");
for (var i = 0; i < theObjects.length; i++) {
theObjects[i].outerHTML = theObjects[i].outerHTML;}
//-->
</script>

</td></tr>
<tr><td><br><br><br><br></td></tr>
<tr align="center"><td><a href="mailto:info@mobilesinfinity.com">    
   <img src="img/mail.gif" width="60" height="60"></a>
</td></tr>

	</table>
<% } %>

<% if ((Gestore.isLoggato()==false) && (Cliente.isLoggato()==false))  { %>


        
	<br><br>
	<table >


<tr><td>


<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
 codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=5,0,0,0"
 WIDTH=130 HEIGHT=416>
<PARAM NAME=movie VALUE="img/menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Forum&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=javascript:PopupCentro()">
<PARAM NAME=loop VALUE=false>
<PARAM NAME=menu VALUE=false>
<PARAM NAME=quality VALUE=high>
<PARAM NAME=scale VALUE=noborder>
<PARAM NAME=salign VALUE=LT>
<PARAM NAME=wmode VALUE=transparent>
<PARAM NAME=bgcolor VALUE=#000000>

<EMBED src="menu.swf?tarframe=_self&exbackground=000000&makenavfield0=Home&makenavurl0=index.jsp&makenavfield1=Chi siamo&makenavurl1=chisiamo.html&makenavfield2=Sede&makenavurl2=sede.html&makenavfield3=Prodotti&makenavurl3=lista&makenavfield4=Forum&makenavurl4=istruzioni.html&makenavfield5=Registrazione&makenavurl5=registrazione.jsp&makenavfield6=Condizioni&makenavurl6=condizioni.html&makenavfield7=Pagamenti&makenavurl7=pagamenti.html&makenavfield8=Garanzie&makenavurl8=garanzie.html&makenavfield9=Spedizioni&makenavurl9=spedizioni.html&makenavfield10=Contatti&makenavurl10=contatti.html" loop=false menu=false quality=high scale=noborder salign=LT wmode=transparent bgcolor=#000000  WIDTH=130 HEIGHT=336 TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"></EMBED>

</OBJECT>

<a href="http://www.guistuff.com/"><img border="0" src="http://www.guistuff.com/images/11dot.gif" width="1" height="1"></a>

<script language = "javascript">
<!--
theObjects = document.getElementsByTagName("object");
for (var i = 0; i < theObjects.length; i++) {
theObjects[i].outerHTML = theObjects[i].outerHTML;}
//-->
</script>



</td></tr>
<tr><td><br><br><br><br></td></tr>
<tr align="center"><td><a href="mailto:info@mobilesinfinity.com">    
   <img src="img/mail.gif" width="60" height="60"></a>
</td></tr>

	</table>
		
<% } %>

