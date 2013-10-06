package sanych.forAimprosoft.controllers;

import sanych.forAimprosoft.Validator;
import sanych.forAimprosoft.database.dao.DepartmentDao;
import sanych.forAimprosoft.database.model.Department;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateDep extends HttpServlet {

    DepartmentDao depDao=new DepartmentDao();
    private Validator validator = new Validator();

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Department entity=new Department();

        try{
            String nameDep = request.getParameter("department");
            validator.validate(nameDep);

            entity.setNameDep(nameDep);
            depDao.create(entity);
        } catch (Validator.ValidationException e) {
            request.setAttribute("errorsDep", e.getErrors());
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            RequestDispatcher rd = request.getRequestDispatcher("/servlet/View");
            rd.forward(request,response);

        }

}
}
