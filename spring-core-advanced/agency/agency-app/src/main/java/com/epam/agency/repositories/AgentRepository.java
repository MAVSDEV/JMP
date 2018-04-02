package com.epam.agency.repositories;

import com.epam.agency.beans.Agent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Agency Service.
 */
@Repository
public interface AgentRepository extends CrudRepository<Agent, Long> {
}
