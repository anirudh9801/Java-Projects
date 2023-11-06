package com.java.ejb;

import java.text.Annotation;

import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.*;

public class SessionHelper {

	public static SessionFactory getConnection() {
		return new AnnotationConfiguration().configure().buildSessionFactory();
		
	}
	
}
