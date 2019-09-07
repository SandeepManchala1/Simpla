package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("UserID");
		String pw=request.getParameter("password");
		
		// Connect to mysql and verify username password
		
		try {
			Class. forName ( "COM.ibm.db2os390.sqlj.jdbc.DB2SQLJDriver"  );
		 // loads driver
		Connection c = DriverManager.getConnection("jdbc:db2://172.16.12.92:50000/MITS","db2admin","mits123$");
 
		PreparedStatement ps = c.prepareStatement("select userid,password from MITSUSERS");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("Home.jsp");
			return;
		}
		response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
