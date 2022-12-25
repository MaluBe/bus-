package com.example.main3;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends Application {
    dbconnection conn = new dbconnection();
    Connection c= conn.conMethod();
        public static void main(String[] args) {
            launch();
        }

        @Override
        public void start(Stage stage) throws Exception {


          Button BTN = new Button("SUBMIT") ;
           BTN.setStyle("-fx-background-color:#DEB887");


            Pane pane = new Pane();
            pane.setStyle("-fx-background-color:#F4A460");

            Label title = new Label();
            Font font = Font.font("Verdana", FontWeight.BOLD, 28);
            title.setStyle("-fx-background-color:#FFE4C4");
           title.setText("Bus Ticket Reservation");
           title.setFont(font);

            VBox th = new VBox();
            th.getChildren().add(title);
            VBox nn= new VBox();
            Label nl = new Label("username");
            nl.setStyle("-fx-background-color:#FFEBCD");
            TextField nameField = new TextField();
            Label pl = new Label("Password");
            pl.setStyle("-fx-background-color:#FFEBCD");
            PasswordField passField = new PasswordField();

            HBox nc = new HBox();
            nc.getChildren().addAll(nl,nameField);
            nc.setSpacing(5);
            nn.getChildren().add(nc);

            HBox pc = new HBox();
            pc.getChildren().addAll(pl,passField);
            pc.setSpacing(5);

            Button login = new Button("Login");
            login.setStyle("-fx-background-color:#FFF8DC");
            VBox lv= new VBox(title,nc,pc,login);
HBox h= new HBox();
Label sx = new Label("                           ");
h.getChildren().addAll(sx,lv);
h.setSpacing(17);

lv.setSpacing(20);
            VBox pn= new VBox();
            pn.getChildren().addAll(h);

            nn.setPadding(new Insets(50,50,50,50));

// HBox to contain the buttons

            Pane adminScene = new Pane();

            adminScene.setStyle("-fx-background-color:#F4A460");
            Label lololol = new Label("  .");


            Label busadt = new Label("Register Bus");
            busadt.setStyle("-fx-background-color:#FFE4C4");
            busadt.setFont(font);
            Label plateNO= new Label("Plate NO");
            Label price= new Label("price");
            Label noS= new Label("no of seats");
            Label des= new Label("destination");
            Label basl= new Label("baseline");
            TextField plt= new TextField();
            TextField pricet= new TextField();
            TextField nost= new TextField();
            TextField dest= new TextField();
            TextField beslt= new TextField();

            VBox nv= new VBox();
            VBox nv2= new VBox();
            nv.getChildren().add(busadt);
            HBox hnv = new HBox();
            hnv.getChildren().addAll(plateNO,lololol,plt);
            nv2.getChildren().add(hnv);

            VBox nv3= new VBox();
            HBox hnv2 = new HBox();
            hnv2.getChildren().addAll(noS,nost);
            nv3.getChildren().add(hnv2);


            VBox nv4= new VBox();
            HBox hnv3 = new HBox();
            hnv3.getChildren().addAll(des,lololol,dest);
            nv4.getChildren().add(hnv3);

            VBox nv5= new VBox();
            HBox hnv4 = new HBox();
            hnv4.getChildren().addAll(basl,beslt);
            nv5.getChildren().add(hnv4);

            VBox nv6= new VBox();
            HBox hnv5 = new HBox();
            hnv5.getChildren().addAll(price,pricet);
            nv6.getChildren().add(hnv5);

            Button reg = new Button("Regster");
            reg.setStyle("-fx-background-color:#FFF8DC");
            Button can = new Button("cancel");
            can.setStyle("-fx-background-color:#FFF8DC");
            VBox nv7= new VBox();
            HBox hnv6 = new HBox();
            hnv6.getChildren().addAll(can,lololol,reg);
            nv7.getChildren().add(hnv6);


VBox sp = new VBox(7);
Button addBus = new Button("add Bus");
           Pane adminPane = new Pane();

            adminPane.setStyle("-fx-background-color:#F4A460");
            VBox v= new VBox();
            v.setPrefSize(300,100);
            v.setPadding(new Insets(20));
           v .setSpacing(20);
            v.getChildren().addAll(nv,nv2,nv3,nv4,nv5,nv6,BTN);

v.setAlignment(Pos.CENTER_LEFT);
HBox centerer = new HBox();
centerer.setAlignment(Pos.CENTER_LEFT);


centerer.getChildren().add(v);
            adminPane.getChildren().add(centerer);

Pane ticket = new Pane();
            ticket.setStyle("-fx-background-color:#F4A460");
Label rt= new Label("Reservation area");
            rt.setStyle("-fx-background-color:#F4A460");
rt.setFont(font);

Label nameLabel = new Label("Full Name");
TextField name = new TextField();
nameLabel.setLabelFor(name);

            Label plateLabel = new Label("plate no");
            TextField plate = new TextField();
            plateLabel.setLabelFor(plate);

            Label destLabel = new Label("Destination");
            TextField destination = new TextField();
            destLabel.setLabelFor(destination);


            Label priceLabel = new Label("Price");
            TextField p = new TextField();
            priceLabel.setLabelFor(p);

            Label seatLabel = new Label("Seat No.");
            TextField seat = new TextField();
            nameLabel.setLabelFor(seat);




Button re = new Button("Reserve");
            re.setStyle("-fx-background-color:#F4A460");
VBox tick = new VBox(7);
tick.getChildren().addAll(rt,nameLabel,name,plateLabel,plate,destLabel,destination,priceLabel,p,seatLabel,seat,re);

re.setOnAction(e-> {
            Connection c = conn.conMethod();

            String getBus = "select FREE,ENROLED from BUS where DESTINATION = '" + destination.getText() + "' and PLATENO = '" + plate.getText() + "'";

            try {
                System.out.println(destination.getText());
                ResultSet res = c.createStatement().executeQuery(getBus);
                while (res.next()) {
                    if (res.getString(1) != "0") {
                        String query = ("insert into TICKET(PLATENO,DESTINATION,PRICE,SEATNO,NAME) values(?,?,?,?,?)");
                        try {
                            PreparedStatement pst = c.prepareStatement(query);
                            pst.setString(1, String.valueOf(Integer.parseInt(plate.getText())));
                            pst.setString(2, destination.getText());
                            pst.setString(3, String.valueOf(Integer.parseInt(p.getText())));
                            pst.setString(4, String.valueOf(Integer.parseInt(seat.getText())));
                           pst.setString(5,name.getText());
                            pst.execute();
                            int en =Integer.parseInt(res.getString(2));
                            int f = ((int)Integer.parseInt(res.getString(1)))-1;

                            String up= "UPDATE BUS SET ENROLED = '"+(en+1)+"', FREE = '"+f+"' WHERE PLATENO = '"+plate.getText()+"'";
                            try{
                                ResultSet ress = c.createStatement().executeQuery(up);
                                while (ress.next()){
                                    JOptionPane.showMessageDialog(null, " Successful");
                                }
                            }
                            catch (Exception E){

                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    }
                }
            } catch (Exception exe) {
                exe.printStackTrace();

            }
        });
Label tata = new Label("Delete old reservations");
            tata.setStyle("-fx-background-color:#F4A460");

tata.setFont(font);
Button delete = new Button("Refresh");
            delete.setStyle("-fx-background-color:#F4A460");

TextField pla = new TextField();
Label pll = new Label("Plate No.");
pll.setLabelFor(pla);
VBox ayi = new VBox(tata,pll,pla,delete);
ayi.setSpacing(5);


Label spacethem = new Label("       ");
VBox spacer = new VBox(spacethem);
HBox tickHorizontal = new HBox(tick,spacer,ayi);
ticket.getChildren().add(tickHorizontal);
delete.setOnAction(e->{
    String d= "DELETE FROM TICKET WHERE PLATENO= ?";
    String getBus = "select FREE,ENROLED,NO_OF_SEATS from BUS where PLATENO = '" + pla.getText() + "'";

    try {

        ResultSet res = c.createStatement().executeQuery(getBus);
        while (res.next()) {
            int en = 0;
            String f = res.getString(3);

            String up = "UPDATE BUS SET ENROLED = '" + en + "', FREE = '" + f + "' WHERE PLATENO = '" + pla.getText() + "'";
            try {
                ResultSet asd = c.createStatement().executeQuery(up);
                while (asd.next()){


                }
            }catch(Exception mx){

            }
        }

    }
    catch(Exception te){te.printStackTrace();}

    try{
        PreparedStatement pst = c.prepareStatement(d);
        pst.setString(1,pla.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null,"Deletion Successful.");
    }
    catch(Exception ae){ae.printStackTrace();}
});

            BTN.setOnAction(e->{
                Connection c= conn.conMethod();

                         String query = ("insert into BUS(PLATENO,DESTINATION,BASELINE,PRICE,NO_OF_SEATS,ENROLED,FREE) values(?,?,?,?,?,?,?)");
                         try {
                             PreparedStatement pst = c.prepareStatement(query);
                             pst.setString(1, String.valueOf(Integer.parseInt(plt.getText())));
                             pst.setString(2, dest.getText());
                             pst.setString(3, beslt.getText());
                             pst.setString(4, String.valueOf(Integer.parseInt(pricet.getText())));
                             pst.setString(5, String.valueOf(Integer.parseInt(nost.getText())));
                             pst.setString(6, "0");
                             pst.setString(7, String.valueOf(Integer.parseInt(nost.getText())));
                             pst.execute();
                             JOptionPane.showMessageDialog(null, "Registration Successful");
                         } catch (Exception ee) {
                             ee.printStackTrace();
                         }

                System.out.println(plt.getText()+' '+ beslt.getText()+" "+dest.getText());
            });

            login.setOnAction(e->{

                String se= "select USERNAME,PASSWORD,ROLL from USERTBL where USERNAME ='" + nameField.getText() + "' and PASSWORD='"+passField.getText()+"'";
                try {
                    ResultSet res = c.createStatement().executeQuery(se);
                    while(res.next()){
                        if (res.getString(3).equals("servant")){
                            System.out.println(res.getString(2));
                            Scene  userScene = new Scene(ticket,800,500) ;
                            stage.setScene(userScene ) ;
                            stage.show() ;

                        }
                        else if (res.getString(3).equals("admin")){
                            System.out.println(res.getString(2));

                            Scene adScene = new Scene(adminPane,600,400);
                            stage.setScene(adScene ) ;
                            stage.show() ;
                        }
                        else{
                            System.out.println(res.getString(3));

                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            });

            pane.getChildren().addAll(th,nn,pn);
            Scene scene = new Scene(pane,500,500);




            stage.setScene(scene ) ;

            stage.show() ;
        }
    }


