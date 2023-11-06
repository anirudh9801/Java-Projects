package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AgentEjbBeanRemote {
	List<Agent> showAgent() throws ClassNotFoundException, SQLException;
    Agent searchAgent(int agentID) throws ClassNotFoundException, SQLException;
    String addAgent(Agent agent) throws ClassNotFoundException, SQLException;
    String deleteAgent(int agentID) throws ClassNotFoundException, SQLException;
    String updateAgent(Agent agent) throws ClassNotFoundException, SQLException;
}
