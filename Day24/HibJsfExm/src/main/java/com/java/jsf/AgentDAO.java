package com.java.jsf;

 

import java.util.List;

 

public interface AgentDAO {

    List<Agent> showAgentsOrderedByBasic();

    String searchAgentById(int agentID);

    String addAgent(Agent agent);

    String deleteAgent(int agentID);
    String updateAgentDao(Agent agentUpdate);

}

 