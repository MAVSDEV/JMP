package com.epam.service;

public interface BaseService<T> {

    T getById(int id);

    void create(T t);

    void update(T t);

    void delete(int id);
}
