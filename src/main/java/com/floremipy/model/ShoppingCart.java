package com.floremipy.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class ShoppingCart {

	private int idArticle;
	private String nomArticle;
	private BigDecimal prixArticle;
	private int qteCommandee;
	private String prixTotal;
	
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

	public String getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(String prixTotal) {
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

	public String calculPrixTotal(Double prix, int q)
	{
		Double qte2 = new Double((int)q);
		Double p2 = new Double(prix);
		Double total = (Double) (prix * qte2); 
		
		return String.format(Locale.ENGLISH,"%.2f",total);	
		

		
		

	}
	
	
	
}
