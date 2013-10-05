package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.database.dao.EmployeeDao;
import sanych.forAimprosoft.database.model.Employee;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmp extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Employee employee = new Employee();
        EmployeeDao empDao=new EmployeeDao();

        try{
            employee.setId(Integer.parseInt(request.getParameter("em_id")));
            empDao.delete(employee);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
            RequestDispatcher rd = request.getRequestDispatcher("/servlet/ViewEmp");
            rd.forward(request,response);
        }

    }
}
