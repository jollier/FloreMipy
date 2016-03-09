package com.floremipy.model.customer.dto;

import com.floremipy.model.Adress;

public class CustomerDto {
	
	private int id;
	private String name;
	private String firstname;
	private String phone;
	private String email;
	private Adress adress;
	
	
	public CustomerDto() {
		super();
	}

	
	
	public CustomerDto(int id, String name, String firstname, String phone, String email, Adress adress) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		this.email = email;
		this.adress = adress;
	}

	public CustomerDto(int id, String name, String firstname, String phone, String email) {
		this(id, name, firstname, phone, email, null);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", firstname=" + firstname + ", phone=" + phone + ", email="
				+ email + ", adress=" + adress + "]";
	}
	
	
}
