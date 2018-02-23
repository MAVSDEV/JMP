package com.epam.userapi.services;

import java.util.List;

/**
 * Common Service.
 */
public interface CommonService<T> {

    List<T> getAll();

    T getById(String objectId);

    void save(T object);

    void update(T object);

    void remove(String objectId);
}
