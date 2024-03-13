package com.example.tp_javafx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PlateauModel implements Serializable {

    private Case[] TableauCases = new Case[100];
    private Dés DéPartie ;




    public void genererCases(EventHandler<ActionEvent> onclickButton){
        TableauCases[0] = new Depart(1, onclickButton);
        TableauCases[99] = new Fin(100, onclickButton);
        Random random = new Random();
        ArrayList<Integer> Random_List = new ArrayList<Integer>();
        Random_List.add(1);
        Random_List.add(2);
        Random_List.add(3);
        Random_List.add(4);
        Random_List.add(5);
        Random_List.add(6);
        //
        Random_List.add(7);
        Random_List.add(8);
        Random_List.add(9);
        Random_List.add(10);
        //

        int BorneInf = 0;
        int BorneSup = Random_List.size();

        int Type_Case =0;
        int bonus =0;
        int malus =0;
        int saut =0;
        int definition =0;
        int image =0;

        for(int i=1 ; i < TableauCases.length-1 ; i++){

            BorneSup = Random_List.size();
            Type_Case = BorneInf + random.nextInt(BorneSup - BorneInf);

            switch (Random_List.get(Type_Case)){

                case 1:
                    if (bonus<5){
                        TableauCases[i] = new Bonus(i+1, onclickButton);
                        bonus++;
                        i++;
                        TableauCases[i] = new Parcour(i+1 ,onclickButton);
                        i++;
                        TableauCases[i] = new Parcour(i+1 ,onclickButton);
                    }
                    else {
                        Random_List.remove(Type_Case);
                        i--;
                    }
                    break;
                case 3:
                    if (malus<5){
                        TableauCases[i] = new Malus(i+1, onclickButton);
                        malus++;
                    }
                    else {
                        Random_List.remove(Type_Case);
                        i--;
                    }
                    break;

                case 5:
                    if (saut<5){
                        TableauCases[i] = new Saut(i+1, onclickButton);
                        saut++;
                    }
                    else {
                        Random_List.remove(Type_Case);
                        i--;
                    }
                    break;
                case 7:
                    if (image<5){
                        TableauCases[i] = new Image(i+1, onclickButton);
                        image++;
                    }
                    else {
                        Random_List.remove(Type_Case);
                        i--;
                    }
                    break;
                case 9:
                    if (definition<5){
                        TableauCases[i] = new Definition(i+1, onclickButton);
                        definition++;
                    }
                    else {
                        Random_List.remove(Type_Case);
                        i--;
                    }
                    break;
                case 6:
                case 2:
                case 4:
                case 8:
                case 10:
                    TableauCases[i] = new Parcour(i+1, onclickButton);
                    break;
            }


        }
    }

    public void remplire(GridPane grid)
    {
        int maxC = 13;
        int maxL = 12;
        int minC = 0;
        int minL = 2;

        int column = 2;
        int ligne = 0;

        int cpt = 0;


        while(cpt < 100)
        {
            while(column <= maxC && cpt<100)
            {
                TableauCases[cpt].setGridColumn(column);
                TableauCases[cpt].setGridRow(ligne);
                TableauCases[cpt].getButton().setText(Integer.toString(cpt+1));
                grid.add(TableauCases[cpt].getButton(),column , ligne );
                column ++;
                cpt ++;
            }
            column --;
            ligne ++;
            maxC -=2;

            while(ligne <= maxL && cpt<100)
            {
                TableauCases[cpt].setGridColumn(column);
                TableauCases[cpt].setGridRow(ligne);
                TableauCases[cpt].getButton().setText(Integer.toString(cpt+1));
                grid.add(TableauCases[cpt].getButton(),column , ligne );
                ligne ++;
                cpt ++;
            }

            ligne --;
            column --;
            maxL -=2;

            while(column >= minC && cpt<100)
            {
                TableauCases[cpt].setGridColumn(column);
                TableauCases[cpt].setGridRow(ligne);
                TableauCases[cpt].getButton().setText(Integer.toString(cpt+1));
                grid.add(TableauCases[cpt].getButton(),column , ligne );
                column --;
                cpt ++;
            }

            column ++;
            ligne --;
            minC +=2;

            while(ligne >= minL && cpt<100)
            {
                TableauCases[cpt].setGridColumn(column);
                TableauCases[cpt].setGridRow(ligne);
                TableauCases[cpt].getButton().setText(Integer.toString(cpt+1));
                grid.add(TableauCases[cpt].getButton(),column , ligne );
                ligne --;
                cpt ++;
            }

            ligne ++;
            column ++;
            minL +=2;
        }

    }

    public void AddCircle(GridPane grid, int column , int ligne, Circle circle){
        grid.add(circle, column , ligne);
    }

    // getters setters


    public Case[] getTableauCases() {
        return TableauCases;
    }
}
