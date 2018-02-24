package com.didacusabella.mobilesolutions.smartphone;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ImportXML", urlPatterns = {"/ImportXML"})

public class ImportXML extends HttpServlet {
  
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
        SmartphoneManager smartphoneManager = null;
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                smartphoneManager = SmartphoneManager.getInstance();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            File prodotti = null;
            String fs = "/"; // sysprops.getProperty("file.separator");
            String UPLOAD_DIRECTORY = getServletContext().getRealPath("/") + "xml" + fs;
            System.out.println("real path " + UPLOAD_DIRECTORY);
            File uploadDirectory = new File(UPLOAD_DIRECTORY);
            uploadDirectory.mkdir();

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is
            // used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Parse the request
            List<FileItem> multiparts = null;
            try {
                multiparts = upload.parseRequest(request);
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            Iterator<FileItem> parameters = multiparts.iterator();
            while (parameters.hasNext()) {
                FileItem nextElement = parameters.next();
                if (!nextElement.isFormField()) {

                    for (FileItem item : multiparts) {
                        System.out.println("Sono nel for");
                        if (!item.isFormField()) {
                            System.out.println("è form-field");
                            System.out.println(item.getName());
                            System.out.println(item.getSize());
                            try {
                                prodotti = new File(uploadDirectory, "prodotti.xml");

                                item.write(prodotti);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }

                        }
                        System.out.println("Tutto ok , ora ecco prodotti " + prodotti);
                        smartphoneManager.importXML(prodotti.getPath());
                    }
                }
            }

        }

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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doGet(request, response);
    }
}
