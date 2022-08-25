package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                .orElseThrow(
                ()-> new ResourceExistsException("Resource doesn't exists"));
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public List<Agent> getPagedAgents(int pageNo, int pageSize) {
        Pageable page= PageRequest.of(pageNo, pageSize);
        Page p= agentRepository.findAll(page);
        return p.toList();
    }

    @Override
    public Agent editTeamAgent(Team team, Agent agent) throws ResourceExistsException{
        Agent a=agentRepository.findById(agent.getId())
                .orElseThrow(
                ()-> new ResourceExistsException("Agent doesn't exist.")
                );
        a.setTeam(team);
        return agentRepository.save(a);
    }

}
