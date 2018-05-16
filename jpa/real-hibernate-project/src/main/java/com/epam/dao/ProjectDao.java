package com.epam.dao;

import com.epam.entity.Project;

import java.util.List;

/**
 * Project DAO.
 */
public interface ProjectDao extends BaseDao<Project> {

    List<Project> getByEmployeeExternalStatus(boolean isEmployeesExternal);
}
