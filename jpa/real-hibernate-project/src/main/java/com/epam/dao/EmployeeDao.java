package com.epam.dao;

import com.epam.entity.Employee;

import java.util.List;

/**
 * Employee DAO.
 */
public interface EmployeeDao extends BaseDao<Employee> {

    void addToUnit(List<Integer> employeeIds, Integer unitId);

    void addToProject(List<Integer> employeeIds, Integer projectId);
}
