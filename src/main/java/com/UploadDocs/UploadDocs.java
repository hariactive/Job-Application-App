package com.UploadDocs;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.connection.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

//@WebServlet("/upload")
@MultipartConfig
public class UploadDocs extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Part p = req.getPart("files");
		String fileName = p.getSubmittedFileName();

		String remark = req.getParameter("remark");

		HttpSession session = req.getSession();

		try {

			Connection conn = DBConnect.getConn();

			PreparedStatement ps = conn.prepareStatement("insert into img_details(img_name,remark) values(?,?)");
			ps.setString(1, fileName);
			ps.setString(2, remark);

			int i = ps.executeUpdate();

			if (i == 1) {

				String path = getServletContext().getRealPath("") + "imgs";

				File file = new File(path);

				p.write(path + File.separator + fileName);

				session.setAttribute("msg", "Upload Sucess");

				resp.sendRedirect("UploadDocs.jsp");

			} else {
				System.out.println("Error in server");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}