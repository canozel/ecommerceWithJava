package com.canozel.dao;

import com.canozel.model.SubCategory;

public interface SubCategoryDAO {
	public void addSubCategory(SubCategory sub_category);
	public void deleteCategory(int id);
	public void updateSubCategory(SubCategory sub_category);
	public SubCategory getSubCategoryById(int id);
}
