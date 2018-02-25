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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Domenico Antonio Tropeano on 21/02/2018 at 12:19
 * @project MobileSolutions
 */
@WebServlet(name = "ShowSales", urlPatterns = "/ShowSales")
public class ShowSales extends HttpServlet {
  
  private static final Logger SHOW_SALES = Logger.getLogger(ShowSales.class.getName());
  
   /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

   /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
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
            SHOW_SALES.log(Level.SEVERE, null, e);
            request.setAttribute("errorMessage", "C'è stato un errore interno. Riprova");
            request.setAttribute("redirect", "Catalog");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            this.getServletContext().getRequestDispatcher("/ExceptionHandler").forward(request, response);
        }
    }
}
