package com.journaldev.jsf.servlet;

import com.google.gson.Gson;
import com.journaldev.jsf.Chitateli;
import com.journaldev.jsf.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class InsertChitateli extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Chitateli> col = new UserDAO().chitateliList();
        request.getRequestDispatcher("WEB-INF/admin_menu.jsp").forward(request, response);
        System.out.println("Books =" + col);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Chitateli> pilots = new UserDAO().chitateliList();
        int NumberChitatelya = pilots.size() + 1;
        int NumberBileta = pilots.size() + 2;
        String FamiliyaImyaOtchestvo = (request.getParameter("FamiliyaImyaOtchestvo"));
        String Address = (request.getParameter("Address"));
        int TelephoneRab = Integer.parseInt(request.getParameter("TelephoneRab"));
        int TelephoneDom = Integer.parseInt(request.getParameter("TelephoneDom"));

        Chitateli pilot = new Chitateli (NumberChitatelya,NumberBileta,FamiliyaImyaOtchestvo,Address,TelephoneRab,TelephoneDom);

        int root = new UserDAO().insertPilot(pilot);
        request.getRequestDispatcher("WEB-INF/admin_menu.jsp").forward(request, response);
    }
}
