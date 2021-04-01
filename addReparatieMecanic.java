package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class addReparatieMecanic {
	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail) throws SQLException
	   {conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
		   Stage window = new Stage();
			window.setTitle("Adauga ore");
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			window.setResizable(false);
			Label nrLabel = new Label("Masina:");
			GridPane.setConstraints(nrLabel, 0, 0);
			TextField numarInput = new TextField();
			numarInput.setPromptText("seriesasiu");
			GridPane.setConstraints(numarInput, 1, 0);
			
			Label oreLabel = new Label("Costul reaparatiei");
			GridPane.setConstraints(oreLabel, 0, 1);
			TextField nroreInput = new TextField();
			nroreInput.setPromptText("200lei");
			GridPane.setConstraints(nroreInput, 1, 1);
			 
			
			Label dataLabel = new Label("Data:");
			GridPane.setConstraints(dataLabel, 0, 2);
			TextField dataInput = new TextField();
			dataInput.setPromptText("13/10/2000");
			GridPane.setConstraints(dataInput, 1, 2);
			
			Button add = new Button("Adauga");
			add.setMinSize(100, 25);
			GridPane.setConstraints(add, 1, 3);
			grid.getChildren().addAll(nrLabel,numarInput,oreLabel,nroreInput,dataLabel,dataInput,add);
			add.setOnAction(e->{
				 try {
					stmt = conn.createStatement();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			String sql1 =  "INSERT INTO Reparatii " +
	    	    		  "VALUES ('"+mail+"','"+dataInput.getText()+"','"+numarInput.getText()+"', "+Integer.parseInt(nroreInput.getText())+")";
				try {
					stmt.executeUpdate(sql1);
					 String query2 = "update Carss set Stare_de_functionare='Buna' " + "where Serie_Sasiu like '"+numarInput.getText()+"'";
					stmt.executeUpdate(query2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mesajEroareAngajat.display("Reparatia a fost efectuata cu succes!");
				window.close();
			});
			Scene scenaPrincipala=new Scene(grid,300,500);
			window.setScene(scenaPrincipala);
			window.show();
	   }
}
