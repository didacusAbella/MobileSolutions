package com.didacusabella.mobilesolutions.sale;

import com.didacusabella.mobilesolutions.booking.BookingManager;
import com.didacusabella.mobilesolutions.entities.Booking;
import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "BuyCart", urlPatterns = {"/BuyCart"})
public class BuyCart extends HttpServlet {
  
  private static final Logger BUY_CART = Logger.getLogger(BuyCart.class.getName());
  
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SaleManager saleManager = SaleManager.getInstance();
            BookingManager bookingManager = BookingManager.getInstance();
            SmartphoneManager smartphoneManager = SmartphoneManager.getInstance();
            HttpSession session = request.getSession(true);
            Client client = (Client) session.getAttribute("user");
            if (client == null) {
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
            } else {
              List<Booking> listOfBooking = bookingManager.getBooking(client.getId());
                for (Booking book : listOfBooking) {
                    Sale sale = new Sale();
                    sale.injectBooking(book);
                    sale.setDate(new Timestamp(System.currentTimeMillis()));
                    sale.setShipmentType(Integer.parseInt(request.getParameter("shipmentType")));
                    sale.setPaymentType(Integer.parseInt(request.getParameter("paymentType")));
                    sale.setPrice(smartphoneManager.getSmartphoneByID(sale.getProduct()).getPrice());
                    saleManager.buyProduct(sale);
                    bookingManager.removeAllBookings(client.getId());
                }
            }
            this.getServletContext().getRequestDispatcher("/Catalog").forward(request, response);

        } catch (SQLException e) {
            BUY_CART.log(Level.SEVERE, null, e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.setAttribute("errorMessage", "C'è stato un errore. Riprova");
            request.setAttribute("redirect", "Catalog");
            this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
    }
}
