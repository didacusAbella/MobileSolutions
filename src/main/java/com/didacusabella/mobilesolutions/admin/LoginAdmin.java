package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.entities.Admin;

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

@WebServlet(name = "LoginAdmin", urlPatterns = {"/LoginAdmin"})
public class LoginAdmin extends HttpServlet {
  
  private static final Logger LOGIN_ADMIN = Logger.getLogger(LoginAdmin.class.getName());
  
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
        AdminManager manager;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            manager = AdminManager.getInstance();
            String hashPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
            if (manager.login(username, hashPassword)) {
                Admin admin = manager.getAdminByUsername(username);
                HttpSession session = request.getSession(true);
                session.setAttribute("admin", admin);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminDashboard");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExceptionHandler");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            LOGIN_ADMIN.log(Level.SEVERE, null, e);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExceptionHandler");
            request.setAttribute("errorMessage", "Parametri della richiesta non validi");
            request.setAttribute("redirect", "administration.jsp");
            dispatcher.forward(request, response);
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
