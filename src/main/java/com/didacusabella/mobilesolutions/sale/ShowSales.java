package com.didacusabella.mobilesolutions.sale;

import com.didacusabella.mobilesolutions.entities.Client;
import com.didacusabella.mobilesolutions.entities.Sale;
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Domenico Antonio Tropeano on 21/02/2018 at 12:19
 * @project MobileSolutions
 */
@WebServlet(name = "ShowSales", urlPatterns = "/ShowSales")
public class ShowSales extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SaleManager saleManager = SaleManager.getInstance();
            SmartphoneManager smartphoneManager = SmartphoneManager.getInstance();
            HttpSession session = request.getSession(true);
            Client client = (Client) session.getAttribute("user");
            List<Sale> listSales = saleManager.getAllSaleForClient(client.getId());
            listSales.forEach(s -> s.setProductName(smartphoneManager.getSmartphoneByID(s.getProduct()).getBrand() + "  " + smartphoneManager.getSmartphoneByID(s.getProduct()).getModel()));
            request.setAttribute("listOfSales", listSales);
            this.getServletContext().getRequestDispatcher("/listOfSales.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
