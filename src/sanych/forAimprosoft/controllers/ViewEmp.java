package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.database.dao.EmployeeDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewEmp extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao empDao=new EmployeeDao();
        response.setContentType("text/html");
        RequestDispatcher rd;

        try{
            String depId;
            depId=request.getParameter("id");
            request.setAttribute("Data1", empDao.getList(depId));
            request.setAttribute("Data2", depId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rd=request.getRequestDispatcher("/WEB-INF/jsp/ViewEmp.jsp");
            rd.forward(request, response);
        }
    }
}
