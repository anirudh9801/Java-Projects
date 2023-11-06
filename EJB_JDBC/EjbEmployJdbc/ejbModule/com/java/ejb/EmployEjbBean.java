package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class EmployEjbBean
 */
@Stateless
@Remote(EmployEjbBeanRemote.class)
public class EmployEjbBean implements EmployEjbBeanRemote {

    /**
     * Default constructor. 
     */
    public EmployEjbBean() {
        // TODO Auto-generated constructor stub
    }
    
    static EmployDAO daoImpl;
    
    static {
    	daoImpl = new EmployDAOImpl();
    }

	@Override
	public List<Employ> showEmploy() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showEmployDao();
	}

	@Override
	public Employ searchEmploy(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.searchEmployDao(empno);
	}

	@Override
	public String addEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.addEmployDao(employ);
	}

	@Override
	public String updateEmploy(Employ employ) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.updateEmployDao(employ);
	}

	@Override
	public String deleteEmploy(int empno) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.deleteEmployDao(empno);
	}

}
