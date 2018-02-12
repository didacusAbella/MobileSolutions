package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class Importazione extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
		String url2 = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
		
		String esterno = request.getParameter("esterno"); //è il file
		String urlExt = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/"+esterno).toString();
		
		DBCell db = new DBCell(url);
		DBMagazzino db2 = new DBMagazzino(url2);
		DBCell dbExt = new DBCell(urlExt);
		
		ArrayList arrPres = new ArrayList();
		  arrPres = db.listaCompleta();
		ArrayList arrEst = new ArrayList();
		  arrEst = dbExt.esterni();
		  
		boolean trovato=false;
		
		for (int i=0; (i<arrEst.size()); i++)
		{
			trovato = false;
			Cellulari cellEst = (Cellulari)arrEst.get(i);
			String modelloEst = cellEst.getModello();
			String quantitaEst = cellEst.getQuantita();
			for (int j=0; (j<arrPres.size()); j++)
			{
				Cellulari cellPres = (Cellulari)arrPres.get(j);
				String modelloPres = cellPres.getModello();
				String quantitaPres = cellPres.getQuantita();
				
				if (modelloPres.equals(modelloEst))
				{
					trovato = true;
				}
			}
			if (trovato==true)
			{
				Magazzino mag = new Magazzino();
				mag.setModello(modelloEst);
				mag.setQuantita(quantitaEst);
				db2.modMagazzino(mag);
			}
			else 
			{
				db.addCellEsternamente(cellEst);
				Magazzino mag = new Magazzino();
				mag.setModello(modelloEst);
				mag.setQuantita(quantitaEst);
				db2.addMagazzino(mag);
			}
		}
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
		disp.forward(request,response);
	}
		
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
