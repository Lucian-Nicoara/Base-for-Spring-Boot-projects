package com.lucian.dgaspc.model;

import java.util.Arrays;

public class HotarareCJC {
	private String id;
	private String nrHotarare;
	private String dataHotarare;
	private String emitent;
	private String dataComunicarii;
	private String idCompartiment;
	private Compartiment compartiment;
	private String compartimentulAdresat;
	private String idPersoanaPrimire;
	private String persoanaPrimire;
	private String dataPrimirii;
	private byte[] fisier;
	private String numeFisier;
	private String stadiu;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getIdCompartiment() {
		return idCompartiment;
	}
	public void setIdCompartiment(String idCompartiment) {
		this.idCompartiment = idCompartiment;
	}
	public Compartiment getCompartiment() {
		return compartiment;
	}
	public void setCompartiment(Compartiment compartiment) {
		this.compartiment = compartiment;
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
	public byte[] getFisier() {
		return fisier;
	}
	public void setFisier(byte[] fisier) {
		this.fisier = fisier;
	}
	public String getNumeFisier() {
		return numeFisier;
	}
	public void setNumeFisier(String numeFisier) {
		this.numeFisier = numeFisier;
	}
	public String getStadiu() {
		return stadiu;
	}
	public void setStadiu(String stadiu) {
		this.stadiu = stadiu;
	}
	@Override
	public String toString() {
		return "HotarareCJC [id=" + id + ", nrHotarare=" + nrHotarare + ", dataHotarare=" + dataHotarare + ", emitent=" + emitent + ", dataComunicarii=" + dataComunicarii + ", idCompartiment=" + idCompartiment + ", compartiment=" + compartiment + ", compartimentulAdresat=" + compartimentulAdresat + ", idPersoanaPrimire=" + idPersoanaPrimire + ", persoanaPrimire=" + persoanaPrimire + ", dataPrimirii=" + dataPrimirii + ", fisier=" + Arrays.toString(fisier) + ", numeFisier=" + numeFisier + ", stadiu=" + stadiu + "]";
	}
}
