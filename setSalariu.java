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

public class setSalariu {
	static Connection conn = null;
	static Statement stmt = null;

	public static void start() throws SQLException {
		conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
		Stage window = new Stage();
		window.setTitle("Modificare Salariu");
		window.setResizable(false);
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label marcaLabel = new Label("Sofer:");
		GridPane.setConstraints(marcaLabel, 0, 0);
		TextField marcaInput = new TextField();
		marcaInput.setPromptText("giga@yahoo.com");
		GridPane.setConstraints(marcaInput, 1, 0);

		Label nriLabel = new Label("Salariul in lei/ora:");
		GridPane.setConstraints(nriLabel, 0, 1);
		TextField nriInput = new TextField();
		nriInput.setPromptText("22");
		GridPane.setConstraints(nriInput, 1, 1);
	Button add=new Button("Modifica");
		
		
		GridPane.setConstraints(add, 1, 2);
		grid.getChildren().addAll(marcaLabel, marcaInput, nriLabel, nriInput, add);
		add.setMinSize(90, 25);
		add.setOnAction(e -> {

			try {
				stmt = (Statement) conn.createStatement();
				String query1 = "update Soferi set Lei_ora='"+Integer.parseInt(nriInput.getText())+"'" + "where Mail like '"+marcaInput.getText()+"' ";
				stmt.executeUpdate(query1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			mesajEroareAngajat.display("Salariul a fost modificat cu suuces");
		window.close();
		});
		Scene scene = new Scene(grid, 300, 600);
		window.setScene(scene);
		window.show();

	}
}
