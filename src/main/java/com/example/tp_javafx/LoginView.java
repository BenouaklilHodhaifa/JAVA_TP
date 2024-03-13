package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView {

    @FXML
    private TextField User_Name;
    @FXML
    private Button COMMENCER;

    private Parent root;



    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        loader.setController(this);
        root = loader.load();
    }

    public void activate(Stage stage, EventHandler<ActionEvent> onClickCommencer) {
        if (stage != null) {
            stage.getScene().setRoot(root);
            stage.show();
            COMMENCER.setOnAction(onClickCommencer);
        }
    }

    // getters and setters


    public Button getCommencer() {
        return COMMENCER;
    }
    public TextField getUser_Name(){return User_Name;}

}
