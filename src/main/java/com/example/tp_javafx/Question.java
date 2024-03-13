package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.Serializable;

public abstract class Question extends  CaseTraitable implements Serializable {
    public Question(EventHandler<ActionEvent> onclickButton){
        super(onclickButton);
    }
}
