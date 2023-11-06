package com.java.comp;

import java.sql.SQLException;
import java.util.List;

public interface ComplaintDAO {
List<Complaint> showComplaintDao() throws ClassNotFoundException, SQLException;
String addComplaintDao(Complaint comp) throws ClassNotFoundException, SQLException;
Complaint searchComplaint(String complaintID) throws ClassNotFoundException, SQLException;
}
