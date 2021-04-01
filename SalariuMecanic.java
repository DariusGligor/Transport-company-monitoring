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

public class SalariuMecanic {
	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail) throws SQLException
	   {
		   Stage window = new Stage();
		   conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
			window.setTitle("SalariuMecanic");
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			window.setResizable(false);
			Label nrLabel = new Label("Mecanic");
			GridPane.setConstraints(nrLabel, 0, 0);
			TextField numarInput = new TextField();
			numarInput.setPromptText("3000");
			GridPane.setConstraints(numarInput, 1, 0);
			
			Label modelLabel = new Label("Salariul in lei");
			GridPane.setConstraints(modelLabel, 0, 1);
			TextField modelInput = new TextField();
			modelInput.setPromptText("model");
			GridPane.setConstraints(modelInput, 1, 1);

			Button add = new Button("Adauga");
			add.setMinSize(100, 25);
			GridPane.setConstraints(add, 1, 2);
			grid.getChildren().addAll(nrLabel,numarInput, modelLabel,add,modelInput);
	  add.setOnAction(e->{
		  
	         try {
	        	 stmt = conn.createStatement();
	        	 String query2 = "update Mecanici set Salariu='"+Integer.parseInt(modelInput.getText())+"'" + "where Mail like '"+numarInput.getText()+"' ";
	        	 stmt.executeUpdate(query2);
	        	 mesajEroareAngajat.display("Salariu a fost modificat cu succes");
	        	 window.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
	  }); 
	  Scene scenaPrincipala=new Scene(grid,300,500);
			window.setScene(scenaPrincipala);
			window.show();
}}
