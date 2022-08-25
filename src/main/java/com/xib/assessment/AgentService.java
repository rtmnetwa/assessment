package com.xib.assessment;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    Agent addAgent(Agent agent);
    Agent getAgent(long id) throws ResourceExistsException;
    List<Agent> getAllAgents();
    //Implements pagination and doesnt return the agent IDnumber
    List<Agent> getPagedAgents(int pageNo, int pageSize);
    //Assigns an agent to the specified team
    Agent editTeamAgent(Team team, Agent agent) throws ResourceExistsException;

}
