package com.floremipy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceUnit;


/**
 * The persistent class for the indicator database table.
 * 
 */
@Entity
@NamedQuery(name="Indicator.findAll", query="SELECT i FROM Indicator i")
@PersistenceUnit(unitName = "FloreMipyWeb")
public class Indicator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	private String periodicity;

	private String sqlText;

	private String targets;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="indicator")
	private List<Result> results;

	public Indicator() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriodicity() {
		return this.periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public String getSqlText() {
		return this.sqlText;
	}

	public void setSqlText(String sqlText) {
		this.sqlText = sqlText;
	}

	public String getTargets() {
		return this.targets;
	}

	public void setTargets(String targets) {
		this.targets = targets;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setIndicator(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setIndicator(null);

		return result;
	}

}