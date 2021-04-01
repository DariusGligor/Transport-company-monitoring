package com.jenkov.javafx.layouts;

import java.sql.*;

public class creazaTabel {
   // JDBC driver name and database URL

   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
    
	   conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-GV541AR\\SQLEXPRESS;user=cristi;password=LPX525qlr;");
      stmt = conn.createStatement();
      /*     
   String sql = "CREATE TABLE Loginn" +
                   "(Mail VARCHAR(255), " +
                   " Parola VARCHAR(255), " + 
                   " NUME VARCHAR(255), " + 
                   " Prenume VARCHAR(255), " + 
                   " Tip VARCHAR(255)" + 
                   " PRIMARY KEY (Mail))";
                  
      String sql = "CREATE TABLE Soferi" +
              "(Mail VARCHAR(255), " +
              " Parola VARCHAR(255), " + 
              " NUME VARCHAR(255), " + 
              " Prenume VARCHAR(255), " + 
              ""; 
      String sql = "CREATE TABLE Carss" +
              "(Serie_Sasiu VARCHAR(255) not NULL, " +
              " Marca VARCHAR(255), " + 
              " Model VARCHAR(255), " + 
              " Data_Fabricare VARCHAR(255), " + 
              " Numar_km INTEGER, " + 
              " Sofer VARCHAR(255), " + 
              " PRIMARY KEY ( Serie_Sasiu ))"; 
      
      String sql = "CREATE TABLE Soferi" +
              "(Mail VARCHAR(255) not NULL, " +
              " Nume VARCHAR(255), " + 
              " Prenume VARCHAR(255), " + 
              " Data_nastere VARCHAR(255), " + 
              " Numar_km INTEGER, " +
              " Numar_ore INTEGER, " +
              " Lei_ora INTEGER, " +
              "Masina VARCHAR(255), " +
              " PRIMARY KEY (Mail))";
      String sql = "CREATE TABLE LucratSoferi" +
              "(Mail VARCHAR(255), " +
              " Data VARCHAR(255), " + 
              " Numar_km INTEGER, " + 
              " Numar_ore INTEGER, " +
              " Lei_km_ore INTEGER)";
    
      String sql = "CREATE TABLE Reparatii" +
              "(Mail VARCHAR(255), " +
              " Data VARCHAR(255), " + 
              " Serie_Masina VARCHAR(255), " + 
              " Costul_in_lei INTEGER)";
      
      
      "";   
  String sql = "CREATE TABLE Carss" +
          "(Serie_Sasiu VARCHAR(255) not NULL, " +
          " Marca VARCHAR(255), " + 
          " Model VARCHAR(255), " + 
          " Data_Fabricare VARCHAR(255), " + 
          " Numar_km INTEGER, " + 
          " Sofer VARCHAR(255), " + 
          " Stare_de_functionare VARCHAR(255), " + 
          " PRIMARY KEY ( Serie_Sasiu ))"; */
      
      String sql = "CREATE TABLE Mecanici" +
              "(Mail VARCHAR(255) not NULL, " +
              " Nume VARCHAR(255), " + 
              " Prenume VARCHAR(255), " + 
              " Data_nastere VARCHAR(255), " + 
              " Salariu INTEGER, " +
              " PRIMARY KEY (Mail))";
      
      
      
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
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
}//end main
}//end JDBCExample