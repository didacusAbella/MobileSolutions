package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.entities.Smartphone;

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
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {
  
  private static final Logger SEARCH = Logger.getLogger(Search.class.getName());
  
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
      String brand = request.getParameter("brand");
      List<Smartphone> smartphones = SmartphoneManager.getInstance().search(brand);
      request.setAttribute("phones", smartphones);
      this.getServletContext().getRequestDispatcher("/searchResult.jsp").forward(request, response);
    } catch (SQLException ex) {
      SEARCH.log(Level.SEVERE, null, ex);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
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
    return "Simple search";
  }

}
