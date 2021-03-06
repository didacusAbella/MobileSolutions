package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.entities.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
@WebServlet(name = "ShowClients", urlPatterns = {"/ShowClients"})
public class ShowClients extends HttpServlet {
  
  private static final Logger SHOW_CLIENTS = Logger.getLogger(ShowClients.class.getName());

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
    try {
      List<Client> clients = ClientManager.getInstance().getAllClients();
      request.setAttribute("partial", "clients.jsp");
      request.setAttribute("clients", clients);
      this.getServletContext().getRequestDispatcher("/admin_resources/adminDashboard.jsp").forward(request, response);
    } catch (SQLException ex) {
      SHOW_CLIENTS.log(Level.SEVERE, null, ex);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "AdminDashboard");
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
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

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Get all clients";
  }

}
