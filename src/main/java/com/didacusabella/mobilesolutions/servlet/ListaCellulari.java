package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class ListaCellulari extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		
		HttpSession session = request.getSession(true);
		ArrayList arr = new ArrayList();
		arr.clear();
		DBCell db = new DBCell(url);
		arr = db.listaCompleta();
		session.putValue("lis",arr);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/lista.jsp");
		disp.forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		doGet(request,response);
	}
}
