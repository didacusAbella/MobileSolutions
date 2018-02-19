package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author diego
 */
@WebServlet(name = "EditPhone", urlPatterns = {"/EditPhone"})
public class EditPhone extends HttpServlet {
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
      int id = Integer.parseInt(request.getParameter("id"));
      Smartphone smartphone = SmartphoneManager.getInstance().getSmartphoneByID(id);
      request.setAttribute("phone", smartphone);
      this.getServletContext().getRequestDispatcher("/AdminDashboard?page=editPhone.jsp").forward(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(EditPhone.class.getName()).log(Level.SEVERE, null, ex);
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
      Smartphone phone = new Smartphone();
      BeanUtils.populate(phone, request.getParameterMap());
      if(BeanValidator.<Smartphone>validateBean(phone) && SmartphoneManager.getInstance().editSmartphone(phone)){
        this.getServletContext().getRequestDispatcher("/admin_resources/managePhones.jsp").forward(request, response);
      }else{
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        this.getServletContext().getRequestDispatcher("/admin_resources/managePhones.jsp").forward(request, response);
      }
    } catch (SQLException ex) {
      Logger.getLogger(EditPhone.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(EditPhone.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvocationTargetException ex) {
      Logger.getLogger(EditPhone.class.getName()).log(Level.SEVERE, null, ex);
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
