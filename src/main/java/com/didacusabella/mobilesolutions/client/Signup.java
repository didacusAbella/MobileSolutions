package com.didacusabella.mobilesolutions.client;

import com.didacusabella.mobilesolutions.customException.UsernameAlreadyExistException;
import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Client;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author diego
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {
  
  private static final Logger SIGNUP_LOG = Logger.getLogger(Signup.class.getName());

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
    doPost(request, response);
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
      ClientManager clientManager = ClientManager.getInstance();
      Client newClient = new Client();
      BeanUtils.populate(newClient, request.getParameterMap());
      newClient.setPassword(DigestUtils.sha256Hex(newClient.getPassword()));
      if (BeanValidator.<Client>validateBean(newClient)) {
        if (clientManager.insertClient(newClient)) {
          this.getServletContext().getRequestDispatcher("/Catalog").forward(request, response);
        } else {
          response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
          request.setAttribute("errorMessage", "C'è stato un errore durante la registrazione.");
          request.setAttribute("redirect", "signup.jsp");
          this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
      } else {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        request.setAttribute("redirect", "signup.jsp");
        request.setAttribute("errorMessage", "Campi non validi");
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException | IllegalAccessException | InvocationTargetException ex) {
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      SIGNUP_LOG.log(Level.SEVERE, null, ex);
      request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova più tardi");
      request.setAttribute("redirect", "signup.jsp");
      this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
    } catch (UsernameAlreadyExistException ex) {
      response.setStatus(HttpServletResponse.SC_CONFLICT);
      SIGNUP_LOG.log(Level.SEVERE, null, ex);
      request.setAttribute("errorMessage", "Username già presente");
      request.setAttribute("redirect", "signup.jsp");
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
    return "Signup Client";
  }

}
