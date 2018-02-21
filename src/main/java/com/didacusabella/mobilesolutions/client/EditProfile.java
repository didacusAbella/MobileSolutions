package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Client;
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
@WebServlet(name = "EditProfile", urlPatterns = {"/EditProfile"})
public class EditProfile extends HttpServlet {

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
      int id = ((Client)request.getSession(true).getAttribute("user")).getId();
      Client client = ClientManager.getInstance().getClient(id);
      request.setAttribute("client", client);
      this.getServletContext().getRequestDispatcher("/editProfile.jsp").forward(request, response);
    } catch (SQLException ex) {
      Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
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
      Client client = new Client();
      BeanUtils.populate(client, request.getParameterMap());
      if(BeanValidator.<Client>validateBean(client) && ClientManager.getInstance().updateClient(client)){
        doGet(request, response);
      }else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        doGet(request, response);
      }
    } catch (IllegalAccessException | InvocationTargetException | SQLException ex) {
      Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Edit Profile";
  }

}
