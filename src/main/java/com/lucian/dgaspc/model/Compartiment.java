package com.lucian.dgaspc.model;

public class Compartiment {
	private String id;
	private String nume;
	
	public Compartiment(String id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	@Override
	public String toString() {
		return "Compartiment [id=" + id + ", nume=" + nume + "]";
	}
}
