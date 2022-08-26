package com.xib.assessment.controllers;

import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.projection.SecureAgent;
import com.xib.assessment.serviceImpl.AgentServiceImp;
import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.serviceImpl.TeamServiceImp;
import com.xib.assessment.models.Agent;
import com.xib.assessment.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private AgentServiceImp agentServiceImp;
    private TeamServiceImp teamServiceImp;
    @Autowired
    public AgentController(AgentServiceImp agentServiceImp, TeamServiceImp teamServiceImp) {
        this.agentServiceImp=agentServiceImp;
        this.teamServiceImp=teamServiceImp;
    }

    @PostMapping("/agent/")
    @ResponseStatus(HttpStatus.CREATED)
    public Agent addAgent(@RequestBody final Agent agent){
        Agent newAgent=new Agent();
        newAgent.setId(UUID.randomUUID().getLeastSignificantBits());
        newAgent.setFirstName(agent.getFirstName());
        newAgent.setLastName(agent.getLastName());
        newAgent.setIdNumber(agent.getIdNumber());
        newAgent.setTeam(agent.getTeam());
        return agentServiceImp.addAgent(newAgent);
    }
    @GetMapping("/agent/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Agent findAgent(@PathVariable("id") long id) throws ResourceNotFoundException {
        return agentServiceImp.getAgent(id);
    }

    @GetMapping("/agents")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Agent> getAllAgents(){
        return agentServiceImp.getAllAgents();
    }

    @GetMapping("/findAgents/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<SecureAgent> findPagedAgents(@PathVariable("pageNo")final int pageNo, @PathVariable("pageSize")final int pageSize) {
        return agentServiceImp.getPagedAgents(pageNo, pageSize);
    }
    @PutMapping("/team/{id}/agent")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Agent editTeamAgent(@PathVariable("id")final long id, @RequestBody final Agent agent) throws ResourceNotFoundException {
        Team team=teamServiceImp.getTeamById(id);
        return agentServiceImp.editTeamAgent(team, agent);
    }
}
