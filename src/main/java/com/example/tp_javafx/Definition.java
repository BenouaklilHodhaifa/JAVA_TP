package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Random;


public class Definition extends Question{

    private String reponse;

    public Definition(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "bleu";
        this.position = position;
        button.setStyle("-fx-background-color: #0288d1; ");

    }



    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Cliquer Case Definition (bleu)");
        // poser la definition GetQuestion()
        if (VerifierReponse(joueur.GetReponse()) == true){
            joueur.incrementerScore(20);
            joueur.ChangerProchainPosition(4);
        }
        else{
            joueur.decrementerScore(10);
        }
        dé.setRollDice(true);
    }

    public String GetQuestion(ArrayList<Def> defTab){
        Random random = new Random();
        int i = random.nextInt(defTab.size() - 0);
        reponse = defTab.get(i).getRep();
        String s = defTab.get(i).getDefinition();
        defTab.remove(i);
        return s;
    }
    public boolean VerifierReponse(String reponse){
        if(this.reponse.equals(reponse) ){
            return true;
        }
        else{
            return false;
        }
    }

    public String getReponse() {
        return reponse;
    }
}
