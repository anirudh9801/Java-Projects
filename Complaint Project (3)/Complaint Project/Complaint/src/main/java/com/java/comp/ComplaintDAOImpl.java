package com.java.comp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAOImpl implements ComplaintDAO {
		Connection connection;
		PreparedStatement pst;
		
		public String  compIDincrement() throws ClassNotFoundException, SQLException {
			connection=ConnectionHelper.getConnection();
			String cmd="Select max(complaintID) complaintID from complaint";
			pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
			String complaintID=rs.getString("complaintID");
			if(complaintID==null) {
				return "C001";
			}else {
				int comp=Integer.parseInt(complaintID.substring(1,4));
				return String.valueOf(complaintID.charAt(0)+"00"+(++comp));
			}
		}	
	@Override
	public List<Complaint> showComplaintDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection= ConnectionHelper.getConnection();
		String cmd="select * from complaint";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();
		List<Complaint> complist=new ArrayList<Complaint>();
		Complaint comp=null;
		while(rs.next()) {
			comp=new Complaint();
			comp.setComplaintID(rs.getString("complaintID"));
			comp.setComplaintType(rs.getString("complaintType"));
			comp.setCDescription(rs.getString("CDescription"));
			comp.setComplaintDate(rs.getDate("complaintDate"));
			comp.setSeverity(rs.getString("severity"));
			comp.setStatus(rs.getString("status"));
			complist.add(comp);
		}
	
		return complist;
	}

	@Override
	public String addComplaintDao(Complaint comp) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String id=compIDincrement();
		comp.setComplaintID(id);
		connection= ConnectionHelper.getConnection();
		String cmd="Insert into complaint(complaintID,ComplaintType,CDescription,Severity)"+"values(?,?,?,?)";
		pst=connection.prepareStatement(cmd);
		pst.setString(1,comp.getComplaintID());
		pst.setString(2,comp.getComplaintType());
		pst.setString(3,comp.getCDescription());
		pst.setString(4,comp.getSeverity());
		pst.executeUpdate();
		return "****Record Inserted****";
	}
	@Override
	public Complaint searchComplaint(String complaintID) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		connection=ConnectionHelper.getConnection();
		String cmd="select * from complaint where complaintID=?";
		pst=connection.prepareStatement(cmd);
		pst.setString(1, complaintID);
		ResultSet rs=pst.executeQuery();
		Complaint comp=null;
		if(rs.next()) {
			comp=new Complaint();
			comp.setComplaintID(rs.getString("complaintID"));
			comp.setComplaintType(rs.getString("ComplaintType"));
			comp.setCDescription(rs.getString("CDescription"));
			comp.setComplaintDate(rs.getDate("complaintDate"));
			comp.setSeverity(rs.getString("Severity"));
			comp.setStatus(rs.getString("status"));
			
	}
		return comp;
	}
	}


