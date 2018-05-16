package com.epam.service.impl;

import com.epam.dao.BaseDao;
import com.epam.service.BaseService;

/**
 * Abstract Service.
 */
public abstract class AbstractService<T> implements BaseService<T> {

    private final BaseDao<T> baseDao;

    AbstractService(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T getById(int id) {
        return baseDao.getById(id);
    }

    @Override
    public void create(T t) {
        baseDao.create(t);
    }

    @Override
    public void update(T t) {
        baseDao.update(t);
    }

    @Override
    public void delete(int id) {
        baseDao.delete(id);
    }
}
