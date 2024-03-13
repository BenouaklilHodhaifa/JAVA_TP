package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class Case { //classe case
    protected String couleur;
    protected int position;
    protected Button button; // bottun in the grid
    protected int gridRow;
    protected int gridColumn;

    public Case(EventHandler<ActionEvent> onclickButton) {
        button = new Button_son();
        button.setPrefWidth(100.00);
        button.setPrefHeight(40.00);
        button.setOnAction(onclickButton);
    }

    public abstract void traiter(Joueur joueur, Dés dé);

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getGridRow() {
        return gridRow;
    }

    public void setGridRow(int gridRow) {
        this.gridRow = gridRow;
    }

    public int getGridColumn() {
        return gridColumn;
    }

    public void setGridColumn(int gridColumn) {
        this.gridColumn = gridColumn;
    }
}
