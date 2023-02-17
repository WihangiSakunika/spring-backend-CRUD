package com.example.bumble.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bumble.exception.ResourceNotFoundException;
import com.example.bumble.model.Product;
import com.example.bumble.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	//Get all product 
	@GetMapping("/products")
	public List<Product>getAllProducts(){
		//return productRepository.findAll();
		return productRepository.findAll();
	}
	//create product resT API
	@PostMapping("/products")
	public Product CreateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	//get product by id rest API
	@GetMapping("/products")
	public ResponseEntity<Product>getProductById(@PathVariable Long id){
		Product product=productRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("product not exits with id:"+id));
		return ResponseEntity.ok(product);
	}
	//update product by rest API
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct (@PathVariable Long id ,@RequestBody Product productDetails){
		Product product=productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not exits with id : "+id));
		product.setProduct_Name(productDetails.getProduct_Name());
		product.setBrand(productDetails.getBrand());
		product.setStatus(productDetails.getStatus());
		product.setPrice(productDetails.getPrice());
		product.setDescription(productDetails.getDescription());
		
		Product updateProduct=productRepository.save(product);
		return ResponseEntity.ok(updateProduct);
	}
	//delete product by rest API
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct (@PathVariable Long id){
		Product product =productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product not exits with id : "+id));
		productRepository.delete(product);
		Map<String, Boolean> response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
