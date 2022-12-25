package com.example.main3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class userview extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane() ;

        Button BTN = new Button("SUBMIT") ;



        TextField txt = new TextField();

        GridPane .setConstraints( txt,1,1) ;
        TextField txt2 = new TextField();
        txt2 .setPromptText("PASSWORD") ;
        GridPane .setConstraints(txt2 ,2,2) ;

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

        choiceBox .getSelectionModel().selectedItemProperty() .addListener((v,oldValue,newValue) ->System.out.println(oldValue)) ;
        VBox layout = new VBox(20) ;
        layout .setPadding(new Insets(60,70,50,80) );
        layout.getChildren() .addAll(choiceBox,choiceBox2,BTN) ;



        Scene  scene2 = new Scene(layout,800,500) ;


        stage.setScene(scene2 ) ;
        stage.show() ;


    }
}
