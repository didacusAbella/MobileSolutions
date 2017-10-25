package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class CancellaCell extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		String url2 = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
		
		String modello = request.getParameter("cancCell");
		HttpSession session = request.getSession(true);
		
		DBCell db = new DBCell(url);
		db.cancellaCell(modello);
		DBMagazzino db2 = new DBMagazzino(url2);
		db2.cancellaCell(modello);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
