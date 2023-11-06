package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface PatientDAO {
	String addPatientDao(Patient patient) throws ClassNotFoundException, SQLException;
	List<Patient> showPatientDao() throws ClassNotFoundException, SQLException;

}
