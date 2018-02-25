package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
@WebServlet(name = "EditPhone", urlPatterns = {"/EditPhone"})
public class EditPhone extends HttpServlet {

  private static final Logger EDIT_PHONE = Logger.getLogger(Catalog.class.getName());

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
      if (admin != null) {
        int id = Integer.parseInt(request.getParameter("id"));
        Smartphone smartphone = SmartphoneManager.getInstance().getSmartphoneByID(id);
        request.setAttribute("phone", smartphone);
        this.getServletContext().getRequestDispatcher("/AdminDashboard?page=editPhone.jsp").forward(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException ex) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "AdminDashboard");
      EDIT_PHONE.log(Level.SEVERE, null, ex);
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
      HttpSession session = request.getSession(true);
      Admin admin = (Admin) session.getAttribute("admin");
      if (admin != null) {
        Smartphone phone = new Smartphone();
        BeanUtils.populate(phone, request.getParameterMap());
        if (BeanValidator.<Smartphone>validateBean(phone)) {
          if (SmartphoneManager.getInstance().editSmartphone(phone)) {
            this.getServletContext().getRequestDispatcher("/AllPhones").forward(request, response);
          } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
            request.setAttribute("redirect", "AdminDashboard");
            this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
          }
        } else {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          request.setAttribute("errorMessage", "Parametri non validi. Controlla i campi della form.");
          request.setAttribute("redirect", "AdminDashboard?page=editPhone.jsp");
          this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException | IllegalAccessException | InvocationTargetException ex) {
      EDIT_PHONE.log(Level.SEVERE, null, ex);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "AdminDashboard");
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
    return "Edit a smartphone";
  }

}
