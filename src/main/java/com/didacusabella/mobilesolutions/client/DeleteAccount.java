package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.entities.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteAccount", urlPatterns = {"/DeleteAccount"})
public class DeleteAccount extends HttpServlet {
  
  private static final Logger DELETE_ACCOUNT = Logger.getLogger(DeleteAccount.class.getName());

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    ClientManager clientManager;
    try {
      clientManager = ClientManager.getInstance();
      HttpSession session = request.getSession(true);
      Client client = (Client) session.getAttribute("user");
      if (clientManager.deleteClient(client.getId())) {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalog");
        dispatcher.forward(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        request.setAttribute("errorMessage", "Account non presente nei nostri archivi");
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException e) {
      DELETE_ACCOUNT.log(Level.SEVERE, null, e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi.");
      request.setAttribute("redirect", "Catalog");
      this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
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
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
