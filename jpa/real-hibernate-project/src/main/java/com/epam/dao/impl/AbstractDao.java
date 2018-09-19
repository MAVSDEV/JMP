package com.epam.dao.impl;

import com.epam.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Abstract Service.
 */
public abstract class AbstractDao<T> implements BaseDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public T getById(int id) {
        return entityManager.find(getClazz(), id);
    }

    @Override
    @Transactional
    public void create(T t) {
        entityManager.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        prepareToUpdate(t);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    protected abstract Class<T> getClazz();

    protected abstract void prepareToUpdate(T t);
}
