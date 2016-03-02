package com.floremipy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the customerorderline database table.
 * 
 */
@Entity
@NamedQuery(name="Customerorderline.findAll", query="SELECT c FROM Customerorderline c")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Customerorderline implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerorderlinePK id;

	private int delivredQuantity;

	private int quantity;

	//bi-directional many-to-one association to Customerorder
	@ManyToOne
	@JoinColumn(name="IdCustomerOrder")
	private Customerorder customerorder;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;

	//bi-directional many-to-one association to Deliverydetail
	@OneToMany(mappedBy="customerorderline")
	private List<Deliverydetail> deliverydetails;

	public Customerorderline() {
	}

	public CustomerorderlinePK getId() {
		return this.id;
	}

	public void setId(CustomerorderlinePK id) {
		this.id = id;
	}

	public int getDelivredQuantity() {
		return this.delivredQuantity;
	}

	public void setDelivredQuantity(int delivredQuantity) {
		this.delivredQuantity = delivredQuantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customerorder getCustomerorder() {
		return this.customerorder;
	}

	public void setCustomerorder(Customerorder customerorder) {
		this.customerorder = customerorder;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Deliverydetail> getDeliverydetails() {
		return this.deliverydetails;
	}

	public void setDeliverydetails(List<Deliverydetail> deliverydetails) {
		this.deliverydetails = deliverydetails;
	}

	public Deliverydetail addDeliverydetail(Deliverydetail deliverydetail) {
		getDeliverydetails().add(deliverydetail);
		deliverydetail.setCustomerorderline(this);

		return deliverydetail;
	}

	public Deliverydetail removeDeliverydetail(Deliverydetail deliverydetail) {
		getDeliverydetails().remove(deliverydetail);
		deliverydetail.setCustomerorderline(null);

		return deliverydetail;
	}

}