package com.kuebiko.it.servlet;

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

import com.kuebiko.it.dao.SignupDao;
import com.kuebiko.it.servlet.dto.SignupDTO;
import com.kuebiko.it.utils.MySQLConnectionUtils;

@WebServlet("/searchSignup")
public class SearchSignupsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String textSearch = req.getParameter("textSearch");
		List<SignupDTO> signupDTOs = new ArrayList<SignupDTO>();

		String actionButton = req.getParameter("bbutton");

		if (actionButton.equalsIgnoreCase("clear")) {
			signupDTOs = SignupDao.findAll();

		} else {

			if (textSearch != null && textSearch.trim().length() > 0) {
				signupDTOs = SignupDao.search(textSearch);
			} else {
				req.setAttribute("message", "Search text cannot be empty");
			}

		}
		// ${message}
		// I have to go to signup.jsp file
		// below line is opening signup.jsp ->>
//		 /signup.jsp - will generate the html contents

		req.setAttribute("bananas", signupDTOs);
		req.getRequestDispatcher("searchSignup.jsp").forward(req, resp);

	}
}
