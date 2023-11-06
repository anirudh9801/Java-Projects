package com.java.comp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResolveComplaint {
	
	Connection connection;
	PreparedStatement pst;
	
	public List<Resolve> ResolvedRecords() throws ClassNotFoundException{
		List<Resolve> records = new ArrayList<>();
		try {
	
		connection=ConnectionHelper.getConnection();
		String cmd="select * from resolve";
		pst=connection.prepareStatement(cmd);
		ResultSet rs=pst.executeQuery();


        while (rs.next()) {
            Resolve complaint = new Resolve();
            complaint.setResolveID(rs.getString("ResolveID"));
            complaint.setComplaintID(rs.getString("ComplaintID"));
            complaint.setComplaintDate(rs.getTimestamp("ComplaintDate"));
            complaint.setResolveDate(rs.getTimestamp("ResolveDate"));
            complaint.setResolvedBy(rs.getString("ResolvedBy"));
            complaint.setComments(rs.getString("Comments"));

            // Calculate TAT (Turn Around Time)
            long tatHours = calculateTAT(complaint.getComplaintDate(), complaint.getResolveDate());
            complaint.setTat(tatHours);

            records.add(complaint);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return records;
}

	 private long calculateTAT(Timestamp complaintDate, Timestamp resolveDate) {
	        long milliseconds = resolveDate.getTime() - complaintDate.getTime();
	        long hours = milliseconds / (60 * 60 * 1000);
	        return hours;
	    }
	 
	 
	 public String  resolveIDincrement() throws ClassNotFoundException, SQLException {
			connection=ConnectionHelper.getConnection();
			String cmd="Select max(ResolveID) ResolveID from resolve";
			pst=connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			rs.next();
			String ResolveID=rs.getString("ResolveID");
			if(ResolveID==null) {
				return "R001";
			}else {
				int comp=Integer.parseInt(ResolveID.substring(1,4));
				return String.valueOf(ResolveID.charAt(0)+"00"+(++comp));
			}
		}	
	 public String addResolve(Resolve resolve) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			String id=resolveIDincrement();
			resolve.setResolveID(id);
			connection= ConnectionHelper.getConnection();
			String cmd="Insert into Resolve(ResolveID,ComplaintID,ResolveDate,ResolvedBy,Comments)"+"values(?,?,?,?,?)";
			pst=connection.prepareStatement(cmd);
			pst.setString(1,resolve.getResolveID());
			pst.setString(2,resolve.getComplaintID());
			pst.setTimestamp(3,resolve.getResolveDate());
			pst.setString(4,resolve.getResolvedBy());
			pst.setString(5,resolve.getComments());
			pst.executeUpdate();
			return "****Record Inserted****";
		}
}





