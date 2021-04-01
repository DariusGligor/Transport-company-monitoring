package com.jenkov.javafx.layouts;

public class oreLucrate {
private String Data;
private Integer nrKm;
private Integer  nrOre;
private Integer leiperkm;
private Integer total;
private String mail;
public String getData() {
	return Data;
}
public void setData(String data) {
	Data = data;
}
public Integer getNrKm() {
	return nrKm;
}
public void setNrKm(Integer nrKm) {
	this.nrKm = nrKm;
}
public Integer getNrOre() {
	return nrOre;
}
public void setNrOre(Integer nrOre) {
	this.nrOre = nrOre;
}
public Integer getLeiperkm() {
	return leiperkm;
}
public void setLeiperkm(Integer leiperkm) {
	this.leiperkm = leiperkm;
}
public Integer getTotal() {
	return total;
}
public void setTotal(Integer total) {
	this.total = total;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public oreLucrate(String data, Integer nrKm, int nrOre, int leiperkm, int total, String mail) {
	super();
	Data = data;
	this.nrKm = nrKm;
	this.nrOre = nrOre;
	this.leiperkm = leiperkm;
	this.total = total;
	this.mail = mail;
}
@Override
public String toString() {
	return "oreLucrate [Data=" + Data + ", nrKm=" + nrKm + ", nrOre=" + nrOre + ", leiperkm=" + leiperkm + ", total="
			+ total + ", mail=" + mail + "]";
}



}
