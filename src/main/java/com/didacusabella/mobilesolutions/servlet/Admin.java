package com.didacusabella.mobilesolutions.servlet;

import com.didacusabella.mobilesolutions.gestioneDB.DBCell;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.didacusabella.mobilesolutions.gestioneDB.DBCliente;
/**
 *
 * @author didacusabella
 */
public class Admin extends HttpServlet {

  
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String partial = request.getParameter("page") != null ? request.getParameter("page") : "clienti.jsp";
    request.setAttribute("partial", partial);
    String path = getServletContext().getRealPath("/");
    switch(partial){
      case "modificaCell.jsp": case "cancellaCell.jsp":
	DBCell dbCell = new DBCell(path+"WEB-INF/database/cellulari.xml");
        request.setAttribute("phones", dbCell.listaCell());
        break;
      case "clienti.jsp":
        DBCliente dbClients = new DBCliente(path+"WEB-INF/database/cliente.xml");
        request.setAttribute("clients", dbClients.listaClienti());
      default:
    }
    this.getServletContext().getRequestDispatcher("/admin_resources/adminDashboard.jsp").include(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }

}
