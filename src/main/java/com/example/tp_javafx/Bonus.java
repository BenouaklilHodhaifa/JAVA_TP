package com.example.tp_javafx;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Bonus extends CaseTraitable implements Serializable {
    // Les attributs
    private final int nbPtsGagner = 10;
    private final int nbCaseAvancer =2;

    // constructor
    public Bonus(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "vert";
        this.position = position;
        button. setStyle("-fx-background-color: #4caf50; ");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé ){
        System.out.println("Cliquer Bonus (vert)");
        joueur.incrementerScore(nbPtsGagner);
        joueur.ChangerProchainPosition(nbCaseAvancer);
        dé.setRollDice(false);  // il faut changer sa position d'abbord
    }
}
