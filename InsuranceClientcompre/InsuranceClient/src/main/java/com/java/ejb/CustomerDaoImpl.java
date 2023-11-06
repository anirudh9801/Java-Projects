package com.java.ejb;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CustomerDaoImpl implements CustomerDao{


	SessionFactory sf ;
	Session session;
	
	
	
	@Override
	public List<Customer> showCustomer() {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		
		List<Customer> list = cr.list();
		return list	;
		
	}
	public Login searchUsername(String username) {

		SessionFactory sf = SessionHelper.getConnection();

		Session session = sf.openSession();

		Criteria cr = session.createCriteria(Login.class);

		cr.add(Restrictions.eq("username", username));

		Login custauth = (Login) cr.uniqueResult();

		return custauth;

	}
	public String verifyOtp(Login login) {

		 Map<String, Object> sessionMap =

					FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

		System.out.println("Inside verifyotp");

		SessionFactory sf = SessionHelper.getConnection();

		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Criteria cr = session.createCriteria(Login.class);

		System.out.println("123333333333");

		cr.add(Restrictions.eq("username", login.getUsername()));

		Projection projection = Projections.property("otp");

		cr.setProjection(projection);

		String otp = (String)cr.uniqueResult();

		System.out.println("786358395387593");

		String pass = login.getPasscode();

		String pwd = EncryptPassword.getCode(pass);

		session.close();

		sf.close();

		if(otp.equals(login.getOtp())) {

			

			Login custFound = searchUsername(login.getUsername());

			custFound.setPasscode(pwd);

			custFound.setStatus("ACTIVE");

			sf = SessionHelper.getConnection();

			session = sf.openSession();

			Transaction trans = session.beginTransaction();

			session.update(custFound);

			trans.commit();

			return "LoginCustomer.jsp?faces-redirect=true";

		}

		else {

			return "Hello.jsp.jsp?faces-redirect=true";

		}

		

	}


	@Override
	public String addCustomer(Customer customer) {
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		customer.setStatus("Active");
		session.save(customer);
		int otp = generateOtp();

		String body = "Welcome to Mr/Miss  " + customer.getFirstName() + "\r\n" + "Your OTP Generated Successfully..."

				+ "\r\n" + "OTP is " + otp;

		MailSend.mailOtp(customer.getEmail(), "Otp Send Successfully...", body);
		trans.commit();
		sf = SessionHelper.getConnection();

		session = sf.openSession();

		Transaction trans2 = session.beginTransaction();

		Login cust = new Login();

		cust.setCustId(customer.getCustId());

		cust.setUsername(customer.getUserName());

		cust.setOtp(String.valueOf(otp));

		session.save(cust);

		session.getTransaction().commit();

		

		return "ResetPassword.jsp?faces-redirect=true";
		
	}	
public static int generateOtp() {

	Random r = new Random(System.currentTimeMillis());

	return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));

}
public String login(Login custauth) {
    SessionFactory sf = SessionHelper.getConnection();
    session = sf.openSession();
    Transaction tx = null;
    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    try {
        if (custauth != null && isValid(custauth)) {
            tx = session.beginTransaction();

            Criteria criteria = session.createCriteria(Login.class);
            criteria.add(Restrictions.eq("username", custauth.getUsername()));
            criteria.add(Restrictions.eq("Passcode", EncryptPassword.getCode(custauth.getPasscode())));

            criteria.setProjection(Projections.rowCount());
            Long count = (Long) criteria.uniqueResult();

            if (count == 1) {
                sessionMap.put("loggedCustomer", custauth.getUsername());
                sessionMap.put("customerId", custauth.getCustId());

                return "ShowInsurance.jsp?faces-redirect=true";
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid input data", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
    } finally {
        if (tx != null) {
            tx.commit();
        }
        session.close();
    }
}

private boolean isValid(Login custauth) {
    return custauth != null && custauth.getUsername() != null && custauth.getPasscode() != null;
}
public String getInsurancePlans(String insuranceId) {
	sf = SessionHelper.getConnection();
	session = sf.openSession();
	Map<String,Object> sessionMap =
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
	Criteria cr = session.createCriteria(InsurancePlans.class);
	cr.add(Restrictions.eq("insuranceId", insuranceId));
	List<InsurancePlans>insList=cr.list();
	sessionMap.put("insList", insList);

	return"ShowPlan.jsp?faces-redirect=true";		
}
public List<Customer> getCustomersWithPagination(int firstRow, int rowCount) {
    SessionFactory sf = SessionHelper.getConnection();
    Session session = sf.openSession();
    List<Customer> customerList = null;
    
    session.beginTransaction();
    Criteria criteria = session.createCriteria(Customer.class);
    criteria.setFirstResult(firstRow);
    criteria.setMaxResults(rowCount);
    
    customerList = criteria.list();
    return customerList;
}

public int countTotalCustomers() {
    SessionFactory sf = SessionHelper.getConnection();
    Session session = sf.openSession();
    try {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        if (criteria != null) {
            return criteria.list().size();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}

//public String planBooking(int planId) {
//	System.out.println("avzil "+planId);
//	sf = SessionHelper.getConnection();
//	session = sf.openSession();
//	Map<String,Object> sessionMap =
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
//
//	Criteria cr = session.createCriteria(Booking.class);
//	
//	cr.add(Restrictions.eq("planId", planId));
//	List<Booking> book = cr.list();
//	sessionMap.put("planId",planId);
//	
//	
//	System.out.println("current session booking " +book);
//	System.out.println("seesion map is "+sessionMap);
//	return "Booking.jsp?faces-redirect=true";
//	
//	
//}
//
public String planBooking(int planId) {
	Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	sf = SessionHelper.getConnection();
	session = sf.openSession();
	Criteria cr = session.createCriteria(InsurancePlans.class);
	cr.add(Restrictions.eq("planId", planId));
	List<InsurancePlans> book = cr.list();
	sessionMap.put("book", book);
	System.out.println("AAAAAAAAAAAAAAAAAAAsAAAAAAAA "+planId);
	return "Booking.jsp?faces-redirect=true";
}
//public String planBooking(int planId) {
//    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//    sf = SessionHelper.getConnection();
//    session = sf.openSession();
//    Criteria cr = session.createCriteria(Booking.class);
//    cr.add(Restrictions.eq("planId", planId));
//    List<Booking> book = cr.list();
//    sessionMap.put("book", book);
//
//    // Set the planId in your managed bean
//    booking.setPlanId(planId);
//
//    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA " + booking.getPlanId());
//    return "Booking.jsp?faces-redirect=true";
}







