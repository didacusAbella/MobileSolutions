package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class CancellaCliente extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cliente.xml").toString();
		
		String username = request.getParameter("username");
		HttpSession session = request.getSession(true);
		DBCliente db = new DBCliente(url);
		db.cancellaCliente(username);
		session.removeAttribute("Cliente");
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
