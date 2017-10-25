package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class RimuoviCarrello extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		HttpSession session = request.getSession(true);
		String modello = request.getParameter("modello");
		
		ArrayList carr = (ArrayList)session.getValue("Carr");
		int pos=0;
		for (int i=0; i<carr.size(); i++)
		{
			Cellulari cell = (Cellulari)carr.get(i);
			if(cell.getModello().equals(modello))
					pos=i;
		}
		carr.remove(pos);
		session.removeAttribute("Carr");
		session.putValue("Carr",carr);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
		disp.forward(request,response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}

}
