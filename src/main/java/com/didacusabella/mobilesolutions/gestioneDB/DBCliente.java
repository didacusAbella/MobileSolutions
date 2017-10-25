package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBCliente
{
	String myURL;
	  Document doc;
	  Element root;

	  public DBCliente(String url)
	  {
	    myURL=url;
	    doc=null;
	    try
	    {
	      SAXBuilder builder=new SAXBuilder();
	      doc=builder.build(myURL);
	    } catch(JDOMException e) {e.printStackTrace(); }
	    root=doc.getRootElement();
	  }

	  public void scrivi()
	  {
	    BufferedWriter out=null;
	    try {
	          out=new BufferedWriter(new FileWriter(myURL));
	          XMLOutputter xout=new XMLOutputter();
	          xout.setIndent(" ");
	          xout.setNewlines(true);
	          xout.setTrimAllWhite(true);
	          xout.setEncoding("iso-8859-1");
	          xout.output(doc,out);
	        } catch (IOException e)
	          {
	          }
	          finally
	          {
	            try {
	                  out.close();
	                } catch(IOException e)
	                  {
	                  }
	          }
	  }
	  
	  /* -------------- LOGIN CLIENTE -------------- */
	  public boolean login(String username, String password)
	  {
		 boolean risultato = false;
		 List children = root.getChildren();
		 Iterator iterator = children.iterator();
		 
		 while(iterator.hasNext())
		 {
			 Element figlio = (Element)iterator.next();
			 Element elusername = figlio.getChild("username");
			 Element elpassword = figlio.getChild("password");
			 
			 if ((elusername.getText().equals(username)) && (elpassword.getText().equals(password)))
			 {
				 risultato = true;
			 }
		 }
		 	return risultato;
	  }
	  
	  /* -------------- CERCA CLIENTE -------------- */
	  public Cliente cercaCliente(String username,String password)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cliente cli = new Cliente();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elusername = e.getChild("username");
			  Element elpassword = e.getChild("password");
			  if ( (elusername.getText().equals(username)) && (elpassword.getText().equals(password)) )
			  {
				  Element elnome = e.getChild("nome");
				  Element elcognome = e.getChild("cognome");
				  Element elcofiscale= e.getChild("cofiscale");
				  Element eltipoindirizzo = e.getChild("tipoindirizzo");
				  Element elindirizzo = e.getChild("indirizzo");
				  Element elcap = e.getChild("cap");
				  Element elcitta = e.getChild("citta");
				  Element elprovincia = e.getChild("provincia");
				  Element eltelcasa = e.getChild("telcasa");
				  Element eltelcell = e.getChild("telcell");
				  Element elfax = e.getChild("fax");
				  Element elemail = e.getChild("email");
				  Element elclausola1 = e.getChild("clausola1");
				  Element elclausola2 = e.getChild("clausola2");
				  
				  cli.setNome(elnome.getText());
				  cli.setCognome(elcognome.getText());
				  cli.setCodicefiscale(elcofiscale.getText());
				  cli.setTipoindirizzo(eltipoindirizzo.getText());
				  cli.setIndirizzo(elindirizzo.getText());
				  cli.setCap(elcap.getText());
				  cli.setCitta(elcitta.getText());
				  cli.setProvincia(elprovincia.getText());
				  cli.setTelcasa(eltelcasa.getText());
				  cli.setTelcell(eltelcell.getText());
				  cli.setFax(elfax.getText());
				  cli.setUsername(elusername.getText());
				  cli.setPassword(elpassword.getText());
				  cli.setEmail(elemail.getText());
				  cli.setClausola1(elclausola1.getText());
				  cli.setClausola2(elclausola2.getText());
				  	break;
			  }
		  }
		  	return cli;
	  }
	  
	  /* -------------- AGGIUNGI CLIENTE -------------- */
	  public void addCliente (Cliente cli)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element cliente = new Element("cliente");
		  Element elnome = new Element("nome");
		  Element elcognome = new Element("cognome");
		  Element elcofiscale= new Element("cofiscale");
		  Element eltipoindirizzo = new Element("tipoindirizzo");
		  Element elindirizzo = new Element("indirizzo");
		  Element elcap = new Element("cap");
		  Element elcitta = new Element("citta");
		  Element elprovincia = new Element("provincia");
		  Element eltelcasa = new Element("telcasa");
		  Element eltelcell = new Element("telcell");
		  Element elfax = new Element("fax");
		  Element elusername = new Element("username");
		  Element elpassword = new Element("password");
		  Element elemail = new Element("email");
		  Element elclausola1 = new Element("clausola1");
		  Element elclausola2 = new Element("clausola2");
		  
		  elnome.setText(cli.getNome());
		  elcognome.setText(cli.getCognome());
		  elcofiscale.setText(cli.getCodicefiscale());
		  eltipoindirizzo.setText(cli.getTipoindirizzo());
		  elindirizzo.setText(cli.getIndirizzo());
		  elcap.setText(cli.getCap());
		  elcitta.setText(cli.getCitta());
		  elprovincia.setText(cli.getProvincia());
		  eltelcasa.setText(cli.getTelcasa());
		  eltelcell.setText(cli.getTelcell());
		  elfax.setText(cli.getFax());
		  elusername.setText(cli.getUsername());
		  elpassword.setText(cli.getPassword());
		  elemail.setText(cli.getEmail());
		  elclausola1.setText(cli.getClausola1());
		  elclausola2.setText(cli.getClausola2());
		  
		  cliente.addContent(elnome);
		  cliente.addContent(elcognome);
		  cliente.addContent(elcofiscale);
		  cliente.addContent(eltipoindirizzo);
		  cliente.addContent(elindirizzo);
		  cliente.addContent(elcap);
		  cliente.addContent(elcitta);
		  cliente.addContent(elprovincia);
		  cliente.addContent(eltelcasa);
		  cliente.addContent(eltelcell);
		  cliente.addContent(elfax);
		  cliente.addContent(elusername);
		  cliente.addContent(elpassword);
		  cliente.addContent(elemail);
		  cliente.addContent(elclausola1);
		  cliente.addContent(elclausola2);
		  
		  root.addContent(cliente);
		  scrivi();
	  }
	  
	  /* -------------- CONTROLLO REGISTRAZIONE CLIENTE -------------- */
	  public boolean control(String username)
	  {
		 boolean risultato = false;
		 List children = root.getChildren();
		 Iterator iterator = children.iterator();
		 
		 while(iterator.hasNext())
		 {
			 Element figlio = (Element)iterator.next();
			 Element elusername = figlio.getChild("username");
			 
			 if ((elusername.getText().equals(username)))
			 {
				 risultato = true;
			 }
		 }
		 	return risultato;
	  }
	  
	  /* -------------- LISTA CLIENTI REGISTRATI -------------- */
	  public ArrayList listaClienti()
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Cliente cli = new Cliente();
			  Element e = (Element)iterator.next();
			  
			  Element elnome = e.getChild("nome");
			  Element elcognome = e.getChild("cognome");
			  Element eltelcell = e.getChild("telcell");
			  Element elemail = e.getChild("email");
			  Element elusername = e.getChild("username");
			  			  			  
			  	cli.setNome(elnome.getText());
			  	cli.setCognome(elcognome.getText());
			  	cli.setTelcell(eltelcell.getText());
			  	cli.setEmail(elemail.getText());
			  	cli.setUsername(elusername.getText());
			  	
			  arr.add(cli);
		  }
		  	return arr;
	  }
	  
	  /* -------------- POSIZIONE DEL CLIENTE -------------- */
	  public int posizioneCliente(String username)
	  {
		  int pos=0;
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cliente cli = new Cliente();
		  
		  while (iterator.hasNext())
		  {
			  i++;
			  Element e = (Element)iterator.next();
			  Element elusername = e.getChild("username");
			  
			  if (elusername.getText().equals(username))
			  {
				  pos=i;
				  break;
			  }
		  }
		  	return pos;
	  }
	  
	  /* -------------- CANCELLA CLIENTE -------------- */
	  public void cancellaCliente (String username)
	  {
		  int pos = posizioneCliente(username);
		  
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  root.getChildren().remove(pos-1);
		  scrivi();
	  }
	  
	  /* -------------- MODIFICA CLIENTE -------------- */
	  public void modificaCliente(Cliente cli)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element elemento = (Element)iterator.next();
			  Element elusername = elemento.getChild("username");
			  
			  if (elusername.getText().equals(cli.getUsername()))
			  {
				  Element elnome = elemento.getChild("nome");
				  Element elcognome = elemento.getChild("cognome");
				  Element elcofiscale = elemento.getChild("cofiscale");
				  Element eltipoindirizzo = elemento.getChild("tipoindirizzo");
				  Element elindirizzo = elemento.getChild("indirizzo");
				  Element elcap = elemento.getChild("cap");
				  Element elcitta = elemento.getChild("citta");
				  Element elprovincia = elemento.getChild("provincia");
				  Element eltelcasa = elemento.getChild("telcasa");
				  Element eltelcell = elemento.getChild("telcell");
				  Element elfax = elemento.getChild("fax");
				  Element elemail = elemento.getChild("email");
				  Element elpassword = elemento.getChild("password");
				 
				  elnome.setText(cli.getNome());
				  elcognome.setText(cli.getCognome());
				  elcofiscale.setText(cli.getCodicefiscale());
				  eltipoindirizzo.setText(cli.getTipoindirizzo());
				  elindirizzo.setText(cli.getIndirizzo());
				  elcap.setText(cli.getCap());
				  elcitta.setText(cli.getCitta());
				  elprovincia.setText(cli.getProvincia()); 
				  eltelcasa.setText(cli.getTelcasa());
				  eltelcell.setText(cli.getTelcell());
				  elfax.setText(cli.getFax());
				  elemail.setText(cli.getEmail());
				  elpassword.setText(cli.getPassword());
				  
				  scrivi();
				  break;
			  }
		  }
	  }

}
