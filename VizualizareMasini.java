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

public class VizualizareMasini {
	static Connection conn = null;
	   static Statement stmt = null;
	public static void start(String mail) throws SQLException
	{
		 Stage window=new Stage();
			window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
			window.setTitle("Masini");
			window.setResizable(false);
			Button buttonClose=new Button("Close");
			buttonClose.setMinSize(90, 25);
			buttonClose.setOnAction(e->{
				window.close();
			});
			TableColumn<Cars,String>marcacol=new TableColumn<>("Marca");
			marcacol.setMinWidth(200);
			marcacol.setCellValueFactory(new PropertyValueFactory<>("Marca"));
			
			
			TableColumn<Cars,String>sofercol=new TableColumn<>("Sofer");
			sofercol.setMinWidth(200);
			sofercol.setCellValueFactory(new PropertyValueFactory<>("Sofer"));
			
			
			TableColumn<Cars,String>modelcol=new TableColumn<>("Model");
			modelcol.setMinWidth(200);
			modelcol.setCellValueFactory(new PropertyValueFactory<>("Model"));
			
			TableColumn<Cars,String>dataFabricare=new TableColumn<>("Data fabricarii");
			dataFabricare.setMinWidth(200);
			dataFabricare.setCellValueFactory(new PropertyValueFactory<>("dataFabricare"));
			
			TableColumn<Cars,Integer>nrkm=new TableColumn<>("Numarul de km");
			nrkm.setMinWidth(200);
			nrkm.setCellValueFactory(new PropertyValueFactory<>("nrKm"));
			
			TableColumn<Cars,Integer>serie=new TableColumn<>("Serie de sasiu");
			serie.setMinWidth(200);
			serie.setCellValueFactory(new PropertyValueFactory<>("serieSasiu"));
			
			
			TableColumn<Cars,String>functionare=new TableColumn<>("Functionare");
			functionare.setMinWidth(200);
			functionare.setCellValueFactory(new PropertyValueFactory<>("functioneaza"));
			
			TableView<Cars> table123 =new TableView<>();
			 table123.setItems(getMasina(mail));
			table123.getColumns().addAll(marcacol,sofercol,modelcol,	dataFabricare,nrkm,serie,functionare);

			VBox meniu=new VBox();
			meniu.getChildren().add(buttonClose);
			meniu.setAlignment(Pos.CENTER);
			BorderPane principal=new BorderPane();
			principal.setBottom(meniu);
			principal.setCenter(table123);
			Scene scene=new Scene(principal,1405,800);
			window.setScene(scene);
			window.showAndWait();
			
	}
	
	private  static ObservableList<Cars> getMasina(String mail)
	{

		
		ObservableList<Cars>a =FXCollections.observableArrayList();
	  try{  conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");

			// ArrayList<oreLucrate> a=new ArrayList<>();
			// Masina m=new Masina("Vw","Passat","AB22NFC",161000,2017);
			 
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT * FROM Carss ";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      
		      while(rs.next()){
		         //Retrieve by column name
		    	  String serieSasiu=rs.getString("Serie_Sasiu");
		    	  String marca=rs.getString("Marca");
		    	  String model=rs.getString("Model");
		    	  String data=rs.getString("Data_Fabricare");
		    	  String sofer=rs.getString("Sofer");
		    	  String funct=rs.getString("Stare_de_functionare");
                  int nrKm=rs.getInt("Numar_km");		
		       //  Angajat ang=new Angajat(nume,Prenume,datan,dataa,pozitie,ani,vechime,cnp);
		        Cars car=new Cars(marca,model,data,sofer,nrKm,serieSasiu,funct);
		           a.add(car);
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
