package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.database.dao.DepartmentDao;
import sanych.forAimprosoft.database.model.Department;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateDep extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Department department=new Department();
        DepartmentDao depDao=new DepartmentDao();

        try{
            department.setNameDep(request.getParameter("department"));
            depDao.update(department);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
           response.sendRedirect("/servlet/View");
        }
    }


}
