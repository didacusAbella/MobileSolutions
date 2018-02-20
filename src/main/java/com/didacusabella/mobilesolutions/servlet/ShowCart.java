package com.didacusabella.mobilesolutions.servlet;

import com.didacusabella.mobilesolutions.booking.BookingManager;
import com.didacusabella.mobilesolutions.entities.Booking;
import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.sale.SaleManager;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 19/02/2018 at 14:54
 * @project MobileSolutions
 */
@WebServlet(name = "ShowCart", urlPatterns = {"/ShowCart"})
public class ShowCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BookingManager bookingManager = BookingManager.getInstance();
            SmartphoneManager smartphoneManager = SmartphoneManager.getInstance();
            List<Booking> bookingList;
            HttpSession session = request.getSession(true);

            Client user = (Client) session.getAttribute("user");
            bookingList = bookingManager.getBooking(user.getId());
            for (Booking booking : bookingList) {
                Smartphone tempSmartphone = smartphoneManager.getSmartphoneByID(booking.getProductID());
                booking.setProductName(tempSmartphone.getModel() + " " + tempSmartphone.getModel());
                booking.setPrice(tempSmartphone.getPrice());
            }
            request.setAttribute("cart", bookingList);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cart.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
