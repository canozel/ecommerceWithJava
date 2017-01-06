package com.canozel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.canozel.dao.UserDAO;
import com.canozel.model.User;
import com.canozel.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	private Connection conn;
	
	public UserDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public int addUser(User user) {
		int id = 0;
		try {
            String query = "insert into users (email, password) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getEmail());
            preparedStatement.setString( 2, user.getPassword());
            preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()){
			    id = resultSet.getInt(1);
			}
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return id;
	}

	@Override
	public void deleteUser(int id) {
		try {
            String query = "delete from users where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateUser(User user) {
		try {
            String query = "update categories set email = ?, password = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getEmail());
            preparedStatement.setString( 1, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public boolean doesExistUserEmail(String email){
		PreparedStatement preparedStatement = null;
        try {
            String query = "select email from users where email=?";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
        
	}

	@Override
	public boolean isAdmin(int id) {
		PreparedStatement preparedStatement = null;
        try {
            String query = "select id from users where id = ? and is_admin = true";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
	}

	@Override
	public int authentication(User user) {
		PreparedStatement preparedStatement = null;
		int id = 0;
        try {
            String query = "select id from users where email = ? and password = ?";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if ( resultSet.next() ) {
                id = resultSet.getInt("id");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return id;
	}

}
