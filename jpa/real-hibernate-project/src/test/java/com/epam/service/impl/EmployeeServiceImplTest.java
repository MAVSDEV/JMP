package com.epam.service.impl;

import com.epam.entity.Employee;
import com.epam.entity.EmployeeStatus;
import com.epam.entity.Project;
import com.epam.entity.Unit;
import com.epam.service.EmployeeService;
import com.epam.service.ProjectService;
import com.epam.service.UnitService;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    private static final Integer EMPLOYEE_ID = 2;
    private static final Integer UNIT_ID = 1;
    private static final Integer PROJECT_ID = 1;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private ProjectService projectService;

    @Before
    public void init() {
        employeeService.create(prepareEmployee());
    }

    @Test
    public void addToUnit() {
        Unit unit = new Unit();
        unit.setName("new unit");
        unitService.create(unit);

        employeeService.addToUnit(Lists.newArrayList(EMPLOYEE_ID), UNIT_ID);
    }

    @Test
    public void addToProject() {
        Project project = new Project();
        project.setName("project name");
        projectService.create(project);

        employeeService.addToProject(Lists.newArrayList(EMPLOYEE_ID), PROJECT_ID);
    }

    @Test
    public void getById() {
        Employee dbEmployee = employeeService.getById(EMPLOYEE_ID);
        Assert.assertNotNull(dbEmployee);
    }

    @Test
    public void update() {
        Employee dbEmployee = employeeService.getById(EMPLOYEE_ID);
        dbEmployee.setExternal(Boolean.FALSE);

        employeeService.update(dbEmployee);
        dbEmployee = employeeService.getById(EMPLOYEE_ID);
        Assert.assertFalse(dbEmployee.isExternal());
    }

    @Test
    public void delete() {
        employeeService.delete(EMPLOYEE_ID);
        Employee employee = employeeService.getById(EMPLOYEE_ID);
        Assert.assertNull(employee);
    }

    private Employee prepareEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeStatus(EmployeeStatus.BENCH);
        employee.setExternal(Boolean.TRUE);
        return employee;
    }

}