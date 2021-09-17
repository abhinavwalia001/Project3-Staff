package com.pos.staff.service;
import java.util.List;

import com.pos.staff.entity.Product;
public interface ProductService {

	public String addProduct(Product product);
	public String updateProduct(Integer id, Product productUpdated);

	public Product getProductById(Integer id);
	
	public Product getProductByName(String name);
	
	public List<Product> getAllProduct();
	
	
	
}
