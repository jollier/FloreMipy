package com.floremipy.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the deliverydetail database table.
 * 
 */
@Entity
@NamedQuery(name="Deliverydetail.findAll", query="SELECT d FROM Deliverydetail d")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Deliverydetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeliverydetailPK id;

	private int quantityDelivred;

	//bi-directional many-to-one association to Delivery
	@ManyToOne
	@JoinColumn(name="IdDelivery")
	private Delivery delivery;

	//bi-directional many-to-one association to Customerorderline
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="IdArticle", referencedColumnName="IdArticle"),
		@JoinColumn(name="IdCustomerOrder", referencedColumnName="IdCustomerOrder")
		})
	private Customerorderline customerorderline;

	public Deliverydetail() {
	}

	public DeliverydetailPK getId() {
		return this.id;
	}

	public void setId(DeliverydetailPK id) {
		this.id = id;
	}

	public int getQuantityDelivred() {
		return this.quantityDelivred;
	}

	public void setQuantityDelivred(int quantityDelivred) {
		this.quantityDelivred = quantityDelivred;
	}

	public Delivery getDelivery() {
		return this.delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Customerorderline getCustomerorderline() {
		return this.customerorderline;
	}

	public void setCustomerorderline(Customerorderline customerorderline) {
		this.customerorderline = customerorderline;
	}

}