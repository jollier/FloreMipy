package com.floremipy.user.dto;

public class UserDto {

	private Long id;
	private String username;
	private String password;
	private String usertype;
	private Long idcustomer;

	public UserDto() {
	}

	public UserDto(Long id, String username, String password, String usertype, Long idcustomer) {

		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.idcustomer = idcustomer;
	}

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

	public Long getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(Long idcustomer) {
		this.idcustomer = idcustomer;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", password=" + password
				+ ", username=" + username + ", usertype=" + usertype + "]";
	}

}
