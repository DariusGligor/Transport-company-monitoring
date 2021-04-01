package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Administrator {
	Connection conn = null;
	public void start(Stage primaryStage) throws Exception {
		Stage window;
	window=primaryStage;
	window.setTitle("gdc22");
	window.setResizable(false);
	Login.log();
	conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
	Button closeButton=new Button("Close");
	Button addMembru=new Button("AddSofer");
	Button addMasina=new Button("AddMasina");
	Button masini=new Button("Masini");
	Button angajati=new Button("Soferi");
	Button asociere=new Button("Asociere");
	Button back=new Button("Back");
	masini.setMinSize(90,25);
	asociere.setMinSize(90, 25);
	angajati.setMinSize(90,25);
	closeButton.setMinSize(90,25);
	addMembru.setMinSize(90,25);
	addMasina.setMinSize(90,25);
	back.setMinSize(90,25);
	window.setOnCloseRequest(e->{
	e.consume();
	CloseProgram(window);
	});
	closeButton.setOnAction(e->{Boolean answer=CloseConfirm.display("INCHIDERE", "Esti sigur ca vrei sa inchizi?");
	if(answer)
	window.close();// sau CloseProgram(window)
	});
	VBox meniuPrincipal=new VBox();
	meniuPrincipal.getChildren().addAll(addMembru,addMasina,masini,angajati,closeButton,asociere);
	meniuPrincipal.setAlignment(Pos.CENTER);
	meniuPrincipal.setSpacing(50);
	BorderPane principal=new BorderPane();
	principal.setCenter(meniuPrincipal);
	Scene scenaPrincipala=new Scene(principal,300,500);
	window.setScene(scenaPrincipala);
	window.show();
}
private void CloseProgram(Stage window)
{Boolean answer=CloseConfirm.display("title", "Esti sigur ca vrei sa inchizi?");
if(answer)
window.close();
}
}
