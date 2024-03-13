package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PlateauController {


    @FXML
    private Button  LancerDé;

    @FXML
    protected void CkiquerLancerDé(ActionEvent event) {

        System.out.println("Le dé est bien lancer !!");
        Dés dé1 = new Dés();
        Dés dé2 = new Dés();
        int k =  dé1.LancerDé();
        int d =  dé2.LancerDé();
    }

    @FXML
    private Button  Arréter_Partie;

    @FXML
    protected void OnClique_Arréter_Partie(ActionEvent event) {
        System.out.println("La Partie est Terminée !!");
    }




}

