function controllo() { 
	errore="";
	
	with(document.registra){
	
	if ((nome.value.length==0) || (cognome.value.length==0) || (indirizzo.value.length==0) || (telefono.value.length==0) ||
	   (username.value.length==0) || (password.value.length==0) || (confpassword.value.length==0) || (email.value.length==0) || 
	   (cartaCredito1.value.length==0) || (cartaCredito2.value.length==0) || (cartaCredito3.value.length==0) || (cartaCredito4.value.length==0)) 
						{ alert("Alcuni dei campi sono vuoti. Compilare e riprovare."); 
							return false; 
						}
	
	if (username.value.length>10) { errore= ("Username\n") }

	if (password.value.length<4) { errore= errore + ("Password\n") }
	
	if (cartaCredito1.value.length<4) { errore = errore + ("Primo campo della Carta di Credito\n") }
	if (cartaCredito2.value.length<4) { errore = errore + ("Secondo campo della Carta di Credito\n") }
	if (cartaCredito3.value.length<4) { errore = errore + ("Terzo campo della Carta di Credito\n") }
	if (cartaCredito4.value.length<4) { errore = errore + ("Quarto campo della Carta di Credito\n") }

	kiocc = email.value.indexOf("@");
	dot = email.value.indexOf("."); 
	len = email.value.length;
	if ((kiocc==-1) || (dot==-1) || (dot<kiocc) || (kiocc==0) || (kiocc==len-1) || (dot==0) || (dot==len-1) || (dot==kiocc+1))
									{ errore= (errore + "Indirizzo-Mail")	}
	
		if (password.value  != confpassword.value) { errore=errore + "----\nI campi password e conferma password sono differenti. Controllare!" }

	}

	if (errore != "") { alert("Contollare i seguenti campi che contengono errori o sono vuoti:\n"+errore);
			    return false; 
	 }
	else  return true;
}


function solonum(e)
{
   if (e.which)
      {
      if (e.which!=8 && (e.which<48 || e.which>57))
         return false;
      }
   else if(e.keyCode)
      {
      if (e.keyCode!=8 && (e.keyCode<48 || e.keyCode>57))
         return false;
      }
     return true;
}
   
function mod()
{
  errore="";
  
  with(document.modificaCliente)
  {
    if ((nome.value.length==0) || (cognome.value.length==0) || (indirizzo.value.length==0) || (telefono.value.length==0) || 
       (email.value.length==0) || (cartaCredito1.value.length==0) || (cartaCredito2.value.length==0) || 
       (cartaCredito3.value.length==0) || (cartaCredito4.value.length==0))
       						{ alert("Alcuni dei campi sono vuoti. Compilare e riprovare."); 
							return false; 
						}
	if (cartaCredito1.value.length<4) { errore = errore + ("Primo campo della Carta di Credito\n") }
	if (cartaCredito2.value.length<4) { errore = errore + ("Secondo campo della Carta di Credito\n") }
	if (cartaCredito3.value.length<4) { errore = errore + ("Terzo campo della Carta di Credito\n") }
	if (cartaCredito4.value.length<4) { errore = errore + ("Quarto campo della Carta di Credito\n") }

	if (errore != "")
		{ alert("Contollare i seguenti campi che contengono errori o sono vuoti:\n"+errore);
			    return false; 
		}
	else  return true;
  }
}