package com.jenkov.javafx.layouts;

public class Cars {
private String Marca;
private String Model;
private String dataFabricare;
private String Sofer;
private Integer nrKm;
private String serieSasiu;
private String functioneaza;
public Cars(String marca, String model, String dataFabricare, String sofer, int nrKm, String serieSasiu,
		String functioneaza) {
	super();
	Marca = marca;
	Model = model;
	this.dataFabricare = dataFabricare;
	Sofer = sofer;
	this.nrKm = nrKm;
	this.serieSasiu = serieSasiu;
	this.functioneaza = functioneaza;
}
public String getMarca() {
	return Marca;
}
public void setMarca(String marca) {
	Marca = marca;
}
public String getModel() {
	return Model;
}
public void setModel(String model) {
	Model = model;
}
public String getDataFabricare() {
	return dataFabricare;
}
public void setDataFabricare(String dataFabricare) {
	this.dataFabricare = dataFabricare;
}
public String getSofer() {
	return Sofer;
}
public void setSofer(String sofer) {
	Sofer = sofer;
}
public Integer getNrKm() {
	return nrKm;
}
public void setNrKm(Integer nrKm) {
	this.nrKm = nrKm;
}
public String getSerieSasiu() {
	return serieSasiu;
}
public void setSerieSasiu(String serieSasiu) {
	this.serieSasiu = serieSasiu;
}
public String isFunctioneaza() {
	return functioneaza;
}
public void setFunctioneaza(String functioneaza) {
	this.functioneaza = functioneaza;
}
@Override
public String toString() {
	return "Cars [Marca=" + Marca + ", Model=" + Model + ", dataFabricare=" + dataFabricare + ", Sofer=" + Sofer
			+ ", nrKm=" + nrKm + ", serieSasiu=" + serieSasiu + ", functioneaza=" + functioneaza + "]";
}
}
