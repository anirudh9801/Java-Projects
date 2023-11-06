package com.java.hms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.mysql.cj.Query;

public class DoctorDAOImpl implements DoctorDAO{
	   private SessionFactory sf;

	    private Session session;
	@Override
	public List<Doctor> showDoctors() {
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Criteria criteria = session.createCriteria(Doctor.class);
	    List<Doctor> doctors = criteria.list();
	    return doctors;
	}


}
