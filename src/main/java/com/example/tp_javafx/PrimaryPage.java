package com.example.tp_javafx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimaryPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrimaryPage.class.getResource("PrimaryPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 704, 523);
        stage.setTitle("jeux de l'oie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}

