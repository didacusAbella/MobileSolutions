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
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = "LoginClient", urlPatterns = {"/LoginClient"})
public class LoginClient extends HttpServlet {

  private static final Logger LOGIN_CLIENT = Logger.getLogger(LoginClient.class.getName());

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
    doPost(request, response);
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
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws
          ServletException, IOException {
    ClientManager manager;
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    try {
      manager = ClientManager.getInstance();
      String hashPassword = DigestUtils.sha256Hex(password);
      if (manager.login(username, hashPassword)) {
        Client client = manager.getClient(username);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", client);
        RequestDispatcher rd = request.getRequestDispatcher("Catalog");
        rd.forward(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        request.setAttribute("errorMessage", "I parametri della richiesta sono errati. Controlla i campi");
        request.setAttribute("redirect", "signin.jsp");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExceptionHandler");
        dispatcher.forward(request, response);
      }
    } catch (SQLException e) {
      LOGIN_CLIENT.log(Level.SEVERE, null, e);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "signin.jsp");
      this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
    }
  }
}
