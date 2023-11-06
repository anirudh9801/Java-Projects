package com.java.hms;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RoomDaoImpl {
	SessionFactory sf;
	Session session;
	
	public List<Room> showDoctorsDao() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Room.class);
		return cr.list();
	}
}
