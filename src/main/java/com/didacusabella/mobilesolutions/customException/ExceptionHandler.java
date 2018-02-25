package com.didacusabella.mobilesolutions.customException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diego
 */
@WebServlet(name = "ExceptionHandler", urlPatterns = {"/ExceptionHandler"})
public class ExceptionHandler extends HttpServlet {

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
   switch(response.getStatus()){
     case HttpServletResponse.SC_NOT_FOUND:
       this.getServletContext().getRequestDispatcher("/not_found.jsp").forward(request, response);
       break;
     case HttpServletResponse.SC_UNAUTHORIZED:
       this.getServletContext().getRequestDispatcher("/unauthorized.jsp").forward(request, response);
       break;
     default:
       this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
       break;
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
    return "Exception handling request";
  }

}
