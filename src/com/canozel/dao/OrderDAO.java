package com.canozel.dao;

import java.util.List;

import com.canozel.model.Order;
import com.canozel.model.Product;

public interface OrderDAO {
	public void addOrder(Order order);
	public void deleteOrder(int product_id, int user_id);
	public void checkOrders(int user_id);
	public List<Product> getOrdersByUserId(int user_id);
	
}
