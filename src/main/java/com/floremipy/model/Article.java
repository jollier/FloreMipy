package com.floremipy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String category;

	private String description;

	private String imgsrc;

	private String name;

	private int quantityInStock;

	//bi-directional many-to-one association to Articleinprogress
	@OneToMany(mappedBy="article")
	private List<Articleinprogress> articleinprogresses;

	//bi-directional many-to-one association to Customerorderline
	@OneToMany(mappedBy="article")
	private List<Customerorderline> customerorderlines;

	//bi-directional many-to-one association to Price
	@OneToMany(mappedBy="article")
	private List<Price> prices;

	public Article() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityInStock() {
		return this.quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public List<Articleinprogress> getArticleinprogresses() {
		return this.articleinprogresses;
	}

	public void setArticleinprogresses(List<Articleinprogress> articleinprogresses) {
		this.articleinprogresses = articleinprogresses;
	}

	public Articleinprogress addArticleinprogress(Articleinprogress articleinprogress) {
		getArticleinprogresses().add(articleinprogress);
		articleinprogress.setArticle(this);

		return articleinprogress;
	}

	public Articleinprogress removeArticleinprogress(Articleinprogress articleinprogress) {
		getArticleinprogresses().remove(articleinprogress);
		articleinprogress.setArticle(null);

		return articleinprogress;
	}

	public List<Customerorderline> getCustomerorderlines() {
		return this.customerorderlines;
	}

	public void setCustomerorderlines(List<Customerorderline> customerorderlines) {
		this.customerorderlines = customerorderlines;
	}

	public Customerorderline addCustomerorderline(Customerorderline customerorderline) {
		getCustomerorderlines().add(customerorderline);
		customerorderline.setArticle(this);

		return customerorderline;
	}

	public Customerorderline removeCustomerorderline(Customerorderline customerorderline) {
		getCustomerorderlines().remove(customerorderline);
		customerorderline.setArticle(null);

		return customerorderline;
	}

	public List<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public Price addPrice(Price price) {
		getPrices().add(price);
		price.setArticle(this);

		return price;
	}

	public Price removePrice(Price price) {
		getPrices().remove(price);
		price.setArticle(null);

		return price;
	}

}