package com.epam.service.impl;

import com.epam.dao.UnitDao;
import com.epam.entity.Unit;
import com.epam.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Unit Service.
 */
@Service
public class UnitServiceImpl extends AbstractService<Unit> implements UnitService {

    @Autowired
    public UnitServiceImpl(UnitDao unitDao) {
        super(unitDao);
    }
}
