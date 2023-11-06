package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;





public class PatientDaoImpl implements PatientDAO {
	Connection connection;
	PreparedStatement pst;
	@Override
	public String addPatientDao(Patient patient) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
        String cmd = "Insert into patient_master(pid,name,age,weight,gender,address,phoneno,disease,doctor_id) "
         		+ " values(?,?,?,?,?,?,?,?,?)";
         PreparedStatement pst = connection.prepareStatement(cmd);
         pst.setString(1, patient.getPid());
         pst.setString(2, patient.getName());
         pst.setInt(3, patient.getAge());
         pst.setInt(4, patient.getWeight());
         pst.setString(5, patient.getGender());
         pst.setString(6, patient.getAddress());
         pst.setString(7, patient.getPhoneno());
         pst.setString(8, patient.getDisease());
         pst.setString(9, patient.getDoctorid());
         pst.executeUpdate();
         return "Patient Record Inserted...";
	}
	@Override
	public List<Patient> showPatientDao() throws ClassNotFoundException, SQLException {
			connection = ConnectionHelper.getConnection();
			String cmd = "select * from patient_master";
			pst = connection.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			List<Patient> patientList = new ArrayList<Patient>();
			Patient patient = null;
			while(rs.next()) {
				patient = new Patient();
				patient.setPid(rs.getString("pid"));
				patient.setName(rs.getString("name"));
				patient.setAge(rs.getInt("age"));
				patient.setWeight(rs.getInt("weight"));
				patient.setGender(rs.getString("gender"));
				patient.setAddress(rs.getString("address"));
				patient.setPhoneno(rs.getString("phoneno"));
				patient.setDisease(rs.getString("disease"));
				patient.setDoctorid(rs.getString("disease"));
				patientList.add(patient);
			}
			return patientList;
		}
	}
	



