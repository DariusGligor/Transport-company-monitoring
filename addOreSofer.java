package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class addOreSofer {
	static Connection conn = null;
	   static Statement stmt = null;
	   static Statement stmt2 = null;
	   public static void start(String mail) throws SQLException {
		   Stage window = new Stage();
		   conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=sa;password=LPX525qlr;");
			window.setTitle("Adauga ore");
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
			grid.setVgap(8);
			grid.setHgap(10);
			window.setResizable(false);
			Label nrLabel = new Label("Numar de km:");
			GridPane.setConstraints(nrLabel, 0, 0);
			TextField numarInput = new TextField();
			numarInput.setPromptText("numarul de km");
			GridPane.setConstraints(numarInput, 1, 0);
			
			Label oreLabel = new Label("Numar de ore:");
			GridPane.setConstraints(oreLabel, 0, 1);
			TextField nroreInput = new TextField();
			nroreInput.setPromptText("numarul de ore");
			GridPane.setConstraints(nroreInput, 1, 1);
			 

			Label dataLabel = new Label("Data:");
			GridPane.setConstraints(dataLabel, 0, 2);
			TextField dataInput = new TextField();
			dataInput.setPromptText("13/10/2000");
			GridPane.setConstraints(dataInput, 1, 2);
			System.out.print(mail);
			Button add = new Button("Adauga");
			add.setMinSize(100, 25);
			GridPane.setConstraints(add, 1, 3);
			grid.getChildren().addAll(nrLabel,numarInput,oreLabel,nroreInput,dataLabel,dataInput,add);
			add.setOnAction(e->{
			
				
				 
				try {
					System.out.print(mail);
					System.out.print("aaaaaaaaaaaaaaaaaaaaaaa");
					
					stmt = conn.createStatement();
					String sql2 =   "SELECT * FROM Carss where Sofer like '"+mail+"'";
				  ResultSet rs2;
					rs2 = stmt.executeQuery(sql2);
					int nr=0;
					while(rs2.next())
					{nr=rs2.getInt("Numar_km");}
				
			String nri=numarInput.getText();
		int nrii=Integer.parseInt(nri);
		    	if(nr/5000!=(nr+nrii)/5000) {mesajEroareAngajat.display("Aveti nevoie de o revizie, se recomanda ducerea masinii intr-un service");
		//!!!!!!scriere la mecanici;
		    	 String query2 = "update Carss set Stare_de_functionare='Proasta' " + "where Sofer like '"+mail+"'";
		         try {
					stmt.executeUpdate(query2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	}
		    	nr=nr+nrii;
		    	stmt = (Statement) conn.createStatement();
		         String query1 = "update Soferi set Numar_km='"+nr+"' " + "where Mail like '"+mail+"'";
		         stmt.executeUpdate(query1);
		         String sql3 =   "SELECT Numar_km FROM Soferi where Mail like '"+mail+"'";
		         ResultSet rs3;
		         rs3 = stmt.executeQuery(sql3);
		         while(rs3.next())
					 {nr= rs3.getInt("Numar_km");}
					 nr=nr+nrii;
		         String query2 = "update Carss set Numar_km='"+nr+"' " + "where Sofer like '"+mail+"'";
		         stmt.executeUpdate(query2);
				try{
		    	      //STEP 2: Register JDBC driver
		    	      //STEP 3: Open a connection
		    	     System.out.println("Connecting to a selected database...");
		    	     conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
		    	     System.out.println("Connected database successfully...");
		    	      
		    	     //STEP 4: Execute a query
		    	     System.out.println("Creating statement...");
		    	     stmt = conn.createStatement();

		    	     String sql =   "SELECT * FROM Soferi where Mail like '"+mail+"'";
		    	      
		    	     ResultSet rs = stmt.executeQuery(sql);
		    	     int leiora=0;
		    	     while(rs.next())
		    	   {leiora= rs.getInt("Lei_ora");
		    	         }
		    	     String sql1 =  "INSERT INTO LucratSoferi " +
								"VALUES ('"+mail+"','"+dataInput.getText()+"',"+Integer.parseInt(numarInput.getText())+", "+Integer.parseInt(nroreInput.getText())+","+leiora+")";
							try {
								stmt.executeUpdate(sql1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		    	     try {
							stmt = conn.createStatement();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		    	     
		    	     System.out.println(leiora);
	    	
							
						
		    	     int nr1=0;
		    	     String sql4 =   "SELECT Numar_ore FROM Soferi where Mail like '"+mail+"'";
			         ResultSet rs4;
			         rs4 = stmt.executeQuery(sql4);
			         while(rs4.next())
						 {nr1= rs4.getInt("Numar_ore");}
		    	     String nro=nroreInput.getText();
		    	     int nroo=Integer.parseInt(nro);
		    	     nr1=nr1+nroo;
		    	     String query21 = "update Soferi set Numar_ore='"+nr1+"' " + "where Mail like '"+mail+"'";
		        stmt.executeUpdate(query21);

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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mesajEroareAngajat.display("Cursa a fost adaugata cu succes");
				window.close();
				
				
				
				
				});
			Scene scenaPrincipala=new Scene(grid,300,500);
			window.setScene(scenaPrincipala);
			window.show();
	   } 
}