package com.java.rms;

import java.sql.Date;	
import java.util.Map;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class OrdersDaoImpl implements OrdersDAO{
	
	SessionFactory sf;
	Session session;
	
	@Override
	public String placeOrderDao(Orders order) {
		java.util.Date utilDate = new java.util.Date();
		Date currentDate = new Date(utilDate.getTime());
		
		Map<String, Object> sessionMap =
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int custId = (int) sessionMap.get("customerId");
		int venId = (int) sessionMap.get("venId");
		int menuId = (int) sessionMap.get("menuId");
		double price = (Double) sessionMap.get("billAmount");
		double billAmount = price * order.getOrdquantity();
		System.out.println(billAmount);
		String payType = (String) sessionMap.get("payType");
		WalletSource ws = WalletSource.valueOf(payType);
		double walletAmount = new CustomerDaoImpl().purseValue(payType);
		if (walletAmount - billAmount > 0) {
			order.setCusid(custId);
			order.setVenid(venId);
			order.setWalsource(payType);
			order.setMenid(menuId);
			order.setOrdbillamount(billAmount);
			order.setOrdstatus(Ordstatus.PENDING);
			order.setOrddate(currentDate);
			System.out.println(order);
			double balance = walletAmount - billAmount;
			
			sf = SessionHelper.getConnection();
			session = sf.openSession();
			Transaction trans = session.beginTransaction();
			session.save(order);
			trans.commit();
			session.close();
			session = SessionHelper.getConnection().openSession();
			String q = "from Wallet where custId = " +custId + " AND walletSource = '" +ws +"'";
			System.out.println(q);
			Query query = session.createQuery(q);
			
			Wallet wallet = (Wallet)query.list().get(0);
			trans = session.beginTransaction(); 
			wallet.setWalletAmount(balance); 
			session.update(wallet);
			trans.commit();
			return "Dashboard.jsp?faces-redirect=true";
		} else {
			return "Message.jsp?faces-redirect=true";
		}
	
	}

	@Override
	public String orderHistory() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		int custId = (int) sessionMap.get("customerId");
		System.out.println(custId);
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("cusid",custId));
		
		List<Order> orderList = criteria.list();
		sessionMap.put("orderList",orderList);
		System.out.println("orderlist"+orderList);
		return "OrderHistory.jsp?faces-redirect=true"; 
	}

	@Override
	public String pendingOrder() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		int custId = (int) sessionMap.get("customerId");
		Criteria cr = session.createCriteria(Orders.class);
		cr.add(Restrictions.eq("cusid", custId));
		cr.add(Restrictions.eq("ordstatus", Ordstatus.PENDING));
		List<Order>orderList = cr.list();
		sessionMap.put("orderList", orderList);
		System.out.println("OrderList"+orderList);
		return "PendingOrder.jsp?faces-redirect=true";
	}
	public String venpendingOrder() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		int venId = (int) sessionMap.get("vendorId");
		Criteria cr = session.createCriteria(Orders.class);
		cr.add(Restrictions.eq("venid", venId));
		cr.add(Restrictions.eq("ordstatus", Ordstatus.PENDING));
		List<Order>orderList = cr.list();
		sessionMap.put("orderList", orderList);
		System.out.println("OrderList"+orderList);
		return "venPendingOrder.jsp?faces-redirect=true";
	}
	
	public String acceptOrder(int ordid) {
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Transaction trans = session.beginTransaction();
	    Orders order = (Orders) session.get(Orders.class, ordid);

	    if (order != null) {
	        if (order.getOrdstatus() == Ordstatus.PENDING) {
	            order.setOrdstatus(Ordstatus.ACCEPTED);
	            session.update(order);

	            trans.commit();
	            return "VendorlDashboard.jsp?faces-redirect=true";
	        } else {
	            return "Order is not in a pending state";
	        }
	    } else {

	        return "not found";
	    }
	    
	}
	public String rejectOrder(int ordid) {
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Transaction trans = session.beginTransaction();

	    Orders order = (Orders) session.get(Orders.class, ordid);

	    if (order != null) {
	        if (order.getOrdstatus() == Ordstatus.PENDING) {
	            List<Wallet> wallets = getCustomerWallet(order.getCusid());
	            if (!wallets.isEmpty()) {
	                for (Wallet wallet : wallets) {
	                    double refundedAmount = order.getOrdbillamount();
	                    wallet.setWalletAmount(wallet.getWalletAmount() + refundedAmount);
	                    session.update(wallet);
	                }
	                order.setOrdstatus(Ordstatus.DENIED);
	                session.update(order);

	                trans.commit();
	                session.close();
	                return "VendorDashboard.xhtml?faces-redirect=true";
	            } else {
	                session.close();
	                return "Customer has no wallets";
	            }
	        } else {
	            session.close();
	            return "Order is not in a pending state";
	        }
	    } else {
	        session.close();
	        return "Order not found";
	    }
	}

	private List<Wallet> getCustomerWallet(int customerId) {
	    Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    sf = SessionHelper.getConnection();
	    Session newSession = sf.openSession();

	    Criteria criteria = newSession.createCriteria(Wallet.class);
	    criteria.add(Restrictions.eq("custId", customerId));
	    List<Wallet> walletList = criteria.list();

	    newSession.close();

	    return walletList;
	}



}
