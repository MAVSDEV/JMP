package com.epam.dao.impl;

import com.epam.dao.UnitDao;
import com.epam.entity.Unit;
import org.springframework.stereotype.Service;

/**
 * Unit Service.
 */
@Service
public class UnitDaoImpl extends AbstractDao<Unit> implements UnitDao {
    @Override
    protected Class<Unit> getClazz() {
        return Unit.class;
    }

    @Override
    protected void prepareToUpdate(Unit unit) {
        Unit dbUnit = getById(unit.getId());
        dbUnit.setName(unit.getName());
        dbUnit.setEmployees(unit.getEmployees());
    }
}
