package com.didacusabella.mobilesolutions.client;

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

@WebServlet(name = "LoginClient", urlPatterns = {"/LoginClient"})
public class LoginClient extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ClientManager manager;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            manager = ClientManager.getInstance();
            String hashPassword = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
            if (manager.login(username, hashPassword)) {
                Client client = manager.getClient(username);
                HttpSession session = request.getSession(true);
                session.setAttribute("user", client);
                RequestDispatcher rd = request.getRequestDispatcher("Catalog");
                rd.forward(request,response);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/errore.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
