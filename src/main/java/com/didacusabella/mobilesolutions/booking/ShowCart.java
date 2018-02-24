package com.didacusabella.mobilesolutions.booking;

import com.didacusabella.mobilesolutions.entities.Booking;
import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 19/02/2018 at 14:54
 * @project MobileSolutions
 */
@WebServlet(name = "ShowCart", urlPatterns = {"/ShowCart"})
public class ShowCart extends HttpServlet {
  
  private static Logger showCartLogger = Logger.getLogger(ShowCart.class.getName());
  
   /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookingManager bookingManager = BookingManager.getInstance();
            SmartphoneManager smartphoneManager = SmartphoneManager.getInstance();
            List<Booking> bookingList;
            HttpSession session = request.getSession(true);
            Client user = (Client) session.getAttribute("user");
            bookingList = bookingManager.getBooking(user.getId());
            for (Booking booking : bookingList) {
                Smartphone tempSmartphone = smartphoneManager.getSmartphoneByID(booking.getProductID());
                booking.setProductName(tempSmartphone.getBrand() + " " + tempSmartphone.getModel());
                booking.setPrice(tempSmartphone.getPrice());
            }
            request.setAttribute("cart", bookingList);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            showCartLogger.log(Level.SEVERE, null, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMessage", "C'è stato un errore interno. Riprovare più tardi");
            this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
    }
}
