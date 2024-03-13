package com.example.tp_javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class PlateauView implements Serializable {

    @FXML
    private Label nomLabel ;

    @FXML
    private Label scoreLabel ;

    @FXML
    private Label mscoreLabel ;

    @FXML
    private Label ProchainePosition;

    @FXML
    private ImageView de1 ;

    @FXML
    private ImageView de2 ;

    @FXML
    private ImageView circleImage;

    @FXML
    private Button LancerDé;

    @FXML
    private Button Arréter_Partie;

    @FXML
    private GridPane grid;



    private Parent root ;

    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Plateau.fxml"));
        loader.setController(this);
        root = loader.load();
    }

    public void activate(Stage stage, EventHandler<ActionEvent> onClickLancerDes, EventHandler<ActionEvent> OnClickArreter) throws FileNotFoundException{
        if(stage != null ){
            stage.getScene().setRoot(root);
            LancerDé.setOnAction(onClickLancerDes);
            Arréter_Partie.setOnAction(OnClickArreter);
            javafx.scene.image.Image circle = new javafx.scene.image.Image(new FileInputStream("D:\\BACKUP_houdhaifah\\Documents\\ESI\\2CP\\Moi\\S4\\POO\\TP\\TP_POO\\TP_POO\\src\\main\\java\\com\\example\\tp_javafx\\ressource\\circle.png"));
            circleImage.setImage(circle);
            stage.show();
        }
    }

    public void setNameLabel(String name){
        nomLabel.setText(name);
    }

    public void setScoreLabel(String scoreActuelle){
        scoreLabel.setText(scoreActuelle);
    }

    public void setProchainePositionLabel(String prochainPosition){ProchainePosition.setText(prochainPosition);}

    public void setMscoreLabel(String MScore){
        mscoreLabel.setText(MScore);
    }

    public void setImageDes(int num1 , int num2) throws FileNotFoundException {
        javafx.scene.image.Image img1 = new javafx.scene.image.Image(new FileInputStream("D:\\BACKUP_houdhaifah\\Documents\\ESI\\2CP\\Moi\\S4\\POO\\TP\\TP_POO\\TP_POO\\src\\main\\java\\com\\example\\tp_javafx\\ressource\\De"+Integer.toString(num1)+".png"));

        javafx.scene.image.Image img2 = new javafx.scene.image.Image(new FileInputStream("D:\\BACKUP_houdhaifah\\Documents\\ESI\\2CP\\Moi\\S4\\POO\\TP\\TP_POO\\TP_POO\\src\\main\\java\\com\\example\\tp_javafx\\ressource\\De"+Integer.toString(num2)+".png"));

        de1.setImage(img1);
        de2.setImage(img2);
    }

    public Button getArréter_Partie() {
        return Arréter_Partie;
    }




    // getters setters

    public GridPane getGrid() {
        return grid;
    }


    public void addCircleInGridPane(int column, int row){
        // test
        ObservableList<Node> childrens = grid.getChildren();
        for(Node node : childrens) {
            if(node instanceof ImageView ) {
                ImageView imageView= (ImageView) node; // use what you want to remove
                grid.getChildren().remove(imageView);
                break;
            }
        }


            grid.add(circleImage, column, row);

    }



}
