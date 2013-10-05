package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.database.dao.DepartmentDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class View extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao depDao=new DepartmentDao();
        response.setContentType("text/html");
        RequestDispatcher rd;
        try{
           request.setAttribute("Data", depDao.getList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rd=request.getRequestDispatcher("/WEB-INF/jsp/View.jsp");
            rd.forward(request, response);
        }
    }

}
