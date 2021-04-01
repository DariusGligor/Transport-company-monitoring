package com.jenkov.javafx.layouts;

public class Sofer {
private String Nume;
private String Prenume;
private String dataNastere;
private Integer nr_km;
private Integer nr_ore;
private Integer bani;
private String mail;
private String serie_masina;
public Sofer(String nume, String prenume, String dataNastere, int nr_km,int nr_ore, int bani, String mail,
		String serie_masina) {
	super();
	Nume = nume;
	Prenume = prenume;
	this.dataNastere = dataNastere;
	this.nr_km = nr_km;
	this.nr_ore = nr_ore;
	this.bani = bani;
	this.mail = mail;
	this.serie_masina = serie_masina;
}
public String getNume() {
	return Nume;
}
public void setNume(String nume) {
	Nume = nume;
}
public String getPrenume() {
	return Prenume;
}
public void setPrenume(String prenume) {
	Prenume = prenume;
}
public String getDataNastere() {
	return dataNastere;
}
public void setDataNastere(String dataNastere) {
	this.dataNastere = dataNastere;
}
public Integer getNr_km() {
	return nr_km;
}
public void setNr_km(Integer nr_km) {
	this.nr_km = nr_km;
}
public Integer getNr_ore() {
	return nr_ore;
}
public void setNr_ore(Integer nr_ore) {
	this.nr_ore = nr_ore;
}
public Integer getBani() {
	return bani;
}
public void setBani(Integer bani) {
	this.bani = bani;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getSerie_masina() {
	return serie_masina;
}
public void setSerie_masina(String serie_masina) {
	this.serie_masina = serie_masina;
}
@Override
public String toString() {
	return "Sofer [Nume=" + Nume + ", Prenume=" + Prenume + ", dataNastere=" + dataNastere + ", nr_km=" + nr_km
			+ ", nr_ore=" + nr_ore + ", bani=" + bani + ", mail=" + mail + ", serie_masina=" + serie_masina + "]";
}

}
