package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HmsEjbBean
 */
@Stateless
@Remote(HmsEjbBeanRemote.class)
public class HmsEjbBean implements HmsEjbBeanRemote {

    /**
     * Default constructor. 
     */
    public HmsEjbBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    static HmsDAO daoImpl;
    
    static {
    	daoImpl = new DoctorsDaoImpl();
    }
    
   static PatientDAO daoImpl1;
    
    static {
    	daoImpl1 = new PatientDaoImpl();
    }
 static RoomDAO daoImpl2;
    
    static {
    	daoImpl2 = new RoomDaoImpl();
    }

	@Override
	public List<Doctors> showDoctors() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl.showDoctorsDao();
	}

	@Override
	public String addPatient(Patient patient) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl1.addPatientDao(patient);
	}

	@Override
	public List<Patient> showPatient() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return daoImpl1.showPatientDao();
	}

	@Override
	public List<String> getRoomTypes() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return daoImpl2.getRoomStatusesDao();
	}

	@Override
	public List<String> getRoomStatuses() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return daoImpl2.getRoomTypesDao();
	}

	

}
