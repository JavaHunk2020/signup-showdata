package com.p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usignup")
public class UpdateSignupServlet extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sidstr=req.getParameter("sid");
		 int sid=Integer.parseInt(sidstr);
		 String username=req.getParameter("username");
		 String email=req.getParameter("email");
		 String gender=req.getParameter("gender");
		 
		 //JDBC PROGRAMMING
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
				String sql="update asignup_tbl set name=?,email=?,gender=? where sid=?";
				
				//Creating prepared statement with query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				//Now Setting value inside place holders
				pstmt.setString(1,username);
				pstmt.setString(2,email);
				pstmt.setString(3,gender);
				pstmt.setInt(4,sid);
				//fire the query
				pstmt.executeUpdate();
			 
		 }catch (Exception e) {
			 //It will print the problem in details
			 e.printStackTrace();
		}
		 
		 //Sending message from servlet to JSP
		 //message=""Data is saved into database..."
		 req.setAttribute("message", "Data is update into database...");
		 
		 //${message}
		 //I have to go to signup.jsp file
		 //below line is opening signup.jsp ->>
//		 /signup.jsp - will generate the html contents
		 req.getRequestDispatcher("searchSignup.jsp").forward(req, resp);
		 
	}
}
