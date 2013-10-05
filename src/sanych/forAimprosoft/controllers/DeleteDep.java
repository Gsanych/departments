package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.database.dao.DepartmentDao;
import sanych.forAimprosoft.database.model.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;


public class DeleteDep extends HttpServlet {
    DepartmentDao depDao=new DepartmentDao();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Department department=new Department();

        try{
            department.setId(Integer.parseInt(request.getParameter("id")));
            depDao.delete(department);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }finally {
           RequestDispatcher rd = request.getRequestDispatcher("/servlet/UpdateDep");
           rd.forward(request,response);
        }

}
}
