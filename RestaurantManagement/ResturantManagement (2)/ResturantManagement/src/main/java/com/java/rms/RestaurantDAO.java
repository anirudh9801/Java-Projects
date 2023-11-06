package com.java.rms;

import java.util.List;

public interface RestaurantDAO {
	List<Restaurant> showRestaurantsDao();
	List<String> getRestaurant(String Restaurant_Name);

}
