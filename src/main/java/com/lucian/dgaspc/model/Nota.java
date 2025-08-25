package com.lucian.dgaspc.model;

public class Nota {
	private String id;
	private String idUser;
	private String data;
	private String idEntitate;
	private String entitate;
	private String text;
	private UserData persoana;
	
	public Nota(String data, String entitate, String text) {
		super();
		this.data = data;
		this.entitate = entitate;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEntitate() {
		return entitate;
	}

	public void setEntitate(String entitate) {
		this.entitate = entitate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserData getPersoana() {
		return persoana;
	}

	public void setPersoana(UserData persoana) {
		this.persoana = persoana;
	}

	public String getIdEntitate() {
		return idEntitate;
	}

	public void setIdEntitate(String idEntitate) {
		this.idEntitate = idEntitate;
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", idUser=" + idUser + ", data=" + data + ", idEntitate=" + idEntitate + ", entitate=" + entitate + ", text=" + text + ", persoana=" + persoana + "]";
	}
}
