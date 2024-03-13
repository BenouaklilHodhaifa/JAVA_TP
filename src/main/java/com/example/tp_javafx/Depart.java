package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.Serializable;

public class Depart extends Case implements Serializable {
    // constructor

    public Depart(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "jaune";
        this.position = position;
        button.setStyle("-fx-background-color: #ffee58; ");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Case Depart (jaune)");
        dé.setRollDice(true);
    }
}
