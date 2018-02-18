package com.didacusabella.mobilesolutions.servlet;

import com.didacusabella.mobilesolutions.UsernameAlreadyExistException;
import com.didacusabella.mobilesolutions.client.ClientManager;
import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Client;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet("/signupClient")
public class Registrazione extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ClientManager clientManager = ClientManager.getInstance();
            Client newClient = new Client();
            BeanUtils.populate(newClient, request.getParameterMap());
            System.out.println(newClient.toString());
            if (BeanValidator.<Client>validateBean(newClient)) {
                if (clientManager.insertClient(newClient)) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
                } else {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/error.jsp");
                }
            } else {
                System.out.println("Client non ben formato");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UsernameAlreadyExistException e) {
            e.printStackTrace();
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
