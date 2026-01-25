package com.lucian.dgaspc.model;

import java.util.List;

public class HotarareCJC {
	private String id;
	private String nrHotarare;
	private String dataHotarare;
	private String emitent;
	private String dataComunicarii;
	private List<PrimitorHCJC> listaPrimitori;
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
	public List<PrimitorHCJC> getListaPrimitori() {
		return listaPrimitori;
	}
	public void setListaPrimitori(List<PrimitorHCJC> listaPrimitori) {
		this.listaPrimitori = listaPrimitori;
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
		return "HotarareCJC [id=" + id + ", nrHotarare=" + nrHotarare + ", dataHotarare=" + dataHotarare + ", emitent="
				+ emitent + ", dataComunicarii=" + dataComunicarii + ", listaPrimitori=" + listaPrimitori
				+ ", numeFisier=" + numeFisier + ", stadiu=" + stadiu + "]";
	}
}
