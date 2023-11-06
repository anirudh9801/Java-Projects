package com.java.rms;

import java.util.List;

public interface OrdersDAO {
	String placeOrderDao(Orders order);
	String orderHistory();
	String pendingOrder();
}
