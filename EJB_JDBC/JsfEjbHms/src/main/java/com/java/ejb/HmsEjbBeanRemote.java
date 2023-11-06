package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface HmsEjbBeanRemote {
	List<Doctors> showDoctors() throws ClassNotFoundException, SQLException;
	String addPatient(Patient patient) throws ClassNotFoundException, SQLException;
	List<Patient> showPatient() throws ClassNotFoundException, SQLException;
	 List<String> getRoomTypes() throws SQLException, ClassNotFoundException;
	    List<String> getRoomStatuses() throws SQLException, ClassNotFoundException;

}
