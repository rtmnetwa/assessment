package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImp implements AgentService {

    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImp(AgentRepository agentRepository) {
        this.agentRepository=agentRepository;
    }

    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgent(long id) throws ResourceExistsException{
        return agentRepository.findById(id)
                .orElseThrow(()-> throw new ResourceExistsException("Agent already exists"));
    }

    @Override
    public List<Agent> getAllAgents() {
        return null;
    }

    @Override
    public List<Agent> getAgents() {
        return null;
    }

    @Override
    public Agent editTeamAgent(Agent agent) {
        return null;
    }

}
