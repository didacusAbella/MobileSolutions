package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBGestore
{
	String myURL;
	  Document doc;
	  Element root;

	  public DBGestore(String url)
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
	  
	       /* ----------- LOGIN GESTORE ----------- */
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
	  
	  		/* ----------- LOGIN GESTORE ----------- */
	  public Gestore cercaGestore(String username,String password)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Gestore ges = new Gestore();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elusername = e.getChild("username");
			  Element elpassword = e.getChild("password");
			  if ( (elusername.getText().equals(username)) && (elpassword.getText().equals(password)) )
			  {
				  Element elnome = e.getChild("nome");
				  Element elcognome = e.getChild("cognome");
				  
				  ges.setNome(elnome.getText());
				  ges.setCognome(elcognome.getText());
				  ges.setUsername(elusername.getText());
				  ges.setPassword(elpassword.getText());
				  	break;
			  }
		  }
		  	return ges;
	  }
	  
	  
}
