package com.jenkov.javafx.layouts;

public class Mecanic {
private String nume;
private String prenume;
private String dataNAstere;
private String mail;
private Integer salariu;
public Mecanic(String nume, String prenume, String dataNAstere, String mail, int salariu) {
	super();
	this.nume = nume;
	this.prenume = prenume;
	this.dataNAstere = dataNAstere;
	this.mail = mail;
	this.salariu = salariu;
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
public String getDataNAstere() {
	return dataNAstere;
}
public void setDataNAstere(String dataNAstere) {
	this.dataNAstere = dataNAstere;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public Integer getSalariu() {
	return salariu;
}
public void setSalariu(Integer salariu) {
	this.salariu = salariu;
}
@Override
public String toString() {
	return "Mecanic [nume=" + nume + ", prenume=" + prenume + ", dataNAstere=" + dataNAstere + ", mail=" + mail
			+ ", salariu=" + salariu + "]";
}

}
