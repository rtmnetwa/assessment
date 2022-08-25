package com.xib.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("agents/")
public class AgentController {

    private AgentRepository agentRepository;
    @Autowired
    public AgentController(AgentRepository agentRepository) {
        this.agentRepository=agentRepository;
    }

    @PostMapping("addAgent/")
    @ResponseStatus(HttpStatus.CREATED)
    public Agent addAgent(@RequestBody final Agent agent){
        Agent newAgent=new Agent();
        newAgent.setId(UUID.randomUUID().getLeastSignificantBits());
        newAgent.setFirstName(agent.getFirstName());
        newAgent.setLastName(agent.getLastName());
        newAgent.setIdNumber(agent.getIdNumber());
        newAgent.setTeam(agent.getTeam());
        return agentRepository.save(newAgent);
    }
    @GetMapping("agent/{id}")
    public Agent findAgent(@PathVariable("id") Long id) {
        Agent a = new Agent();
        a.setId(id);
        return a;
    }

    @GetMapping("agents/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }

}
