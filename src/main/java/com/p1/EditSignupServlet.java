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

@WebServlet("/editData")
public class EditSignupServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<SignupDTO> signupDTOs=new ArrayList<SignupDTO>();
		 
		 
		 String sidstr=req.getParameter("sid");
		 int sid=Integer.parseInt(sidstr);
		 
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
				String sql="select sid,name,email,gender from  asignup_tbl where sid=?";
				//Creating prepared statement with query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, sid);
				//fire the query
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					String name=rs.getString("name");
					String email=rs.getString("email");
					String gender=rs.getString("gender");
					SignupDTO signupDTO=new SignupDTO(sid, name, email, gender);
					//adding data to be edited inside request scope
					req.setAttribute("signupDTO", signupDTO);
				}
			 
		 }catch (Exception e) {
			 //It will print the problem in details
			 e.printStackTrace();
		}
		 req.getRequestDispatcher("esignup.jsp").forward(req, resp);
		 
	}
}
