package com.didacusabella.mobilesolutions.smartphone;

import com.didacusabella.mobilesolutions.entities.Smartphone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 20/02/2018 at 10:09
 * @project MobileSolutions
 */
@WebServlet(name = "Catalog", urlPatterns = {"/Catalog"})
public class Catalog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("Dentro");
            List<Smartphone> phones = SmartphoneManager.getInstance().getAllSmartphone();
            request.setAttribute("phones", phones);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AllPhones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
