package com.didacusabella.mobilesolutions.payment;

import com.didacusabella.mobilesolutions.shipment.ShipmentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Domenico Antonio Tropeano on 21/02/2018 at 11:18
 * @project MobileSolutions
 */
@WebServlet(name = "PaymentLoader", urlPatterns = "/PaymentLoader")
public class PaymentLoader extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PaymentManager paymentManager = PaymentManager.getInstance();
            ShipmentManager shipmentManager = ShipmentManager.getInstance();
            request.setAttribute("shipmentList", shipmentManager.getAllShipment());
            request.setAttribute("paymentList", paymentManager.getAllPayments());
            this.getServletContext().getRequestDispatcher("/payment.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
