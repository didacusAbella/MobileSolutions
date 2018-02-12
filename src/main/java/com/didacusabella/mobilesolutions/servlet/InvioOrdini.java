package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class InvioOrdini extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/ordini.xml").toString();
		
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		
	    Ordini ord = new Ordini();
	    ord.setDataInoltro(request.getParameter("datainoltro"));
		ord.setModalitaSpe(request.getParameter("modalitaSpe"));
		ord.setModalitaPay(request.getParameter("modalitaPay"));
		ord.setTotalePag(request.getParameter("totalePag"));
		
	
		DBOrdini db = new DBOrdini(url);
	
		
			db.addOrdini(ord,username);
			
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
			disp.forward(request,response);
		
	
		
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
