package com.canozel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.canozel.dao.OrderDAO;
import com.canozel.model.Order;
import com.canozel.model.Product;
import com.canozel.util.DBUtil;

public class OrderDAOImpl implements OrderDAO {
	private Connection conn;
	
	public OrderDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addOrder(Order order) {
		try {
            String query = "insert into orders (user_id, product_id, is_checked, created_at, updated_at) values (?,?,?, now(), now())";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, order.getUser_id());
            preparedStatement.setInt(2, order.getProduct_id());
            preparedStatement.setBoolean(3, order.getIs_checked());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteOrder(int product_id, int user_id) {
		try {
            String query = "delete from orders where orders.user_id = ? and orders.product_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, product_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Product> getOrdersByUserId(int user_id) {
		List<Product> products = new ArrayList<Product>();
        try {
        	String query = "select * from products as p inner join orders as o on o.product_id = p.id where o.user_id = ?";
        	PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, user_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	Product product = new Product();
                product.setId( resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setImage(resultSet.getString("image"));
                product.setPrice(resultSet.getString("price"));
                products.add(product);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
	}

	@Override
	public void checkOrders(int user_id) {
		try {
			String query = "";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
