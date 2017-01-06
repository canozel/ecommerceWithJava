package com.canozel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.canozel.dao.ProductDAO;
import com.canozel.model.Product;
import com.canozel.util.DBUtil;

public class ProductDAOImpl implements ProductDAO {
	private Connection conn;
	
	public ProductDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addProduct(Product product) {
		try {
            String query = "insert into products (name, price, description, image, category_id, created_at, updated_at) values (?,?,?,?,?, now(), now())";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getImage());
            preparedStatement.setInt(5, product.getCategory_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteProduct(int id) {
		try {
            String query = "delete from products where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateProduct(Product product) {
		try {
            String query = "update products set name = ?, description = ?, image = ?, price = ?, category_id = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, product.getName());
            preparedStatement.setString( 2, product.getDescription());
            preparedStatement.setString( 3, product.getImage());
            preparedStatement.setString( 4, product.getPrice());
            preparedStatement.setInt( 5, product.getCategory_id());
            preparedStatement.setInt( 6, product.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Product getProductById(int id) {
		Product product = new Product();
        try {
            String query = "select * from products where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	product.setId( resultSet.getInt("id"));
                product.setDescription(resultSet.getString("description"));
                product.setName(resultSet.getString("name"));
                product.setImage(resultSet.getString("image"));
                product.setPrice(resultSet.getString("price"));
                product.setId( resultSet.getInt("category_id"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
	}

	@Override
	public List<Product> getProductsBySubCategoryId(int category_id) {
		List<Product> products = new ArrayList<Product>();
        try {
        	String query = "select * from products where category_id = ?"; //FIX change with sub category
        	PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, category_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	Product product = new Product();
                product.setId( resultSet.getInt("id"));
                product.setDescription(resultSet.getString("description"));
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
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
        try {
        	String query = "select * from products";
        	PreparedStatement preparedStatement = conn.prepareStatement( query );
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	Product product = new Product();
                product.setId( resultSet.getInt("id"));
                product.setDescription(resultSet.getString("description"));
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
}
