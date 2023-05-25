package com.kuebiko.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuebiko.it.dao.SignupDao;

@WebServlet("/deleteData")
public class DeleteSignupsServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sidStr=req.getParameter("sid");
		 //converting String into int value
		 int sid = Integer.parseInt(sidStr);
		 SignupDao.delete(sid);
		 //-> /showData -> this the url-pattern for the servlet
		 req.getRequestDispatcher("showData").forward(req, resp);
	}
}
