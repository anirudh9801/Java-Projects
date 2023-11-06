package com.java.ejb;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.naming.NamingException;

public class AgentEjbImpl {
    public List<Agent> showAgentEjb() throws NamingException, ClassNotFoundException, SQLException {
    	System.out.println("Hello...");
        AgentEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
        return remote.showAgent();
    }

    public String searchAgentEjb(int agentID) throws NamingException, ClassNotFoundException, SQLException {
        AgentEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
        Agent agent = remote.searchAgent(agentID);
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        sessionMap.put("editAgent", agent);
        return "UpdateAgent.jsp?faces-redirect=true";
    }

    public String updateAgentEjb(Agent agentNew) throws NamingException, ClassNotFoundException, SQLException {
        AgentEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
        remote.updateAgent(agentNew);
        return "AgentDaoTable.jsp?faces-redirect=true";
    }

    public String deleteAgentEjb(int agentID) throws NamingException, ClassNotFoundException, SQLException {
        AgentEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
        remote.deleteAgent(agentID);
        return "AgentDaoTable.jsp?faces-redirect=true";
    }

    public String addAgentEjb(Agent agentNew) throws NamingException, ClassNotFoundException, SQLException {
        AgentEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessAgent();
        remote.addAgent(agentNew);
        return "AgentDaoTable.jsp?faces-redirect=true";
    }
}
