package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface HmsDAO {
	List<Doctors> showDoctorsDao() throws ClassNotFoundException, SQLException;
}
