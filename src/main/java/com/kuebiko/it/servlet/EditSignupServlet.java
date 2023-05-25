package com.kuebiko.it.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kuebiko.it.dao.SignupDao;
import com.kuebiko.it.servlet.dto.SignupDTO;

@WebServlet("/editData")
public class EditSignupServlet extends HttpServlet {

	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sidstr=req.getParameter("sid");
		 int sid=Integer.parseInt(sidstr);
		 SignupDTO signupDTO=SignupDao.findBySid(sid);
		 req.setAttribute("signupDTO", signupDTO);
		 req.getRequestDispatcher("esignup.jsp").forward(req, resp);
		 
	}
}
