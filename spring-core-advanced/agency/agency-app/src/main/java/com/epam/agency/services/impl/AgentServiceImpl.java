package com.epam.agency.services.impl;

import com.epam.agency.beans.Agent;
import com.epam.agency.beans.Estate;
import com.epam.agency.repositories.AgentRepository;
import com.epam.agency.repositories.EstateRepository;
import com.epam.agency.services.AgentService;
import com.epam.agency.utils.CommonUtil;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private EstateRepository estateRepository;

    @Override
    public Optional<Agent> getById(Long id) {
        return agentRepository.findById(id);
    }

    @Override
    public List<Agent> getAll() {
        return Lists.newArrayList(agentRepository.findAll());
    }

    @Override
    public void save(Agent agent) {
        agentRepository.save(agent);
    }

    @Override
    public void delete(Long agentId) {
        agentRepository.deleteById(agentId);
    }

    @Override
    public Map<Agent, Integer> getTopAgentsByRangeOfTime(int top) {
        CommonUtil.sleep(2000);
        Map<Agent, Integer> countOfSoldEstatesOfAgent = Maps.newHashMap();

        Lists.newArrayList(estateRepository.findAll()).stream()
                .filter(Estate::getSold)
                .forEach(estate -> {
                    Integer count = 1;
                    if (countOfSoldEstatesOfAgent.containsKey(estate.getAgent())) {
                        count = countOfSoldEstatesOfAgent.get(estate.getAgent());
                    }
                    countOfSoldEstatesOfAgent.put(estate.getAgent(), ++count);

                });
        return countOfSoldEstatesOfAgent.entrySet().stream()
                .sorted((f1, f2) -> Long.compare(f2.getValue(), f1.getValue()))
                .limit(top)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }
}
