package com.example.bumble.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Product_Name")
	private String Product_Name;
	@Column(name="Brand")
	private String Brand;
	@Column(name="Status")
	private String Status;
	@Column(name="Price")
	private Double Price;
	@Column(name="Description")
	private String Description;
	
	public Product() {}
	
	public Product(String product_Name, String brand, String status, Double price, String description) {
		super();
		this.Product_Name = product_Name;
		this.Brand = brand;
		this.Status = status;
		this.Price = price;
		this.Description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.Product_Name = product_Name;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		this.Brand = brand;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		this.Status = status;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		this.Price = price;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	
	
}
