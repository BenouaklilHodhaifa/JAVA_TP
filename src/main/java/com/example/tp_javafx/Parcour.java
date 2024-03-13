package com.example.tp_javafx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.Serializable;

public class Parcour extends Case implements Serializable {

    // constructor

    public Parcour(int podition, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        this.position = podition;
        couleur = "none"; // pas de couleur
        button.setStyle("-fx-background-color: #ffebee;");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Case Parcour (blanc)");
        dé.setRollDice(true);
    }
}
