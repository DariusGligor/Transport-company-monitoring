package com.jenkov.javafx.layouts;


import javafx.geometry.Pos;
import javafx.geometry.VPos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class CloseConfirm{
	static boolean inchidem;
public static boolean display(String title,String message)
{   
Stage window=new Stage();
window.initModality(Modality.APPLICATION_MODAL);//nu ma lasa sa acces pagina din spate;
window.setTitle(title);
window.setMinWidth(300);
window.setMinHeight(300);
Text label1=new Text();
label1.setText(message);
label1.setTextOrigin(VPos.TOP);
label1.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,12));
Button yesButton=new Button("da");
Button noButton=new Button("no");
noButton.setOnAction(e->{
inchidem=false;
window.close();}
);
yesButton.setOnAction(e->{
inchidem=true;
window.close();
});
VBox layout2=new VBox(10);
HBox layout=new HBox(10);
layout2.setAlignment(Pos.CENTER);
layout2.getChildren().addAll(label1);
layout.getChildren().addAll(yesButton,noButton);
layout.setAlignment(Pos.CENTER);
layout2.getChildren().add(layout);
layout2.setAlignment(Pos.CENTER);
Scene scene=new Scene(layout2);
window.setScene(scene);
window.showAndWait();
return inchidem;
}
}