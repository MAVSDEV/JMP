package com.epam.dao.impl;

import com.epam.dao.ProjectDao;
import com.epam.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Dao.
 */
@Service
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {

    @Override
    public List<Project> getByEmployeeExternalStatus(boolean isEmployeesExternal) {
        return null;
    }

    @Override
    protected Class<Project> getClazz() {
        return Project.class;
    }

    @Override
    protected void prepareToUpdate(Project project) {
        Project dbProject = getById(project.getId());
        dbProject.setEmployees(project.getEmployees());
        dbProject.setName(project.getName());
    }
}
