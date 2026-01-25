package com.lucian.dgaspc.model;

public class PrimitorHCJC {
	private String id;
	private String idHotarareHCJC;
	private String idCompartiment;
	private String compartimentulAdresat;
	private String idPersoanaPrimire;
	private String persoanaPrimire;
	private String dataPrimirii;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCompartiment() {
		return idCompartiment;
	}
	public void setIdCompartiment(String idCompartiment) {
		this.idCompartiment = idCompartiment;
	}
	public String getCompartimentulAdresat() {
		return compartimentulAdresat;
	}
	public void setCompartimentulAdresat(String compartimentulAdresat) {
		this.compartimentulAdresat = compartimentulAdresat;
	}
	public String getIdPersoanaPrimire() {
		return idPersoanaPrimire;
	}
	public void setIdPersoanaPrimire(String idPersoanaPrimire) {
		this.idPersoanaPrimire = idPersoanaPrimire;
	}
	public String getPersoanaPrimire() {
		return persoanaPrimire;
	}
	public void setPersoanaPrimire(String persoanaPrimire) {
		this.persoanaPrimire = persoanaPrimire;
	}
	public String getDataPrimirii() {
		return dataPrimirii;
	}
	public void setDataPrimirii(String dataPrimirii) {
		this.dataPrimirii = dataPrimirii;
	}
	public String getIdHotarareHCJC() {
		return idHotarareHCJC;
	}
	public void setIdHotarareHCJC(String idHotarareHCJC) {
		this.idHotarareHCJC = idHotarareHCJC;
	}
	@Override
	public String toString() {
		return "PrimitorHCJC [id=" + id + ", idHotarareHCJC=" + idHotarareHCJC + ", idCompartiment=" + idCompartiment
				+ ", compartimentulAdresat=" + compartimentulAdresat + ", idPersoanaPrimire=" + idPersoanaPrimire
				+ ", persoanaPrimire=" + persoanaPrimire + ", dataPrimirii=" + dataPrimirii + "]";
	}
}
