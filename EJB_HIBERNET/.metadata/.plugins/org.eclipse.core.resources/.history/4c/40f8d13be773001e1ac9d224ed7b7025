package com.java.ejb;

import java.util.List;

import javax.naming.NamingException;

public class InsuranceImpl {

	
	public List<Insurance> showInsuranceDao() throws NamingException {
		InsuranceBeanRemote remote = RemoteHelper.lookupRemoteStatelessInsurance();
		return remote.showInsurance();
	}
	
	
}
