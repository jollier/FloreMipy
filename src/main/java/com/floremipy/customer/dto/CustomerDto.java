package com.floremipy.customer.dto;

public class CustomerDto {

	private String name;
	private String firstName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param name
	 * @param firstName
	 */
	public CustomerDto(String name, String firstName) {
		super();
		this.name = name;
		this.firstName = firstName;
	}
	/**
	 * 
	 */
	public CustomerDto() {
		super();
	}
	
	
	

}
