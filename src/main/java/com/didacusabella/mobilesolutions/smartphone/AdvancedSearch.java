package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.entities.Smartphone;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@WebServlet(name = "AdvancedSearch", urlPatterns = {"/AdvancedSearch"})
public class AdvancedSearch extends HttpServlet {

  private static Logger advacedSearchLogger = Logger.getLogger(AdvancedSearch.class.getName());
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
      Map<String, String[]> filteredParameters = new HashMap<>();
      request.getParameterMap().forEach((name, value) -> {
        if(!value[0].isEmpty())
          filteredParameters.put(name, value);
      });
      List<Smartphone> smartphones = SmartphoneManager.getInstance().advancedSearch(filteredParameters);
      request.setAttribute("phones", smartphones);
      this.getServletContext().getRequestDispatcher("/searchResult.jsp").forward(request, response);
    } catch (SQLException ex) {
      advacedSearchLogger.log(Level.SEVERE, null, ex);
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
    return "Advanced search";
  }

}
