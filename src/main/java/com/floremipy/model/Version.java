package com.floremipy.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Version implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8111795531972298788L;

	@Id
	private int id;
	
	private int version;

	public Version() {

	}

	public int getId() {
		return this.id;
	}
	public int getVersion() {
		return this.version;
	}



}
