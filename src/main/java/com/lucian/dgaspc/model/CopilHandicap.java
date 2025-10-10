package com.lucian.dgaspc.model;

public class CopilHandicap {
	private String id;
	private String dataComisie;
	private String nume;
	private String prenume;
	private String sex;
	private String dataNasterii;
	private String cnp;
	private String domiciliu;
	private String diagnostic;
	private String codCim;
	private String tipHandicap;
	private String gradHandicap;
	private String insotitor;
	private String scolarizat;
	private String cazNou;
	private String locul;
	private String categoriiDeAfectiune;
	private String valabilitateCertificat;
	private String statusTransfer;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataComisie() {
		return dataComisie;
	}
	public void setDataComisie(String dataComisie) {
		this.dataComisie = dataComisie;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDataNasterii() {
		return dataNasterii;
	}
	public void setDataNasterii(String dataNasterii) {
		this.dataNasterii = dataNasterii;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getDomiciliu() {
		return domiciliu;
	}
	public void setDomiciliu(String domiciliu) {
		this.domiciliu = domiciliu;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public String getCodCim() {
		return codCim;
	}
	public void setCodCim(String codCim) {
		this.codCim = codCim;
	}
	public String getTipHandicap() {
		return tipHandicap;
	}
	public void setTipHandicap(String tipHandicap) {
		this.tipHandicap = tipHandicap;
	}
	public String getGradHandicap() {
		return gradHandicap;
	}
	public void setGradHandicap(String gradHandicap) {
		this.gradHandicap = gradHandicap;
	}
	public String getInsotitor() {
		return insotitor;
	}
	public void setInsotitor(String insotitor) {
		this.insotitor = insotitor;
	}
	public String getScolarizat() {
		return scolarizat;
	}
	public void setScolarizat(String scolarizat) {
		this.scolarizat = scolarizat;
	}
	public String getCazNou() {
		return cazNou;
	}
	public void setCazNou(String cazNou) {
		this.cazNou = cazNou;
	}
	public String getLocul() {
		return locul;
	}
	public void setLocul(String locul) {
		this.locul = locul;
	}
	public String getCategoriiDeAfectiune() {
		return categoriiDeAfectiune;
	}
	public void setCategoriiDeAfectiune(String categoriiDeAfectiune) {
		this.categoriiDeAfectiune = categoriiDeAfectiune;
	}
	public String getValabilitateCertificat() {
		return valabilitateCertificat;
	}
	public void setValabilitateCertificat(String valabilitateCertificat) {
		this.valabilitateCertificat = valabilitateCertificat;
	}
	public String getStatusTransfer() {
		return statusTransfer;
	}
	public void setStatusTransfer(String statusTransfer) {
		this.statusTransfer = statusTransfer;
	}
	
	@Override
	public String toString() {
		return "CopilHandicap [id=" + id + ", dataComisie=" + dataComisie + ", nume=" + nume + ", prenume=" + prenume
				+ ", sex=" + sex + ", dataNasterii=" + dataNasterii + ", cnp=" + cnp + ", domiciliu=" + domiciliu
				+ ", diagnostic=" + diagnostic + ", codCim=" + codCim + ", tipHandicap=" + tipHandicap
				+ ", gradHandicap=" + gradHandicap + ", insotitor=" + insotitor + ", scolarizat=" + scolarizat
				+ ", cazNou=" + cazNou + ", locul=" + locul + ", categoriiDeAfectiune=" + categoriiDeAfectiune
				+ ", valabilitateCertificat=" + valabilitateCertificat + ", statusTransfer=" + statusTransfer + "]";
	}
}
