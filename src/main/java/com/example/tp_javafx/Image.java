package com.example.tp_javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Image extends Question implements Serializable {
    // Les attributs
    private String img1, img2, img3, img4, mot, imgCorrect;
    private final int nbAvancer = 2;
    private final int nbGagner = 10;

    private String[] tabImages= new String[4];
    private String[] tabrep= new String[4];
    private String reponseJuste;



    // constructor


    public Image(int position, EventHandler<ActionEvent> onclickButton) {
        super(onclickButton);
        couleur = "rose";
        this.position = position;
        button.setStyle("-fx-background-color: #f48fb1;");
    }

    @Override
    public void traiter(Joueur joueur, Dés dé) {
        System.out.println("Cliquer Case Image (rose)");
        if (VerifierReponse(joueur.GetReponse()) == true){
            joueur.incrementerScore(nbGagner);
            joueur.ChangerProchainPosition(nbAvancer);
        }
        dé.setRollDice(true);
    }

    public void getImage(ArrayList<String> TabImage, ArrayList<String> TabNoms){
        Random random = new Random();
        int a,b,c,d;

         a = random.nextInt(TabImage.size() - 0);
         b = random.nextInt(TabImage.size() - 0);
         while (b == a){
             b = random.nextInt(TabImage.size() - 0);
         }
        c = random.nextInt(TabImage.size() - 0);
         while (c== a || c == b){
             c = random.nextInt(TabImage.size() - 0);
         }
        d = random.nextInt(TabImage.size() - 0);
         while (d == a || d == b || d == c){
             d = random.nextInt(TabImage.size() - 0);
         }

        String tab1[] = new String[4];

             tab1[0] = TabImage.get(a);
             tab1[1] = TabImage.get(b);
             tab1[2] = TabImage.get(c);
             tab1[3] = TabImage.get(d);

             tabImages = tab1;
            System.out.println("Tab Image[0] :"+tabImages[0]);


        String tab[] = new String[4];

             tab[0] = TabNoms.get(a);
             tab[1] = TabNoms.get(b);
             tab[2] = TabNoms.get(c);
             tab[3] = TabNoms.get(d);


        tabrep = tab;
        System.out.println("Tab rep[0] :"+tabrep[0]);

        a = random.nextInt(3 - 0);

        reponseJuste = tabrep[a];


    }



    public boolean VerifierReponse(String s){
        if(reponseJuste.equals(s) == true){
            System.out.println("oui");
            return true;
        }
        else {
            return false;
        }
    }

    public String getReponseJuste() {
        return reponseJuste;
    }

    public String[] getTabImages() {
        return tabImages;
    }

    public String[] getTabrep() {
        return tabrep;
    }
}
