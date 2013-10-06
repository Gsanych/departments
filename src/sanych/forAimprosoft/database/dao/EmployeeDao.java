package sanych.forAimprosoft.database.dao;


import sanych.forAimprosoft.database.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static sanych.forAimprosoft.database.ConnectionManager.getInstance;


public class EmployeeDao implements GenericDao<Employee>{


    @Override
    public List<Employee> getList() {
        return null;
    }

    public List<Employee> getList(String depId) {
        Connection connection = getInstance().getConnection();
        List<Employee> employees = new ArrayList<>();
        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("select * from employee where dept_id="+depId);
            while (rs.next()) {
                Employee employee=new Employee();
                employee.setId(rs.getInt("em_id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setEmail(rs.getString("email"));
                employee.setSurname(rs.getString("surname"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setDepartment(depId);
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            getInstance().releaseConnection(connection);
        }
        return employees;
    }

    public boolean exists(String email) {
        Connection connection = getInstance().getConnection();
        int count = 0;
        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("select count(*) as total from employee where email='" + email + "'");
            while (rs.next()) {
                count = rs.getInt("total");
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            getInstance().releaseConnection(connection);
        }
        return count != 0;
    }

    @Override
    public Employee create(Employee entity) {
        Connection connection = getInstance().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO employee(name,surname,age,email,birthday,dept_id) VALUES(?,?,?,?,?,?)");
            st.setString(1, entity.getName());
            st.setString(2, entity.getSurname());
            st.setInt(3, entity.getAge());
            st.setString(4, entity.getEmail());

            Date date = new Date(entity.getBirthday().getTime());
            st.setDate(5, date);

            st.setInt(6, Integer.parseInt(entity.getDepartment()));

            st.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }  finally {
            getInstance().releaseConnection(connection);
        }
        return entity;
    }


    @Override
    public void update(Employee entity) {
        Connection connection = getInstance().getConnection();
        try{
            String sql="UPDATE employee SET name=?,surname=?,email=?,age=?,birthday=?,dept_id=? WHERE em_id =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSurname());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getAge());

            Date date = new Date(entity.getBirthday().getTime());
            ps.setDate(5, date);
            ps.setString(6, entity.getDepartment());
            ps.setInt(7, entity.getId());
            ps.executeUpdate();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        } finally {
            getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void delete(Employee id) {
        Connection connection = getInstance().getConnection();
        try{
            String sql = "DELETE FROM employee WHERE em_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id.getId());
            ps.executeUpdate();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        }finally {
            getInstance().releaseConnection(connection);
        }
    }
}
