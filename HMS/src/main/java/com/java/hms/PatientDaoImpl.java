package com.java.hms;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class PatientDaoImpl {
	SessionFactory sf;
	Session session;
	
	public String addPatient(Patient patient) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(patient);
		trans.commit();
		return "Record inserted";
	}
}
