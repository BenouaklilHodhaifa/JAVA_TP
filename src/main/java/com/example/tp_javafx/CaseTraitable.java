package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

abstract class CaseTraitable extends Case{
    public CaseTraitable(EventHandler<ActionEvent> onclickButton){
        super(onclickButton);
    }


    //public abstract void traiter(Joueur joueur); // elle est dans la class case


}
