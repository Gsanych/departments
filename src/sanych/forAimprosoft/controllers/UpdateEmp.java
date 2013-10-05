package sanych.forAimprosoft.controllers;


import sanych.forAimprosoft.database.dao.EmployeeDao;
import sanych.forAimprosoft.database.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateEmp extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Employee employee=new Employee();
        EmployeeDao empDao=new EmployeeDao();

        try{
            employee.setName(request.getParameter("nameEmp"));
            employee.setSurname(request.getParameter("surname"));
            employee.setEmail(request.getParameter("email"));
            employee.setAge(Integer.parseInt(request.getParameter("age")));
            employee.setDepartment(request.getParameter("id"));
            empDao.update(employee);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
           response.sendRedirect(String.format("/servlet/ViewEmp?id=%s", request.getParameter("id")));
        }
    }
}
