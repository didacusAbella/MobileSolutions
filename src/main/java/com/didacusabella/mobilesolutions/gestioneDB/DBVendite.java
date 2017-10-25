package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBVendite {
	String myURL;
	  Document doc;
	  Element root;

	  public DBVendite(String url)
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
	  
	  /* -------------- AGGIUNGE UNA VENDITA -------------- */
	  public void addVendita(Cellulari cell, String username)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element vendita = new Element("vendita");
		  Element elcliente = new Element ("cliente");
		  Element elmarca=new Element("marca");
		  Element elmodello = new Element ("modello");
		  Element elprezzo = new Element ("prezzo");
		  
		  elcliente.setText(username);
		  elmarca.setText(cell.getMarca());
		  elmodello.setText(cell.getModello());
		  elprezzo.setText(cell.getPrezzo());
		  
		  vendita.addContent(elmarca);
		  vendita.addContent(elmodello);
		  vendita.addContent(elprezzo);
		  vendita.addContent(elcliente);
		  
		  root.addContent(vendita);
		  scrivi();
	  }
	  
	  /* -------------- LISTA LE VENDITE -------------- */
	  public ArrayList listaVendite(String cliente)
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  Vendite ven = new Vendite();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elcliente = e.getChild("cliente");
			  
			  if (elcliente.getText().equals(cliente))
			  {   
				  Element elmarca=e.getChild("marca");
				  Element elmodello = e.getChild("modello");
				  Element elprezzo=e.getChild("prezzo");
				  ven=new Vendite();
				  ven.setUsername(cliente);
				  ven.setMarca(elmarca.getText());
				  ven.setModello(elmodello.getText());
				  ven.setPrezzo(elprezzo.getText());

				  arr.add(ven);
			  }
		  }
		  	return arr;
	  }

}