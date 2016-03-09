package com.floremipy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the adress database table.
 * 
 */
@Entity
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String city;

	private String location;

	private String zipCode;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="adress")
	private List<Customer> customers;

	//bi-directional many-to-one association to Customerorder
	@OneToMany(mappedBy="adress")
	private List<Customerorder> customerorders;

	public Adress() {
	}
	
	

	public Adress(String city, String location, String zipCode) {
		super();
		this.city = city;
		this.location = location;
		this.zipCode = zipCode;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAdress(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAdress(null);

		return customer;
	}

	public List<Customerorder> getCustomerorders() {
		return this.customerorders;
	}

	public void setCustomerorders(List<Customerorder> customerorders) {
		this.customerorders = customerorders;
	}

	public Customerorder addCustomerorder(Customerorder customerorder) {
		getCustomerorders().add(customerorder);
		customerorder.setAdress(this);

		return customerorder;
	}

	public Customerorder removeCustomerorder(Customerorder customerorder) {
		getCustomerorders().remove(customerorder);
		customerorder.setAdress(null);

		return customerorder;
	}

}