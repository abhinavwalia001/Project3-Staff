package com.pos.staff.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pos.staff.dao.ProductDao;
import com.pos.staff.entity.Product;
import com.pos.staff.exception.ProductIdNotFoundException;
import com.pos.staff.exception.ProductNameNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public String updateProduct(Integer id, Product productUpdated) {
		
		if(!productDao.existsById(id)) {
    		throw new ProductIdNotFoundException("error");
    	}
	
		
		return productDao.findById(id)
				.map(product -> {
					
					product.setStock(productUpdated.getStock());
					
					return "Product stock updated successfully!";
				}).orElseThrow(()-> new ProductIdNotFoundException("error"));
					
	}

	@Override
	public String addProduct(Product product) {
		
		
		 productDao.save(product);
			return "Product added successfully!";
		}
	
	
	@Override
	public Product getProductById(Integer id) {
		Optional<Product> optionalProduct = productDao.findById(id);
		  if(optionalProduct.isPresent()) {
	    		return optionalProduct.get();
	    	}else {
	    		throw new ProductIdNotFoundException("error");
	    	}
		  
		  
	}
	@Override
	public Product getProductByName(String name) {
		Optional<Product> optionalProduct = productDao.findByName(name);
		  if(optionalProduct.isPresent()) {
	    		return optionalProduct.get();
	    	}else {
	    		throw new ProductNameNotFoundException("Product not found");
	    	}
		
		
	}

	@Override
	public List<Product> getAllProduct() {
		
		return productDao.findAll();
		
	}
}
	
	
