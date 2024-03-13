package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Malus extends CaseTraitable implements Serializable {
    // Les attributs
    private final int nbPtsPerdue = 10;
    private final int nbCaseReculer = -2;

    public Malus(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "rouge";
        this.position = position;
        button.setStyle("-fx-background-color: #d32f2f;");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Cliquer Case Malus (rouge)");
        joueur.decrementerScore(nbPtsPerdue);
        joueur.ChangerProchainPosition(nbCaseReculer);
        dé.setRollDice(false);
    }


}
