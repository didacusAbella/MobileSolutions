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
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {

  private static final Logger ADD_TO_CART = Logger.getLogger(AddToCart.class.getName());

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
    HttpSession session = request.getSession(true);
    Client client = (Client) session.getAttribute("user");
    BookingManager bookingManager;
    try {
      bookingManager = BookingManager.getInstance();
      if (client == null) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExceptionHandler");
        dispatcher.forward(request, response);
      } else {
        Booking newBooking = new Booking();
        newBooking.setProductID(Integer.parseInt(request.getParameter("idProduct")));
        newBooking.setUsername(client.getId());
        newBooking.setDate(new Timestamp(System.currentTimeMillis()));
        newBooking.setQuantity(1);
        bookingManager.addBooking(newBooking);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Catalog");
        dispatcher.forward(request, response);
      }
    } catch (SQLException e) {
      ADD_TO_CART.log(Level.SEVERE, null, e);
      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      request.setAttribute("errorMessage", "Si è verificato un errore Interno");
      request.setAttribute("redirect", "Catalog");
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
