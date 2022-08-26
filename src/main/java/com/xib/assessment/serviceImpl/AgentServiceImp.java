package com.xib.assessment.serviceImpl;

import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Agent;
import com.xib.assessment.models.Team;
import com.xib.assessment.repositories.AgentRepository;
import com.xib.assessment.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImp implements AgentService {

    private AgentRepository agentRepository;

    @Autowired
    public AgentServiceImp(AgentRepository agentRepository) {
        this.agentRepository=agentRepository;
    }

    public Agent addAgent(final Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public Agent getAgent(final long id) throws ResourceNotFoundException {
        return agentRepository.findById(id)
                .orElseThrow(
                ()-> new ResourceNotFoundException("Agent doesn't exists"));
    }

    @Override
    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    //First method to test
    @Override
    public List<Agent> getPagedAgents(final int pageNo, final int pageSize) {
        Pageable page= PageRequest.of(pageNo, pageSize);
        Page p= agentRepository.findAll(page);
        return p.toList();
    }

    @Override
    public Agent editTeamAgent(final Team team, final Agent agent) throws ResourceNotFoundException{
        Agent a=agentRepository.findById(agent.getId())
                .orElseThrow(
                ()-> new ResourceNotFoundException("Agent doesn't exist.")
                );
        a.setTeam(team);
        return agentRepository.save(a);
    }

}
