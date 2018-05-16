package com.epam.service.impl;

import com.epam.dao.ProjectDao;
import com.epam.entity.Project;
import com.epam.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project Service.
 */
@Service
public class ProjectServiceImpl extends AbstractService<Project> implements ProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        super(projectDao);
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getByEmployeeExternalStatus(boolean isEmployeesExternal) {
        return projectDao.getByEmployeeExternalStatus(isEmployeesExternal);
    }
}
