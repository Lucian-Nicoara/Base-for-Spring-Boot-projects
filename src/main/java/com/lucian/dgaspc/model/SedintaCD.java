package com.lucian.dgaspc.model;
/*sedinte pentru registrul Consiliul Director*/

public class SedintaCD {
	private String id;
	private String sedinta;
	private String dataSedinta;
	private String subiect;
	private String noteDeFundamentare;
	private String hotarareAviz;
	private byte[] fisier;
	private String numeFisier;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSedinta() {
		return sedinta;
	}
	public void setSedinta(String sedinta) {
		this.sedinta = sedinta;
	}
	public String getDataSedinta() {
		return dataSedinta;
	}
	public void setDataSedinta(String dataSedinta) {
		this.dataSedinta = dataSedinta;
	}
	public String getSubiect() {
		return subiect;
	}
	public void setSubiect(String subiect) {
		this.subiect = subiect;
	}
	public String getNoteDeFundamentare() {
		return noteDeFundamentare;
	}
	public void setNoteDeFundamentare(String noteDeFundamentare) {
		this.noteDeFundamentare = noteDeFundamentare;
	}
	public String getHotarareAviz() {
		return hotarareAviz;
	}
	public void setHotarareAviz(String hotarareAviz) {
		this.hotarareAviz = hotarareAviz;
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
	@Override
	public String toString() {
		return "SedintaCD [id=" + id + ", sedinta=" + sedinta + ", dataSedinta=" + dataSedinta + ", subiect=" + subiect
				+ ", noteDeFundamentare=" + noteDeFundamentare + ", hotarareAviz=" + hotarareAviz + ", numeFisier="
				+ numeFisier + "]";
	}
}
