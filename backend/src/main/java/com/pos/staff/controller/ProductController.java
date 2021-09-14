package com.pos.staff.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pos.staff.entity.Product;
import com.pos.staff.exception.ProductIdNotFoundException;
import com.pos.staff.exception.ProductNameNotFoundException;
import com.pos.staff.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProduct(){
		return new ResponseEntity<>(productService.getAllProduct(),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		return new ResponseEntity<>(productService.getProductById(id),new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping("/product/name/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable String name){
		return new ResponseEntity<>(productService.getProductByName(name),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> addProduct(@RequestBody Product product){
		
		return new ResponseEntity<>(productService.addProduct(product),new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateEmployee( @PathVariable("id") Integer id,@RequestBody Product product){
		
		return new ResponseEntity<>(productService.updateProduct(id, product),new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<String> productIdNotFound(ProductIdNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(ProductNameNotFoundException.class)
	public ResponseEntity<String> productNameNotFound(ProductNameNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	
}
