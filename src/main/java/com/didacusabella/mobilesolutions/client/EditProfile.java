package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Client;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author diego
 */
@WebServlet(name = "EditProfile", urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

  private static final Logger EDIT_PROFILE = Logger.getLogger(EditProfile.class.getName());

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
      Client client = (Client) request.getSession(true).getAttribute("user");
      if (client == null) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      } else {
        int id = client.getId();
        client = ClientManager.getInstance().getClient(id);
        request.setAttribute("client", client);
        this.getServletContext().getRequestDispatcher("/editProfile.jsp").forward(request, response);
      }
    } catch (SQLException ex) {
      EDIT_PROFILE.log(Level.SEVERE, null, ex);
      request.setAttribute("errorMessage", "C'è un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "Catalog");
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      Client logged = (Client) request.getSession().getAttribute("user");
      if (logged == null) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      } else {
        Client client = new Client();
        BeanUtils.populate(client, request.getParameterMap());
        if (BeanValidator.<Client>validateBean(client) && ClientManager.getInstance().updateClient(client)) {
          doGet(request, response);
        } else {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          request.setAttribute("errorMessage", "Parametri della richiesta non corretti.");
          request.setAttribute("redirect", "EditProfile");
          this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
      }
    } catch (IllegalAccessException | InvocationTargetException | SQLException ex) {
      EDIT_PROFILE.log(Level.SEVERE, null, ex);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "Errore interno durante la modifica del profilo. Riprova più tardi");
      request.setAttribute("redirect", "EditProfile");
      this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Edit Profile";
  }

}
