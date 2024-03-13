package com.example.tp_javafx;


import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Jeux implements Serializable {

    private ArrayList<Joueur> ListeDesJoueurs;
    private int MeilleurScoreJeux;




// Le constructeur du jeux

    public Jeux(ArrayList<Joueur> ListeDesJoueurs, int MeilleurScoreJeux){

        this.ListeDesJoueurs = ListeDesJoueurs;
        this.MeilleurScoreJeux = MeilleurScoreJeux;


    }

//---------------------------------- La liste des Méthodes -------------------------------------------------

//Placer le joueur dans la case du départ pour une nouvelle  partie de ce jeux

    //Ajouter un nouveau joueur

    public void AjouterJoueur(Joueur joueur){this.ListeDesJoueurs.add(joueur);}


    // vérifier  si le nom du joueur existe déja

    public Joueur ChercherJoueur(String NomJoueur){

        Joueur joueur = null;
        boolean trouv = false;
        int i = 0;
        while (! trouv && i < ListeDesJoueurs.size()) {
            if (ListeDesJoueurs.get(i).getNom() == NomJoueur) {
                joueur = ListeDesJoueurs.get(i);
                trouv = true;
            }
            i++;
        }

        return joueur;
    }



    public void afficher(){
      for (int i=0 ; i<ListeDesJoueurs.size() ; i++){System.out.println(ListeDesJoueurs.get(i).getNom());}
        System.out.println(MeilleurScoreJeux);

    }

    // Getters and Setters

    public ArrayList<Joueur> getListeDesJoueurs() {return ListeDesJoueurs;}

    public void setListeDesJoueurs(ArrayList<Joueur> listeDesJoueurs) {this.ListeDesJoueurs = listeDesJoueurs;}

    public int getMeilleurScore() {return MeilleurScoreJeux;}

    public void setMeilleurScore(int meilleurScoreJeux) {this.MeilleurScoreJeux = meilleurScoreJeux;}
}
