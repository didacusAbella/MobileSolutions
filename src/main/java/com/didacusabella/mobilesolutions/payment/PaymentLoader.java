package com.didacusabella.mobilesolutions.payment;

import com.didacusabella.mobilesolutions.shipment.ShipmentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import org.jboss.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 21/02/2018 at 11:18
 * @project MobileSolutions
 */
@WebServlet(name = "PaymentLoader", urlPatterns = "/PaymentLoader")
public class PaymentLoader extends HttpServlet {
  
  private static final Logger PAYMENT_LOG = Logger.getLogger(PaymentLoader.class.getName());
  
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
            PaymentManager paymentManager = PaymentManager.getInstance();
            ShipmentManager shipmentManager = ShipmentManager.getInstance();
            request.setAttribute("shipmentList", shipmentManager.getAllShipment());
            request.setAttribute("paymentList", paymentManager.getAllPayments());
            this.getServletContext().getRequestDispatcher("/payment.jsp").forward(request, response);
        } catch (SQLException e) {
            PAYMENT_LOG.log(Logger.Level.FATAL, null, e);
            request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova pi tardi");
            request.setAttribute("redirect", "Catalog");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
    }
}
