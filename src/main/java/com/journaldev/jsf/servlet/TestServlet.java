package com.journaldev.jsf.servlet;

import com.journaldev.jsf.Books;
import com.journaldev.jsf.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Books> col = new UserDAO().pilotsList();
        System.out.println("Books =" + col);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/books.jsp");
        dispatcher.forward(request, response);

    }
}

