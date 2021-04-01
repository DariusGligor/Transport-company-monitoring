package com.jenkov.javafx.layouts;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Login {
public static void log()
{
	Stage window = new Stage();
	window.setTitle("Login");
	GridPane grid = new GridPane();
	grid.setPadding(new Insets(10, 10, 10, 10));
	grid.setVgap(8);
	grid.setHgap(10);
	Label numeLabel = new Label("Mail:");
	GridPane.setConstraints(numeLabel, 0, 0);
	TextField numeInput = new TextField();
	numeInput.setPromptText("exemplu@yahoo.com");
	GridPane.setConstraints(numeInput, 1, 0);
	
	Label pLabel = new Label("Parola");
	GridPane.setConstraints(pLabel, 0, 1);
	PasswordField pInput = new PasswordField();
	pInput.setPromptText("parola");
	GridPane.setConstraints(pInput, 1, 1);
	Button log = new Button("Login");
	log.setMinSize(100,25);
	GridPane.setConstraints(log, 1, 3);
	Button cont = new Button("Inregistreaza-te");
	cont.setMinSize(90,25);
	GridPane.setConstraints(cont, 1, 5);
	grid.getChildren().addAll(numeLabel,numeInput,pInput,pLabel,log,cont);
	log.setOnAction(e->System.out.println(pInput.getText()));
cont.setOnAction(e->Inregistreaza.inr());
	Scene scene = new Scene(grid, 300, 600);
	window.setScene(scene);
	window.show();
	}
}
