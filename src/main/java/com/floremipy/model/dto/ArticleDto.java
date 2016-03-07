package com.floremipy.model.dto;

public class ArticleDto {
	private int id;
	private String category;
	private String description;
	private String imgsrc;
	private String name;
	private int quantityInStock;
	
	public ArticleDto() {
		
	}
	
	public ArticleDto(int id, String category, String description, String imgsrc, String name,
			int quantityInStock) {
		super();
		this.id = id;
		this.category = category;
		this.description = description;
		this.imgsrc = imgsrc;
		this.name = name;
		this.quantityInStock = quantityInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	@Override
	public String toString() {
		return "ArticleDto [id=" + id + ", category=" + category + ", description=" + description + ", imgsrc=" + imgsrc
				+ ", name=" + name + ", quantityInStock=" + quantityInStock + "]";
	}
	
	
	
}
