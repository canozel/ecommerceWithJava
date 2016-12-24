package com.canozel.model;

public class Order {
	private int id;
	private int user_id;
	private int product_id;
	private boolean is_checked;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public boolean getIs_checked() {
		return is_checked;
	}
	public void setIs_checked(boolean is_checked) {
		this.is_checked = is_checked;
	}
	
}
