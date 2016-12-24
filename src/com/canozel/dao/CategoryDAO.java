package com.canozel.dao;

import java.util.List;

import com.canozel.model.Category;

public interface CategoryDAO {
	public void addCategory(Category category);
	public void deleteCategory(int id); // Alt katagorilerini de sil
	public void updateCategory(Category category);
	public Category getCategoryById(int id);
	public List<Category> getCategories();
}
