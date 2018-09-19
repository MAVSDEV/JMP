package com.epam.agency.controllers;

import com.epam.agency.beans.Agent;
import com.epam.agency.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Agent Controller.
 */
@RestController
@RequestMapping("/api/v1/agency")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @RequestMapping("/topAgents")
    public Map<Agent, Integer> getTopAgentsByRangeOfTime() {
        return agentService.getTopAgentsByRangeOfTime(5);
    }

}
