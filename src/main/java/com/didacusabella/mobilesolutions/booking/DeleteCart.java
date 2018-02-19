package com.didacusabella.mobilesolutions.booking;

import com.didacusabella.mobilesolutions.booking.BookingManager;
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

@WebServlet(name = "DeleteCart", urlPatterns = {"/DeleteCart"})
public class DeleteCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingManager bookingManager = null;
        try {
            bookingManager = BookingManager.getInstance();
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
        HttpSession session = request.getSession(true);
        List<Booking> cart = new ArrayList<>();
        Client user = (Client) session.getAttribute("user");
        if (bookingManager.removeAllBookings(user.getId())) {
            session.setAttribute("cart", cart);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ok.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
