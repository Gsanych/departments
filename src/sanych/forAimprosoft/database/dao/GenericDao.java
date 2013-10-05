package sanych.forAimprosoft.database.dao;

import java.util.List;

public interface GenericDao<T> {

    List<T> getList();

    T create(T entity);

    void update(T entity);

    void delete(T id);


}
