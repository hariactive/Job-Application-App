package com.jobapply;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(maxFileSize=169999999)
public class JobApplication1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String email = request.getParameter("email");
			String jobRole = request.getParameter("job_role");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			int pincode = Integer.parseInt(request.getParameter("pincode"));
			String dob = request.getParameter("date");
			Part filepart = request.getPart("upload");
			
			InputStream inputstream = null;
			if(filepart !=null) {
				long fileSize =filepart.getSize();
				String fileContent = filepart.getContentType();
				inputstream = filepart.getInputStream();
			}
			Class.forName("com.mysql.cj.jdbc.Driver");  
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","aa11BB22@@");
		    
		    PreparedStatement preparedstatement =con.prepareStatement("INSERT INTO users (first_name,last_name,email,job_role,address,city,pincode,dob,uploadcv) VALUES (?,?,?,?,?,?,?,?,?)");
		    preparedstatement.setString(1, firstName);
		    preparedstatement.setString(2, lastName);
		    preparedstatement.setString(3, email);
		    preparedstatement.setString(4,jobRole);
		    preparedstatement.setString(5, address);
		    preparedstatement.setString(6, city);
		    preparedstatement.setInt(7, pincode);
		    preparedstatement.setString(8, dob);
		    preparedstatement.setBlob(9, inputstream);
		    
		    int returncode = preparedstatement.executeUpdate();
		    
		    if(returncode ==0) {
		    	request.setAttribute("Message","Error inserting file");
		    	getServletContext().getRequestDispatcher("/failure.jsp").forward(request, response);
		    }else {
		    	request.setAttribute("Message", "Your record inserted");
		    	getServletContext().getRequestDispatcher("/UploadDocs.jsp").forward(request, response);
		    }
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
