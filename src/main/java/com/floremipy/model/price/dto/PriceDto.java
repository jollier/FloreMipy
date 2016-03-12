package com.floremipy.model.price.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.floremipy.model.Article;

public class PriceDto {

	
	private int id;
	
	private int idArticle;

	private Date date;

	private BigDecimal value;
	
	public PriceDto() {
		
	}

	public PriceDto(int id, int idArticle, Date date, BigDecimal value) {
		super();
		this.id = id;
		this.idArticle = idArticle;
		this.date = date;
		this.value = value;
	}
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}


	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	@Override
	public String toString() {
		return "PriceDto [id=" + id + ", idArticle=" + idArticle + ", date=" + date + ", value=" + value + "]";
	}
	
	
}
