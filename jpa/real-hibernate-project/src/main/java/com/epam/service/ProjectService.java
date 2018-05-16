package com.epam.service;

import com.epam.entity.Project;

import java.util.List;

/**
 * Project Service.
 */
public interface ProjectService extends BaseService<Project> {

    List<Project> getByEmployeeExternalStatus(boolean isEmployeesExternal);
}
