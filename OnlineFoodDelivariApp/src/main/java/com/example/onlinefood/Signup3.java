package com.example.onlinefood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Signup3 {
    public User user;
    private Parent parent;
    private Stage stage;
    private Scene scene;

    @FXML
    Label successMsg;

    @FXML
    private TextField address;



    @FXML
    private TextField apartment;




    @FXML
    private TextField phone;
    private Socket client;




    @FXML
    private TextField street;
    //Saving address
    @FXML
    int count=0;
    String userlabel,finalprice;
    public void initialize(Socket sc, String s1, String s2) {
        client = sc;
  userlabel=s1;
    finalprice=s2;

    }


    public void save (ActionEvent actionEvent){

        String Street = street.getText();
        String Apartment  = apartment.getText();
        String Phone = phone.getText();
        String Address = address.getText();


            String str=  Street + "," + Apartment + "," +Phone+","+Address;

            try {
                FileWriter f = new FileWriter("C:/My Project/OnlineFoodDelivariApp/src/main/java/com/example/onlinefood/address.txt", true);
                BufferedWriter writer = new BufferedWriter(f);
                writer.write(str);
                writer.newLine();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("checkout.fxml"));
                parent = loader.load();
               // Checkout c = loader.getController();
               // c.initialize(client,userlabel,finalprice);


                stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



