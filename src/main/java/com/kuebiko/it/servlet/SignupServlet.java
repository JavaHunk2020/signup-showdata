package com.kuebiko.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuebiko.it.dao.SignupDao;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 		 
		 String username=req.getParameter("username");
		 String email=req.getParameter("email");
		 String gender=req.getParameter("gender");
		 SignupDao.save(username, email, gender);
		 //Sending message from servlet to JSP
		 //message=""Data is saved into database..."
		 req.setAttribute("message", "Data is saved into database...");
		 //${message}
		 //I have to go to signup.jsp file
		 //below line is opening signup.jsp ->>
//		 /signup.jsp - will generate the html contents
		 req.getRequestDispatcher("signup.jsp").forward(req, resp);
	}
}
