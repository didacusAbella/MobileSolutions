package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.entities.Admin;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diego
 */
@WebServlet(name = "RemoveSmartphone", urlPatterns = {"/RemoveSmartphone"})
public class RemoveSmartphone extends HttpServlet {
  
  private static final Logger REMOVE_PHONE = Logger.getLogger(RemoveSmartphone.class.getName());

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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    try {
      HttpSession session = request.getSession(true);
      Admin admin = (Admin) session.getAttribute("admin");
      if (admin != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        if (SmartphoneManager.getInstance().deleteSmartphone(id)) {
          this.getServletContext().getRequestDispatcher("/AllPhones").forward(request, response);
        } else {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          request.setAttribute("errorMessage", "Telefono non presente");
          request.setAttribute("redirect", "AllPhones");
          this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException ex) {
      REMOVE_PHONE.log(Level.SEVERE, null, ex);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "C'è un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "AllPhones");
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
    return "Remove a phone";
  }
  
}
