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

public class AdaugaMasina {
	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail) throws SQLException
	   {
		   Stage window = new Stage();
		   conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
			window.setTitle("Adauga masina");
			GridPane grid = new GridPane();
			window.setResizable(false);
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			
			Label nrLabel = new Label("Marca");
			GridPane.setConstraints(nrLabel, 0, 0);
			TextField numarInput = new TextField();
			numarInput.setPromptText("marca");
			GridPane.setConstraints(numarInput, 1, 0);
			
			Label modelLabel = new Label("Model");
			GridPane.setConstraints(modelLabel, 0, 1);
			TextField modelInput = new TextField();
			modelInput.setPromptText("model");
			GridPane.setConstraints(modelInput, 1, 1);
			
			Label dataLabel = new Label("Data de fabricare");
			GridPane.setConstraints(dataLabel, 0, 2);
			TextField dataInput = new TextField();
			dataInput.setPromptText("22/10/2000");
			GridPane.setConstraints(dataInput, 1, 2);
			
			Label soferLabel = new Label("Soferul");
			GridPane.setConstraints(soferLabel, 0, 3);
			TextField soferInput = new TextField();
			soferInput.setPromptText("sofer@yahoo.com");
			GridPane.setConstraints(soferInput, 1, 3);
			
			Label nrkmLabel = new Label("Numarul de km");
			GridPane.setConstraints(nrkmLabel, 0, 4);
			TextField nrkmInput = new TextField();
			nrkmInput.setPromptText("100000");
			GridPane.setConstraints(nrkmInput, 1, 4);
			
		
		
			Label serieLabel = new Label("Seria de sasiu");
			GridPane.setConstraints(serieLabel, 0, 5);
			TextField serieInput = new TextField();
			serieInput.setPromptText("serie");
			GridPane.setConstraints(serieInput, 1, 5);
			
			
			Label functionareLabel = new Label("Stare de functionare:");
			GridPane.setConstraints(functionareLabel, 0, 6);
			TextField functionareInput = new TextField();
			functionareInput.setPromptText("Buna/Rea");
			GridPane.setConstraints(functionareInput, 1, 6);
			
			
			Button add = new Button("Adauga");
			add.setMinSize(100, 25);
			GridPane.setConstraints(add, 1, 7);
			grid.getChildren().addAll(nrLabel,numarInput, modelLabel,modelInput,dataLabel,dataInput,soferLabel,soferInput,nrkmLabel,nrkmInput,serieLabel,serieInput,functionareLabel,functionareInput,add);
	  add.setOnAction(e->{
		  
	         try {
	        	 stmt = conn.createStatement();
	        	 String query2 = "update Carss set Sofer='nu are sofer'" + "where Sofer like '"+soferInput.getText()+"' ";
	        	 stmt.executeUpdate(query2);
	        	 String sql = "INSERT INTO Carss " +
	                     "VALUES ('"+serieInput.getText()+"', '"+numarInput.getText()+"','"+modelInput.getText()+"','"+dataInput.getText()+"',"+Integer.parseInt(nrkmInput.getText())+",'"+soferInput.getText()+"','" +functionareInput.getText()+"')";
	        	 String query1 = "update Soferi set Masina='"+ serieInput.getText()+"'" + "where Mail like '"+soferInput.getText()+"' ";
	        	 stmt.executeUpdate(sql);
	        	 stmt.executeUpdate(query1);
	        	 mesajEroareAngajat.display("Masina a fost adaugata cu succes");
	        	 window.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
	  }); 
	  Scene scenaPrincipala=new Scene(grid,300,500);
		window.setScene(scenaPrincipala);
		window.show();
	   }
}
