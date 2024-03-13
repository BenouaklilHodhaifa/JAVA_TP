package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrimaryPageController {
    @FXML
    private Button JouerButton;

    @FXML


    protected  void OnJouerButton(ActionEvent event) throws IOException {
        System.out.println("hello");
        FXMLLoader loader =new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(),704,523);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}