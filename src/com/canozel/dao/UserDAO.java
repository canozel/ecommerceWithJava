package com.canozel.dao;

import com.canozel.model.User;

public interface UserDAO {
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public int authentication(User user);
	public boolean doesExistUserEmail(String email);
	public boolean isAdmin(int id);
	
}
