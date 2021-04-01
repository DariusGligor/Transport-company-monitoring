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

public class VizualizareReparatiiAdministrator {

	static Connection conn = null;
	   static Statement stmt = null;
	   public static void start(String mail) throws SQLException
	   {  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
		   Stage window=new Stage();
			window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
			window.setTitle("Reparatii");
			window.setResizable(false);
			Button buttonClose=new Button("Close");
			buttonClose.setMinSize(90, 25);
			buttonClose.setOnAction(e->{
				window.close();
			});
			TableColumn<Reparatii,String>mailacol=new TableColumn<>("Mecanic");
			mailacol.setMinWidth(200);
			mailacol.setCellValueFactory(new PropertyValueFactory<>("mail"));
			
			TableColumn<Reparatii,String>marcacol=new TableColumn<>("Data");
			marcacol.setMinWidth(200);
			marcacol.setCellValueFactory(new PropertyValueFactory<>("data"));
			
			TableColumn<Reparatii,String>kmcol=new TableColumn<>("Seria Masinii");
			kmcol.setMinWidth(200);
			kmcol.setCellValueFactory(new PropertyValueFactory<>("serieMasina"));
			
			TableColumn<Reparatii,Integer>orecol=new TableColumn<>("Costul reparatiei in lei");
			orecol.setMinWidth(200);
			orecol.setCellValueFactory(new PropertyValueFactory<>("costulInLei"));
			
			
			TableView<Reparatii> table12 =new TableView<>();
			table12.setItems(getMasina(mail));
			table12.getColumns().addAll(mailacol,marcacol,orecol,kmcol);
			VBox meniu=new VBox();
			meniu.getChildren().add(buttonClose);
			meniu.setAlignment(Pos.CENTER);
			BorderPane principal=new BorderPane();
			principal.setBottom(meniu);
			principal.setCenter(table12);
			Scene scene=new Scene(principal,805,800);
			window.setScene(scene);
			window.showAndWait();
			}
		private  static ObservableList<Reparatii> getMasina(String mail)
		{

			
			ObservableList<Reparatii>a =FXCollections.observableArrayList();
		  try{  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
	
				// ArrayList<oreLucrate> a=new ArrayList<>();
				// Masina m=new Masina("Vw","Passat","AB22NFC",161000,2017);
				 
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			      String sql = "SELECT *  FROM Reparatii ";
			      ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			 
			      while(rs.next()){
			         //Retrieve by column name
			         int costul = rs.getInt("Costul_in_lei");
			         String serie_Masina=rs.getString("Serie_Masina");
			         String data=rs.getString("Data");
			         String maill=rs.getString("Mail");
			       //  Angajat ang=new Angajat(nume,Prenume,datan,dataa,pozitie,ani,vechime,cnp);
			         Reparatii rep=new Reparatii(maill,data,serie_Masina,costul);
			           a.add(rep);
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
