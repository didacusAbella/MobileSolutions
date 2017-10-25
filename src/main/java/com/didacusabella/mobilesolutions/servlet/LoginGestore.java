package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.gestioneDB.*;
import com.didacusabella.mobilesolutions.beans.*;

public class LoginGestore extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/gestore.xml").toString();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DBGestore db = new DBGestore(url);
		boolean ris = db.login(username,password);
		
		if (ris==true)
		{
			Gestore ges = db.cercaGestore(username,password);
			HttpSession session = request.getSession(true);
			ges.setLoggato(true);
			session.putValue("Gestore",ges);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
			disp.forward(request,response);
		}
		else
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/errore.jsp");
			disp.forward(request,response);
		}
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		doGet(request,response);
	}

}
