package com.didacusabella.mobilesolutions.servlet;;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.gestioneDB.*;

public class AcquistaCarrello extends HttpServlet
{
	public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		String url = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/magazzino.xml").toString();
		String url2 = getServletConfig().getServletContext().getRealPath("/WEB-INF/database/vendite.xml").toString();
		
		HttpSession session = request.getSession(true);
		ArrayList carr = new ArrayList();
		carr = (ArrayList)session.getValue("Carr");
		String user = request.getParameter("username");
		Cellulari cell = new Cellulari();
		
		ArrayList maga = new ArrayList();
		DBMagazzino db = new DBMagazzino(url);
		maga=db.listaMagazzino();
		
		/* In qst for sottraggo le copie al magazzino */
		for(int i=0; i<carr.size(); i++)
		{
			cell = (Cellulari)carr.get(i);
			for(int j=0; j<maga.size(); j++)
			{
				Magazzino m = (Magazzino)maga.get(j);
				if (m.getModello().equals(cell.getModello()))
				{
					String temp = m.getQuantita();
					int temp2 = Integer.parseInt(temp);
					temp2--;
					maga.remove(j);
					m.setQuantita(Integer.toString(temp2));
					maga.add(0,m);
				}
			}
		}
		
		int controllo=0;
		String errore="";
		/* In qst for verifico se nel magazzino c'� qlc notebook cn qnt <0 */
		for(int i=0; i<maga.size(); i++)
		{
			Magazzino ma = (Magazzino)maga.get(i);
			int a = Integer.parseInt(ma.getQuantita());
			if (a<0)
			{
				controllo=1;
				errore=ma.getModello();
				break;
			}
		}
		
		if (controllo==1)
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/errore.jsp");
			disp.forward(request,response);
		} else {
				DBVendite ven = new DBVendite(url2);
				for(int i=0; i<carr.size(); i++)
				{
					cell = (Cellulari)carr.get(i);
					ven.addVendita(cell,user);
				}
					db.aggiornaMagazzino(maga);
					carr.clear();
					session.putValue("Carr",carr);
					
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/pagamento.jsp");
					disp.forward(request,response);
				}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
	{
		doGet(request,response);
	}
}
