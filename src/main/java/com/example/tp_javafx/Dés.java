package com.example.tp_javafx;

import java.io.Serializable;
import java.util.Random;

// la classe dé qui caractirise un seul dé
public class Dés implements Serializable {

    private int de;
    private boolean rollDice ;


    public Dés(){}

    public int LancerDé(){
        int dé1 = 0;
        int BorneInf = 1;
        int BorneSup = 7;

        Random random = new Random();
        dé1 = BorneInf + random.nextInt(BorneSup - BorneInf);
        de = dé1;
        return dé1 ;

    }

    public int SetDé(){return  de;} // retourer la valeur de premier des

    public void afficherDes(){
        // elle verifié la valeur de "de" et affiche l'image associé à le numéro
    }
    // getters setters


    public boolean getRollDice() {
        return rollDice;
    }

    public void setRollDice(boolean rollDice) {
        this.rollDice = rollDice;
    }
}
