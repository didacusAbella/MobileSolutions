package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class Ricerca extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		
		HttpSession session = request.getSession(true);
		
		String marca = (String)request.getParameter("marca");
		String modello = (String)request.getParameter("modello");
		
		DBCell db = new DBCell(url);
		Cellulari cell = new Cellulari();
		cell = db.ricerca(marca,modello);
		
		if (cell.getMarca().equals(""))
		{
			session.putValue("Risultato","PRODOTTO NON TROVATO");
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/visualizzaCellulare.jsp");
			disp.forward(request,response);
		}
		else 
		{	
			session.putValue("Risultato","TROVATO");
			session.putValue("Cellulari",cell);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/visualizzaCellulare.jsp");
			disp.forward(request,response);
		}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
