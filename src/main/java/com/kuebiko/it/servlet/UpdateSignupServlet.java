package com.kuebiko.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuebiko.it.dao.SignupDao;
import com.kuebiko.it.utils.MySQLConnectionUtils;

@WebServlet("/usignup")
public class UpdateSignupServlet extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sidstr=req.getParameter("sid");
		 int sid=Integer.parseInt(sidstr);
		 String username=req.getParameter("username");
		 String email=req.getParameter("email");
		 String gender=req.getParameter("gender");
		 SignupDao.update(username, email, gender, sid);
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
