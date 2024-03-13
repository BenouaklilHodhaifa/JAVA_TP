package com.example.tp_javafx;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.util.Random;

public class Saut extends CaseTraitable implements Serializable {

    public Saut(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
           this.couleur = "orange";
           this.position = position;
            button.setStyle("-fx-background-color: #ef6c00;");
    }


    // génerer le numéro de la case au le joueur va déplacer
    public int genererNbCase(){

        int nmbreDeLaCase = 0;
        int BorneInf = 1;
        int BorneSup = 101;

        Random random = new Random();
        nmbreDeLaCase = BorneInf + random.nextInt(BorneSup - BorneInf);


        return nmbreDeLaCase ;
    }

    @Override
    public void traiter(Joueur joueur, Dés dé){
        System.out.println("Cliquer Case Saut (Orange)");
        joueur.ChangerProchainPosition(genererNbCase());
        dé.setRollDice(false);
    }

}
