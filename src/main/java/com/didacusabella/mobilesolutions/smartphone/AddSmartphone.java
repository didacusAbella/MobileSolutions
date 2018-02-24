package com.didacusabella.mobilesolutions.smartphone;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.didacusabella.mobilesolutions.admin.AdminManager;
import com.didacusabella.mobilesolutions.database.BeanValidator;
import com.didacusabella.mobilesolutions.entities.Smartphone;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/addSmartphone")
public class AddSmartphone extends HttpServlet {
  
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.getServletContext().getRequestDispatcher("/AdminDashboard?page=addPhone.jsp").forward(request, response);
    }

   /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         SmartphoneManager smartphoneManager = null;
        AdminManager adminManager = null;
        try {
            smartphoneManager = SmartphoneManager.getInstance();
            adminManager = AdminManager.getInstance();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        if (true || adminManager.getAdminByUsername(username) != null) {
            Smartphone smartphone = new Smartphone();
            try {
                BeanUtils.populate(smartphone, request.getParameterMap());
                if (BeanValidator.<Smartphone>validateBean(smartphone)) {
                    smartphoneManager.addSmartphone(smartphone);
                } else {
                    System.out.println("Smartphon not well formed");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            //non sei amministratore
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/error.jsp");
        }


        RequestDispatcher disp = getServletContext().getRequestDispatcher("/AllPhones");
        disp.include(request, response);
    }

}
