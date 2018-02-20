package com.didacusabella.mobilesolutions.smartphone;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "RemoveSmartphone", urlPatterns = {"/RemoveSmartphone"})
public class RemoveSmartphone extends HttpServlet {

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
      int id = Integer.parseInt(request.getParameter("id"));
      if(SmartphoneManager.getInstance().deleteSmartphone(id)){
        this.getServletContext().getRequestDispatcher("/AllPhones").forward(request, response);
      }else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        this.getServletContext().getRequestDispatcher("/AllPhones").forward(request, response);
      }
    } catch (SQLException ex) {
      Logger.getLogger(RemoveSmartphone.class.getName()).log(Level.SEVERE, null, ex);
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
