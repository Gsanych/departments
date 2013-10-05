package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.Validator;
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

public class CreateEmp extends HttpServlet {

    private static final String FORMAT = "yyyy-MM-dd";

    private EmployeeDao empDao = new EmployeeDao();
    private Validator validator = new Validator();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateFormat format = new SimpleDateFormat(FORMAT);

        response.setContentType("text/html");
        Employee entity=new Employee();
        try {
            String email = request.getParameter("email");
            String age = request.getParameter("age");
            String date = request.getParameter("birthDay");
            validator.validate(email, age, date);

            Date birthDay = format.parse(date);

            entity.setName(request.getParameter("nameEmp"));
            entity.setSurname(request.getParameter("surname"));
            entity.setEmail(email);
            entity.setAge(Integer.parseInt(age));
            entity.setDepartment(request.getParameter("id"));
            entity.setBirthday(birthDay);
            empDao.create(entity);
        } catch (Validator.ValidationException e) {
            request.setAttribute("errors", e.getErrors());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/insertemp.jsp");
            rd.forward(request, response);
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/servlet/ViewEmp");
        rd.forward(request,response);

    }

}
