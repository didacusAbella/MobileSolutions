package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class Esaurimento extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
		
		HttpSession session = request.getSession(true);
		
		String scorta = request.getParameter("scorta");
		ArrayList arr = new ArrayList();
		arr.clear();
		DBMagazzino db = new DBMagazzino(url);
		arr=db.listaEsaurimento(scorta);
		
		session.putValue("esaur",arr);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/listaEsaurimento.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
