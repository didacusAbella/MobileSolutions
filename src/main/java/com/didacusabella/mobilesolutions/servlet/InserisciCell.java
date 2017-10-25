package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class InserisciCell extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		String url2 = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
		
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		Cellulari cell = new Cellulari();
			cell.setMarca(request.getParameter("marca"));
			cell.setModello(request.getParameter("modello"));
			cell.setDimensioni(request.getParameter("dimensioni"));
			cell.setFotocamera(request.getParameter("fotocamera"));
			//cell.setMemoria(request.getParameter("memoria"));
			cell.setRisSchermo(request.getParameter("risSchermo"));
			cell.setConnettivita(request.getParameter("connettivita"));
			cell.setImmagine(request.getParameter("immagine"));			
			cell.setPrezzo(request.getParameter("prezzo"));
				DBCell db = new DBCell(url);
				db.addCellulare(cell,username);
		
		Magazzino mag = new Magazzino();
			mag.setModello(request.getParameter("modello"));
			mag.setQuantita(request.getParameter("quantita"));
				DBMagazzino db2 = new DBMagazzino(url2);
				db2.addMagazzino(mag);
				
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
		disp.include(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
