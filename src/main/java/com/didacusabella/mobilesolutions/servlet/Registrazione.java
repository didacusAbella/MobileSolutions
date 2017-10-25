package com.didacusabella.mobilesolutions.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class Registrazione extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cliente.xml").toString();
		
		String username = request.getParameter("username");
		
		Cliente cli = new Cliente();
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
		cli.setUsername(request.getParameter("username"));
		cli.setPassword(request.getParameter("password"));
		cli.setEmail(request.getParameter("email"));
		cli.setClausola1(request.getParameter("clausola1"));
		cli.setClausola2(request.getParameter("clausola2"));
		DBCliente db = new DBCliente(url);
		boolean trovato = db.control(username);
		if (!trovato)
		{
			db.addCliente(cli);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
			disp.forward(request,response);
		}
		else
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/errore.jsp");
			disp.forward(request,response);
		}
		
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
