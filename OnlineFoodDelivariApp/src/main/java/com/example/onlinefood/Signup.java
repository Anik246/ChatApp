package com.example.onlinefood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Signup {
    ArrayList<String> uList = new ArrayList<>();

    private Parent parent;
    private Stage stage;
    private Scene scene;
    private User user;

    @FXML
    TextField fName, lName, email, username, pass, confirmPass;
    @FXML
    Label errorMessage;

    @FXML
    void initialize(){
        try{
            FileReader f = new FileReader("C:/My Project/OnlineFoodDelivariApp/src/main/java/com/example/onlinefood/users.txt");
            File file = new File("C:/My Project/OnlineFoodDelivariApp/src/main/java/com/example/onlinefood/users.txt");

            if(file.exists() && file.length() != 0){
                BufferedReader reader = new BufferedReader(f);
                String line;
                while ((line = reader.readLine()) != null) {
                    String [] parts = line.split("#");
                    uList.add(parts[3]);
                }
                reader.close();
            }
        }
        catch (Exception e){}
    }

    @FXML
    public void backButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Saving personal data except credit card info and address
    @FXML
    public void nextButton1(ActionEvent event) throws Exception {
        user = new User();
        user.fName = fName.getText();
        user.lName = lName.getText();
        user.email = email.getText();


        if(email.getText().contains("@gmail.com")) {


            if (!uList.contains(username.getText())) {
                user.username = username.getText();


                if (pass.getText().equals(confirmPass.getText())) {
                    user.pass = pass.getText();


                    try {
                        FileWriter f = new FileWriter("C:/My Project/OnlineFoodDelivariApp/src/main/java/com/example/onlinefood/users.txt", true);
                        BufferedWriter writer = new BufferedWriter(f);
                        String str = user.fName+"#"+user.lName+"#"+user.email+"#"+
                                user.username + "#" + user.pass;
                        writer.write(str);
                        writer.newLine();
                        writer.close();



                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(fxmlLoader.load());
                    stage.setScene(scene);
                    stage.show();



                } else {
                    confirmPass.setText("Pass does not match!!");


                }


            } else {
                username.setText("Username already exist!!");
                email.setText("email not valid");
            }

        }else {
    email.setText("Email is not valid");
            }

    }



}
