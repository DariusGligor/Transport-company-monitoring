package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Inregistreaza {
	  static Connection conn = null;
	   static Statement stmt = null;
	   static Statement stmt1 = null;
	   static Statement stmt2 = null;
	public static void inr() {
		Stage window = new Stage();
		window.setTitle("Adauga un angajat");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);
		Label nameLabel = new Label("Nume:");
		GridPane.setConstraints(nameLabel, 0, 0);
		TextField nameInput = new TextField();
		nameInput.setPromptText("Nume");
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label prenumeLabel = new Label("Prenume:");
		GridPane.setConstraints(prenumeLabel, 0, 1);
		TextField prenumeInput = new TextField();
		prenumeInput.setPromptText("Prenume");
		GridPane.setConstraints(prenumeInput, 1, 1);

		Label mailLabel = new Label("Mail:");
		GridPane.setConstraints(mailLabel, 0, 2);
		TextField mailInput = new TextField();
		mailInput.setPromptText("mail");
		GridPane.setConstraints(mailInput, 1, 2);
		Label pLabel = new Label("Parola");
		GridPane.setConstraints(pLabel, 0, 3);
		PasswordField pInput = new PasswordField();
		pInput.setPromptText("parola");
		GridPane.setConstraints(pInput, 1, 3);

		Label copLabel = new Label("Confirmare parola:");
		GridPane.setConstraints(copLabel, 0, 4);
		PasswordField copInput = new PasswordField();
		copInput.setPromptText("confirmareparola");
		GridPane.setConstraints(copInput, 1, 4);

		Label datan = new Label("Data Nastere:");
		GridPane.setConstraints(datan, 0, 5);
		TextField dataInput = new TextField();
		dataInput.setPromptText("22/10/2000");
		GridPane.setConstraints(dataInput, 1, 5);
	
		Label pozitieLabel = new Label("Pozitie:");
		GridPane.setConstraints(pozitieLabel, 0, 6);

		ChoiceBox<String> lista = new ChoiceBox<>();
		lista.setMinSize(100, 25);
		lista.getItems().add("Administrator");
		lista.getItems().add("Sofer");
		lista.getItems().add("Mecanic");
		GridPane.setConstraints(lista, 1, 6);
		Button add = new Button("Creaza");
		add.setMinSize(100, 25);
		GridPane.setConstraints(add, 1, 7);
		grid.getChildren().addAll(nameLabel, nameInput, prenumeLabel, prenumeInput, lista, mailInput, mailLabel,
				pozitieLabel, add, copLabel, copInput, pLabel, pInput,datan,dataInput);
		add.setOnAction(e -> {
			boolean ok = true;
			if (verificBox(lista) == false) {
				ok = false;
				mesajEroareAngajat.display("Nu ati selectat pozitia");
			} else if (verificN(nameInput.getText()) == false) {
				ok = false;
				mesajEroareAngajat.display("Numele a fost introdus gresit,acesta trebuie sa contina o litera mare");
			} else if (verificN(prenumeInput.getText()) == false) {
				ok = false;
				mesajEroareAngajat.display("Prenumele a fost introdus gresit,acesta trebuie sa contina o litera mare");
			} else if (validaremail(mailInput.getText()) == false) {
				ok = false;
				mesajEroareAngajat.display(
						"Mail-ul trebuie sa contine litere mici urmate de  cifre si/sau un punct plus terminatia @yahoo.com");
			} else if (validareparola(pInput.getText(), copInput.getText()) == false) {
				ok = false;
				mesajEroareAngajat.display(
						"Parola trebuie sa contina o litera mare urmata de o combinatie de litere si/sau cifre");
			}
			if (ok == true) {
				try{
				

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
				      System.out.println("Connected database successfully...");
				      
				      //STEP 4: Execute a query
				      System.out.println("Inserting records into the table...");
				      stmt = conn.createStatement();
				      
				      String sql = "INSERT INTO Loginn " +
				                   "VALUES ('"+mailInput.getText()+"', '"+pInput.getText()+"','"+ nameInput.getText()+"', '"+prenumeInput.getText()+"', '"+lista.getValue()+"')";
				      stmt.executeUpdate(sql);
				      String aaa=lista.getValue();
				     if(aaa.equals("Sofer"))
				     {
				     int nrkm=0;
				     int nrore=0;
				     int nrolei=0;
				     String Masina="nu are";
				    	 String sql1 = "INSERT INTO Soferi " +
				                   "VALUES ('"+mailInput.getText()+"', '"+nameInput.getText()+"','"+ prenumeInput.getText()+"' , '"+dataInput.getText()+"', "+nrkm+", "+nrore+",  "+nrolei+",'"+Masina+"')";
				    	 stmt1 = conn.createStatement();
				    	 stmt1.executeUpdate(sql1);
				     }
				     else if (aaa.equals("Mecanic"))
				     {int salariu=0;
				    	 String sql2 = "INSERT INTO Mecanici " +
			                   "VALUES ('"+mailInput.getText()+"', '"+nameInput.getText()+"','"+ prenumeInput.getText()+"' , '"+dataInput.getText()+"',"+salariu+")";
			    	 stmt2 = conn.createStatement();
			    	 stmt2.executeUpdate(sql2);
				    	 
				     }
				      System.out.println("Inserted records into the table...");

				   }catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception x){
				      //Handle errors for Class.forName
				      x.printStackTrace();
				   }finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            conn.close();
				      }catch(SQLException se){
				      }// do nothing
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   System.out.println("Goodbye!");
				mesajEroareAngajat.display("Contul a fost creat cu succes");
				window.close();
			}
		});
		Scene scene = new Scene(grid, 300, 600);
		window.setResizable(false);
		window.setScene(scene);
		window.show();
	}

	public static boolean verificBox(ChoiceBox<String> a) {
		if (a.getValue() == null)
			return false;
		else
			return true;
	}

	public static boolean verificN(String a) {
		Pattern p = Pattern.compile("[A-Z]{1}[a-zA-Z]{1,}");
		Matcher m = p.matcher(a);
		boolean verificNume = m.matches();
		return verificNume;
	}

	public static boolean validaremail(String mail) {
		Pattern p = Pattern.compile("[a-zA-Z0-9.]+@yahoo.com");
		Matcher m = p.matcher(mail);
		boolean b = m.matches();
		return b;
	}

	public static boolean validareparola(String a, String bb) {
		Pattern p = Pattern.compile("[A-Z]+[a-zA-Z0-9]*");
		Matcher m = p.matcher(a);
		boolean b = m.matches();
		if (b == true&&(bb.equals(a)==true))
			return true;
		else
			return false;
	}
}
