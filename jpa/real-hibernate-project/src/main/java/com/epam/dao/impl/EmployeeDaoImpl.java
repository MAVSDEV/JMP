package com.epam.dao.impl;

import com.epam.dao.EmployeeDao;
import com.epam.dao.ProjectDao;
import com.epam.dao.UnitDao;
import com.epam.entity.Employee;
import com.epam.entity.Project;
import com.epam.entity.Unit;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Employee Service.
 */
@Service
public class EmployeeDaoImpl extends AbstractDao<Employee> implements EmployeeDao {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private UnitDao unitDao;

    @Transactional
    @Override
    public void addToUnit(List<Integer> employeeIds, Integer unitId) {
        Unit newUnit = unitDao.getById(unitId);
        employeeIds.forEach(employeeId -> {
            Employee dbEmployee = getById(employeeId);
            if (dbEmployee != null) {
                dbEmployee.setUnit(newUnit);
                update(dbEmployee);
            }
        });
    }

    @Transactional
    @Override
    public void addToProject(List<Integer> employeeIds, Integer projectId) {
        Project newProject = projectDao.getById(projectId);

        employeeIds.forEach(employeeId -> {
            Employee dbEmployee = getById(employeeId);
            if (dbEmployee != null) {
                List<Project> projects = dbEmployee.getProjects();
                projects = projects != null ? projects : Lists.newArrayList();
                projects.add(newProject);
                dbEmployee.setProjects(projects);
                update(dbEmployee);
            }
        });
    }

    @Override
    protected Class<Employee> getClazz() {
        return Employee.class;
    }

    @Override
    protected void prepareToUpdate(Employee employee) {
        Employee dbEmployee = getById(employee.getId());
        dbEmployee.setAddress(employee.getAddress());
        dbEmployee.setEmployeePersonalInfo(employee.getEmployeePersonalInfo());
        dbEmployee.setExternal(employee.isExternal());
        dbEmployee.setProjects(employee.getProjects());
        dbEmployee.setUnit(employee.getUnit());
        dbEmployee.setEmployeeStatus(employee.getEmployeeStatus());
        dbEmployee.setPersonal(employee.getPersonal());
    }
}
