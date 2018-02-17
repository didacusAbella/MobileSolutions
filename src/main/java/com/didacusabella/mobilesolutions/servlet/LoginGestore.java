package com.didacusabella.mobilesolutions.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.admin.AdminManager;
import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Booking;

public class LoginGestore extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminManager manager;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            manager = AdminManager.getInstance();
            String hashPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
            if (manager.login(username, hashPassword)) {
                Admin admin = manager.getAdminByUsername(username);
                HttpSession session = request.getSession(true);
                session.setAttribute("admin", admin);
                ArrayList<Booking> cart = new ArrayList();
                session.setAttribute("cart", cart);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/errore.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
