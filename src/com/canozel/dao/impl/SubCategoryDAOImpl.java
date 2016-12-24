package com.canozel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.canozel.dao.SubCategoryDAO;
import com.canozel.model.SubCategory;
import com.canozel.util.DBUtil;

public class SubCategoryDAOImpl implements SubCategoryDAO {
	private Connection conn;
	
	public SubCategoryDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addSubCategory(SubCategory sub_category) {
		try {
            String query = "insert into sub_categories (name) values (?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, sub_category.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteCategory(int id) {
		try {
            String query = "delete from sub_categories where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateSubCategory(SubCategory sub_category) {
		try {
            String query = "update sub_categories set name = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, sub_category.getName() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public SubCategory getSubCategoryById(int id) {
		SubCategory sub_category = new SubCategory();
        try {
            String query = "select * from sub_categories where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
            	sub_category.setId(resultSet.getInt("id"));
            	sub_category.setName(resultSet.getString("name"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub_category;
	}

}
