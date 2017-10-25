package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class ModificaCliente extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cliente.xml").toString();
		
	    Cliente cli = new Cliente();
	    cli.setUsername(request.getParameter("username"));
	    cli.setNome(request.getParameter("nome"));
	    cli.setCognome(request.getParameter("cognome"));
	    cli.setCodicefiscale(request.getParameter("cofiscale"));
	    cli.setTipoindirizzo(request.getParameter("tipoindirizzo"));
	    cli.setIndirizzo(request.getParameter("indirizzo"));
	    cli.setCap(request.getParameter("cap"));
	    cli.setCitta(request.getParameter("citta"));
	    cli.setProvincia(request.getParameter("prov"));
	    cli.setTelcasa(request.getParameter("telcas"));
	    cli.setTelcell(request.getParameter("telcel"));
	    cli.setFax(request.getParameter("fax"));
	    cli.setEmail(request.getParameter("email"));
	    cli.setPassword(request.getParameter("password"));
          DBCliente db = new DBCliente(url);
		db.modificaCliente(cli);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
