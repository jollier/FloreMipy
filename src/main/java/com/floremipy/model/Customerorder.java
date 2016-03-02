package com.floremipy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the customerorder database table.
 * 
 */
@Entity
@NamedQuery(name="Customerorder.findAll", query="SELECT c FROM Customerorder c")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Customerorder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date customerOrderDate;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="IdCustomer")
	private Customer customer;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="IdAdress")
	private Adress adress;

	//bi-directional many-to-one association to Customerorderline
	@OneToMany(mappedBy="customerorder")
	private List<Customerorderline> customerorderlines;

	public Customerorder() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCustomerOrderDate() {
		return this.customerOrderDate;
	}

	public void setCustomerOrderDate(Date customerOrderDate) {
		this.customerOrderDate = customerOrderDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Customerorderline> getCustomerorderlines() {
		return this.customerorderlines;
	}

	public void setCustomerorderlines(List<Customerorderline> customerorderlines) {
		this.customerorderlines = customerorderlines;
	}

	public Customerorderline addCustomerorderline(Customerorderline customerorderline) {
		getCustomerorderlines().add(customerorderline);
		customerorderline.setCustomerorder(this);

		return customerorderline;
	}

	public Customerorderline removeCustomerorderline(Customerorderline customerorderline) {
		getCustomerorderlines().remove(customerorderline);
		customerorderline.setCustomerorder(null);

		return customerorderline;
	}

}