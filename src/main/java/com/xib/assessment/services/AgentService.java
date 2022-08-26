package com.xib.assessment.services;

import com.xib.assessment.exceptionHandling.ResourceExistsException;
import com.xib.assessment.exceptionHandling.ResourceNotFoundException;
import com.xib.assessment.models.Agent;
import com.xib.assessment.models.Team;

import java.util.List;

public interface AgentService {
    Agent addAgent(Agent agent);
    Agent getAgent(long id) throws ResourceNotFoundException;
    List<Agent> getAllAgents();
    //Test this method...
    List<Agent> getPagedAgents(int pageNo, int pageSize);
    //Assigns an agent to the specified team
    Agent editTeamAgent(Team team, Agent agent) throws ResourceNotFoundException;

}
