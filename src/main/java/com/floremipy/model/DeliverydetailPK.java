package com.floremipy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the deliverydetail database table.
 * 
 */
@Embeddable
public class DeliverydetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idDelivery;

	@Column(insertable=false, updatable=false)
	private int idCustomerOrder;

	@Column(insertable=false, updatable=false)
	private int idArticle;

	public DeliverydetailPK() {
	}
	public int getIdDelivery() {
		return this.idDelivery;
	}
	public void setIdDelivery(int idDelivery) {
		this.idDelivery = idDelivery;
	}
	public int getIdCustomerOrder() {
		return this.idCustomerOrder;
	}
	public void setIdCustomerOrder(int idCustomerOrder) {
		this.idCustomerOrder = idCustomerOrder;
	}
	public int getIdArticle() {
		return this.idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeliverydetailPK)) {
			return false;
		}
		DeliverydetailPK castOther = (DeliverydetailPK)other;
		return 
			(this.idDelivery == castOther.idDelivery)
			&& (this.idCustomerOrder == castOther.idCustomerOrder)
			&& (this.idArticle == castOther.idArticle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDelivery;
		hash = hash * prime + this.idCustomerOrder;
		hash = hash * prime + this.idArticle;
		
		return hash;
	}
}