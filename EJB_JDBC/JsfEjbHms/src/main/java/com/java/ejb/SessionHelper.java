

package com.java.ejb;

 

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;

 

public class SessionHelper {

 

	public static SessionFactory getConnection() {

		return new AnnotationConfiguration().configure().buildSessionFactory();

	}

}
