package com.didacusabella.mobilesolutions.booking;

import com.didacusabella.mobilesolutions.entities.Booking;
import com.didacusabella.mobilesolutions.entities.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "DeleteCart", urlPatterns = {"/DeleteCart"})
public class DeleteCart extends HttpServlet {
  
  private static Logger deleteCartLogger = Logger.getLogger(DeleteCart.class.getName());

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
    BookingManager bookingManager = null;
    try {
      bookingManager = BookingManager.getInstance();
      HttpSession session = request.getSession(true);
      List<Booking> cart = new ArrayList<>();
      Client user = (Client) session.getAttribute("user");
      if (bookingManager.removeAllBookings(user.getId())) {
        session.setAttribute("cart", cart);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowCart");
        dispatcher.forward(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        request.setAttribute("errorMessage", "Si è verificato un errore durante la rimozione del carrello");
        this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
      }
    } catch (SQLException e) {
      deleteCartLogger.log(Level.SEVERE, null, e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "Si è verificato un errore interno");
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
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
