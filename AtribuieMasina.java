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

public class AtribuieMasina {
	static Connection conn = null;
	static Statement stmt = null;

	public static void start() throws SQLException {
		conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
		Stage window = new Stage();
		window.setTitle("Asocierea unei masini cu un sofer");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		window.setResizable(false);
		Label marcaLabel = new Label("Sofer:");
		GridPane.setConstraints(marcaLabel, 0, 0);
		TextField marcaInput = new TextField();
		marcaInput.setPromptText("giga@yahoo.com");
		GridPane.setConstraints(marcaInput, 1, 0);

		Label nriLabel = new Label("Masina:");
		GridPane.setConstraints(nriLabel, 0, 1);
		TextField nriInput = new TextField();
		nriInput.setPromptText("22");
		GridPane.setConstraints(nriInput, 1, 1);
	Button add=new Button("Modifica");
		
		
		GridPane.setConstraints(add, 1, 2);
		grid.getChildren().addAll(marcaLabel, marcaInput, nriLabel, nriInput, add);
		add.setMinSize(90, 25);
		add.setOnAction(e -> {

			try {stmt = conn.createStatement();
       	 String query3 = "update Carss set Sofer='nu are sofer'" + "where Sofer like '"+marcaInput.getText()+"' ";
       	 stmt.executeUpdate(query3);
				stmt = (Statement) conn.createStatement();
				String query1 = "update Soferi set Masina='"+nriInput.getText()+"'" + "where Mail like '"+marcaInput.getText()+"' ";
				stmt.executeUpdate(query1);
				String query2 = "update Carss set Sofer='"+marcaInput.getText()+"'" + "where Serie_Sasiu like '"+nriInput.getText()+"'  ";
				stmt.executeUpdate(query2);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mesajEroareAngajat.display("Asocierea masinii cu soferul a fost efectuata cu succes");
			window.close();
		});
		Scene scene = new Scene(grid, 300, 600);
		window.setScene(scene);
		window.show();

	}
}