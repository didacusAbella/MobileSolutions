package com.didacusabella.mobilesolutions.smartphone;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/addSmartphone")
public class AddSmartphone extends HttpServlet {

  private static final Logger ADD_SMARTPHONE = Logger.getLogger(AddSmartphone.class.getName());

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
    this.getServletContext().getRequestDispatcher("/AdminDashboard?page=addPhone.jsp").forward(request, response);
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
    SmartphoneManager smartphoneManager;
    try {
      smartphoneManager = SmartphoneManager.getInstance();
      HttpSession session = request.getSession(true);
      Admin admin = (Admin) session.getAttribute("admin");
      if (admin != null) {
        Smartphone smartphone = new Smartphone();
        BeanUtils.populate(smartphone, request.getParameterMap());
        if (BeanValidator.<Smartphone>validateBean(smartphone)) {
          smartphoneManager.addSmartphone(smartphone);
          RequestDispatcher disp = getServletContext().getRequestDispatcher("/AllPhones");
          disp.forward(request, response);
        } else {
          response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
          request.setAttribute("errorMessage", "Ci sono errori nei campi. Ricontrolla la form");
          request.setAttribute("redirect", "AdminDashboard?page=addPhone.jsp");
          this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/ExceptionHandler");
        disp.forward(request, response);
      }
    } catch (SQLException | IllegalAccessException | InvocationTargetException e) {
      ADD_SMARTPHONE.log(Level.SEVERE, null, e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "Ci sono degli errori interni. Riprova più tardi");
      request.setAttribute("redirect", "AdminDashboard");
      this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
    }

  }
}
