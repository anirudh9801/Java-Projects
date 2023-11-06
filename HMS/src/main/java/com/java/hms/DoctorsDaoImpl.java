package com.java.hms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DoctorsDaoImpl {
	SessionFactory sf;
	Session session;
	
	public List<Doctors> showDoctorsDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Doctors.class);
		return cr.list();
	}
}
