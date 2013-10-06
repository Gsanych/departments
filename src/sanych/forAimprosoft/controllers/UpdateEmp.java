package sanych.forAimprosoft.controllers;


import sanych.forAimprosoft.database.dao.EmployeeDao;
import sanych.forAimprosoft.database.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UpdateEmp extends HttpServlet {

    private static final String FORMAT = "yyyy-MM-dd";
    EmployeeDao empDao = new EmployeeDao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DateFormat format = new SimpleDateFormat(FORMAT);

        response.setContentType("text/html");
        Employee employee = new Employee();

        try {
            employee.setId(Integer.parseInt(request.getParameter("em_id")));
            employee.setName(request.getParameter("nameEmp"));
            employee.setSurname(request.getParameter("surname"));
            employee.setEmail(request.getParameter("email"));
            employee.setAge(Integer.parseInt(request.getParameter("age")));

            String date = request.getParameter("birthDay");
            Date birthDay = format.parse(date);
            employee.setBirthday(birthDay);

            employee.setDepartment(request.getParameter("id"));
            empDao.update(employee);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("/servlet/ViewEmp");
            rd.forward(request, response);
        }
    }
}
