package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class CompletaCell extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
				
		String modello = request.getParameter("mod");
		Cellulari cell = new Cellulari();
		DBCell db = new DBCell(url);
		cell=db.cercaCellulari(modello);
		
		HttpSession session = request.getSession(true);
		session.putValue("Cellulari",cell);
				
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/caratteristicheCell.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
