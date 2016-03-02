package com.floremipy.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the delivery database table.
 * 
 */
@Entity
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date deliveryDate;

	//bi-directional many-to-one association to Deliverydetail
	@OneToMany(mappedBy="delivery")
	private List<Deliverydetail> deliverydetails;

	public Delivery() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Deliverydetail> getDeliverydetails() {
		return this.deliverydetails;
	}

	public void setDeliverydetails(List<Deliverydetail> deliverydetails) {
		this.deliverydetails = deliverydetails;
	}

	public Deliverydetail addDeliverydetail(Deliverydetail deliverydetail) {
		getDeliverydetails().add(deliverydetail);
		deliverydetail.setDelivery(this);

		return deliverydetail;
	}

	public Deliverydetail removeDeliverydetail(Deliverydetail deliverydetail) {
		getDeliverydetails().remove(deliverydetail);
		deliverydetail.setDelivery(null);

		return deliverydetail;
	}

}