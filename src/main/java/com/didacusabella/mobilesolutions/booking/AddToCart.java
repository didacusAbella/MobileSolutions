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
import java.util.ArrayList;

@WebServlet(name = "AddToCart", urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getAttribute("user");
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
            newBooking.setProductID((Integer) request.getAttribute("idProduct"));
            newBooking.setUsername(client.getId());
            newBooking.setDate(new Timestamp(System.currentTimeMillis()));
            newBooking.setQuantity(1);
            bookingManager.addBooking(newBooking);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ok.jsp");
            dispatcher.forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
