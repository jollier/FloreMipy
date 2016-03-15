package com.floremipy.model.articleinprogress.dto;

import java.util.Date;

public class ArticleInProgressDto {

	int id;
	int quantity;
	Date startDate;
	Date releaseDate;
	int idArticle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public ArticleInProgressDto(int id, int quantity, Date startDate, Date releaseDate, int idArticle) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.startDate = startDate;
		this.releaseDate = releaseDate;
		this.idArticle = idArticle;
	}
	public ArticleInProgressDto() {
		super();
	}
	@Override
	public String toString() {
		return "ArticleInProgressDto [id=" + id + ", quantity=" + quantity + ", startDate=" + startDate
				+ ", releaseDate=" + releaseDate + ", idArticle=" + idArticle + "]";
	}
	
	
	
	
	
	
}
