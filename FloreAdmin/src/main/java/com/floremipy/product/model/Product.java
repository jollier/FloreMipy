package com.floremipy.product.model;

public class Product {
	
	long id;
	String name;
	String description;
	String imgsrc;
	String category;
	int quantityInStock;
	
	public Product(long id, String name, String description, String imgsrc, String category, int quantityInStock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imgsrc = imgsrc;
		this.category = category;
		this.quantityInStock = quantityInStock;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	
}
