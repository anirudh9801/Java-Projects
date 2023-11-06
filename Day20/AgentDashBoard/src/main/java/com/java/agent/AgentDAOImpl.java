package com.java.agent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAOImpl implements AgentDAO{
	
	
	Connection connection;
	PreparedStatement pst;
	
	
	@Override
	public List<Agent> showAgentDao() throws ClassNotFoundException, SQLException {
		connection = AgentConnectionHelper.getConnection();
		String cmd = "select * from Agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()) {
			agent = new Agent();
			agent.setAgentID(rs.getInt("agentID"));
			agent.setName(rs.getString("name"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setCity(rs.getString("city"));
			agent.setMaritalStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			agentList.add(agent);
		}
		return agentList;
	}

	@Override
	public Agent searchAgentDao(int agentID) throws ClassNotFoundException, SQLException {
		connection = AgentConnectionHelper.getConnection();
		String cmd = "select * from Agent where agentID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentID);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()) {
			agent = new Agent();
			agent.setAgentID(rs.getInt("agentID"));
			agent.setName(rs.getString("name"));
			agent.setGender(Gender.valueOf(rs.getString("gender")));
			agent.setCity(rs.getString("city"));
			agent.setMaritalStatus(rs.getInt("MaritalStatus"));
			agent.setPremium(rs.getDouble("premium"));
			agentList.add(agent);
		}
		return agent;
	

}

	@Override
	public String addAgentDao(Agent agent) throws SQLException, ClassNotFoundException {
		connection = AgentConnectionHelper.getConnection();
        String cmd = "Insert into Agent(AgentId,name,gender,city,premium,MaritalStatus) "
         		+ " values(?,?,?,?,?,?)";
         PreparedStatement pst = connection.prepareStatement(cmd);
         pst.setInt(1, agent.getAgentID());
         pst.setString(2, agent.getName());
         pst.setString(3, agent.getGender().toString());
         pst.setString(4, agent.getCity());
         pst.setDouble(5,  agent.getPremium());
         pst.setInt(6, agent.getMaritalStatus());
         pst.executeUpdate();
         return "Agent Record Inserted...";
	}

	@Override
	public String deleteAgentDao(int agentID) throws ClassNotFoundException, SQLException {
		Agent agent = searchAgentDao(agentID);
		if(agent!=null) {
			connection = AgentConnectionHelper.getConnection();
			String cmd = "Delete from Agent where agentID=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, agentID);
			pst.executeUpdate();
			return "Agent Record deleted...";
			
		}
	return "Agent not found";
	}

	@Override
	public String updateAgentDao(Agent agentNew) throws ClassNotFoundException, SQLException {
		Agent agentFound = searchAgentDao(agentNew.getAgentID());
		if (agentFound!=null) {
			connection = AgentConnectionHelper.getConnection();
			String cmd = "Update Agent set Name=?, Gender=?, City=?, Premium=?, MaritalStatus=? Where "
					+ " AgentID=?";
			pst = connection.prepareStatement(cmd);
			
			pst.setString(1, agentNew.getName());
			pst.setString(2, agentNew.getGender().toString());
			pst.setString(3, agentNew.getCity());
			pst.setDouble(4, agentNew.getPremium());
			pst.setInt(5, agentNew.getMaritalStatus());
			pst.setInt(6, agentNew.getAgentID());
			pst.executeUpdate();
			return "Agent Record Updated...";
		}
		return "Agent Record Not Found...";
	}
	}

