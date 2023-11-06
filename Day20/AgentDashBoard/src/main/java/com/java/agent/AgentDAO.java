package com.java.agent;

import java.sql.SQLException;
import java.util.List;

public interface AgentDAO {
	List<Agent> showAgentDao() throws ClassNotFoundException, SQLException;
	Agent searchAgentDao(int agentID) throws ClassNotFoundException, SQLException;
	String addAgentDao(Agent agent) throws SQLException, ClassNotFoundException; 
	String deleteAgentDao(int agentID) throws ClassNotFoundException, SQLException;
	String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException;



}
