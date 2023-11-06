package com.java.jsp;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CalculationDaoImpl implements CalculationDao{
	SessionFactory sf;
	Session session;
	@Override
	public String saveCalculation(Calculations calculation) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		double a=calculation.getNum1();
	    double b=	calculation.getNum2();
	    
	    double sum=a+b;
	   	     calculation.setResult(sum);
	   
	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     double calc=calculation.getResult();
	     session.save(calculation);
			trans.commit();
			sessionMap.put("sum", sum);
			System.out.println(sum);
			return "Result.jsp?faces-redirect=true";
		
	     
		
	}
	public String subtract(Calculations calculation) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		double a=calculation.getNum1();
	    double b=	calculation.getNum2();
	    
	    double sub=a-b;
	     calculation.setResult(sub);
	
	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     double calc=calculation.getResult();
	     session.save(calculation);
			trans.commit();
			sessionMap.put("sub", sub);
			return "Result.jsp?faces-redirect=true";
		
	     
		
	}
	public String multiply(Calculations calculation) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		double a=calculation.getNum1();
	    double b=	calculation.getNum2();
	    
	    double mult=a*b;

	     calculation.setResult(mult);

	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     double calc=calculation.getResult();
	     session.save(calculation);
			trans.commit();
			sessionMap.put("mult", mult);
			return "Result.jsp?faces-redirect=true";
		
	     
		
	}
	public String division(Calculations calculation) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		double a=calculation.getNum1();
	    double b=	calculation.getNum2();
	
	    double divi=a/b;

	     calculation.setResult(divi);
	     Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	     double calc=calculation.getResult();
	     session.save(calculation);
			trans.commit();
			sessionMap.put("divi", divi);
			return "Result.jsp?faces-redirect=true";
		
	     
		
	}
	


}
