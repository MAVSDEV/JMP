package com.epam.service.impl;

import com.epam.dao.EmployeeDao;
import com.epam.entity.Employee;
import com.epam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Employee Service.
 */
@Service
@Transactional
public class EmployeeServiceImpl extends AbstractService<Employee> implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        super(employeeDao);
        this.employeeDao = employeeDao;
    }

    @Override
    public void addToUnit(List<Integer> employeeIds, Integer unitId) {

        employeeIds.forEach();

        employeeDao.addToUnit(employeeIds, unitId);
    }

    @Override
    public void addToProject(List<Integer> employeeIds, Integer projectId) {
        employeeDao.addToProject(employeeIds, projectId);
    }
}
