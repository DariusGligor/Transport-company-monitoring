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

public class LaSoferi {
	static Connection conn = null;
	static Statement stmt = null;
		public static void start(String mail) throws SQLException
		{
			Stage window=new Stage();
			window.setTitle("gdc22");
			window.setResizable(false);
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
			Button soferi=new Button("Soferi");
			Button salariu=new Button("Salariu");
			salariu.setMinSize(90, 25);
	salariu.setOnAction(e->{
		try {
			setSalariu.start();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
			Button Masina=new Button("Masina");
			Masina.setOnAction(e->{
				try {
					AtribuieMasina.start();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			Masina.setMinSize(90, 25);
			Button curse=new Button("Curse");
			 soferi.setOnAction(e->{
				try {
					VizualizareSoferi.start(mail);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			});
			 curse.setOnAction(e->{
				VizualizareCurseAd.start(mail);
			 });
			soferi.setMinSize(90,25);
			curse.setMinSize(90,25);
			VBox meniuPrincipal=new VBox();
			meniuPrincipal.getChildren().addAll(soferi,curse,salariu,Masina);
			meniuPrincipal.setAlignment(Pos.CENTER);
			meniuPrincipal.setSpacing(50);
			BorderPane principal=new BorderPane();
			principal.setCenter(meniuPrincipal);
			Scene scenaPrincipala=new Scene(principal,300,500);
			window.setScene(scenaPrincipala);
			window.show();
			}
}
