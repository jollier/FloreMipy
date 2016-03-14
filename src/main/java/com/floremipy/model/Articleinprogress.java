package com.floremipy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceUnit;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the articleinprogress database table.
 * 
 */
@Entity
@NamedQuery(name="Articleinprogress.findAll", query="SELECT a FROM Articleinprogress a")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Articleinprogress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int quantity;

	@Temporal(TemporalType.DATE)
	private Date releaseDate;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="IdArticle")
	private Article article;

	public Articleinprogress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}