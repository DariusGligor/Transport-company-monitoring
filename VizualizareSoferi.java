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

public class VizualizareSoferi {
	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail) throws SQLException
	   {  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
		   Stage window=new Stage();
			window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
			window.setTitle("Soferi");
			window.setResizable(false);
			Button buttonClose=new Button("Close");
			buttonClose.setMinSize(90, 25);
			buttonClose.setOnAction(e->{
				window.close();
			});
			TableColumn<Sofer,String>mailcol=new TableColumn<>("Mail");
			mailcol.setMinWidth(200);
			mailcol.setCellValueFactory(new PropertyValueFactory<>("mail"));
			
			TableColumn<Sofer,String>numecol=new TableColumn<>("Nume");
			numecol.setMinWidth(200);
			numecol.setCellValueFactory(new PropertyValueFactory<>("Nume"));
			
			
			TableColumn<Sofer,String>prenumecol=new TableColumn<>("Prenume");
			prenumecol.setMinWidth(200);
			prenumecol.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
			
			
			TableColumn<Sofer,String>datacol=new TableColumn<>("Data de nastere");
			datacol.setMinWidth(200);
			datacol.setCellValueFactory(new PropertyValueFactory<>("dataNastere"));
			
			
			TableColumn<Sofer,String>masinacol=new TableColumn<>("Seria masinii");
			masinacol.setMinWidth(200);
			masinacol.setCellValueFactory(new PropertyValueFactory<>("serie_masina"));
			
			
			
			TableColumn<Sofer,String>nrkmcol=new TableColumn<>("Numarul de km");
			nrkmcol.setMinWidth(200);
			nrkmcol.setCellValueFactory(new PropertyValueFactory<>("nr_km"));
			
			
			TableColumn<Sofer,String>nrorecol=new TableColumn<>("Numarul de ore");
			nrorecol.setMinWidth(200);
			nrorecol.setCellValueFactory(new PropertyValueFactory<>("nr_ore"));
			
			TableColumn<Sofer,Integer>leiorecol=new TableColumn<>("Lei/km");
			leiorecol.setMinWidth(200);
			leiorecol.setCellValueFactory(new PropertyValueFactory<>("bani"));
			
			TableView<Sofer> table12 =new TableView<>();
			table12.setItems(getMasina(mail));
			table12.getColumns().addAll(mailcol,numecol,prenumecol,datacol,masinacol,nrkmcol,nrorecol,leiorecol);
			VBox meniu=new VBox();
			meniu.getChildren().add(buttonClose);
			meniu.setAlignment(Pos.CENTER);
			BorderPane principal=new BorderPane();
			principal.setBottom(meniu);
			principal.setCenter(table12);
			Scene scene=new Scene(principal,1605,800);
			window.setScene(scene);
			window.showAndWait();
			}
		private  static ObservableList<Sofer> getMasina(String mail)
		{

			
			ObservableList<Sofer>a =FXCollections.observableArrayList();
		  try{  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
	
				// ArrayList<oreLucrate> a=new ArrayList<>();
				// Masina m=new Masina("Vw","Passat","AB22NFC",161000,2017);
				 
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			      String sql = "SELECT *  FROM Soferi";
			      ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			 
			      while(rs.next()){
			         //Retrieve by column name
			         String maill=rs.getString("Mail");
			         String nume=rs.getString("Nume");
			         String prenume=rs.getString("Prenume");
			         String data=rs.getString("Data_nastere");
			         int nrkm=rs.getInt("Numar_km");
			         int nrore=rs.getInt("Numar_ore");
			         int leiora=rs.getInt("Lei_ora");
			         String masina=rs.getString("Masina");
			       //  Angajat ang=new Angajat(nume,Prenume,datan,dataa,pozitie,ani,vechime,cnp);
			        Sofer sof =new Sofer(nume,prenume,data,nrkm,nrore,leiora,maill,masina);
			           a.add(sof);
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
