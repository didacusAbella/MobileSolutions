package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class LogoutCliente extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		session.removeAttribute("Cliente");
		session.invalidate();
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
		disp.forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		doGet(request,response);
	}
}
