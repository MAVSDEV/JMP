package com.epam.service;

import com.epam.entity.Employee;

import java.util.List;

/**
 * Employee Service.
 */
public interface EmployeeService extends BaseService<Employee> {

    void addToUnit(List<Integer> employeeIds, Integer unitId);

    void addToProject(List<Integer> employeeIds, Integer projectId);
}
