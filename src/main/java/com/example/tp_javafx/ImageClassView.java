package com.example.tp_javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageClassView {

    @FXML
    private Label mot;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private ImageView img4;


    private Parent root;

    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Image.fxml"));
        loader.setController(this);
        root = loader.load();
    }

    public void activate(Stage stage, EventHandler<MouseEvent> onClickImage){
        if(stage != null ){
            stage.getScene().setRoot(root);
            img1.setOnMouseClicked(onClickImage);
            img2.setOnMouseClicked(onClickImage);
            img3.setOnMouseClicked(onClickImage);
            img4.setOnMouseClicked(onClickImage);
            stage.show();
        }
    }

    public void setMot(String mot){
        this.mot.setText(mot);
    }

    public void setImage1(String chemin) throws FileNotFoundException {
        System.out.println("chemin: "+chemin);
        javafx.scene.image.Image img = new javafx.scene.image.Image(new FileInputStream(chemin));
        img1.setImage(img);
    }

    public void setImage2(String chemin) throws FileNotFoundException {
        javafx.scene.image.Image img = new javafx.scene.image.Image(new FileInputStream(chemin));
        img2.setImage(img);
    }

    public void setImage3(String chemin) throws FileNotFoundException {
        javafx.scene.image.Image img = new javafx.scene.image.Image(new FileInputStream(chemin));
        img3.setImage(img);
    }

    public void setImage4(String chemin) throws FileNotFoundException {
        javafx.scene.image.Image img = new javafx.scene.image.Image(new FileInputStream(chemin));
        img4.setImage(img);
    }

    public ImageView getImage(int i ){
        switch (i){
            case 0:
                return img1;
            case 1:
                return img2;
            case 2:
                return img3;
            case 3:
                return img4;

        }
        return img1;
    }

}
