package com.didacusabella.mobilesolutions.gestioneDB;

import java.io.*;
import java.util.*;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;
import com.didacusabella.mobilesolutions.beans.*;

public class DBCell {
	String myURL;
	  Document doc;
	  Element root;

	  public DBCell(String url)
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
	  
	  /* -------------- AGGIUNGE CELLULARE -------------- */
	  public void addCellulare(Cellulari cell, String username)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element c = new Element("cellulare");
		  Element elcodice = new Element ("codice");
		  Element elmarca = new Element ("marca");
		  Element elmodello = new Element ("modello");
		  Element eltecnologia=new Element ("tecnologia");
		  Element elrete=new Element("rete");
		  Element elsisoper=new Element("sisoper");
		  Element elpeso=new Element("peso");
		  Element eldimensioni = new Element ("dimensioni");
		  Element elrisschermo = new Element ("risSchermo");
		  Element elfotocamera = new Element ("fotocamera");
		  Element elmemoriaint = new Element ("memoriaint");
		  Element elmemoriaest = new Element("memoriaest");
		  Element elconnettivita = new Element ("connettivita");
		  Element elvibrazione=new Element("vibrazione");
		  Element elbatteria=new Element("batteria");
		  Element elautonomia=new Element("autonomia");
		  Element elautonomiast=new Element("autonomiast");
		  Element elantenna=new Element("antenna");
		  Element elbrowser=new Element("browser");
		  Element elgiochi=new Element("giochi");
		  Element elmessaggi=new Element("messaggi");
		  Element eljava = new Element ("java");
		  Element elvideochiamata=new Element("videochiamata");
		  Element elgps=new Element("gps");
		  Element ellettori=new Element("lettori");
		  Element elvivavoce=new Element("vivavoce");
		  Element elradio = new Element ("radio");
		  Element elsuonerie = new Element ("suonerie");
		  Element elimmagine=new Element("immagine");
		  Element elprezzo = new Element ("prezzo");
		  int app = contaCell();
		  app = app + 1;
		  String codice = String.valueOf(app);
		  
		  elcodice.setText(codice);
		  
		  elmarca.setText(cell.getMarca());
		  elmodello.setText(cell.getModello());
		  eltecnologia.setText(cell.getTecnologia());
		  elrete.setText(cell.getRete());
		  elsisoper.setText(cell.getSisoper());
		  elpeso.setText(cell.getPeso());
		  eldimensioni.setText(cell.getDimensioni());
		  elrisschermo.setText(cell.getRisSchermo());
		  elfotocamera.setText(cell.getFotocamera());
		  elmemoriaint.setText(cell.getMemoriaint());
		  elmemoriaest.setText(cell.getMemoriaest());
		  elconnettivita.setText(cell.getConnettivita());
		  elvibrazione.setText(cell.getVibrazione());
		  elbatteria.setText(cell.getBatteria());
		  elautonomia.setText(cell.getAutonomia());
		  elautonomiast.setText(cell.getAutonomiast());
		  elantenna.setText(cell.getAntenna());
		  elbrowser.setText(cell.getBrowser());
		  elgiochi.setText(cell.getGiochi());
		  elmessaggi.setText(cell.getMessaggi());
		  eljava.setText(cell.getJava());
		  elvideochiamata.setText(cell.getVideochiamata());
		  elgps.setText(cell.getGps());
		  ellettori.setText(cell.getLettori());
		  elvivavoce.setText(cell.getVivavoce());
		  elradio.setText(cell.getRadio());
		  elsuonerie.setText(cell.getSuonerie());
		  elimmagine.setText(cell.getImmagine());
		  elprezzo.setText(cell.getPrezzo());
		  
		  c.addContent(elcodice);
		  c.addContent(elmarca);
		  c.addContent(elmodello);
		  c.addContent(eltecnologia);
		  c.addContent(elrete);
		  c.addContent(elsisoper);
		  c.addContent(elpeso);
		  c.addContent(eldimensioni);
		  c.addContent(elrisschermo);
		  c.addContent(elfotocamera);
		  c.addContent(elmemoriaint);
		  c.addContent(elmemoriaest);
		  c.addContent(elconnettivita);
		  c.addContent(elvibrazione);
		  c.addContent(elbatteria);
		  c.addContent(elautonomia);
		  c.addContent(elautonomiast);
		  c.addContent(elantenna);
		  c.addContent(elbrowser);
		  c.addContent(elgiochi);
		  c.addContent(elmessaggi);
		  c.addContent(eljava);
		  c.addContent(elvideochiamata);
		  c.addContent(elgps);
		  c.addContent(ellettori);
		  c.addContent(elvivavoce);
		  c.addContent(elradio);
		  c.addContent(elsuonerie);
		  c.addContent(elimmagine);
		  c.addContent(elprezzo);
		  root.addContent(c);
		  scrivi();		  
	  }
	  
	  /* -------------- CONTA IL NUMERO DI CELLULARI -------------- */
	  public int contaCell()
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
	  
	  /* -------------- LISTA COMPLETA DEI CELLULARI -------------- */
	  public ArrayList listaCompleta()
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Cellulari cell = new Cellulari();
			  Element e = (Element)iterator.next();
			  
			  Element elmarca =e.getChild("marca");
			  Element elmodello =e.getChild("modello");
			  Element eltecnologia=e.getChild("tecnologia");
			  Element elrete=e.getChild("rete");
			  Element elsisoper=e.getChild("sisoper");
			  Element elpeso=e.getChild("peso");
			  Element eldimensioni = e.getChild("dimensioni");
			  Element elrisschermo = e.getChild("risSchermo");
			  Element elfotocamera = e.getChild("fotocamera");
			  Element elmemoriaint = e.getChild("memoriaint");
			  Element elmemoriaest = e.getChild("memoriaest");
			  Element elconnettivita = e.getChild("connettivita");
			  Element elvibrazione=e.getChild("vibrazione");
			  Element elbatteria=e.getChild("batteria");
			  Element elautonomia=e.getChild("autonomia");
			  Element elautonomiast=e.getChild("autonomiast");
			  Element elantenna=e.getChild("antenna");
			  Element elbrowser=e.getChild("browser");
			  Element elgiochi=e.getChild("giochi");
			  Element elmessaggi=e.getChild("messaggi");
			  Element eljava =e.getChild("java");
			  Element elvideochiamata=e.getChild("videochiamata");
			  Element elgps=e.getChild("gps");
			  Element ellettori=e.getChild("lettori");
			  Element elvivavoce=e.getChild("vivavoce");
			  Element elradio = e.getChild("radio");
			  Element elsuonerie =e.getChild("suonerie");
			  Element elimmagine =e.getChild("immagine");
			  Element elprezzo =e.getChild("prezzo");	  
			  	cell.setMarca(elmarca.getText());
			  	cell.setModello(elmodello.getText());
			    cell.setTecnologia(eltecnologia.getText());
			    cell.setRete(elrete.getText());
			    cell.setSisoper(elsisoper.getText());
			    cell.setPeso(elpeso.getText());
			    cell.setDimensioni(eldimensioni.getText());
			    cell.setRisSchermo(elrisschermo.getText());
			    cell.setFotocamera(elfotocamera.getText());
			    cell.setMemoriaint(elmemoriaint.getText());
			    cell.setMemoriaest(elmemoriaest.getText());
			    cell.setConnettivita(elconnettivita.getText());
			    cell.setVibrazione(elvibrazione.getText());
			    cell.setBatteria(elbatteria.getText());
			    cell.setAutonomia(elautonomia.getText());
			    cell.setAutonomiast(elautonomiast.getText());
			    cell.setAntenna(elantenna.getText());
			    cell.setBrowser(elbrowser.getText());
			    cell.setGiochi(elgiochi.getText());
			    cell.setMessaggi(elmessaggi.getText());
			    cell.setJava(eljava.getText());
			    cell.setVideochiamata(elvideochiamata.getText());
			    cell.setGps(elgps.getText());
			    cell.setLettori(ellettori.getText());
			    cell.setVivavoce(elvivavoce.getText());
			    cell.setRadio(elradio.getText());
			    cell.setSuonerie(elsuonerie.getText());
			    cell.setImmagine(elimmagine.getText());
			    cell.setPrezzo(elprezzo.getText());
			  arr.add(cell);
		  }
		  	return arr;
	  }
	  
	  /* -------------- CERCA CELLULARI PER CARATTERISTICHE CELL -------------- */
	  public Cellulari cercaCellulari (String modello)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cellulari cell = new Cellulari();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (elmodello.getText().equals(modello))
			  {
				  Element elmarca = e.getChild("marca");
				  Element elimmagine =e.getChild("immagine");
				  Element eltecnologia=e.getChild("tecnologia");
				  Element elrete=e.getChild("rete");
				  Element elsisoper=e.getChild("sisoper");;
				  Element elpeso=e.getChild("peso");
				  Element eldimensioni = e.getChild("dimensioni");
				  Element elrisschermo = e.getChild("risSchermo");
				  Element elfotocamera = e.getChild("fotocamera");
				  Element elmemoriaint = e.getChild("memoriaint");
				  Element elmemoriaest = e.getChild("memoriaest");
				  Element elconnettivita = e.getChild("connettivita");
				  Element elvibrazione=e.getChild("vibrazione");
				  Element elbatteria=e.getChild("batteria");
				  Element elautonomia=e.getChild("autonomia");
				  Element elautonomiast=e.getChild("autonomiast");
				  Element elantenna=e.getChild("antenna");
				  Element elbrowser=e.getChild("browser");
				  Element elgiochi=e.getChild("giochi");
				  Element elmessaggi=e.getChild("messaggi");
				  Element eljava =e.getChild("java");
				  Element elvideochiamata=e.getChild("videochiamata");
				  Element elgps=e.getChild("gps");
				  Element ellettori=e.getChild("lettori");
				  Element elvivavoce=e.getChild("vivavoce");
				  Element elradio = e.getChild("radio");
				  Element elsuonerie =e.getChild("suonerie");
				
				  Element elprezzo =e.getChild("prezzo");	  
				
				  	cell.setModello(elmodello.getText());
				  	cell.setMarca(elmarca.getText());
				  	cell.setImmagine(elimmagine.getText());
				    cell.setTecnologia(eltecnologia.getText());
				    cell.setRete(elrete.getText());
				    cell.setSisoper(elsisoper.getText());
				    cell.setPeso(elpeso.getText());
				    cell.setDimensioni(eldimensioni.getText());
				    cell.setRisSchermo(elrisschermo.getText());
				    cell.setFotocamera(elfotocamera.getText());
				    cell.setMemoriaint(elmemoriaint.getText());
				    cell.setMemoriaest(elmemoriaest.getText());
				    cell.setConnettivita(elconnettivita.getText());
				    cell.setVibrazione(elvibrazione.getText());
				    cell.setBatteria(elbatteria.getText());
				    cell.setAutonomia(elautonomia.getText());
				    cell.setAutonomiast(elautonomiast.getText());
				    cell.setAntenna(elantenna.getText());
				    cell.setBrowser(elbrowser.getText());
				    cell.setGiochi(elgiochi.getText());
				    cell.setMessaggi(elmessaggi.getText());
				    cell.setJava(eljava.getText());
				    cell.setVideochiamata(elvideochiamata.getText());
				    cell.setGps(elgps.getText());
				    cell.setLettori(ellettori.getText());
				    cell.setVivavoce(elvivavoce.getText());
				    cell.setRadio(elradio.getText());
				    cell.setSuonerie(elsuonerie.getText());
				    cell.setPrezzo(elprezzo.getText());
				   break;
			  }
		  }
		  return cell;
	  }
	  
	  /* -------------- RICERCA DI UN CELLULARE -------------- */
	  public Cellulari ricerca(String marca, String modello)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cellulari cell = new Cellulari();
		  boolean controllo = false;
		  
		  while(iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmarca = e.getChild("marca");
			  Element elmodello = e.getChild("modello");
			  
			  if ((elmarca.getText().equals(marca)) && (elmodello.getText().equals(modello)))
			  {   Element elimmagine =e.getChild("immagine");
				  Element eltecnologia=e.getChild("tecnologia");
				  Element elrete=e.getChild("rete");
				  Element elsisoper=e.getChild("sisoper");
				  Element elpeso=e.getChild("peso");
				  Element eldimensioni = e.getChild("dimensioni");
				  Element elrisschermo = e.getChild("risSchermo");
				  Element elfotocamera = e.getChild("fotocamera");
				  Element elmemoriaint = e.getChild("memoriaint");
				  Element elmemoriaest = e.getChild("memoriaest");
				  Element elconnettivita = e.getChild("connettivita");
				  Element elvibrazione=e.getChild("vibrazione");
				  Element elbatteria=e.getChild("batteria");
				  Element elautonomia=e.getChild("autonomia");
				  Element elautonomiast=e.getChild("autonomiast");
				  Element elantenna=e.getChild("antenna");
				  Element elbrowser=e.getChild("browser");
				  Element elgiochi=e.getChild("giochi");
				  Element elmessaggi=e.getChild("messaggi");
				  Element eljava =e.getChild("java");
				  Element elvideochiamata=e.getChild("videochiamata");
				  Element elgps=e.getChild("gps");
				  Element ellettori=e.getChild("lettori");
				  Element elvivavoce=e.getChild("vivavoce");
				  Element elradio = e.getChild("radio");
				  Element elsuonerie =e.getChild("suonerie");
				
				  Element elprezzo =e.getChild("prezzo");	  
				  	cell.setMarca(elmarca.getText());
				  	cell.setModello(elmodello.getText());
				  	cell.setImmagine(elimmagine.getText());
				    cell.setTecnologia(eltecnologia.getText());
				    cell.setRete(elrete.getText());
				    cell.setSisoper(elsisoper.getText());
				    cell.setPeso(elpeso.getText());
				    cell.setDimensioni(eldimensioni.getText());
				    cell.setRisSchermo(elrisschermo.getText());
				    cell.setFotocamera(elfotocamera.getText());
				    cell.setMemoriaint(elmemoriaint.getText());
				    cell.setMemoriaest(elmemoriaest.getText());
				    cell.setConnettivita(elconnettivita.getText());
				    cell.setVibrazione(elvibrazione.getText());
				    cell.setBatteria(elbatteria.getText());
				    cell.setAutonomia(elautonomia.getText());
				    cell.setAutonomiast(elautonomiast.getText());
				    cell.setAntenna(elantenna.getText());
				    cell.setBrowser(elbrowser.getText());
				    cell.setGiochi(elgiochi.getText());
				    cell.setMessaggi(elmessaggi.getText());
				    cell.setJava(eljava.getText());
				    cell.setVideochiamata(elvideochiamata.getText());
				    cell.setGps(elgps.getText());
				    cell.setLettori(ellettori.getText());
				    cell.setVivavoce(elvivavoce.getText());
				    cell.setRadio(elradio.getText());
				    cell.setSuonerie(elsuonerie.getText());
				    cell.setPrezzo(elprezzo.getText());
				  controllo=true;
				  break;
			  }
		  }
		  	if (controllo==false)
		  	{
		  		cell.setMarca("");
			  	cell.setModello("");
			  	cell.setImmagine("");
			    cell.setTecnologia("");
			    cell.setRete("");
			    cell.setSisoper("");
			    cell.setPeso("");
			    cell.setDimensioni("");
			    cell.setRisSchermo("");
			    cell.setFotocamera("");
			    cell.setMemoriaint("");
			    cell.setMemoriaest("");
			    cell.setConnettivita("");
			    cell.setVibrazione("");
			    cell.setBatteria("");
			    cell.setAutonomia("");
			    cell.setAutonomiast("");
			    cell.setAntenna("");
			    cell.setBrowser("");
			    cell.setGiochi("");
			    cell.setMessaggi("");
			    cell.setJava("");
			    cell.setVideochiamata("");
			    cell.setGps("");
			    cell.setLettori("");
			    cell.setVivavoce("");
			    cell.setRadio("");
			    cell.setSuonerie("");
			    cell.setPrezzo("");
					return cell;
		  	}
		  	else return cell;
	  }
	  
	  /* -------------- RICERCA AVANZATA DI UN CELLULARE -------------- */
	  public ArrayList ricercaAvanzata(String prezzoMassimo,String connettivita,String tecnologia
			  ,String rete,String sisoper,String pesoMassimo,String autonomiaMin,String autonomiastMin,
			    String messaggi,String suonerie,String vibrazione,String browser,String giochi,
			    String java,String videochiamata,String gps,String lettori,String vivavoce,
			    String radio,String fotocamera,String memoriaint,String memoriaest)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  
		  int prezzMax = Integer.parseInt(prezzoMassimo);
		  int pesMax= Integer.parseInt(pesoMassimo);
		  int autonoMin = Integer.parseInt(autonomiaMin);
		  int autonostMin= Integer.parseInt(autonomiastMin);
		  while(iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elprezzo = e.getChild("prezzo");
			  Element elconnettivita = e.getChild("connettivita");
			  Element eltecnologia=e.getChild("tecnologia");
			  Element elrete=e.getChild("rete");
			  Element elsisoper=e.getChild("sisoper");
			  Element elpeso=e.getChild("peso");
			  Element elautonomia=e.getChild("autonomia");
			  Element elautonomiast=e.getChild("autonomiast");
			  Element elmessaggi=e.getChild("messaggi");
			  Element elsuonerie =e.getChild("suonerie");
			  
			  Element elvibrazione=e.getChild("vibrazione");
			  Element elbrowser=e.getChild("browser");
			  Element elgiochi=e.getChild("giochi");
			  Element eljava =e.getChild("java");
			  Element elvideochiamata=e.getChild("videochiamata");
			  Element elgps=e.getChild("gps");
			  Element ellettori=e.getChild("lettori");
			  Element elvivavoce=e.getChild("vivavoce");
			  Element elradio = e.getChild("radio");
			  Element elfotocamera = e.getChild("fotocamera");
			  Element elmemoriaint = e.getChild("memoriaint");
			  Element elmemoriaest = e.getChild("memoriaest");
			  
			  Cellulari cell = new Cellulari();
			  int p = Integer.parseInt(elprezzo.getText());
			  int pes= Integer.parseInt(elpeso.getText());
			  int aut = Integer.parseInt(elautonomia.getText());
			  int autst= Integer.parseInt(elautonomiast.getText());
			  
  if ((p<=prezzMax)&&(elconnettivita.getText().equals(connettivita))&&(eltecnologia.getText().equals(tecnologia))
			&&(elrete.getText().equals(rete))&&(elsisoper.getText().equals(sisoper))&&
			(pes<=pesMax)&&(aut>=autonoMin)&&(autst>=autonostMin)&&(elmessaggi.getText().equals(messaggi))&&
			(elsuonerie.getText().equals(suonerie))&&(elvibrazione.getText().equals(vibrazione))&&
			(elbrowser.getText().equals(browser))&&(elgiochi.getText().equals(giochi))&&(eljava.getText().equals(java))
			&&(elvideochiamata.getText().equals(videochiamata))&&(elgps.getText().equals(gps))&&
			(ellettori.getText().equals(lettori))&&(elvivavoce.getText().equals(vivavoce))
			&&(elradio.getText().equals(radio))&&(elfotocamera.getText().equals(fotocamera))
			&&(elmemoriaint.getText().equals(memoriaint))&&(elmemoriaest.getText().equals(memoriaest)))
  

			

			
  
		   {
				  Element elmarca =e.getChild("marca");
				  Element elmodello =e.getChild("modello");
				  Element eldimensioni = e.getChild("dimensioni");
				  Element elrisschermo = e.getChild("risSchermo");
			      Element elbatteria=e.getChild("batteria");
				  Element elantenna=e.getChild("antenna");
				  Element elimmagine =e.getChild("immagine");
				 	  
				  	cell.setMarca(elmarca.getText());
				  	cell.setModello(elmodello.getText());
				    cell.setTecnologia(eltecnologia.getText());
				    cell.setRete(elrete.getText());
				    cell.setSisoper(elsisoper.getText());
				    cell.setPeso(elpeso.getText());
				    cell.setDimensioni(eldimensioni.getText());
				    cell.setRisSchermo(elrisschermo.getText());
				    cell.setFotocamera(elfotocamera.getText());
				    cell.setMemoriaint(elmemoriaint.getText());
				    cell.setMemoriaest(elmemoriaest.getText());
				    cell.setConnettivita(elconnettivita.getText());
				    cell.setVibrazione(elvibrazione.getText());
				    cell.setBatteria(elbatteria.getText());
				    cell.setAutonomia(elautonomia.getText());
				    cell.setAutonomiast(elautonomiast.getText());
				    cell.setAntenna(elantenna.getText());
				    cell.setBrowser(elbrowser.getText());
				    cell.setGiochi(elgiochi.getText());
				    cell.setMessaggi(elmessaggi.getText());
				    cell.setJava(eljava.getText());
				    cell.setVideochiamata(elvideochiamata.getText());
				    cell.setGps(elgps.getText());
				    cell.setLettori(ellettori.getText());
				    cell.setVivavoce(elvivavoce.getText());
				    cell.setRadio(elradio.getText());
				    cell.setSuonerie(elsuonerie.getText());
				    cell.setImmagine(elimmagine.getText());
				    cell.setPrezzo(elprezzo.getText());
				  
				  arr.add(cell);
			  }
		  }
		  	 return arr;
	  }
	  
	  /* -------------- CERCA IL CELLULARE PER LA MODIFICA -------------- */
	  public Cellulari cercaCellulare (String modello)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cellulari cell = new Cellulari();
		  
		  while (iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (elmodello.getText().equals(modello))
			  {
				  Element elmarca = e.getChild("marca");
				  Element elimmagine =e.getChild("immagine");
				  Element eltecnologia=e.getChild("tecnologia");
				  Element elrete=e.getChild("rete");
				  Element elsisoper=e.getChild("sisoper");
				  Element elpeso=e.getChild("peso");
				  Element eldimensioni = e.getChild("dimensioni");
				  Element elrisschermo = e.getChild("risSchermo");
				  Element elfotocamera = e.getChild("fotocamera");
				  Element elmemoriaint = e.getChild("memoriaint");
				  Element elmemoriaest = e.getChild("memoriaest");
				  Element elconnettivita = e.getChild("connettivita");
				  Element elvibrazione=e.getChild("vibrazione");
				  Element elbatteria=e.getChild("batteria");
				  Element elautonomia=e.getChild("autonomia");
				  Element elautonomiast=e.getChild("autonomiast");
				  Element elantenna=e.getChild("antenna");
				  Element elbrowser=e.getChild("browser");
				  Element elgiochi=e.getChild("giochi");
				  Element elmessaggi=e.getChild("messaggi");
				  Element eljava =e.getChild("java");
				  Element elvideochiamata=e.getChild("videochiamata");
				  Element elgps=e.getChild("gps");
				  Element ellettori=e.getChild("lettori");
				  Element elvivavoce=e.getChild("vivavoce");
				  Element elradio = e.getChild("radio");
				  Element elsuonerie =e.getChild("suonerie");
				
				  Element elprezzo =e.getChild("prezzo");	  
				
				  	cell.setModello(elmodello.getText());
				  	cell.setMarca(elmarca.getText());
				  	cell.setImmagine(elimmagine.getText());
				    cell.setTecnologia(eltecnologia.getText());
				    cell.setRete(elrete.getText());
				    cell.setSisoper(elsisoper.getText());
				    cell.setPeso(elpeso.getText());
				    cell.setDimensioni(eldimensioni.getText());
				    cell.setRisSchermo(elrisschermo.getText());
				    cell.setFotocamera(elfotocamera.getText());
				    cell.setMemoriaint(elmemoriaint.getText());
				    cell.setMemoriaest(elmemoriaest.getText());
				    cell.setConnettivita(elconnettivita.getText());
				    cell.setVibrazione(elvibrazione.getText());
				    cell.setBatteria(elbatteria.getText());
				    cell.setAutonomia(elautonomia.getText());
				    cell.setAutonomiast(elautonomiast.getText());
				    cell.setAntenna(elantenna.getText());
				    cell.setBrowser(elbrowser.getText());
				    cell.setGiochi(elgiochi.getText());
				    cell.setMessaggi(elmessaggi.getText());
				    cell.setJava(eljava.getText());
				    cell.setVideochiamata(elvideochiamata.getText());
				    cell.setGps(elgps.getText());
				    cell.setLettori(ellettori.getText());
				    cell.setVivavoce(elvivavoce.getText());
				    cell.setRadio(elradio.getText());
				    cell.setSuonerie(elsuonerie.getText());
				    cell.setPrezzo(elprezzo.getText());
				  break;
			  }
		  }
		  return cell;
	  }
	  
	  /* -------------- MODIFICA IL CELLULARE -------------- */
	  public void modificaCell (Cellulari cell)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while(iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Element elmodello = e.getChild("modello");
			  
			  if (elmodello.getText().equals(cell.getModello()))
			  {
				  Element elmarca = e.getChild("marca");
				  Element elimmagine =e.getChild("immagine");
				  Element eltecnologia=e.getChild("tecnologia");
				  Element elrete=e.getChild("rete");
				  Element elsisoper=e.getChild("sisoper");
				  Element elpeso=e.getChild("peso");
				  Element eldimensioni = e.getChild("dimensioni");
				  Element elrisschermo = e.getChild("risSchermo");
				  Element elfotocamera = e.getChild("fotocamera");
				  Element elmemoriaint = e.getChild("memoriaint");
				  Element elmemoriaest = e.getChild("memoriaest");
				  Element elconnettivita = e.getChild("connettivita");
				  Element elvibrazione=e.getChild("vibrazione");
				  Element elbatteria=e.getChild("batteria");
				  Element elautonomia=e.getChild("autonomia");
				  Element elautonomiast=e.getChild("autonomiast");
				  Element elantenna=e.getChild("antenna");
				  Element elbrowser=e.getChild("browser");
				  Element elgiochi=e.getChild("giochi");
				  Element elmessaggi=e.getChild("messaggi");
				  Element eljava =e.getChild("java");
				  Element elvideochiamata=e.getChild("videochiamata");
				  Element elgps=e.getChild("gps");
				  Element ellettori=e.getChild("lettori");
				  Element elvivavoce=e.getChild("vivavoce");
				  Element elradio = e.getChild("radio");
				  Element elsuonerie =e.getChild("suonerie");
				  Element elprezzo =e.getChild("prezzo");	
				  
				  elmarca.setText(cell.getMarca());
				  elimmagine.setText(cell.getImmagine());
				  eltecnologia.setText(cell.getTecnologia());
				  elrete.setText(cell.getRete());
				  elsisoper.setText(cell.getSisoper());
				  elpeso.setText(cell.getPeso());
				  eldimensioni.setText(cell.getDimensioni());
				  elrisschermo.setText(cell.getRisSchermo());
				  elfotocamera.setText(cell.getFotocamera());
				  elmemoriaint.setText(cell.getMemoriaint());
				  elmemoriaest.setText(cell.getMemoriaest());
				  elconnettivita.setText(cell.getConnettivita());
				  elvibrazione.setText(cell.getVibrazione());
				  elbatteria.setText(cell.getBatteria());
				  elautonomia.setText(cell.getAutonomia());
				  elautonomiast.setText(cell.getAutonomiast());
				  elantenna.setText(cell.getAntenna());
				  elbrowser.setText(cell.getBrowser());
				  elgiochi.setText(cell.getGiochi());
				  elmessaggi.setText(cell.getMessaggi());
				  eljava.setText(cell.getJava());
				  elvideochiamata.setText(cell.getVideochiamata());
				  elgps.setText(cell.getGps());
				  ellettori.setText(cell.getLettori());
				  elvivavoce.setText(cell.getVivavoce());
				  elradio.setText(cell.getRadio());
				  elsuonerie.setText(cell.getSuonerie());
				 
				  elprezzo.setText(cell.getPrezzo());
				  
				  scrivi();
				  break;
			  }
		  }
	  }
	  
	  /* -------------- LISTA I CELLULARI PER LA MODIFICA -------------- */
	  public ArrayList listaCell()
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
			  	String modello = elmodello.getText();
			  arr.add(modello);
		  }
		  	return arr;
	  }
	  
	  /* -------------- POSIZIONE DEL CELLULARE -------------- */
	  public int posizioneCell(String modello)
	  {
		  int pos=0;
		  int i=0;
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  Cellulari cell = new Cellulari();
		  
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
	  
	  /* -------------- CANCELLA IL CELLULARE -------------- */
	  public void cancellaCell(String modello)
	  {
		  int pos = posizioneCell(modello);
		  
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  root.getChildren().remove(pos-1);
		  scrivi();
	  }
	  
	  /* -------------- RITORNA LE NOVITA' -------------- */
	  public ArrayList novita()
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while(iterator.hasNext())
		  {
			  Element e = (Element)iterator.next();
			  Cellulari cell = new Cellulari();
			  
			  Element elmarca = e.getChild("marca");
			  Element elmodello = e.getChild("modello");
			  Element elimmagine = e.getChild("immagine");
			  cell.setMarca(elmarca.getText());
			  cell.setModello(elmodello.getText());
			  cell.setImmagine(elimmagine.getText());
			  arr.add(0,cell);
		  }
		  	return arr;
	  }
	  
	  /* -------------- RITORNA CELLULARI FILE ESTERNO -------------- */
	  public ArrayList esterni()
	  {
		  ArrayList arr = new ArrayList();
		  arr.clear();
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  while (iterator.hasNext())
		  {
			  Cellulari cell = new Cellulari();
			  Element e = (Element)iterator.next();
			  
			  Element elmarca =e.getChild("marca");
			  Element elmodello =e.getChild("modello");
			  Element eltecnologia=e.getChild("tecnologia");
			  Element elrete=e.getChild("rete");
			  Element elsisoper=e.getChild("sisoper");
			  Element elpeso=e.getChild("peso");
			  Element eldimensioni = e.getChild("dimensioni");
			  Element elrisschermo = e.getChild("risSchermo");
			  Element elfotocamera = e.getChild("fotocamera");
			  Element elmemoriaint = e.getChild("memoriaint");
			  Element elmemoriaest = e.getChild("memoriaest");
			  Element elconnettivita = e.getChild("connettivita");
			  Element elvibrazione=e.getChild("vibrazione");
			  Element elbatteria=e.getChild("batteria");
			  Element elautonomia=e.getChild("autonomia");
			  Element elautonomiast=e.getChild("autonomiast");
			  Element elantenna=e.getChild("antenna");
			  Element elbrowser=e.getChild("browser");
			  Element elgiochi=e.getChild("giochi");
			  Element elmessaggi=e.getChild("messaggi");
			  Element eljava =e.getChild("java");
			  Element elvideochiamata=e.getChild("videochiamata");
			  Element elgps=e.getChild("gps");
			  Element ellettori=e.getChild("lettori");
			  Element elvivavoce=e.getChild("vivavoce");
			  Element elradio = e.getChild("radio");
			  Element elsuonerie =e.getChild("suonerie");
			  Element elimmagine =e.getChild("immagine");
			  Element elprezzo =e.getChild("prezzo");	  
			  Element elquanto = e.getChild("quantita");
			  			  
			    cell.setMarca(elmarca.getText());
			  	cell.setModello(elmodello.getText());
			    cell.setTecnologia(eltecnologia.getText());
			    cell.setRete(elrete.getText());
			    cell.setSisoper(elsisoper.getText());
			    cell.setPeso(elpeso.getText());
			    cell.setDimensioni(eldimensioni.getText());
			    cell.setRisSchermo(elrisschermo.getText());
			    cell.setFotocamera(elfotocamera.getText());
			    cell.setMemoriaint(elmemoriaint.getText());
			    cell.setMemoriaest(elmemoriaest.getText());
			    cell.setConnettivita(elconnettivita.getText());
			    cell.setVibrazione(elvibrazione.getText());
			    cell.setBatteria(elbatteria.getText());
			    cell.setAutonomia(elautonomia.getText());
			    cell.setAutonomiast(elautonomiast.getText());
			    cell.setAntenna(elantenna.getText());
			    cell.setBrowser(elbrowser.getText());
			    cell.setGiochi(elgiochi.getText());
			    cell.setMessaggi(elmessaggi.getText());
			    cell.setJava(eljava.getText());
			    cell.setVideochiamata(elvideochiamata.getText());
			    cell.setGps(elgps.getText());
			    cell.setLettori(ellettori.getText());
			    cell.setVivavoce(elvivavoce.getText());
			    cell.setRadio(elradio.getText());
			    cell.setSuonerie(elsuonerie.getText());
			 	cell.setImmagine(elimmagine.getText());
			    cell.setPrezzo(elprezzo.getText());
			  	cell.setQuantita(elquanto.getText());
			  	
			  arr.add(cell);
		  }
		  	return arr;
	  }
	  
	  /* -------------- AGGIUNGE CELLULARE DA FILE ESTERNO -------------- */
	  public void addCellEsternamente(Cellulari cell)
	  {
		  List children = root.getChildren();
		  Iterator iterator = children.iterator();
		  
		  Element c = new Element("cellulare");
		  Element elcodice = new Element ("codice");
		  Element elmarca = new Element ("marca");
		  Element elmodello = new Element ("modello");
		  Element eltecnologia=new Element ("tecnologia");
		  Element elrete=new Element("rete");
		  Element elsisoper=new Element("sisoper");
		  Element elpeso=new Element("peso");
		  Element eldimensioni = new Element ("dimensioni");
		  Element elrisschermo = new Element ("risSchermo");
		  Element elfotocamera = new Element ("fotocamera");
		  Element elmemoriaint = new Element ("memoriaint");
		  Element elmemoriaest = new Element("memoriaest");
		  Element elconnettivita = new Element ("connettivita");
		  Element elvibrazione=new Element("vibrazione");
		  Element elbatteria=new Element("batteria");
		  Element elautonomia=new Element("autonomia");
		  Element elautonomiast=new Element("autonomiast");
		  Element elantenna=new Element("antenna");
		  Element elbrowser=new Element("browser");
		  Element elgiochi=new Element("giochi");
		  Element elmessaggi=new Element("messaggi");
		  Element eljava = new Element ("java");
		  Element elvideochiamata=new Element("videochiamata");
		  Element elgps=new Element("gps");
		  Element ellettori=new Element("lettori");
		  Element elvivavoce=new Element("vivavoce");
		  Element elradio = new Element ("radio");
		  Element elsuonerie = new Element ("suonerie");
		  Element elimmagine=new Element("immagine");
		  Element elprezzo = new Element ("prezzo");
		  int app = contaCell();
		  app = app + 1;
		  String codice = String.valueOf(app);
		  
		  elcodice.setText(codice);
		  
		  elmarca.setText(cell.getMarca());
		  elmodello.setText(cell.getModello());
		  eltecnologia.setText(cell.getTecnologia());
		  elrete.setText(cell.getRete());
		  elsisoper.setText(cell.getSisoper());
		  elpeso.setText(cell.getPeso());
		  eldimensioni.setText(cell.getDimensioni());
		  elrisschermo.setText(cell.getRisSchermo());
		  elfotocamera.setText(cell.getFotocamera());
		  elmemoriaint.setText(cell.getMemoriaint());
		  elmemoriaest.setText(cell.getMemoriaest());
		  elconnettivita.setText(cell.getConnettivita());
		  elvibrazione.setText(cell.getVibrazione());
		  elbatteria.setText(cell.getBatteria());
		  elautonomia.setText(cell.getAutonomia());
		  elautonomiast.setText(cell.getAutonomiast());
		  elantenna.setText(cell.getAntenna());
		  elbrowser.setText(cell.getBrowser());
		  elgiochi.setText(cell.getGiochi());
		  elmessaggi.setText(cell.getMessaggi());
		  eljava.setText(cell.getJava());
		  elvideochiamata.setText(cell.getVideochiamata());
		  elgps.setText(cell.getGps());
		  ellettori.setText(cell.getLettori());
		  elvivavoce.setText(cell.getVivavoce());
		  elradio.setText(cell.getRadio());
		  elsuonerie.setText(cell.getSuonerie());
		  elimmagine.setText(cell.getImmagine());
		  elprezzo.setText(cell.getPrezzo());
		  
		  c.addContent(elcodice);
		  c.addContent(elmarca);
		  c.addContent(elmodello);
		  c.addContent(eltecnologia);
		  c.addContent(elrete);
		  c.addContent(elsisoper);
		  c.addContent(elpeso);
		  c.addContent(eldimensioni);
		  c.addContent(elrisschermo);
		  c.addContent(elfotocamera);
		  c.addContent(elmemoriaint);
		  c.addContent(elmemoriaest);
		  c.addContent(elconnettivita);
		  c.addContent(elvibrazione);
		  c.addContent(elbatteria);
		  c.addContent(elautonomia);
		  c.addContent(elautonomiast);
		  c.addContent(elantenna);
		  c.addContent(elbrowser);
		  c.addContent(elgiochi);
		  c.addContent(elmessaggi);
		  c.addContent(eljava);
		  c.addContent(elvideochiamata);
		  c.addContent(elgps);
		  c.addContent(ellettori);
		  c.addContent(elvivavoce);
		  c.addContent(elradio);
		  c.addContent(elsuonerie);
		  c.addContent(elimmagine);
		  c.addContent(elprezzo);
		  
		  root.addContent(c);
		  scrivi();		  
	  }
	
}