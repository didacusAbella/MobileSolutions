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
import com.didacusabella.mobilesolutions.smartphone.SmartphoneManager;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/addSmartphone")
public class AddSmartphone extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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


        RequestDispatcher disp = getServletContext().getRequestDispatcher("/ok.jsp");
        disp.include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
