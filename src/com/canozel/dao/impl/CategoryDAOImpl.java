package com.canozel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.canozel.dao.CategoryDAO;
import com.canozel.model.Category;
import com.canozel.util.DBUtil;
import com.mysql.jdbc.Statement;

public class CategoryDAOImpl implements CategoryDAO {
	private Connection conn;
	
	public CategoryDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addCategory(Category category) {
		try {
            String query = "insert into categories (name, created_at, updated_at) values (?, now(), now())";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, category.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteCategory(int id) {
		try {
            String query = "delete from categories where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateCategory(Category category) {
		try {
            String query = "update categories set name = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, category.getName() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Category getCategoryById(int id) {
		Category category = new Category();
        try {
            String query = "select * from categories where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
	
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet resultSet = statement.executeQuery( "select * from categories" );
			while( resultSet.next() ) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				categories.add(category);
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
}
