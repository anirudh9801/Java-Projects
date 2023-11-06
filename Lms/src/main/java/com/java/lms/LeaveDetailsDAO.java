package com.java.lms;

 

import java.sql.SQLException;

 

public interface LeaveDetailsDAO {

	

	String applyLeave(LeaveDetails leavedetails) throws ClassNotFoundException, SQLException;



}