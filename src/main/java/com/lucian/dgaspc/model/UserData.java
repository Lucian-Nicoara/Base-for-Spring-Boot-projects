package com.lucian.dgaspc.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserData implements UserDetails{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String nume;
	private String prenume;
	private String idCompartiment;
	private Compartiment compartiment;
	private Date registrationDate;
	private List<UserRole> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(List<UserRole> authorities) {
		this.authorities = authorities;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getIdCompartiment() {
		return idCompartiment;
	}
	public void setIdCompartiment(String idCompartiment) {
		this.idCompartiment = idCompartiment;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Compartiment getCompartiment() {
		return compartiment;
	}
	public void setCompartiment(Compartiment compartiment) {
		this.compartiment = compartiment;
	}
	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", password=" + password + ", nume=" + nume + ", prenume=" + prenume + ", idCompartiment=" + idCompartiment + ", compartiment=" + compartiment + ", registrationDate=" + registrationDate + ", authorities=" + authorities + "]";
	}
}
