package com.epam.agency.services;

import com.epam.agency.beans.Agent;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AgentService {

    Optional<Agent> getById(Long id);

    List<Agent> getAll();

    void save(Agent agent);

    void delete(Long agentId);

    Map<Agent, Integer> getTopAgentsByRangeOfTime(int top);
}
