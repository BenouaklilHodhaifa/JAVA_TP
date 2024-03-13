package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class PrimaryPageView {
    @FXML
    private Button Login;

    @FXML
    private Button SignUp;

    Parent root;

    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PrimaryPage.fxml"));
        loader.setController(this);
        root = loader.load();
    }

    public void activate(Stage stage, EventHandler<ActionEvent> onClickLogin, EventHandler<ActionEvent> onClickSignUp) {
        if (stage != null) {
            stage.getScene().setRoot(root);
            stage.show();
            Login.setOnAction(onClickLogin);
            SignUp.setOnAction(onClickSignUp);
        }
    }

    /*public Button getJouerButton() {
        return JouerButton;
    }*/

}
