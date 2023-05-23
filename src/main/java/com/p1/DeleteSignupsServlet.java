package com.p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteData")
public class DeleteSignupsServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 String sidStr=req.getParameter("sid");
		 //converting String into int value
		 int sid = Integer.parseInt(sidStr);
		 try {
			   //Loading the DRIVER
			    //Class is class
				Class.forName("com.mysql.jdbc.Driver");
				//Making connect to the database
				Connection conn=DriverManager.
						getConnection("jdbc:mysql://localhost:3306/batch100_db",
								"root","mysql@1234");
				if(conn!=null) {
					System.out.println("I am connected with database");
				}
				//Creating the query
				String sql="delete  from  asignup_tbl where sid = ?";
				//Creating prepared statement with query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sid);
				pstmt.executeUpdate();
				
		 }catch (Exception e) {
			 //It will print the problem in details
			 e.printStackTrace();
		}
		 
		 //-> /showData -> this the url-pattern for the servlet
		 req.getRequestDispatcher("showData").forward(req, resp);
	}
}
