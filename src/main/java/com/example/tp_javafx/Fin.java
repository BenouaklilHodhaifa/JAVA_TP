package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.Serializable;

public class Fin extends CaseTraitable implements Serializable {

    // constructor


    public Fin(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "noire";
        this.position = position;
        button.setStyle("-fx-background-color: #212121; -fx-text-fill: white;");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Cliquer Case Fin (noire)");
        dé.setRollDice(false);

    }

}
