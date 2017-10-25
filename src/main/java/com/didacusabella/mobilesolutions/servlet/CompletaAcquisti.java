package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class CompletaAcquisti extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/vendite.xml").toString();
				
		String cliente = request.getParameter("cliente");
		ArrayList arr = new ArrayList();
		arr.clear();
		DBVendite db = new DBVendite(url);
		arr=db.listaVendite(cliente);
		
		HttpSession session = request.getSession(true);
		session.putValue("ven",arr);
		session.putValue("cli", cliente);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/acquistiCliente.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
