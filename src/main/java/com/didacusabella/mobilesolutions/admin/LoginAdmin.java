package com.didacusabella.mobilesolutions.admin;

import com.didacusabella.mobilesolutions.entities.Admin;
import com.didacusabella.mobilesolutions.entities.Booking;

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

@WebServlet(name = "LoginAdmin", urlPatterns = {"/LoginAdmin"})
public class LoginAdmin extends HttpServlet {
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
