package sanych.forAimprosoft.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Redirect extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("Data3", request.getParameter("id"));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/insertemp.jsp");
        rd.forward(request,response);
    }
}
