package com.floremipy.model.customer.dto;

public class CustomerLightDto {
	private int id;
	private String name;
	private String firstname;
	
	
	public CustomerLightDto() {
		super();
	}


	public CustomerLightDto(int id, String name, String firstname) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	@Override
	public String toString() {
		return "CustomerLightDto [id=" + id + ", name=" + name + ", firstname=" + firstname + "]";
	}
	
	
	
}
