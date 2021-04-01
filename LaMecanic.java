package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LaMecanic {
	static Connection conn = null;
	   static Statement stmt = null;
	public static void start(String mail) throws SQLException
	{
	Stage window=new Stage();
	window.setTitle("gdc22");
	window.setResizable(false);
	conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
	Button vizualizeaza=new Button("Vizualizeaza");
	Button add=new Button("Repara");
	add.setOnAction(e->{
	try {
		addReparatieMecanic.start(mail);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	});
	 vizualizeaza.setOnAction(e->{
		 try {
			VizualizeazaReparatiiMecanic.start(mail);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 });
	vizualizeaza.setMinSize(90,25);
	add.setMinSize(90,25);
	VBox meniuPrincipal=new VBox();
	meniuPrincipal.getChildren().addAll(vizualizeaza,add);
	meniuPrincipal.setAlignment(Pos.CENTER);
	meniuPrincipal.setSpacing(50);
	BorderPane principal=new BorderPane();
	principal.setCenter(meniuPrincipal);
	Scene scenaPrincipala=new Scene(principal,300,500);
	window.setScene(scenaPrincipala);
	window.show();
}
}
