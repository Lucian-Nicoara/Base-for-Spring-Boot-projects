package com.lucian.base.model;

public class HotarareCJC {
	private String id;
	private String nrHotarare;
	private String dataHotarare;
	private String emitent;
	private String dataComunicarii;
	private String compartimentulAdresat;
	private String persoanaPrimire;
	private String dataPrimirii;
	private String stadiu;
	
	public String getNrHotarare() {
		return nrHotarare;
	}
	public void setNrHotarare(String nrHotarare) {
		this.nrHotarare = nrHotarare;
	}
	public String getDataHotarare() {
		return dataHotarare;
	}
	public void setDataHotarare(String dataHotarare) {
		this.dataHotarare = dataHotarare;
	}
	public String getEmitent() {
		return emitent;
	}
	public void setEmitent(String emitent) {
		this.emitent = emitent;
	}
	public String getDataComunicarii() {
		return dataComunicarii;
	}
	public void setDataComunicarii(String dataComunicarii) {
		this.dataComunicarii = dataComunicarii;
	}
	public String getCompartimentulAdresat() {
		return compartimentulAdresat;
	}
	public void setCompartimentulAdresat(String compartimentulAdresat) {
		this.compartimentulAdresat = compartimentulAdresat;
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
	public String getStadiu() {
		return stadiu;
	}
	public void setStadiu(String stadiu) {
		this.stadiu = stadiu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "HotarareCJC [id=" + id + ", nrHotarare=" + nrHotarare + ", dataHotarare=" + dataHotarare + ", emitent=" + emitent + ", dataComunicarii=" + dataComunicarii + ", compartimentulAdresat=" + compartimentulAdresat + ", persoanaPrimire=" + persoanaPrimire + ", dataPrimirii=" + dataPrimirii + ", stadiu=" + stadiu + "]";
	}
	
}
