package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class CompletaDispon extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
				
		String modello = request.getParameter("mod");
		Magazzino magaz = new Magazzino ();
		DBMagazzino db = new DBMagazzino(url);
		magaz=db.cercaInMagazzino(modello);
		
		HttpSession session = request.getSession(true);
		session.putValue("Magazzino",magaz);
				
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/disponibilita.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
