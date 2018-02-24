package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.entities.Admin;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "AdminDashboard", urlPatterns = {"/AdminDashboard"})
public class AdminDashboard extends HttpServlet {

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
    HttpSession session = request.getSession(true);
    Admin admin = (Admin) session.getAttribute("admin");
    if (admin == null) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExceptionHandler");
      dispatcher.forward(request, response);
    } else {
      String page = (request.getParameter("page") != null) ? request.getParameter("page") : "remainingPhones.jsp";
      request.setAttribute("partial", page);
      this.getServletContext().getRequestDispatcher("/admin_resources/adminDashboard.jsp").forward(request, response);
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
    return "AdminDashboard dashboard";
  }

}
