package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDAO {

	@Override
	public List<String> getRoomTypesDao() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionHelper.getConnection();
        List<String> roomTypes = new ArrayList<>();

        String query = "SELECT DISTINCT room_type FROM room_master";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            roomTypes.add(resultSet.getString("room_type"));
        }

        connection.close();

        return roomTypes;
    
	}

	 public List<String> getRoomStatusesDao() throws SQLException, ClassNotFoundException {
	        Connection connection = ConnectionHelper.getConnection();
	        List<String> roomStatuses = new ArrayList<>();

	        String query = "SELECT DISTINCT status FROM room_master";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            roomStatuses.add(resultSet.getString("status"));
	        }

	        connection.close();

	        return roomStatuses;
	    }
	}




