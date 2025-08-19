package com.lucian.dgaspc.model;

import org.springframework.security.core.GrantedAuthority;

public class UserRole implements GrantedAuthority{

	private static final long serialVersionUID = 1L;
	private int id;
	private String authority;
	private int userId;
	
	public UserRole() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return this.authority;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", authority=" + authority + ", userId=" + userId + "]";
	}

}
