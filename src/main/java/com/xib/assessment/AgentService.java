package com.xib.assessment;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    Agent addAgent(Agent agent);
    Agent getAgent(long id) throws ResourceExistsException;
    List<Agent> getAllAgents();
    //Implements pagination and doesnt return the agent IDnumber
    List<Agent> getAgents();
    //Assigns an agent to the specified team
    Agent editTeamAgent(Agent agent);

}
