package com.floremipy.model;

import java.math.BigDecimal;

public class ShoppingCart {

	private int idArticle;
	private String nomArticle;
	private BigDecimal prixArticle;
	private int qteCommandee;
	private BigDecimal prixTotal;
	
	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return this.nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public BigDecimal getPrixArticle() {
		return this.prixArticle;
	}

	public void setPrixArticle(BigDecimal prixArticle) {
		this.prixArticle = prixArticle;
	}

	public int getQteCommandee() {
		return this.qteCommandee;
	}

	public void setQteCommandee(int qteCommandee) {
		this.qteCommandee = qteCommandee;
	}

	public BigDecimal getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public ShoppingCart()
	{
		
	}
	
	public ShoppingCart(int id, String nomArticle, BigDecimal prixArticle, int qteCommandee)
	{
		this.idArticle = id;
		this.nomArticle = nomArticle;
		this.prixArticle = prixArticle;
		this.qteCommandee = qteCommandee;
	}

	public BigDecimal calculPrixTotal(BigDecimal prix, int q)
	{
		BigDecimal total = new BigDecimal((int)q);
		//BigDecimal total = (prix  qte2) 
		return total;

	}
	
	
	
}
