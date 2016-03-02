package com.floremipy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private String firstName;

	private String name;

	private String phone;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="IdAdress")
	private Adress adress;

	//bi-directional many-to-one association to Customerorder
	@OneToMany(mappedBy="customer")
	private List<Customerorder> customerorders;

	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="customer1")
	private List<New> news1;

	//bi-directional many-to-one association to New
	@OneToMany(mappedBy="customer2")
	private List<New> news2;

	public Customer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Customerorder> getCustomerorders() {
		return this.customerorders;
	}

	public void setCustomerorders(List<Customerorder> customerorders) {
		this.customerorders = customerorders;
	}

	public Customerorder addCustomerorder(Customerorder customerorder) {
		getCustomerorders().add(customerorder);
		customerorder.setCustomer(this);

		return customerorder;
	}

	public Customerorder removeCustomerorder(Customerorder customerorder) {
		getCustomerorders().remove(customerorder);
		customerorder.setCustomer(null);

		return customerorder;
	}

	public List<New> getNews1() {
		return this.news1;
	}

	public void setNews1(List<New> news1) {
		this.news1 = news1;
	}

	public New addNews1(New news1) {
		getNews1().add(news1);
		news1.setCustomer1(this);

		return news1;
	}

	public New removeNews1(New news1) {
		getNews1().remove(news1);
		news1.setCustomer1(null);

		return news1;
	}

	public List<New> getNews2() {
		return this.news2;
	}

	public void setNews2(List<New> news2) {
		this.news2 = news2;
	}

	public New addNews2(New news2) {
		getNews2().add(news2);
		news2.setCustomer2(this);

		return news2;
	}

	public New removeNews2(New news2) {
		getNews2().remove(news2);
		news2.setCustomer2(null);

		return news2;
	}

}