package com.jenkov.javafx.layouts;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.sql.Connection;
public class TextExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Connection conn = null;
    Statement stmt = null;
    public void start(Stage primaryStage) throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
        Stage window = new Stage();
    	window.setTitle("Login");
    	window.setResizable(false);
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
    log.setOnAction(e->{
    	try{
    	      //STEP 2: Register JDBC driver
    	      //STEP 3: Open a connection
    	      System.out.println("Connecting to a selected database...");
    	      conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
    	      System.out.println("Connected database successfully...");
    	      
    	      //STEP 4: Execute a query
    	      System.out.println("Creating statement...");
    	      stmt = conn.createStatement();

    	      String sql = "SELECT Tip FROM Loginn where Mail like '"+numeInput .getText()+"' and Parola like '"+pInput .getText()+"'";
    	      ResultSet rs = stmt.executeQuery(sql);
    	      //STEP 5: Extract data from result set
    	      if(rs.next()) {System.out.println("Contul exista");
    	      String tip=rs.getString("Tip");
    	      System.out.println(tip); 
    	      if(tip.equals("Sofer")) {
    	    	  System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
    	    	  LaSofer.start(numeInput.getText());
    	    	  window.close();
    	      }
    	      else if (tip.equals("Mecanic")) {
    	    	  System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
    	    	  LaMecanic.start(numeInput.getText());
    	    	  window.close();
    	      }
    	      else {
    	    	  System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAa");
    	    	  LaAdministrator.start(numeInput.getText());
    	    	  window.close();
    	      }}
    	      else {
    	    	  mesajEroareAngajat.display("Contul acesta nu exista");
    	      }
    	 
    	      rs.close();
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
    });
    	Scene scene = new Scene(grid, 300, 600);
    	window.setScene(scene);
    	window.show();
    }
}