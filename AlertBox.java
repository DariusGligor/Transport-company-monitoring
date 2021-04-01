package com.jenkov.javafx.layouts;

import java.awt.Label;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class AlertBox{
public static void display(String title,String message)
{   
Stage window=new Stage();
window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
window.setResizable(false);
window.setTitle(title);
window.setMinWidth(300);
window.setMinHeight(300);
//Label label1=new Label(message);
//label1.setText(message);
//Button close=new Button("Close");
//close.setOnAction(e->window.close());
//VBox layout=new VBox(10);
//layout.getChildren().add(close);
//Scene scene=new Scene(layout, 100,100,javafx.scene.paint.Color.BLACK);
Text label1=new Text();
label1.setText(message);
Button closeButton=new Button("Close");
closeButton.setOnAction(e->window.close());
VBox layout=new VBox(10);
layout.getChildren().addAll(label1,closeButton);
Scene scene=new Scene(layout);
window.setScene(scene);
//window.showAndWait();
window.show();
}
}
