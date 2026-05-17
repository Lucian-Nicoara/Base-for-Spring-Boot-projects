package com.lucian.dgaspc.model;

import java.util.List;

public class Dispozitie {
	private String id;
	private String nrDispozitie;
	private String dataDispozitie;
	private String emitent;
	private String dataComunicarii;
	private List<PrimitorDispozitie> listaPrimitori;
	private byte[] fisier;
	private String numeFisier;
	private String stadiu;
	private String totalNote;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNrDispozitie() {
		return nrDispozitie;
	}
	public void setNrDispozitie(String nrDispozitie) {
		this.nrDispozitie = nrDispozitie;
	}
	public String getDataDispozitie() {
		return dataDispozitie;
	}
	public void setDataDispozitie(String dataDispozitie) {
		this.dataDispozitie = dataDispozitie;
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
	public List<PrimitorDispozitie> getListaPrimitori() {
		return listaPrimitori;
	}
	public void setListaPrimitori(List<PrimitorDispozitie> listaPrimitori) {
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
	public String getTotalNote() {
		return totalNote;
	}
	public void setTotalNote(String totalNote) {
		this.totalNote = totalNote;
	}
	@Override
	public String toString() {
		return "Dispozitie [id=" + id + ", nrDispozitie=" + nrDispozitie + ", dataDispozitie=" + dataDispozitie + ", emitent="
				+ emitent + ", dataComunicarii=" + dataComunicarii + ", listaPrimitori=" + listaPrimitori
				+ ", numeFisier=" + numeFisier + ", stadiu=" + stadiu + ", totalNote=" + totalNote + "]";
	}
	
}
