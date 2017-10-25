package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class LoginCliente extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cliente.xml").toString();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		DBCliente db = new DBCliente(url);
		boolean ris = db.login(username,password);
		
		if (ris==true)
		{
			Cliente cli = db.cercaCliente(username,password);
			HttpSession session = request.getSession(true);
			cli.setLoggato(true);
			session.putValue("Cliente",cli);
			ArrayList carr = new ArrayList();
			carr.clear();
			session.putValue("Carr",carr);
						
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
