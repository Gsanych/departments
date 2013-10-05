package sanych.forAimprosoft.database.dao;

import sanych.forAimprosoft.database.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static sanych.forAimprosoft.database.ConnectionManager.getInstance;

public class DepartmentDao implements GenericDao<Department> {

    @Override
    public List<Department> getList() {
        Connection connection = getInstance().getConnection();
        List<Department> departments = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from departments");
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("dept_id"));
                department.setNameDep(rs.getString("department"));
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } finally {
            getInstance().releaseConnection(connection);
        }
        return departments;
    }

    @Override
    public Department create(Department entity) {
        Connection connection = getInstance().getConnection();
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO departments(department) VALUES(?)");
            st.setString(1, entity.getNameDep());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }  finally {
        getInstance().releaseConnection(connection);
    }
        return entity;
    }

    @Override
    public void update(Department entity) {
        Connection connection = getInstance().getConnection();
        try{
        String sql="UPDATE departments SET department =? WHERE dept_id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, entity.getNameDep());
        ps.setInt(2, entity.getId());
        ps.executeUpdate();
        } catch(SQLException e){
            throw new IllegalStateException(e);
        } finally {
            getInstance().releaseConnection(connection);
        }
    }

    @Override
    public void delete(Department id){
    Connection connection = getInstance().getConnection();
        try{
        String sql = "DELETE FROM departments WHERE dept_id=?";
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
