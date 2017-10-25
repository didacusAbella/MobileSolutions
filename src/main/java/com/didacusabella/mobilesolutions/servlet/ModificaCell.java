package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class ModificaCell extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		
		Cellulari cell = new Cellulari();
		String modello = request.getParameter("modelloCell");
		String quantita = request.getParameter("quantita");
		DBCell db = new DBCell(url);
		cell = db.cercaCellulare(modello);
		HttpSession session = request.getSession(true);
		session.putValue("Cellulari",cell);
		session.putValue("Quantita",quantita);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/modificaCaratt.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
