package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    ArrayList<Joueur> ListeDesJoueurs = new ArrayList<Joueur>();
    ArrayList<Partie> ListeDesParties = new ArrayList<Partie>();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField User_Name;

    @FXML

    protected void User_Name_Action(ActionEvent event) {
        System.out.println("User Name !!!");

    }

    @FXML
    private TextField Mot_Passe;

    @FXML

    protected void Mot_Passe_Action(ActionEvent event) {
        System.out.println("Password !");

    }


    @FXML
    private Button COMMENCER;

    @FXML

    protected void OnCommencerButton(ActionEvent event) {

        String dd = User_Name.getText();
        String mm = Mot_Passe.getText();

        //si on trouve le joueur en accéde a la partie précédente
        //sinon


        //partie partie = new partie(joueur, plateau);
        //On insére ce joueur dans la nouvelle cae de array list des joueurs

        System.out.println("Commencer une partie !! ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Plateau.fxml"));
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
