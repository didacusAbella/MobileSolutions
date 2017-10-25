package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class InserisciCarrello extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		
		String user = request.getParameter("username");
		if (user.equals("false"))
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/errore.jsp");
			disp.forward(request,response);
		}
		else 
		{
			ArrayList carr = new ArrayList();
			HttpSession session = request.getSession(true);
			carr = (ArrayList)session.getValue("Carr");
			session.removeAttribute("Carr");
			String modello = request.getParameter("modello");
			Cellulari cell = new Cellulari();
			DBCell db = new DBCell(url);
			cell = db.cercaCellulari(modello);
			carr.add(cell);
			session.setAttribute("Carr",carr);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
			disp.forward(request,response);
		}
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
