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

@WebServlet("/showData")
public class ShowSignupsServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<SignupDTO> signupDTOs=new ArrayList<SignupDTO>();  		 
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
				String sql="select sid,name,email,gender from  asignup_tbl";
				//Creating prepared statement with query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				
				//fire the query
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					int sid=rs.getInt("sid");
					String name=rs.getString("name");
					String email=rs.getString("email");
					String gender=rs.getString("gender");
					//1 row data goes inside one signup dto
					SignupDTO signupDTO=new SignupDTO(sid, name, email, gender);
					signupDTOs.add(signupDTO);
				}
			 
		 }catch (Exception e) {
			 //It will print the problem in details
			 e.printStackTrace();
		}
		 
		 //Sending message from servlet to JSP
		 //message=""Data is saved into database..."
		 req.setAttribute("message", "Data is saved into database...");
		 
		 //${message}
		 //I have to go to signup.jsp file
		 //below line is opening signup.jsp ->>
//		 /signup.jsp - will generate the html contents
		 
		 req.setAttribute("bananas", signupDTOs);
		 
		 req.getRequestDispatcher("signup.jsp").forward(req, resp);
		 
	}
}
