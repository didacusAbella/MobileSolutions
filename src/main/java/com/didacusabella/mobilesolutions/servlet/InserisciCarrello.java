package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.beans.*;
import com.didacusabella.mobilesolutions.entities.Booking;
import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import com.didacusabella.mobilesolutions.gestioneDB.*;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;

public class InserisciCarrello extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        if (user == null) {
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/errore.jsp");
            disp.forward(request, response);
        } else {
            ArrayList<Booking> cart = new ArrayList<>();
            HttpSession session = request.getSession(true);
            cart = (ArrayList<Booking>) session.getAttribute("Carr");
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
