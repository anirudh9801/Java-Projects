package com.java.ejb;

import java.sql.SQLException;	
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class HmsEjbImpl {
	  SessionFactory sf;
      Session session;
	public List<Doctors> showDoctorsEjb() throws NamingException, ClassNotFoundException, SQLException{
		HmsEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessDotors();
		return remote.showDoctors();
		}
	
	public String addPatientEjb(Patient patient) {
      
	    	sf = SessionHelper.getConnection();
	        session = sf.openSession();
	        Transaction transaction = session.beginTransaction();
	        int otp = generateOtp();
	        patient.setotp(String.valueOf(otp));
	        patient.setstatus("pending");
	        session.save(patient);
	        
	       
	        String body = "Welcome  Mr/Miss  " + patient.getName() + "\r\n" +
	                "Your OTP Generated Successfully..." + "\r\n" +
	                "OTP is " + otp;
	        MailSend.mailOtp(patient.getemail(), "Otp Send Successfully...", body);
	        transaction.commit();
	        return "OtpVerification.jsp?faces-redirect=true";
	
	}
	public static int generateOtp() {

		Random r = new Random( System.currentTimeMillis() );

	    return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));

	}
	public String verifyOTP(Patient patient, String enteredOTP) {
	    String generatedOTP = patient.getotp();
	    boolean verificationSuccessful = generatedOTP != null && generatedOTP.trim().equals(enteredOTP.trim());

	    if (verificationSuccessful) {
	        System.out.println("Verification successful. Redirecting to ResetPassword.jsp.");
	        return "ResetPassword.jsp?faces-redirect=true";
	    } else {
	        System.out.println("Verification failed. Redirecting to ErrorPage.");
	        return "ErrorPage?faces-redirect=true";
	    }
	}



	

	  public List<Patient> showPatientEjb() throws NamingException, ClassNotFoundException, SQLException{
		  HmsEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessDotors();
		  return remote.showPatient();
	  }
	  
		public List<String> getRoomTypesEjb() throws NamingException, ClassNotFoundException, SQLException{
			 HmsEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessDotors();
			 return remote.getRoomTypes();
			 
		 }
		
		public List<String> getRoomStatusesEjb() throws NamingException, ClassNotFoundException, SQLException{
			HmsEjbBeanRemote remote = RemoteHelper.lookupRemoteStatelessDotors();
			return remote.getRoomStatuses();
		}

}
