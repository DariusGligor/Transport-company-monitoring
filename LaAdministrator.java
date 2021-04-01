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

public class LaAdministrator {
	static Connection conn = null;
	static Statement stmt = null;

	public static void start(String mail) throws SQLException {
		Stage window = new Stage();
		window.setTitle("gdc22");
		window.setResizable(false);
		conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
		Button masini = new Button("Masini");
		masini.setOnAction(e->{
			try {
				LaMasini.start(mail);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		masini.setMinSize(100, 25);
		Button mecanici = new Button("Mecanici");
		mecanici.setOnAction(e->{
			try {
				LaMecanici.start(mail);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	    Button soferi =new Button("Soferi");
	    
	    soferi.setOnAction(e->{
	    	try {
				LaSoferi.start(mail);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    });
		masini.setMinSize(90, 25);
		mecanici.setMinSize(90, 25);
		soferi.setMinSize(90, 25);
		VBox meniuPrincipal = new VBox();
		meniuPrincipal.getChildren().addAll(masini,mecanici,soferi);
		meniuPrincipal.setAlignment(Pos.CENTER);
		meniuPrincipal.setSpacing(50);
		BorderPane principal = new BorderPane();
		principal.setCenter(meniuPrincipal);
		Scene scenaPrincipala = new Scene(principal, 300, 500);
		window.setScene(scenaPrincipala);
		window.show();
	}
}
