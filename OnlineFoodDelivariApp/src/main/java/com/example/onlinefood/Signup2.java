package com.example.onlinefood;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Signup2 {
    private Scene scene;
    private Stage stage;
    private Parent parent;

    @FXML
    TextField cardNum, expDate;

    private User user;

    //Saving credit card info
    @FXML
    public void backButton2(MouseEvent mouseEvent) {
        try {
            parent = FXMLLoader.load(getClass().getResource("checkout.fxml"));
            scene = new Scene(parent);
            stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) throws IOException {

        parent = FXMLLoader.load(getClass().getResource("checkout.fxml"));
        scene = new Scene(parent);
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
