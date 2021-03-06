package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Smartphone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
@WebServlet(name = "RemainingPhones", urlPatterns = {"/RemainingPhones"})
public class RemainingPhones extends HttpServlet {
  
  private static final Logger REMAINING_PHONES = Logger.getLogger(RemainingPhones.class.getName());

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
      HttpSession session = request.getSession(true);
      Admin admin = (Admin) session.getAttribute("admin");
      if(admin != null){
      int quantity = Integer.parseInt(request.getParameter("quantity"));
      List<Smartphone> smartphones = SmartphoneManager.getInstance().getSmartphoneOUT(quantity);
      request.setAttribute("phones", smartphones);
      this.getServletContext().getRequestDispatcher("/searchResult.jsp").forward(request, response);
      }else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException ex) {
      REMAINING_PHONES.log(Level.SEVERE, null, ex);
      request.setAttribute("errorMessage", "C'è un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "AdminDashboard");
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
    return "List all remmaining phones based on a precise quantity";
  }

}
