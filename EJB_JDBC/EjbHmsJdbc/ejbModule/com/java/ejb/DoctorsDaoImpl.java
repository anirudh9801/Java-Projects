package com.java.ejb;

import java.sql.Connection;	

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DoctorsDaoImpl implements HmsDAO {

	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Doctors> showDoctorsDao() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from doctor_master";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Doctors> doctorList = new ArrayList<Doctors>();
		Doctors doctor = null;
		while(rs.next()) {
			doctor = new Doctors();
			doctor.setDrid(rs.getString("Dr_id"));
			doctor.setDrname(rs.getString("Dr_name"));
			doctor.setDept(rs.getString("Dept"));
			doctorList.add(doctor);
		}
		return doctorList;
	}
}