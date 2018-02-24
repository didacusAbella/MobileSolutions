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

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {
  
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
        BookingManager bookingManager = null;
        try {
            bookingManager = BookingManager.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (client == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/errore.jsp");
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
