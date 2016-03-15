package com.floremipy.model.adress.dto;

public class AdressDto {
	private int id;
	private String city;
	private String location;
	private String zipCode;
	
	public AdressDto() {
	}
	
	public AdressDto(int id, String city, String location, String zipCode) {
		super();
		this.id = id;
		this.city = city;
		this.location = location;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	

	@Override
	public String toString() {
		return "AdressDto [id=" + id + ", city=" + city + ", location=" + location + ", zipCode=" + zipCode + "]";
	}
	
	
	

}
