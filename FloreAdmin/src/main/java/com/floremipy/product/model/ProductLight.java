package com.floremipy.product.model;

public class ProductLight {
	
	long id;
	String name;
	String category;
	int quantityInStock;
	int alertLotMature;

	public ProductLight(long id, String name, String category, int quantityInStock, int alertLotMature) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.quantityInStock = quantityInStock;
		this.alertLotMature = alertLotMature;
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
	public int getAlertLotMature() {
		return alertLotMature;
	}
	public void setAlertLotMature(int alertLotMature) {
		this.alertLotMature = alertLotMature;
	}

	@Override
	public String toString() {
		return "ProductLight [id=" + id + ", name=" + name + ", category=" + category + ", quantityInStock="
				+ quantityInStock + ", alertLotMature=" + alertLotMature + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + alertLotMature;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantityInStock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductLight other = (ProductLight) obj;
		if (alertLotMature != other.alertLotMature)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantityInStock != other.quantityInStock)
			return false;
		return true;
	}
	
	
}
