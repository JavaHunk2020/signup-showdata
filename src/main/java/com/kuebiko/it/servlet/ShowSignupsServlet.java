package com.kuebiko.it.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuebiko.it.dao.SignupDao;
import com.kuebiko.it.servlet.dto.SignupDTO;
import com.kuebiko.it.utils.MySQLConnectionUtils;

@WebServlet("/showData")
public class ShowSignupsServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 
		 //Sending message from servlet to JSP
		 //message=""Data is saved into database..."
		 req.setAttribute("message", "Data is saved into database...");
		 
		 //${message}
		 //I have to go to signup.jsp file
		 //below line is opening signup.jsp ->>
//		 /signup.jsp - will generate the html contents
		 List<SignupDTO> signupDTOs=SignupDao.findAll();
		 req.setAttribute("bananas", signupDTOs);
		 req.getRequestDispatcher("signup.jsp").forward(req, resp);
		 
	}
}
