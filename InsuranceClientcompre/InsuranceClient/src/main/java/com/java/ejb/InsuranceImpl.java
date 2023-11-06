package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InsuranceImpl {

	
	public List<Insurance> showInsuranceDao() throws NamingException {
		InsuranceBeanRemote remote = RemoteHelper.lookupRemoteStatelessInsurance();
		return remote.showInsurance();
	}
	public List<Insurance> getListOfInsurance(int firstRow, int rowCount) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		List<Insurance> cdList = null;
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Insurance.class);
			criteria.setFirstResult(firstRow);
			criteria.setMaxResults(rowCount);
		return criteria.list();
	}
	
	public int countRows() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Insurance.class);
			if (criteria != null) {
				return criteria.list().size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
