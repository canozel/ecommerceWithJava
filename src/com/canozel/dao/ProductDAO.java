package com.canozel.dao;

import java.util.List;

import com.canozel.model.Product;

public interface ProductDAO {
	public void addProduct(Product product);
	public void deleteProduct(int id);
	public void updateProduct(Product product);
	public Product getProductById(int id);
	public List<Product> getProducts();
	public List<Product> getProductsBySubCategoryId(int category_id);
}
