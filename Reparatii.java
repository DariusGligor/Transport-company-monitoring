package com.jenkov.javafx.layouts;

public class Reparatii {
	private String mail;
	private String data;
private String serieMasina;
private int costulInLei;
public Reparatii(String mail, String data, String serieMasina, int costulInLei) {
	super();
	this.mail = mail;
	this.data = data;
	this.serieMasina = serieMasina;
	this.costulInLei = costulInLei;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getSerieMasina() {
	return serieMasina;
}
public void setSerieMasina(String serieMasina) {
	this.serieMasina = serieMasina;
}
public int getCostulInLei() {
	return costulInLei;
}
public void setCostulInLei(int costulInLei) {
	this.costulInLei = costulInLei;
}
@Override
public String toString() {
	return "Reparatii [mail=" + mail + ", data=" + data + ", serieMasina=" + serieMasina + ", costulInLei="
			+ costulInLei + "]";
};
}
