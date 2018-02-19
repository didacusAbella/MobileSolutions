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
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getAttribute("username");
        if (client == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/errore.jsp");
            dispatcher.forward(request, response);
        } else {
            ArrayList<Booking> cart = new ArrayList<>();
            HttpSession session = request.getSession(true);
            cart = (ArrayList<Booking>) session.getAttribute("Cart");
            Booking newBooking = new Booking();
            newBooking.setProduct((Integer) request.getAttribute("idProduct"));
            newBooking.setUsername((Integer) request.getAttribute("idUser"));
            newBooking.setDate(new Timestamp(System.currentTimeMillis()));
            newBooking.setQuantity((Integer) request.getAttribute("quantity"));
            cart.add(newBooking);
            session.setAttribute("Cart", cart);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ok.jsp");
            dispatcher.forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
