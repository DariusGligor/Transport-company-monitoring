package com.jenkov.javafx.layouts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VizualizareCurseAd {
	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail)
	   { 
		    Stage window=new Stage();
			window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
			window.setTitle("Curse");
			window.setResizable(false);
			Button buttonClose=new Button("Close");
			buttonClose.setMinSize(90, 25);
			buttonClose.setOnAction(e->{
				window.close();
			});
			TableColumn<oreLucrate,String>mailcol=new TableColumn<>("Mail");
			mailcol.setMinWidth(200);
			mailcol.setCellValueFactory(new PropertyValueFactory<>("mail"));
			
			
			TableColumn<oreLucrate,String>marcacol=new TableColumn<>("Data");
			marcacol.setMinWidth(200);
			marcacol.setCellValueFactory(new PropertyValueFactory<>("Data"));
			
			TableColumn<oreLucrate,Integer>kmcol=new TableColumn<>("Numar de km");
			kmcol.setMinWidth(200);
			kmcol.setCellValueFactory(new PropertyValueFactory<>("nrKm"));
			
			TableColumn<oreLucrate,Integer>orecol=new TableColumn<>("Numar de ore");
			orecol.setMinWidth(200);
			orecol.setCellValueFactory(new PropertyValueFactory<>("nrOre"));
			
			TableColumn<oreLucrate,Integer>totalcol=new TableColumn<>("Salariu");
			totalcol.setMinWidth(200);
			totalcol.setCellValueFactory(new PropertyValueFactory<>("total"));
			
			TableView<oreLucrate> table12 =new TableView<>();
			 table12.setItems(getMasina(mail));
			table12.getColumns().addAll(mailcol,marcacol,orecol,kmcol,totalcol);

			VBox meniu=new VBox();
			meniu.getChildren().add(buttonClose);
			meniu.setAlignment(Pos.CENTER);
			BorderPane principal=new BorderPane();
			principal.setBottom(meniu);
			principal.setCenter(table12);
			Scene scene=new Scene(principal,1005,800);
			window.setScene(scene);
			window.showAndWait();
			}
		private  static ObservableList<oreLucrate> getMasina(String mail)
		{

			
			ObservableList<oreLucrate>a =FXCollections.observableArrayList();
		  try{  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
	
				// ArrayList<oreLucrate> a=new ArrayList<>();
				// Masina m=new Masina("Vw","Passat","AB22NFC",161000,2017);
				 
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			      String sql = "SELECT * FROM LucratSoferi";
			      ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			      int s=0;
			      while(rs.next()){
			         //Retrieve by column name
			         int nrkm = rs.getInt("Numar_km");
			         int nrore = rs.getInt("Numar_ore");
			         int sal=rs.getInt("Lei_km_ore");
			         String data=rs.getString("Data");
			         String maill=rs.getString("Mail");
			        s=s+nrkm*sal+nrore*30;
			       //  Angajat ang=new Angajat(nume,Prenume,datan,dataa,pozitie,ani,vechime,cnp);
			         oreLucrate ore=new oreLucrate(data,nrkm,nrore,sal,s,maill);
			           a.add(ore);
			      }
			      rs.close();
			      
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception ea){
			      //Handle errors for Class.forName
			      ea.printStackTrace();
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
			      }
			   }//end try
			   System.out.println("Goodbye!");
		return a;
			}
		}