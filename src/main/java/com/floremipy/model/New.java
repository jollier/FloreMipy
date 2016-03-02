package com.floremipy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the news database table.
 * 
 */
@Entity
@Table(name="news")
@NamedQuery(name="New.findAll", query="SELECT n FROM New n")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class New implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contenu;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	private Date dateModification;

	private byte modifiable;

	private String nom;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="Auteur")
	private Customer customer1;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="DernierAuteur")
	private Customer customer2;

	public New() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return this.dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public byte getModifiable() {
		return this.modifiable;
	}

	public void setModifiable(byte modifiable) {
		this.modifiable = modifiable;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Customer getCustomer1() {
		return this.customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}

	public Customer getCustomer2() {
		return this.customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

}