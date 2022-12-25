package com.example.main3;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelloApplication extends Application  {
Stage window;

Scene scene1;
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start (Stage primarystage) throws Exception {
window = primarystage;
primarystage .setTitle("YORA TRAVEL AGENCIES") ;
        GridPane pane = new GridPane() ;
        pane.setPadding(new Insets(10,10,10,10) );
        pane.setVgap(8) ;
        pane.setHgap(10) ;
        Label namelabel = new Label("USER NAME");
        GridPane.setConstraints(namelabel,9,8) ;
        TextField  nameInput = new TextField();
        GridPane .setConstraints(nameInput,13,8);
        Label passlabel = new Label("PASSWORD");
        GridPane.setConstraints(passlabel,9,10) ;
        PasswordField fd = new PasswordField();
        GridPane .setConstraints( fd,13,10) ;

         Button loginbutton = new Button("LOG IN") ;
      //   loginbutton .setOnAction(e->){


      //  }

        Button BTN = new Button("SUBMIT") ;

        GridPane .setConstraints( loginbutton,13,18) ;

        pane.getChildren() .addAll(namelabel,nameInput, passlabel,fd,loginbutton);

        TextField txt = new TextField();

        GridPane .setConstraints( txt,1,1) ;
        TextField txt2 = new TextField();
        txt2 .setPromptText("PASSWORD") ;
        VBox sp = new VBox(7);


        ChoiceBox<String> choiceBox = new ChoiceBox<>() ;
        choiceBox.getItems() .add("ADDIS ABEBA");
       choiceBox.getItems() .add("HAWASSA");
       choiceBox.getItems() .add("GONDER");
       choiceBox.getItems() .add("BAHIRDAR");
       choiceBox.getItems() .add("DIREDAWA");

       ChoiceBox<String> choiceBox2 = new ChoiceBox<>() ;

       choiceBox2.getItems() .add("ADDIS ABEBA");
       choiceBox2.getItems() .add("HAWASSA");
       choiceBox2.getItems() .add("GONDER");
       choiceBox2.getItems() .add("DIREDAWA");


//listen for selection change
       choiceBox .getSelectionModel().selectedItemProperty() .addListener((v,oldValue,newValue) ->System.out.println(oldValue)) ;
       VBox layout = new VBox(20) ;
        layout .setPadding(new Insets(60,70,50,80) );
        layout.getChildren() .addAll(choiceBox,choiceBox2,BTN) ;



        Scene scene = new Scene( pane,500,500) ;
        StackPane layout2 = new StackPane() ;
       Scene  scene2 = new Scene(layout,800,500) ;
        loginbutton .setOnAction (e->{
            dbconnection db = new dbconnection() ;
            db.conMethod();
                    window.setScene(scene2);
                });

        window.setScene(scene ) ;
        window.show() ;


        }

}