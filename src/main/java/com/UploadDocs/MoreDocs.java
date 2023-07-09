package com.UploadDocs;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(maxFileSize=169999999)
public class MoreDocs extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part ten = request.getPart("ten");
            Part twelve = request.getPart("twelve");
            Part graduation = request.getPart("graduation");
            Part caste = request.getPart("caste");

            InputStream inputStream1 = null;
            InputStream inputStream2 = null;
            InputStream inputStream3 = null;
            InputStream inputStream4 = null;

            // Update the if conditions and assignment statements for each Part object

            if (ten != null) {
                long fileSize1 = ten.getSize();
                String fileContent1 = ten.getContentType();
                inputStream1 = ten.getInputStream();
            }
            if (twelve != null) {
                long fileSize = twelve.getSize();
                String fileContent = twelve.getContentType();
                inputStream2 = twelve.getInputStream();
            }
            if (caste != null) {
                long fileSize = caste.getSize();
                String fileContent = caste.getContentType();
                inputStream3 = caste.getInputStream();
            }
            if (graduation != null) {
                long fileSize = graduation.getSize();
                String fileContent = graduation.getContentType();
                inputStream4 = graduation.getInputStream();
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "aa11BB22@@");

            PreparedStatement preparedstatement = con.prepareStatement("INSERT INTO marksheets (ten, twelve, graduation, caste) VALUES (?, ?, ?, ?)");

            preparedstatement.setBlob(1, inputStream1);
            preparedstatement.setBlob(2, inputStream2);
            preparedstatement.setBlob(3, inputStream3);
            preparedstatement.setBlob(4, inputStream4);

            int returncode = preparedstatement.executeUpdate();

            if (returncode == 0) {
                request.setAttribute("Message", "Error inserting file");
                getServletContext().getRequestDispatcher("/failure.jsp").forward(request, response);
            } else {
                response.setContentType("text/html");

                String successMessage = "Your application has been successfully submitted.";
                request.setAttribute("Message", successMessage);

                // Set the refresh header to redirect to the homepage after a delay
                response.setHeader("Refresh", "3;URL=printform.jsp");

                // Display the success message
                request.getRequestDispatcher("/SuccessPopUp.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
}
