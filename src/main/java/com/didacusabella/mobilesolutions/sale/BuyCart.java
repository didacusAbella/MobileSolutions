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

@WebServlet(name = "BuyCart", urlPatterns = {"/BuyCart"})
public class BuyCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SaleManager saleManager = SaleManager.getInstance();
            BookingManager bookingManager = BookingManager.getInstance();
            SmartphoneManager smartphoneManager = SmartphoneManager.getInstance();
            HttpSession session = request.getSession(true);
            Client client = (Client) session.getAttribute("user");
            List<Booking> listOfBooking = bookingManager.getBooking(client.getId());
            if (client == null) {
                //Errore
            } else {
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
            e.printStackTrace();
        }
    }
}
