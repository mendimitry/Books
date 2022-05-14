package com.journaldev.jsf.servlet;

import com.google.gson.Gson;
import com.journaldev.jsf.Books;
import com.journaldev.jsf.Chitateli;
import com.journaldev.jsf.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Chitateli> col = new UserDAO().chitateliList();
		String json = new Gson().toJson(col);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
