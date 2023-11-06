package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO {
	 List<String> getRoomTypesDao() throws SQLException, ClassNotFoundException;
	    List<String> getRoomStatusesDao() throws SQLException, ClassNotFoundException;
	
}
