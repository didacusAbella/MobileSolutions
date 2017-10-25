package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBMagazzino {
	String myURL;
	  Document doc;
	  Element root;

	  public DBMagazzino(String url)
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

	  /* -------------- AGGIUNGE PRODOTTO NEL MAGAZZINO-------------- */
	  public void addMagazzino(Magazzino mag)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element prod = new Element("prod");
		  Element elmodello = new Element ("modello");
		  Element elquantita = new Element ("quantita");
		  
		  elmodello.setText(mag.getModello());
		  elquantita.setText(mag.getQuantita());
		  
		  prod.addContent(elmodello);
		  prod.addContent(elquantita);
		  
		  root.addContent(prod);
		  scrivi();
	  }
	  
	  /* -------------- RESTITUISCE LA QUANTITA' DI UN PRODOTTO -------------- */
	  public int getQuantita(String modello)
	  {
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (modello.equals(elmodello.getText()))
			  {
				  Element elquantita = e.getChild("quantita");
				  i = Integer.parseInt(elquantita.getText());
				  	break;
			  }
		  }
		  	return i;
	  }
	  
	  /* -------------- MODIFICA UN PRODOTTO NEL MAGAZZINO-------------- */
	  public void modMagazzino(Magazzino mag)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  int i = Integer.parseInt(mag.getQuantita());
		  
		  while (iterator.hasNext())
		  {
			  Element elemento = (Element)iterator.next();
			  Element elmodello = elemento.getChild("modello");
			  
			  if ( elmodello.getText().equals(mag.getModello()) )
			  {
				  Element elquantita = elemento.getChild("quantita");
				  int c = Integer.parseInt(elquantita.getText());
				  c=c+i;
				  String q = Integer.toString(c);
				  
				  elquantita.setText(q);
				  
				  scrivi();
				  break;
			  }
		  }
	  }
	  
	  /* -------------- LISTA IL CONTENUTO DEL MAGAZZINO -------------- */
	  public ArrayList listaMagazzino()
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  int i=0;
		  
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  Element elquantita = e.getChild("quantita");
			  
			  Magazzino mag = new Magazzino();
			  mag.setModello(elmodello.getText());
			  mag.setQuantita(elquantita.getText());
			  arr.add(mag);
		  }
		  	return arr;
	  }
	  
	  /* -------------- CONTA I PRODOTTI DEL MAGAZZINO -------------- */
	  public int contaMagazzino()
	  {
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  i++;
		  }
		  	return i;
	  }
	  
	  /* -------------- AGGIORNA IL CONTENUTO DEL MAGAZZINO -------------- */
	  public void aggiornaMagazzino(ArrayList maga)
	  {
		  int a = contaMagazzino();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  for(int i=0; i<a; i++) //Cancello tutto il contenuto del Magazzino
		  {
			  children.remove(0);
			  scrivi();
		  }
		  	Magazzino ma = new Magazzino();
		  	for(int i=0; i<maga.size(); i++)
		  	{
		  		ma = (Magazzino)maga.get(i);
		  		addMagazzino(ma);
		  	}
	  }
	  
	  /* -------------- RITORNA I CELLULARI CHE STANNO FINENDO -------------- */
	  public ArrayList listaEsaurimento(String scorta)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  
		  int scort = Integer.parseInt(scorta);
		  
		  while(iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elquantita = e.getChild("quantita");
			  Magazzino mag = new Magazzino();
			  int quant = Integer.parseInt(elquantita.getText());
			  
			  if (quant <= scort)
			  {
				  Element elmodello = e.getChild("modello");
				  
				  mag.setModello(elmodello.getText());
				  mag.setQuantita(elquantita.getText());
				  
				  arr.add(mag);
			  }
		  }
		  	 return arr;
	  }
	  
	  /* -------------- POSIZIONE DEL CELLULARE NEL MAGAZZINO -------------- */
	  public int posizioneCell(String modello)
	  {
		  int pos=0;
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Magazzino mag = new Magazzino();
		  
		  while (iterator.hasNext())
		  {
			  i++;
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (elmodello.getText().equals(modello))
			  {
				  pos=i;
				  break;
			  }
		  }
		  	return pos;
	  }
	  
	  /* -------------- CANCELLA IL CELLULARE DAL MAGAZZINO -------------- */
	  public void cancellaCell(String modello)
	  {
		  int pos = posizioneCell(modello);
		  
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  root.getChildren().remove(pos-1);
		  scrivi();
	  }
	  
	  
	  public Magazzino cercaInMagazzino (String modello)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Magazzino magaz = new Magazzino();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (elmodello.getText().equals(modello))
			  {
				 
				  Element elquantita =e.getChild("quantita");
					magaz.setModello(elmodello.getText());
				  	magaz.setQuantita(elquantita.getText());
				  	break;
			  }}
return magaz;
	  }
	  }