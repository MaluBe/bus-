package com.example.main3;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
public class ComformBox {

    public class HelloApplication extends Application  {
        Stage window;
        Scene scene1, scene2;

        @Override
        public void start (Stage primarystage) throws Exception {
            window = primarystage;
            Label label1 = new Label("welcome to the first scene");
            Button button1 = new Button("go to scene2");
            button1.setOnAction (e->window.setScene(scene2) );

            //layout 1= children are laid on vertical column


            VBox layout1 = new VBox(20);
            layout1.getChildren().addAll(label1 ,button1);
            scene1 = new Scene(layout1,200,200);
            Button  button2 = new Button("go back to scene1") ;

            button2.setOnAction (e->window.setScene(scene1) );

//layout 2

            StackPane layout2 = new StackPane() ;
            layout2.getChildren().add(button2);
            scene2 = new Scene(layout2,400,300) ;
            window.setScene(scene1 ) ;
            window.getTitle();
            window.show();

        };






        public static void main(String[] args) {
            launch();
        }



    }
}
