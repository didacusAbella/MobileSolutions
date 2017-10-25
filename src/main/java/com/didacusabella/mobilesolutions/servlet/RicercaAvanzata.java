package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class RicercaAvanzata extends HttpServlet
{
		public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
		{
			String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/cellulari.xml").toString();
			HttpSession session = request.getSession(true);
			
			String prezzoMassimo = (String)request.getParameter("prezzoMassimo");
			String connettivita = (String)request.getParameter("connettivita");
			String tecnologia = (String)request.getParameter("tecnologia");
			String rete = (String)request.getParameter("rete");
			String sisoper = (String)request.getParameter("sisoper");
			String pesoMassimo = (String)request.getParameter("peso");
			String autonomiaMin = (String)request.getParameter("autonomia");
			String autonomiastMin = (String)request.getParameter("autonomiast");
			String messaggi = (String)request.getParameter("messaggi");
			String suonerie = (String)request.getParameter("suonerie");
			String vibrazione=(String)request.getParameter("vibrazione");
			String browser = (String)request.getParameter("browser");
			String giochi = (String)request.getParameter("giochi");
			String java = (String)request.getParameter("java");
			String videochiamata = (String)request.getParameter("videochiamata");
			String gps = (String)request.getParameter("gps");
			String lettori = (String)request.getParameter("lettori");
			String vivavoce = (String)request.getParameter("vivavoce");
			String radio = (String)request.getParameter("radio");
			String fotocamera = (String)request.getParameter("fotocamera");
			String memoriaint = (String)request.getParameter("memoriaint");
			String memoriaest = (String)request.getParameter("memoriaest");
			DBCell db = new DBCell(url);
			
			ArrayList arr = new ArrayList();
			arr = db.ricercaAvanzata(prezzoMassimo,connettivita,tecnologia,rete,sisoper,pesoMassimo,autonomiaMin,autonomiastMin,messaggi,suonerie,vibrazione,
					  browser,giochi,java,videochiamata,gps,lettori,vivavoce,radio,fotocamera,memoriaint,memoriaest);
			
				session.putValue("Cellulari",arr);
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/visCellAvanz.jsp");
				disp.forward(request,response);
		}
		
		public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
		{
			doGet(request,response);
		}
}
