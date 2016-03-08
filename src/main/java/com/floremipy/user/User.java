package com.floremipy.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//@PersistenceUnit(unitName = "FloreMipyUser")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String password;

	private String username;

	private String usertype;
	
	private Long idcustomer;
	
	

	public User() {
	}
	

//	public User(Long id, String password, String username, String usertype, Long idcustomer) {
//		this.id = id;
//		this.password = password;
//		this.username = username;
//		this.usertype = usertype;
//		this.idcustomer = idcustomer;
//		
//	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password
				+ ", username=" + username + ", usertype=" + usertype + ", idcustomer=" + idcustomer + "]";
	}


	public Long getIdcustomer() {
		return idcustomer;
	}


	public void setIdcustomer(Long idcustomer) {
		this.idcustomer = idcustomer;
	}
	
	
	

}