package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBOrdini {
	String myURL;
	  Document doc;
	  Element root;

	  public DBOrdini(String url)
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
	  public void addOrdini(Ordini ord,String username)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element ordini = new Element("ordini");
		  Element elidordine = new Element ("idordine");
		  Element elcliente = new Element ("cliente");
		  Element elinoltro=new Element("datainoltro");
		  Element elmodalitaspe=new Element("modalitaSpe");
		  Element elmodalitapay=new Element("modalitaPay");
		  Element eltotale=new Element("totalePag");
		 
		  
		  int app = contaOrdini();
		  app = app + 1;
		  String idordine = String.valueOf(app);
		  
		  elidordine.setText(idordine);
		  
		  elcliente.setText(username);
		  elinoltro.setText(ord.getDataInoltro());
	      elmodalitaspe.setText(ord.getModalitaSpe());
		  elmodalitapay.setText(ord.getModalitaPay());
		  eltotale.setText(ord.getTotalePag());
		  
		  ordini.addContent(elidordine);
		  ordini.addContent(elinoltro);
		  ordini.addContent(elmodalitaspe);
		  ordini.addContent(elmodalitapay);
		  ordini.addContent(eltotale);
		  ordini.addContent(elcliente);
		  root.addContent(ordini);
		  scrivi();
	  }
	  /* -------------- CONTA IL NUMERO DI ORDINI -------------- */
	  public int contaOrdini()
	  {
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e=(Element)iterator.next();
			  i++;
		  }
		  	return i;
	  }
	
	  /* -------------- LISTA GLI ORDINI -------------- */
	  public ArrayList listaOrdini(String cliente)
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  Ordini ord = new Ordini();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elcliente = e.getChild("cliente");
			  
			  if (elcliente.getText().equals(cliente))
			  {   
				  Element elidordine=e.getChild("idordine");
				  Element elinoltro = e.getChild("datainoltro");
				  Element elmodalitaspe=e.getChild("modalitaSpe");
				  Element elmodalitapay=e.getChild("modalitaPay");
				  Element eltotale=e.getChild("totalePag");
				  
				  ord=new Ordini();
				  ord.setUsername(cliente);
				  ord.setIdordine(elidordine.getText());
				  ord.setDataInoltro(elinoltro.getText());
				  ord.setModalitaSpe(elmodalitaspe.getText());
				  ord.setModalitaPay(elmodalitapay.getText());
				  ord.setTotalePag(eltotale.getText());
				  arr.add(ord);
			  }
		  }
		  	return arr;
	  }
}