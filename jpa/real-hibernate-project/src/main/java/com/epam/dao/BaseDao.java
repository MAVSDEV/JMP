package com.epam.dao;

public interface BaseDao<T> {

    T getById(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
