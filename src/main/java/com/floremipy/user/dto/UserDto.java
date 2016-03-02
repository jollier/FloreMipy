package com.floremipy.user.dto;

import com.floremipy.user.UserType;


public class UserDto {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String firstname;

	private String lastname;

	private String password;

	private String username;
	
	
	private UserType usertype;

	public UserDto() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public UserType getUsertype() {
		return this.usertype;
	}

	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ ", username=" + username + ", usertype=" + usertype + "]";
	}
	
	

}
